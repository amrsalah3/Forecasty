package com.narify.v2forecasty.utils;

import java.util.Calendar;

import android.graphics.drawable.Drawable;

import com.narify.v2forecasty.R;
import com.narify.v2forecasty.data.local.DataManager;
import com.narify.v2forecasty.models.SingleWeather;
import com.narify.v2forecasty.singletons.AppResources;

public class WeatherFormat {

    public static String getTime(SingleWeather weather) {
        if (weather.isDay())
            return DateUtils.getFormattedDayFromMillis(weather.getTimeInMillis());
        else
            return DateUtils.getFormattedHourFromMillis(weather.getTimeInMillis());
    }

    public static String[] getFullCondition(SingleWeather weather) {
        int weatherCode = Integer.parseInt(weather.getMainCondition());
        return OpenMeteoWeatherConditionUtils.getConditionAndDescription(weatherCode);
    }

    public static String getMainCondition(SingleWeather weather) {
        int weatherCode = Integer.parseInt(weather.getMainCondition());
        return OpenMeteoWeatherConditionUtils.getWeatherCondition(weatherCode);
    }

    public static String getTemperature(SingleWeather weather) {
        if (weather.isDay()) {
            return String.format(AppResources.get().getString(R.string.day_temperature_text),
                    weather.getMaxTemp(),
                    weather.getMinTemp(),
                    UnitUtils.getTemperatureSymbol(DataManager.getUnitSystem()));
        } else {
            return String.format(AppResources.get().getString(R.string.hour_temperature_text),
                    weather.getTemperature(),
                    UnitUtils.getTemperatureSymbol(DataManager.getUnitSystem()));
        }

    }

    public static Drawable getIconDrawable(SingleWeather weather, long sunset) {
        boolean isNight;
        if (weather.isDay()) {
            isNight = DateUtils.isPastDay(weather.getTimeInMillis())
                    && DateUtils.isNight(Calendar.getInstance().getTimeInMillis(), sunset);
        } else {
            isNight = DateUtils.isNight(weather.getTimeInMillis(), sunset);
        }

        int weatherCode = Integer.parseInt(weather.getMainCondition());
        int iconResId = OpenMeteoIconUtils.getWeatherIconResId(weatherCode, isNight);

        return AppResources.get().getDrawable(iconResId);
    }

    public static String getPressure(SingleWeather weather) {
        return String.format(AppResources.get().getString(R.string.pressure_text),
                weather.getPressure(),
                UnitUtils.getPressureUnit());
    }

    public static String getHumidity(SingleWeather weather) {
        return String.format(AppResources.get().getString(R.string.humidity_text),
                weather.getHumidity(),
                UnitUtils.getHumidityUnit());
    }

    public static String getWindSpeed(SingleWeather weather) {
        return String.format(AppResources.get().getString(R.string.wind_speed_text),
                weather.getWindSpeed(),
                UnitUtils.getWindSpeedUnit(DataManager.getUnitSystem()));

    }


}
