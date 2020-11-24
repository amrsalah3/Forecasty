package com.narify.forecasty.utils;

import android.content.Context;

import com.narify.forecasty.R;
import com.narify.forecasty.singletons.AppContext;

public class WeatherConditionUtils {

    /* Main conditions */
    private final static String CLEAR = "Clear";
    private final static String CLOUDS = "Clouds";
    private final static String DRIZZLE = "Drizzle";
    private final static String RAIN = "Rain";
    private final static String SNOW = "Snow";
    private final static String THUNDERSTORM = "Thunderstorm";
    private final static String TORNADO = "Tornado";

    /* Sub condition description keywords */
    private final static String FEW = "few";
    private final static String OVERCAST = "overcast";
    private final static String LIGHT = "light";
    private final static String MODERATE = "moderate";
    private final static String HEAVY = "heavy";
    private static final String RAGGED = "ragged";
    private final static String SHOWER = "shower";
    private static final String FREEZING = "freezing";


    public static String[] convertOwmToLocaleCondition(String main, String description) {
        Context context = AppContext.get();
        String[] result = new String[2];
        switch (main) {
            case CLEAR:
                result[0] = context.getString(R.string.clear);
                result[1] = context.getString(R.string.clear_sky);
                break;
            case CLOUDS:
                result[0] = context.getString(R.string.Clouds);
                if (description.contains(FEW)) result[1] = context.getString(R.string.few_clouds);
                else if (description.contains(OVERCAST))
                    result[1] = context.getString(R.string.overcast_clouds);
                else result[1] = context.getString(R.string.broken_clouds);
                break;
            case DRIZZLE:
                result[0] = context.getString(R.string.drizzle);
                if (description.contains(LIGHT))
                    result[1] = context.getString(R.string.light_drizzle);
                else if (description.contains(HEAVY))
                    result[1] = context.getString(R.string.heavy_drizzle);
                else if (description.contains(SHOWER))
                    result[1] = context.getString(R.string.shower_drizzle);
                else result[1] = context.getString(R.string.drizzle_rain);
                break;
            case RAIN:
                result[0] = context.getString(R.string.rain);
                if (description.contains(LIGHT)) result[1] = context.getString(R.string.light_rain);
                else if (description.contains(MODERATE))
                    result[1] = context.getString(R.string.moderate_rain);
                else if (description.contains(SHOWER))
                    result[1] = context.getString(R.string.shower_rain);
                else if (description.contains(FREEZING))
                    result[1] = context.getString(R.string.freezing_rain);
                else result[1] = context.getString(R.string.heavy_rain);
                break;
            case SNOW:
                result[0] = context.getString(R.string.snow);
                if (description.contains(LIGHT)) result[1] = context.getString(R.string.light_snow);
                else if (description.contains(HEAVY))
                    result[1] = context.getString(R.string.heavy_snow);
                else if (description.contains(SHOWER))
                    result[1] = context.getString(R.string.shower_snow);
                else if (description.contains(RAIN))
                    result[1] = context.getString(R.string.rain_and_snow);
                else result[1] = context.getString(R.string.moderate_snow);
                break;
            case THUNDERSTORM:
                result[0] = context.getString(R.string.thunderstorm);
                if (description.contains(RAIN) || description.contains(DRIZZLE)) {
                    if (description.contains(LIGHT))
                        result[1] = context.getString(R.string.thunderstorm_light_rain);
                    else if (description.contains(HEAVY))
                        result[1] = context.getString(R.string.thunderstorm_heavy_rain);
                    else result[1] = context.getString(R.string.thunderstorm_rain);
                    break;
                } else if (description.contains(HEAVY) || description.contains(RAGGED))
                    result[1] = context.getString(R.string.heavy_thunderstorm);
                else result[1] = context.getString(R.string.light_thunderstorm);
                break;
            case TORNADO:
                result[0] = context.getString(R.string.tornado);
                result[1] = context.getString(R.string.tornado);
                break;
            default:
                result[0] = context.getString(R.string.foggy);
                result[1] = context.getString(R.string.haze);
                break;
        }

        return result;
    }

    public static String convertOwmMainToLocaleCondition(String main) {
        Context context = AppContext.get();
        switch (main) {
            case CLEAR:
                return context.getString(R.string.clear);
            case CLOUDS:
                return context.getString(R.string.Clouds);
            case DRIZZLE:
                return context.getString(R.string.drizzle);
            case RAIN:
                return context.getString(R.string.rain);
            case SNOW:
                return context.getString(R.string.snow);
            case THUNDERSTORM:
                return context.getString(R.string.thunderstorm);
            case TORNADO:
                return context.getString(R.string.tornado);
            default:
                return context.getString(R.string.foggy);
        }

    }
}
