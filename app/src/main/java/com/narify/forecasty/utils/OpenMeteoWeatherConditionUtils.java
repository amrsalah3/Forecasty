package com.narify.forecasty.utils;

import static com.narify.forecasty.utils.OpenMeteoWeatherCodes.CLEAR;
import static com.narify.forecasty.utils.OpenMeteoWeatherCodes.CLOUDS;
import static com.narify.forecasty.utils.OpenMeteoWeatherCodes.DRIZZLE;
import static com.narify.forecasty.utils.OpenMeteoWeatherCodes.FREEZING;
import static com.narify.forecasty.utils.OpenMeteoWeatherCodes.HEAVY;
import static com.narify.forecasty.utils.OpenMeteoWeatherCodes.LIGHT;
import static com.narify.forecasty.utils.OpenMeteoWeatherCodes.MODERATE;
import static com.narify.forecasty.utils.OpenMeteoWeatherCodes.RAIN;
import static com.narify.forecasty.utils.OpenMeteoWeatherCodes.SHOWER;
import static com.narify.forecasty.utils.OpenMeteoWeatherCodes.SNOW;
import static com.narify.forecasty.utils.OpenMeteoWeatherCodes.THUNDERSTORM;

import android.content.Context;

import com.narify.forecasty.R;
import com.narify.forecasty.singletons.AppContext;

public class OpenMeteoWeatherConditionUtils {

    public static String[] getConditionAndDescription(int code) {
        Context context = AppContext.get();
        String[] result = new String[2];
        if (CLEAR.contains(code)) {
            result[0] = context.getString(R.string.clear);
            result[1] = context.getString(R.string.clear_sky);
        } else if (CLOUDS.contains(code)) {
            result[0] = context.getString(R.string.Clouds);
            if (LIGHT.contains(code)) result[1] = context.getString(R.string.mainly_clear);
            else if (HEAVY.contains(code)) result[1] = context.getString(R.string.overcast_clouds);
            else result[1] = context.getString(R.string.partly_cloudy);
        } else if (DRIZZLE.contains(code)) {
            result[0] = context.getString(R.string.drizzle);
            if (LIGHT.contains(code)) result[1] = context.getString(R.string.light_drizzle);
            else if (HEAVY.contains(code)) result[1] = context.getString(R.string.heavy_drizzle);
            else result[1] = context.getString(R.string.shower_drizzle);
        } else if (RAIN.contains(code)) {
            result[0] = context.getString(R.string.rain);
            if (LIGHT.contains(code)) result[1] = context.getString(R.string.light_rain);
            else if (MODERATE.contains(code)) result[1] = context.getString(R.string.moderate_rain);
            else if (SHOWER.contains(code)) result[1] = context.getString(R.string.shower_rain);
            else if (FREEZING.contains(code)) result[1] = context.getString(R.string.freezing_rain);
            else result[1] = context.getString(R.string.heavy_rain);
        } else if (SNOW.contains(code)) {
            result[0] = context.getString(R.string.snow);
            if (LIGHT.contains(code)) result[1] = context.getString(R.string.light_snow);
            else if (MODERATE.contains(code)) result[1] = context.getString(R.string.moderate_snow);
            else if (SHOWER.contains(code)) result[1] = context.getString(R.string.shower_snow);
            else result[1] = context.getString(R.string.heavy_snow);
        } else if (THUNDERSTORM.contains(code)) {
            result[0] = context.getString(R.string.thunderstorm);
            if (SHOWER.contains(code))
                result[1] = context.getString(R.string.thunderstorm_heavy_rain);
            else result[1] = context.getString(R.string.heavy_thunderstorm);
        } else {
            result[0] = context.getString(R.string.foggy);
            result[1] = context.getString(R.string.haze);
        }

        return result;
    }

    public static String getWeatherCondition(int code) {
        Context context = AppContext.get();
        if (CLEAR.contains(code)) return context.getString(R.string.clear);
        else if (CLOUDS.contains(code)) return context.getString(R.string.Clouds);
        else if (DRIZZLE.contains(code)) return context.getString(R.string.drizzle);
        else if (RAIN.contains(code)) return context.getString(R.string.rain);
        else if (SNOW.contains(code)) return context.getString(R.string.snow);
        else if (THUNDERSTORM.contains(code)) return context.getString(R.string.thunderstorm);
        else return context.getString(R.string.foggy);
    }
}
