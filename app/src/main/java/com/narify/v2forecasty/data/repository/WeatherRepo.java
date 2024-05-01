package com.narify.v2forecasty.data.repository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import timber.log.Timber;

import androidx.lifecycle.LiveData;

import com.narify.v2forecasty.data.local.DataManager;
import com.narify.v2forecasty.data.local.db.WeatherDao;
import com.narify.v2forecasty.data.remote.openmeteo.OpenMeteoClient;
import com.narify.v2forecasty.data.remote.openmeteo.OpenMeteoMapper;
import com.narify.v2forecasty.models.SingleWeather;
import com.narify.v2forecasty.utils.DateUtils;
import com.narify.v2forecasty.utils.UnitUtils;

@Singleton
public class WeatherRepo {
    public LiveData<List<SingleWeather>> weatherLiveData;
    private OpenMeteoClient openMeteoClient;
    private WeatherDao weatherDao;
    private OpenMeteoMapper mapper;

    @Inject
    public WeatherRepo(OpenMeteoClient openMeteoClient,
                       WeatherDao weatherDao,
                       OpenMeteoMapper openMeteoMapper) {
        this.openMeteoClient = openMeteoClient;
        this.weatherDao = weatherDao;
        this.mapper = openMeteoMapper;
        this.weatherLiveData = weatherDao.getAllWeather();
    }

    public synchronized LiveData<List<SingleWeather>> getWeather() {
        if (!isSynced()) refreshWeather();
        return weatherLiveData;
    }

    public synchronized void refreshWeather() {
        openMeteoClient.getWeather()
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
