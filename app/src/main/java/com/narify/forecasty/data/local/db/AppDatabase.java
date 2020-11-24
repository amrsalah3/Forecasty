package com.narify.forecasty.data.local.db;

import com.narify.forecasty.models.SingleWeather;
import com.narify.forecasty.utils.Converters;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = SingleWeather.class, version = 2, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_FILE_NAME = "weather_database";

    public abstract WeatherDao weatherDao();
}


