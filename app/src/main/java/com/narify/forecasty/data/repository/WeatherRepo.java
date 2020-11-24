package com.narify.forecasty.data.repository;

import com.narify.forecasty.data.local.DataManager;
import com.narify.forecasty.data.local.db.WeatherDao;
import com.narify.forecasty.data.remote.openweathermap.OpenWeatherClient;
import com.narify.forecasty.data.remote.openweathermap.OpenWeatherMapper;
import com.narify.forecasty.models.SingleWeather;
import com.narify.forecasty.utils.DateUtils;
import com.narify.forecasty.utils.UnitUtils;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.LiveData;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import timber.log.Timber;

@Singleton
public class WeatherRepo {
    public LiveData<List<SingleWeather>> weatherLiveData;
    private OpenWeatherClient openWeatherClient;
    private WeatherDao weatherDao;
    private OpenWeatherMapper mapper;

    @Inject
    public WeatherRepo(OpenWeatherClient openWeatherClient, WeatherDao weatherDao,
                       OpenWeatherMapper openWeatherMapper) {
        this.openWeatherClient = openWeatherClient;
        this.weatherDao = weatherDao;
        this.mapper = openWeatherMapper;
        this.weatherLiveData = weatherDao.getAllWeather();
    }

    public synchronized LiveData<List<SingleWeather>> getWeather() {
        if (!isSynced()) refreshWeather();

        return weatherLiveData;
    }

    public synchronized void refreshWeather() {
        openWeatherClient.getWeather()
                .map(mapper::mapToWeatherList)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new SingleObserver<List<SingleWeather>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<SingleWeather> weatherList) {
                        if (weatherList.isEmpty()) return;

                        if (!DataManager.isMetric()) {
                            UnitUtils.convertWeatherListUnits(weatherList, true);
                        }

                        updateDatabase(weatherList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Timber.d("GeneralLogKey refreshWeather onError: " + e);
                    }
                });
    }

    public synchronized void updateUnits(boolean toImperial) {
        // Get current weather list from database with old units
        List<SingleWeather> oldData = weatherDao.getUnobservableWeatherList();
        // Create a new weather list and fill it with the old list after converting its units
        List<SingleWeather> newData = UnitUtils.convertWeatherListUnits(oldData, toImperial);

        updateDatabase(newData);
    }

    private synchronized void updateDatabase(List<SingleWeather> weatherList) {
        if (weatherList != null && !weatherList.isEmpty()) {
            // Delete old weather data from database since no need to display them
            weatherDao.deleteAll();
            // Add new weather data to the database
            weatherDao.insertAll(weatherList);
        }
    }

    private synchronized boolean isSynced() {
        // Check if the the first day in the database is today, if yes, thus synced
        try {
            long firstDayAtDB = weatherDao.getUnobservableWeatherList().get(0).getTimeInMillis();
            return !DateUtils.isPastDay(firstDayAtDB);

        } catch (Exception e) {
            return false;
        }
    }

}
