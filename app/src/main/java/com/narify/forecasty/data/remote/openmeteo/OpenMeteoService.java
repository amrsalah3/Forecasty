package com.narify.forecasty.data.remote.openmeteo;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

import com.narify.forecasty.models.OpenMeteoWeatherResponse;

public interface OpenMeteoService {
    String BASE_URL = "https://api.open-meteo.com/v1/";

    @GET("forecast?daily=weather_code,temperature_2m_max,temperature_2m_min,sunrise,sunset," +
            "precipitation_probability_max,wind_speed_10m_max" +
            "&hourly=temperature_2m,weather_code,pressure_msl" +
            "&wind_speed_unit=ms" +
            "&timeformat=unixtime" +
            "&timezone=auto"
    )
    Single<OpenMeteoWeatherResponse> getWeather(
            @Query("latitude") String latitude,
            @Query("longitude") String longitude
    );
}
