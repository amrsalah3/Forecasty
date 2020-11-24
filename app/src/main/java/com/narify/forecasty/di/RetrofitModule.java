package com.narify.forecasty.di;

import com.narify.forecasty.data.remote.geonames.GeoNamesService;
import com.narify.forecasty.data.remote.openweathermap.OpenWeatherService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public class RetrofitModule {

    @Singleton
    @Provides
    public static GeoNamesService provideGeoNamesService() {
        return new Retrofit.Builder()
                .baseUrl(GeoNamesService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(GeoNamesService.class);
    }

    @Singleton
    @Provides
    public static OpenWeatherService provideOpenWeatherService() {
        return new Retrofit.Builder()
                .baseUrl(OpenWeatherService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(OpenWeatherService.class);
    }


}
