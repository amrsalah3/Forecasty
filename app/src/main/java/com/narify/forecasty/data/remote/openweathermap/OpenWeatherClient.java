package com.narify.forecasty.data.remote.openweathermap;

import com.narify.forecasty.BuildConfig;
import com.narify.forecasty.data.local.DataManager;
import com.narify.forecasty.data.remote.HttpsTrustManager;
import com.narify.forecasty.models.WeatherResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Single;

@Singleton
public class OpenWeatherClient {

    private OpenWeatherService openWeatherService;

    @Inject
    public OpenWeatherClient(OpenWeatherService openWeatherService) {
        this.openWeatherService = openWeatherService;
        HttpsTrustManager.allowAllSSL();
    }

    public Single<WeatherResponse> getWeather() {
        return openWeatherService.getWeather(
                DataManager.getLocation().getLatitude(),
                DataManager.getLocation().getLongitude(),
                BuildConfig.OWM_API_KEY
        );
    }

}
