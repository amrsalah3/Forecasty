package com.narify.v2forecasty.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpenMeteoWeatherResponse {

    @SerializedName("latitude")
    @Expose
    private double latitude;
    @SerializedName("longitude")
    @Expose
    private double longitude;
    @SerializedName("generationtime_ms")
    @Expose
    private double generationtimeMs;
    @SerializedName("utc_offset_seconds")
    @Expose
    private long utcOffsetSeconds;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("timezone_abbreviation")
    @Expose
    private String timezoneAbbreviation;
    @SerializedName("elevation")
    @Expose
    private long elevation;
    @SerializedName("hourly_units")
    @Expose
    private HourlyUnits hourlyUnits;
    @SerializedName("hourly")
    @Expose
    private Hourly hourly;
    @SerializedName("daily_units")
    @Expose
    private DailyUnits dailyUnits;
    @SerializedName("daily")
    @Expose
    private Daily daily;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getGenerationtimeMs() {
        return generationtimeMs;
    }

    public void setGenerationtimeMs(double generationtimeMs) {
        this.generationtimeMs = generationtimeMs;
    }

    public long getUtcOffsetSeconds() {
        return utcOffsetSeconds;
    }

    public void setUtcOffsetSeconds(long utcOffsetSeconds) {
        this.utcOffsetSeconds = utcOffsetSeconds;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTimezoneAbbreviation() {
        return timezoneAbbreviation;
    }

    public void setTimezoneAbbreviation(String timezoneAbbreviation) {
        this.timezoneAbbreviation = timezoneAbbreviation;
    }

    public long getElevation() {
        return elevation;
    }

    public void setElevation(long elevation) {
        this.elevation = elevation;
    }

    public HourlyUnits getHourlyUnits() {
        return hourlyUnits;
    }

    public void setHourlyUnits(HourlyUnits hourlyUnits) {
        this.hourlyUnits = hourlyUnits;
    }

    public Hourly getHourly() {
        return hourly;
    }

    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    public DailyUnits getDailyUnits() {
        return dailyUnits;
    }

    public void setDailyUnits(DailyUnits dailyUnits) {
        this.dailyUnits = dailyUnits;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    @Override
    public String toString() {
        return "OpenMeteoWeatherResponse{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", generationtimeMs=" + generationtimeMs +
                ", utcOffsetSeconds=" + utcOffsetSeconds +
                ", timezone='" + timezone + '\'' +
                ", timezoneAbbreviation='" + timezoneAbbreviation + '\'' +
                ", elevation=" + elevation +
                ", hourlyUnits=" + hourlyUnits +
                ", hourly=" + hourly +
                ", dailyUnits=" + dailyUnits +
                ", daily=" + daily +
                '}';
    }

    public class Daily {

        @SerializedName("time")
        @Expose
        private List<Long> time;
        @SerializedName("weather_code")
        @Expose
        private List<Long> weatherCode;
        @SerializedName("temperature_2m_max")
        @Expose
        private List<Double> temperature2mMax;
        @SerializedName("temperature_2m_min")
        @Expose
        private List<Double> temperature2mMin;
        @SerializedName("sunrise")
        @Expose
        private List<Long> sunrise;
        @SerializedName("sunset")
        @Expose
        private List<Long> sunset;
        @SerializedName("precipitation_probability_max")
        @Expose
        private List<Long> precipitationProbabilityMax;
        @SerializedName("wind_speed_10m_max")
        @Expose
        private List<Double> windSpeed10mMax;

        public List<Long> getTime() {
            return time;
        }

        public void setTime(List<Long> time) {
            this.time = time;
        }

        public List<Long> getWeatherCode() {
            return weatherCode;
        }

        public void setWeatherCode(List<Long> weatherCode) {
            this.weatherCode = weatherCode;
        }

        public List<Double> getTemperature2mMax() {
            return temperature2mMax;
        }

        public void setTemperature2mMax(List<Double> temperature2mMax) {
            this.temperature2mMax = temperature2mMax;
        }

        public List<Double> getTemperature2mMin() {
            return temperature2mMin;
        }

        public void setTemperature2mMin(List<Double> temperature2mMin) {
            this.temperature2mMin = temperature2mMin;
        }

        public List<Long> getSunrise() {
            return sunrise;
        }

        public void setSunrise(List<Long> sunrise) {
            this.sunrise = sunrise;
        }

        public List<Long> getSunset() {
            return sunset;
        }

        public void setSunset(List<Long> sunset) {
            this.sunset = sunset;
        }

        public List<Long> getPrecipitationProbabilityMax() {
            return precipitationProbabilityMax;
        }

        public void setPrecipitationProbabilityMax(List<Long> precipitationProbabilityMax) {
            this.precipitationProbabilityMax = precipitationProbabilityMax;
        }

        public List<Double> getWindSpeed10mMax() {
            return windSpeed10mMax;
        }

        public void setWindSpeed10mMax(List<Double> windSpeed10mMax) {
            this.windSpeed10mMax = windSpeed10mMax;
        }

        @Override
        public String toString() {
            return "Daily{" +
                    "time=" + time +
                    ", weatherCode=" + weatherCode +
                    ", temperature2mMax=" + temperature2mMax +
                    ", temperature2mMin=" + temperature2mMin +
                    ", sunrise=" + sunrise +
                    ", sunset=" + sunset +
                    ", precipitationProbabilityMax=" + precipitationProbabilityMax +
                    ", windSpeed10mMax=" + windSpeed10mMax +
                    '}';
        }
    }

    public class DailyUnits {

        @SerializedName("time")
        @Expose
        private String time;
        @SerializedName("weather_code")
        @Expose
        private String weatherCode;
        @SerializedName("temperature_2m_max")
        @Expose
        private String temperature2mMax;
        @SerializedName("temperature_2m_min")
        @Expose
        private String temperature2mMin;
        @SerializedName("sunrise")
        @Expose
        private String sunrise;
        @SerializedName("sunset")
        @Expose
        private String sunset;
        @SerializedName("precipitation_probability_max")
        @Expose
        private String precipitationProbabilityMax;
        @SerializedName("wind_speed_10m_max")
        @Expose
        private String windSpeed10mMax;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getWeatherCode() {
            return weatherCode;
        }

        public void setWeatherCode(String weatherCode) {
            this.weatherCode = weatherCode;
        }

        public String getTemperature2mMax() {
            return temperature2mMax;
        }

        public void setTemperature2mMax(String temperature2mMax) {
            this.temperature2mMax = temperature2mMax;
        }

        public String getTemperature2mMin() {
            return temperature2mMin;
        }

        public void setTemperature2mMin(String temperature2mMin) {
            this.temperature2mMin = temperature2mMin;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public String getPrecipitationProbabilityMax() {
            return precipitationProbabilityMax;
        }

        public void setPrecipitationProbabilityMax(String precipitationProbabilityMax) {
            this.precipitationProbabilityMax = precipitationProbabilityMax;
        }

        public String getWindSpeed10mMax() {
            return windSpeed10mMax;
        }

        public void setWindSpeed10mMax(String windSpeed10mMax) {
            this.windSpeed10mMax = windSpeed10mMax;
        }

        @Override
        public String toString() {
            return "DailyUnits{" +
                    "time='" + time + '\'' +
                    ", weatherCode='" + weatherCode + '\'' +
                    ", temperature2mMax='" + temperature2mMax + '\'' +
                    ", temperature2mMin='" + temperature2mMin + '\'' +
                    ", sunrise='" + sunrise + '\'' +
                    ", sunset='" + sunset + '\'' +
                    ", precipitationProbabilityMax='" + precipitationProbabilityMax + '\'' +
                    ", windSpeed10mMax='" + windSpeed10mMax + '\'' +
                    '}';
        }
    }

    public class Hourly {

        @SerializedName("time")
        @Expose
        private List<Long> time;
        @SerializedName("temperature_2m")
        @Expose
        private List<Double> temperature2m;
        @SerializedName("weather_code")
        @Expose
        private List<Long> weatherCode;
        @SerializedName("pressure_msl")
        @Expose
        private List<Double> pressure;

        public List<Long> getTime() {
            return time;
        }

        public void setTime(List<Long> time) {
            this.time = time;
        }

        public List<Double> getTemperature2m() {
            return temperature2m;
        }

        public void setTemperature2m(List<Double> temperature2m) {
            this.temperature2m = temperature2m;
        }

        public List<Long> getWeatherCode() {
            return weatherCode;
        }

        public void setWeatherCode(List<Long> weatherCode) {
            this.weatherCode = weatherCode;
        }

        public List<Double> getPressure() {
            return pressure;
        }

        public void setPressure(List<Double> pressure) {
            this.pressure = pressure;
        }

        @Override
        public String toString() {
            return "Hourly{" +
                    "time=" + time +
                    ", temperature2m=" + temperature2m +
                    ", weatherCode=" + weatherCode +
                    ", pressure=" + pressure +
                    '}';
        }
    }

    public class HourlyUnits {

        @SerializedName("time")
        @Expose
        private String time;
        @SerializedName("temperature_2m")
        @Expose
        private String temperature2m;
        @SerializedName("weather_code")
        @Expose
        private String weatherCode;
        @SerializedName("pressure_msl")
        @Expose
        private String pressure;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTemperature2m() {
            return temperature2m;
        }

        public void setTemperature2m(String temperature2m) {
            this.temperature2m = temperature2m;
        }

        public String getWeatherCode() {
            return weatherCode;
        }

        public void setWeatherCode(String weatherCode) {
            this.weatherCode = weatherCode;
        }

        public String getPressure() {
            return pressure;
        }

        public void setPressure(String pressure) {
            this.pressure = pressure;
        }

        @Override
        public String toString() {
            return "HourlyUnits{" +
                    "time='" + time + '\'' +
                    ", temperature2m='" + temperature2m + '\'' +
                    ", weatherCode='" + weatherCode + '\'' +
                    ", pressure=" + pressure +
                    '}';
        }
    }
}
