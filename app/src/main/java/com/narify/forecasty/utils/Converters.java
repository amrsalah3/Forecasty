package com.narify.forecasty.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.narify.forecasty.models.SingleWeather;

import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import androidx.room.TypeConverter;

public class Converters {
    private static final Gson gson = new Gson();

    @TypeConverter
    public static List<SingleWeather> jsonToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<SingleWeather>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String listToJson(List<SingleWeather> weatherList) {
        return gson.toJson(weatherList);
    }

    public static <T> String objToJson(T object) {
        return gson.toJson(object);
    }

    public static <T> T jsonToObj(String json, Class<T> type) throws JSONException {
        return gson.fromJson(json, type);
    }


}
