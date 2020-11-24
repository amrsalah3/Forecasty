package com.narify.forecasty.data.remote.openweathermap;

import com.narify.forecasty.models.WeatherResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherService {
    String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    @GET("onecall?units=metric")
    Single<WeatherResponse> getWeather(@Query("lat") String latitude,
                                       @Query("lon") String longitude,
                                       @Query("appid") String apiKey
    );
}
