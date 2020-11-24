package com.narify.forecasty.models;

import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "weather")
public class SingleWeather {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "main_condition")
    private String mainCondition;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "timestamp")
    private long timeInMillis;

    @ColumnInfo(name = "pressure")
    private int pressure;

    @ColumnInfo(name = "humidity")
    private int humidity;

    @ColumnInfo(name = "wind_speed")
    private int windSpeed;

    /* if isDay is true, weather forecast is for a day and have min/max values,
    whereas temperature does not have value, and vice versa */
    @ColumnInfo(name = "is_day_forecast")
    private boolean isDay;

    /* Only for day forecast */
    @ColumnInfo(name = "sunrise")
    private long sunrise;

    @ColumnInfo(name = "sunset")
    private long sunset;

    @ColumnInfo(name = "min_temp")
    private int minTemp;

    @ColumnInfo(name = "max_temp")
    private int maxTemp;

    @ColumnInfo(name = "hours_list")
    private List<SingleWeather> hoursList;

    /* Only for hour forecast */
    @ColumnInfo(name = "temperature")
    private int temperature;


    public SingleWeather() {
        // Empty public constructor required for Room
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTimeInMillis() {
        return timeInMillis;
    }

    public void setTimeInMillis(long timeInMillis) {
        this.timeInMillis = timeInMillis;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getMainCondition() {
        return mainCondition;
    }

    public void setMainCondition(String mainCondition) {
        this.mainCondition = mainCondition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDay() {
        return isDay;
    }

    public void setDay(boolean day) {
        isDay = day;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public List<SingleWeather> getHoursList() {
        return hoursList;
    }

    public void setHoursList(List<SingleWeather> hoursList) {
        this.hoursList = hoursList;
    }

    @Ignore
    @Override
    public String toString() {
        return "SingleWeather{" +
                "id=" + id +
                ", timestamp=" + timeInMillis +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", mainCondition='" + mainCondition + '\'' +
                ", description='" + description + '\'' +
                ", isDay=" + isDay +
                ", temperature=" + temperature +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                ", hoursList=" + hoursList +
                '}';
    }
}
