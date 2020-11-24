package com.narify.forecasty.di;


import android.app.Application;

import com.narify.forecasty.data.local.db.AppDatabase;
import com.narify.forecasty.data.local.db.WeatherDao;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DatabaseModule {
    @Singleton
    @Provides
    public static AppDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application,
                AppDatabase.class, AppDatabase.DATABASE_FILE_NAME)
                .build();
    }

    @Provides
    public static WeatherDao provideWeatherDao(AppDatabase appDatabase) {
        return appDatabase.weatherDao();
    }

}
