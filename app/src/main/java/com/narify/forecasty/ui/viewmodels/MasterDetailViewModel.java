package com.narify.forecasty.ui.viewmodels;

import com.narify.forecasty.models.SingleWeather;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MasterDetailViewModel extends ViewModel {

    private MutableLiveData<SingleWeather> mSelectedForecast = new MutableLiveData<>();

    public void selectWeather(SingleWeather weather) {
        mSelectedForecast.setValue(weather);
    }

    public LiveData<SingleWeather> getSelectedWeatherLiveData() {
        return mSelectedForecast;
    }
}