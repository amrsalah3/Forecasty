package com.narify.v2forecasty.di;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import android.app.Application;

import androidx.room.Room;

import com.narify.v2forecasty.data.local.db.AppDatabase;
import com.narify.v2forecasty.data.local.db.WeatherDao;

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
