package com.narify.v2forecasty.data.remote.openmeteo;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import com.narify.v2forecasty.models.OpenMeteoWeatherResponse;
import com.narify.v2forecasty.models.SingleWeather;
import com.narify.v2forecasty.utils.DateUtils;

public class OpenMeteoMapper {

    private final static int MAX_NUM_OF_HOURLY_FORECASTS = 168;
    private int hourlyForecastsCounter = 0;

    @Inject
    public OpenMeteoMapper() {
    }


    public List<SingleWeather> mapToWeatherList(OpenMeteoWeatherResponse response) {
        if (response == null) return new ArrayList<>();
        hourlyForecastsCounter = 0;

        List<SingleWeather> dailyList = new ArrayList<>();
        for (int i = 0; i < response.getDaily().getTime().size(); i++) {
            OpenMeteoWeatherResponse.Daily day = response.getDaily();
            if (DateUtils.isPastDay(day.getTime().get(i) * 1000)) continue;

            SingleWeather weather = new SingleWeather();
            weather.setMainCondition(day.getWeatherCode().get(i).toString());
            weather.setDescription(day.getWeatherCode().get(i).toString());
            weather.setTimeInMillis(day.getTime().get(i) * 1000);
            weather.setSunrise(day.getSunrise().get(i) * 1000);
            weather.setSunset(day.getSunset().get(i) * 1000);
            weather.setPressure((int) Math.round(response.getHourly().getPressure().get(hourlyForecastsCounter)));
            weather.setHumidity(day.getPrecipitationProbabilityMax().get(i).intValue());
            weather.setWindSpeed((int) Math.round(day.getWindSpeed10mMax().get(i)));
            weather.setMinTemp((int) Math.round(day.getTemperature2mMin().get(i)));
            weather.setMaxTemp((int) Math.round(day.getTemperature2mMax().get(i)));
            weather.setDay(true);
            weather.setHoursList(mapHourlyForecasts(weather, response));

            dailyList.add(weather);
        }

        return dailyList;
    }

    private List<SingleWeather> mapHourlyForecasts(SingleWeather wrappingDay, OpenMeteoWeatherResponse response) {
        List<SingleWeather> hourlyList = new ArrayList<>();

        long timeAt00 = DateUtils.getLocalTimeMillisAt00(wrappingDay.getTimeInMillis());
        long timeAt24 = DateUtils.getLocalTimeMillisAfter24(timeAt00);

        OpenMeteoWeatherResponse.Hourly hourly = response.getHourly();

        // Get hourly forecast for the given wrapping day
        while (hourlyForecastsCounter < MAX_NUM_OF_HOURLY_FORECASTS) {
            SingleWeather weather = new SingleWeather();

            long hourTiming = hourly.getTime().get(hourlyForecastsCounter) * 1000;
            // If the hour is after the wrapping day, then break and move on to the next day
            if (!(hourTiming >= timeAt00 && hourTiming < timeAt24)) break;

            weather.setMainCondition(hourly.getWeatherCode().get(hourlyForecastsCounter).toString());
            weather.setDescription(hourly.getWeatherCode().get(hourlyForecastsCounter).toString());
            weather.setTimeInMillis(hourTiming);
            weather.setTemperature((int) Math.round(hourly.getTemperature2m().get(hourlyForecastsCounter)));
            weather.setDay(false);

            hourlyList.add(weather);

            hourlyForecastsCounter++;
        }

        return hourlyList;
    }

}
