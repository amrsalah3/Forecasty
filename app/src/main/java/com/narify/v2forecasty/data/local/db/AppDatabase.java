package com.narify.v2forecasty.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.narify.v2forecasty.models.SingleWeather;
import com.narify.v2forecasty.utils.Converters;

@Database(entities = SingleWeather.class, version = 2, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_FILE_NAME = "weather_database";

    public abstract WeatherDao weatherDao();
}


