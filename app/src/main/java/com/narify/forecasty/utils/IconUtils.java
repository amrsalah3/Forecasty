package com.narify.forecasty.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.narify.forecasty.R;

public class IconUtils {
    /* Main weather condition names in OWM -- (all in lowercase) */
    private static final String CLEAR_SKY = "clear";
    private static final String CLOUDS = "clouds";
    private static final String SNOW = "snow";
    private static final String RAIN = "rain";
    private static final String DRIZZLE = "drizzle";
    private static final String THUNDER_STORM = "thunderstorm";
    private static final String TORNADO = "tornado";
    /* Description of weather condition key words in OWM */
    private static final String FEW_CLOUDS = "few";
    private static final String SCATTERED_CLOUDS = "scattered";
    private static final String SHOWER_RAIN = "shower";


    /**
     * This function takes main string condition and string description of OWM weather and returns
     * icon resource id of that condition
     *
     * @param condition   is the main condition name of OWM weather condition
     * @param description is the sentence describing details of the condition
     * @param isNight     whether the current time is at night or day light
     * @return android resource id of the drawable icon representing the weather condition
     */
    public static int getWeatherIconResId(String condition, String description, boolean isNight) {
        int id;
        switch (condition.toLowerCase()) {
            case CLEAR_SKY:
                if (!isNight) id = R.drawable.ic_clear_sky_d;
                else id = R.drawable.ic_clear_sky_n;
                break;
            case CLOUDS:
                if (description.contains(FEW_CLOUDS)) {
                    if (!isNight) id = R.drawable.ic_few_clouds_d;
                    else id = R.drawable.ic_few_clouds_n;
                } else if (description.contains(SCATTERED_CLOUDS))
                    id = R.drawable.ic_scatter_clouds;
                else id = R.drawable.ic_broken_clouds;
                break;
            case SNOW:
                id = R.drawable.ic_snow;
                break;
            case RAIN:
                if (description.contains(SHOWER_RAIN)) id = R.drawable.ic_shower_rain;
                else id = R.drawable.ic_rain;
                break;
            case THUNDER_STORM:
                if (description.contains(RAIN) || description.contains(DRIZZLE))
                    id = R.drawable.ic_storm_rain;
                else {
                    if (!isNight) id = R.drawable.ic_storm_d;
                    else id = R.drawable.ic_storm_n;
                }
                break;
            case DRIZZLE:
                id = R.drawable.ic_drizzle;
                break;
            case TORNADO:
                id = R.drawable.ic_tornado;
                break;
            default:
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

