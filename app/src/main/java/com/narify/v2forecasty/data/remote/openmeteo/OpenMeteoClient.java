package com.narify.v2forecasty.data.remote.openmeteo;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Single;

import com.narify.v2forecasty.data.local.DataManager;
import com.narify.v2forecasty.data.remote.HttpsTrustManager;
import com.narify.v2forecasty.models.OpenMeteoWeatherResponse;

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
