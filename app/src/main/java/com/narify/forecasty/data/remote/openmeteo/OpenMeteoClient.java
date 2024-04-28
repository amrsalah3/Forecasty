package com.narify.forecasty.data.remote.openmeteo;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Single;

import com.narify.forecasty.data.local.DataManager;
import com.narify.forecasty.data.remote.HttpsTrustManager;
import com.narify.forecasty.models.OpenMeteoWeatherResponse;

@Singleton
public class OpenMeteoClient {

    private final OpenMeteoService openMeteoService;

    @Inject
    public OpenMeteoClient(OpenMeteoService openMeteoService) {
        this.openMeteoService = openMeteoService;
        HttpsTrustManager.allowAllSSL();
    }

    public Single<OpenMeteoWeatherResponse> getWeather() {
        return openMeteoService.getWeather(
                DataManager.getLocation().getLatitude(),
                DataManager.getLocation().getLongitude()
        );
    }
}
