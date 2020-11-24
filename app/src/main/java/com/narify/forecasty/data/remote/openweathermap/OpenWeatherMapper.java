package com.narify.forecasty.data.remote.openweathermap;

import com.narify.forecasty.models.SingleWeather;
import com.narify.forecasty.models.WeatherResponse;
import com.narify.forecasty.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class OpenWeatherMapper {

    private final static int MAX_NUM_OF_HOURLY_FORECASTS = 48;
    private int hourlyForecastsCounter = 0;

    @Inject
    public OpenWeatherMapper() {
    }


    public List<SingleWeather> mapToWeatherList(WeatherResponse response) {
        if (response == null) return new ArrayList<>();
        hourlyForecastsCounter = 0;

        List<SingleWeather> dailyList = new ArrayList<>();
        for (int i = 0; i < response.getDaily().size(); i++) {
            WeatherResponse.Daily day = response.getDaily().get(i);
            if (DateUtils.isPastDay(day.getDt() * 1000)) continue;

            SingleWeather weather = new SingleWeather();
            weather.setMainCondition(day.getWeather().get(0).getMain());
            weather.setDescription(day.getWeather().get(0).getDescription());
            weather.setTimeInMillis(day.getDt() * 1000);
            weather.setSunrise(day.getSunrise() * 1000);
            weather.setSunset(day.getSunset() * 1000);
            weather.setPressure((int) day.getPressure());
            weather.setHumidity((int) day.getHumidity());
            weather.setWindSpeed((int) day.getWindSpeed());
            weather.setMinTemp((int) day.getTemp().getMin());
            weather.setMaxTemp((int) day.getTemp().getMax());
            weather.setDay(true);
            weather.setHoursList(mapHourlyForecasts(weather, response));

            dailyList.add(weather);
        }

        return dailyList;
    }

    private List<SingleWeather> mapHourlyForecasts(SingleWeather wrappingDay, WeatherResponse response) {
        List<SingleWeather> hourlyList = new ArrayList<>();

        long timeAt00 = DateUtils.getLocalTimeMillisAt00(wrappingDay.getTimeInMillis());
        long timeAt24 = DateUtils.getLocalTimeMillisAfter24(timeAt00);

        // Get hourly forecast for the given wrapping day
        while (hourlyForecastsCounter < MAX_NUM_OF_HOURLY_FORECASTS) {
            SingleWeather weather = new SingleWeather();
            WeatherResponse.Hourly hour = response.getHourly().get(hourlyForecastsCounter);

            long hourTiming = hour.getDt() * 1000;
            // If the hour is after the wrapping day, then break and move on to the next day
            if (!(hourTiming >= timeAt00 && hourTiming < timeAt24)) break;

            weather.setMainCondition(hour.getWeather().get(0).getMain());
            weather.setDescription(hour.getWeather().get(0).getDescription());
            weather.setTimeInMillis(hourTiming);
            weather.setPressure((int) hour.getPressure());
            weather.setHumidity((int) hour.getHumidity());
            weather.setWindSpeed((int) hour.getWindSpeed());
            weather.setTemperature((int) hour.getTemp());
            weather.setDay(false);

            hourlyList.add(weather);

            hourlyForecastsCounter++;
        }

        return hourlyList;
    }

}
