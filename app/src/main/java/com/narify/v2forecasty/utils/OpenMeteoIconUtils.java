package com.narify.v2forecasty.utils;

import static com.narify.v2forecasty.utils.OpenMeteoWeatherCodes.CLEAR;
import static com.narify.v2forecasty.utils.OpenMeteoWeatherCodes.CLOUDS;
import static com.narify.v2forecasty.utils.OpenMeteoWeatherCodes.DRIZZLE;
import static com.narify.v2forecasty.utils.OpenMeteoWeatherCodes.HEAVY;
import static com.narify.v2forecasty.utils.OpenMeteoWeatherCodes.LIGHT;
import static com.narify.v2forecasty.utils.OpenMeteoWeatherCodes.MODERATE;
import static com.narify.v2forecasty.utils.OpenMeteoWeatherCodes.RAIN;
import static com.narify.v2forecasty.utils.OpenMeteoWeatherCodes.SHOWER;
import static com.narify.v2forecasty.utils.OpenMeteoWeatherCodes.SNOW;
import static com.narify.v2forecasty.utils.OpenMeteoWeatherCodes.THUNDERSTORM;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.narify.v2forecasty.R;

public class OpenMeteoIconUtils {
    /**
     * This function takes weather condition code of OpenMeteo API and returns
     * icon resource id of that condition
     *
     * @param code    is the weather condition code of OpenMeteo
     * @param isNight whether the current time is at night or day light
     * @return android resource id of the drawable icon representing the weather condition
     */
    public static int getWeatherIconResId(int code, boolean isNight) {
        int id;
        if (CLEAR.contains(code)) {
            if (!isNight) id = R.drawable.ic_clear_sky_d;
            else id = R.drawable.ic_clear_sky_n;
        } else if (CLOUDS.contains(code)) {
            if (LIGHT.contains(code) || MODERATE.contains(code)) {
                if (!isNight) id = R.drawable.ic_few_clouds_d;
                else id = R.drawable.ic_few_clouds_n;
            } else if (HEAVY.contains(code)) {
                id = R.drawable.ic_broken_clouds;
            } else {
                id = R.drawable.ic_scatter_clouds;
            }
        } else if (SNOW.contains(code)) {
            id = R.drawable.ic_snow;
        } else if (RAIN.contains(code)) {
            if (SHOWER.contains(code)) id = R.drawable.ic_shower_rain;
            else id = R.drawable.ic_rain;
        } else if (THUNDERSTORM.contains(code)) {
            if (SHOWER.contains(code)) {
                id = R.drawable.ic_storm_rain;
            } else {
                if (!isNight) id = R.drawable.ic_storm_d;
                else id = R.drawable.ic_storm_n;
            }
        } else if (DRIZZLE.contains(code)) {
            id = R.drawable.ic_drizzle;
        } else {
            id = R.drawable.ic_mist;
        }

        return id;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    public static Bitmap scaleDownBitmap(Bitmap bitmap) {
        return bitmap = Bitmap.createScaledBitmap(bitmap,
                bitmap.getWidth() / 2,
                bitmap.getHeight() / 2,
                true);
    }


}

