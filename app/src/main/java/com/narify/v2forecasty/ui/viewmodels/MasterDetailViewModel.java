package com.narify.v2forecasty.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.narify.v2forecasty.models.SingleWeather;

public class MasterDetailViewModel extends ViewModel {

    private MutableLiveData<SingleWeather> mSelectedForecast = new MutableLiveData<>();

    public void selectWeather(SingleWeather weather) {
        mSelectedForecast.setValue(weather);
    }

    public LiveData<SingleWeather> getSelectedWeatherLiveData() {
        return mSelectedForecast;
    }
}
