package com.narify.v2forecasty.utils;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

import com.narify.v2forecasty.R;
import com.narify.v2forecasty.models.SingleWeather;
import com.narify.v2forecasty.singletons.AppResources;

@Singleton
public class UnitUtils {

    /**
     * This function receives a unit system and returns the temperature unit symbol
     *
     * @param unitSystem used to determine the symbol of the temperature
     * @return a string contain only the symbol of the temperature
     */
    public static String getTemperatureSymbol(String unitSystem) {
        if (AppResources.get().getString(R.string.imperial).equals(unitSystem)) {
            return AppResources.get().getString(R.string.symbol_fahrenheit);
        } else {
            return AppResources.get().getString(R.string.symbol_celsius);
        }
    }

    /**
     * This function receives a unit system and returns the wind speed unit symbol
     *
     * @param unitSystem used to determine the symbol of the wind speed
     * @return a string contain only the symbol of the wind speed
     */
    public static String getWindSpeedUnit(String unitSystem) {
        if (AppResources.get().getString(R.string.imperial).equals(unitSystem)) {
            return AppResources.get().getString(R.string.symbol_miles_per_hour);
        } else {
            return AppResources.get().getString(R.string.symbol_metres_per_second);
        }
    }

    /**
     * This function returns the pressure unit symbol
     *
     * @return a string contain only the symbol of the pressure
     */
    public static String getPressureUnit() {
        return AppResources.get().getString(R.string.symbol_hPa);
    }

    /**
     * This function returns the humidity symbol
     *
     * @return a string contain only the symbol of the humidity
     */
    public static String getHumidityUnit() {
        return AppResources.get().getString(R.string.symbol_humidity);
    }

    public static List<SingleWeather> convertWeatherListUnits(List<SingleWeather> oldData,
                                                              boolean toImperial) {
        if (toImperial)
            return UnitUtils.weatherMetricToImperial(oldData);
        else
            return UnitUtils.weatherImperialToMetric(oldData);
    }

    /**
     * This function receives a weather list of type SingleWeather and
     * converts its data units from Metric to Imperial system
     *
     * @param weatherList List of weather data in Metric system
     * @return List of weather data in Imperial system
     */
    public static List<SingleWeather> weatherMetricToImperial(List<SingleWeather> weatherList) {
        for (SingleWeather dailyWeather : weatherList) {
            dailyWeather.setMinTemp(UnitUtils.celsiusToFahrenheit(dailyWeather.getMinTemp()));
            dailyWeather.setMaxTemp(UnitUtils.celsiusToFahrenheit(dailyWeather.getMaxTemp()));
            dailyWeather.setWindSpeed(UnitUtils.mpsToMiph(dailyWeather.getWindSpeed()));
            for (SingleWeather hourlyWeather : dailyWeather.getHoursList()) {
                hourlyWeather.setTemperature(UnitUtils.celsiusToFahrenheit(hourlyWeather.getTemperature()));
                hourlyWeather.setWindSpeed(UnitUtils.mpsToMiph(hourlyWeather.getWindSpeed()));
            }
        }
        return weatherList;
    }

    /**
     * This function receives a weather list of type SingleWeather and
     * converts its data units from Imperial to Metric system
     *
     * @param weatherList List of weather data in Imperial system
     * @return List of weather data in Metric system
     */
    public static List<SingleWeather> weatherImperialToMetric(List<SingleWeather> weatherList) {
        List<SingleWeather> updatedWeatherList = new ArrayList<>(weatherList);
        for (SingleWeather dailyWeather : updatedWeatherList) {
            dailyWeather.setMinTemp(UnitUtils.fahrenheitToCelsius(dailyWeather.getMinTemp()));
            dailyWeather.setMaxTemp(UnitUtils.fahrenheitToCelsius(dailyWeather.getMaxTemp()));
            dailyWeather.setWindSpeed(UnitUtils.miphToMps(dailyWeather.getWindSpeed()));
            for (SingleWeather hourlyWeather : dailyWeather.getHoursList()) {
                hourlyWeather.setTemperature(UnitUtils.fahrenheitToCelsius(hourlyWeather.getTemperature()));
                hourlyWeather.setWindSpeed(UnitUtils.miphToMps(hourlyWeather.getWindSpeed()));
            }
        }
        return updatedWeatherList;
    }

    /**
     * Convert temperature in celsius to fahrenheit
     *
     * @param celsiusProperty Temperature in celsius
     * @return Temperature in fahrenheit
     */
    public static int celsiusToFahrenheit(int celsiusProperty) {
        return (int) Math.round((celsiusProperty * 9.0 / 5.0) + 32);
    }

    /**
     * Convert temperature in fahrenheit to celsius
     *
     * @param fahrenheitProperty Temperature in fahrenheit
     * @return Temperature in celsius
     */
    public static int fahrenheitToCelsius(int fahrenheitProperty) {
        return (int) Math.round((fahrenheitProperty - 32.0) * 5 / 9);
    }

    /**
     * Convert speed from metres-per-second to miles-per-hour
     *
     * @param mpsProperty speed in metres-per-second
     * @return speed in miles-per-hour
     */
    public static int mpsToMiph(int mpsProperty) {
        return (int) Math.round(mpsProperty * 2.237);
    }

    /**
     * Convert speed from miles-per-hour to metres-per-second
     *
     * @param miphProperty speed in miles-per-hour
     * @return speed in metres-per-second
     */
    public static int miphToMps(int miphProperty) {
        return (int) Math.round(miphProperty / 2.237);
    }


}
