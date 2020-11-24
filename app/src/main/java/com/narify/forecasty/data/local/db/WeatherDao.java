package com.narify.forecasty.data.local.db;

import com.narify.forecasty.models.SingleWeather;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface WeatherDao {

    @Query("SELECT * FROM weather")
    LiveData<List<SingleWeather>> getAllWeather();

    @Query("SELECT * FROM weather")
    List<SingleWeather> getUnobservableWeatherList();

    @Insert
    void insertAll(List<SingleWeather> weatherList);

    @Query("DELETE FROM weather")
    void deleteAll();

}
