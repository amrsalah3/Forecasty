package com.narify.v2forecasty.utils;

import java.util.Calendar;

import android.text.format.DateFormat;

import com.narify.v2forecasty.R;
import com.narify.v2forecasty.singletons.AppResources;

public class DateUtils {

    /**
     * This function takes a time and converts it to a readable day of the week
     *
     * @param serverTimeInMillis to check whether the time given is today, tomorrow, or later
     * @return string name of the day. If it is today or tomorrow, the value is "Today" or "Tomorrow".
     */
    public static String getFormattedDayFromMillis(long serverTimeInMillis) {
        long currentTimeMillis = Calendar.getInstance().getTimeInMillis();
        long timeAtStartOfTheDay = getLocalTimeMillisAt00(currentTimeMillis);
        long timeAfterOneDay = getLocalTimeMillisAfter24(timeAtStartOfTheDay);
        long timeAfterTwoDays = getLocalTimeMillisAfter24(timeAfterOneDay);
        if (serverTimeInMillis > timeAtStartOfTheDay) {
            if (serverTimeInMillis < timeAfterOneDay)
                return AppResources.get().getString(R.string.today);
            else if (serverTimeInMillis < timeAfterTwoDays)
                return AppResources.get().getString(R.string.tomorrow);
        }
        return DateFormat.format("EEEE", serverTimeInMillis).toString();
    }

    /**
     * This function takes a time and converts it to a readable hour of a day (24-Hour format)
     *
     * @param serverTimeInMillis that is to be converted to a readable string
     * @return hour string (i.e. 15:00)
     */
    public static String getFormattedHourFromMillis(long serverTimeInMillis) {
        return DateFormat.format("kk:mm", serverTimeInMillis).toString();
    }

    /**
     * This function gets time stamp at 00:00:00 for the given time's day
     *
     * @param referenceTimeInMillis the time at the day that is its start to be returned
     * @return long time in millis at 00:00:00 for that day
     */
    public static long getLocalTimeMillisAt00(long referenceTimeInMillis) {
        Calendar cal = Calendar.getInstance();

        cal.setTimeInMillis(referenceTimeInMillis);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTimeInMillis();
    }

    /**
     * This function computes time stamp after 24 hours from a given reference time
     *
     * @param referenceTimeInMillis that a 24 hours is add to.
     * @return long time in millis at 00:00:00 after 24 hours from the given time
     */
    public static long getLocalTimeMillisAfter24(long referenceTimeInMillis) {
        return referenceTimeInMillis + 24 * 60 * 60 * 1000;
    }

    /**
     * This function determines whether a given time is today or not
     *
     * @param referenceTimeMillis long time in millis that is to be checked if today or not
     * @return Boolean true if the given time is on today, otherwise false
     */
    public static boolean isPastDay(long referenceTimeMillis) {
        long currentDayStart = getLocalTimeMillisAt00(Calendar.getInstance().getTimeInMillis());
        long currentDayEnd = getLocalTimeMillisAfter24(currentDayStart);

        return referenceTimeMillis < currentDayStart;
    }

    /**
     * This function determines whether the given time is at night or not
     *
     * @param timeInMillis that is to be checked
     * @param sunset       time according to OWM servers (must be converted to milliseconds)
     * @return true if night, otherwise false
     */
    public static boolean isNight(long timeInMillis, long sunset) {
        return timeInMillis > sunset;
    }

    /**
     * This function calculates time left for the end of the current day
     *
     * @return long time in millis left
     */
    public static long getTimeLeftForDayEnd() {
        Calendar calenderAt24 = Calendar.getInstance();
        calenderAt24.set(Calendar.HOUR_OF_DAY, 24);
        calenderAt24.set(Calendar.MINUTE, 0);
        calenderAt24.set(Calendar.SECOND, 0);
        calenderAt24.set(Calendar.MILLISECOND, 0);

        return calenderAt24.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();
    }

    public static int getHourFromMillis(long timeMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMillis);

        return calendar.get(Calendar.HOUR_OF_DAY);
    }

}
