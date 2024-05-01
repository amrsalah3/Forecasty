package com.narify.v2forecasty.ui.viewmodels;

import java.util.List;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.narify.v2forecasty.data.repository.WeatherRepo;
import com.narify.v2forecasty.models.SingleWeather;
import com.narify.v2forecasty.singletons.AppExecutors;

public class WeatherViewModel extends ViewModel {

    private LiveData<List<SingleWeather>> weatherLiveData;
    private WeatherRepo weatherRepo;
    private AppExecutors appExecutors;

    @ViewModelInject
    public WeatherViewModel(WeatherRepo weatherRepo, AppExecutors appExecutors) {
        this.weatherRepo = weatherRepo;
        this.appExecutors = appExecutors;
        this.weatherLiveData = weatherRepo.weatherLiveData;
    }

    public LiveData<List<SingleWeather>> getWeather() {
        appExecutors.getDiskIO().execute(() -> weatherRepo.getWeather());

        return weatherLiveData;
    }

    public void refreshWeather() {
        weatherRepo.refreshWeather();
    }

    public void updateUnits(boolean toImperial) {
        appExecutors.getDiskIO().execute(() -> weatherRepo.updateUnits(toImperial));
    }

}
