package com.narify.forecasty.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {

    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lon")
    @Expose
    private double lon;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("timezone_offset")
    @Expose
    private long timezoneOffset;
    @SerializedName("current")
    @Expose
    private Current current;
    @SerializedName("hourly")
    @Expose
    private List<Hourly> hourly = null;
    @SerializedName("daily")
    @Expose
    private List<Daily> daily = null;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public long getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(long timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public List<Hourly> getHourly() {
        return hourly;
    }

    public void setHourly(List<Hourly> hourly) {
        this.hourly = hourly;
    }

    public List<Daily> getDaily() {
        return daily;
    }

    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", timezone='" + timezone + '\'' +
                ", timezoneOffset=" + timezoneOffset +
                ", current=" + current +
                ", hourly=" + hourly +
                ", daily=" + daily +
                '}';
    }

    public class Current {

        @SerializedName("dt")
        @Expose
        private long dt;
        @SerializedName("sunrise")
        @Expose
        private long sunrise;
        @SerializedName("sunset")
        @Expose
        private long sunset;
        @SerializedName("temp")
        @Expose
        private double temp;
        @SerializedName("feels_like")
        @Expose
        private double feelsLike;
        @SerializedName("pressure")
        @Expose
        private long pressure;
        @SerializedName("humidity")
        @Expose
        private long humidity;
        @SerializedName("dew_point")
        @Expose
        private double dewPoint;
        @SerializedName("uvi")
        @Expose
        private double uvi;
        @SerializedName("clouds")
        @Expose
        private long clouds;
        @SerializedName("visibility")
        @Expose
        private long visibility;
        @SerializedName("wind_speed")
        @Expose
        private double windSpeed;
        @SerializedName("wind_deg")
        @Expose
        private long windDeg;
        @SerializedName("weather")
        @Expose
        private List<Weather> weather = null;

        public long getDt() {
            return dt;
        }

        public void setDt(long dt) {
            this.dt = dt;
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

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getFeelsLike() {
            return feelsLike;
        }

        public void setFeelsLike(double feelsLike) {
            this.feelsLike = feelsLike;
        }

        public long getPressure() {
            return pressure;
        }

        public void setPressure(long pressure) {
            this.pressure = pressure;
        }

        public long getHumidity() {
            return humidity;
        }

        public void setHumidity(long humidity) {
            this.humidity = humidity;
        }

        public double getDewPoint() {
            return dewPoint;
        }

        public void setDewPoint(double dewPoint) {
            this.dewPoint = dewPoint;
        }

        public double getUvi() {
            return uvi;
        }

        public void setUvi(double uvi) {
            this.uvi = uvi;
        }

        public long getClouds() {
            return clouds;
        }

        public void setClouds(long clouds) {
            this.clouds = clouds;
        }

        public long getVisibility() {
            return visibility;
        }

        public void setVisibility(long visibility) {
            this.visibility = visibility;
        }

        public double getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
        }

        public long getWindDeg() {
            return windDeg;
        }

        public void setWindDeg(long windDeg) {
            this.windDeg = windDeg;
        }

        public List<Weather> getWeather() {
            return weather;
        }

        public void setWeather(List<Weather> weather) {
            this.weather = weather;
        }

        @Override
        public String toString() {
            return "Current{" +
                    "dt=" + dt +
                    ", sunrise=" + sunrise +
                    ", sunset=" + sunset +
                    ", temp=" + temp +
                    ", feelsLike=" + feelsLike +
                    ", pressure=" + pressure +
                    ", humidity=" + humidity +
                    ", dewPoint=" + dewPoint +
                    ", uvi=" + uvi +
                    ", clouds=" + clouds +
                    ", visibility=" + visibility +
                    ", windSpeed=" + windSpeed +
                    ", windDeg=" + windDeg +
                    ", weather=" + weather +
                    '}';
        }
    }

    public class Daily {

        @SerializedName("dt")
        @Expose
        private long dt;
        @SerializedName("sunrise")
        @Expose
        private long sunrise;
        @SerializedName("sunset")
        @Expose
        private long sunset;
        @SerializedName("temp")
        @Expose
        private Temp temp;
        @SerializedName("feels_like")
        @Expose
        private FeelsLike feelsLike;
        @SerializedName("pressure")
        @Expose
        private long pressure;
        @SerializedName("humidity")
        @Expose
        private long humidity;
        @SerializedName("dew_point")
        @Expose
        private double dewPoint;
        @SerializedName("wind_speed")
        @Expose
        private double windSpeed;
        @SerializedName("wind_deg")
        @Expose
        private long windDeg;
        @SerializedName("weather")
        @Expose
        private List<Weather> weather = null;
        @SerializedName("clouds")
        @Expose
        private long clouds;
        @SerializedName("pop")
        @Expose
        private double pop;
        @SerializedName("uvi")
        @Expose
        private double uvi;
        @SerializedName("rain")
        @Expose
        private double rain;

        public long getDt() {
            return dt;
        }

        public void setDt(long dt) {
            this.dt = dt;
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

        public Temp getTemp() {
            return temp;
        }

        public void setTemp(Temp temp) {
            this.temp = temp;
        }

        public FeelsLike getFeelsLike() {
            return feelsLike;
        }

        public void setFeelsLike(FeelsLike feelsLike) {
            this.feelsLike = feelsLike;
        }

        public long getPressure() {
            return pressure;
        }

        public void setPressure(long pressure) {
            this.pressure = pressure;
        }

        public long getHumidity() {
            return humidity;
        }

        public void setHumidity(long humidity) {
            this.humidity = humidity;
        }

        public double getDewPoint() {
            return dewPoint;
        }

        public void setDewPoint(double dewPoint) {
            this.dewPoint = dewPoint;
        }

        public double getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
        }

        public long getWindDeg() {
            return windDeg;
        }

        public void setWindDeg(long windDeg) {
            this.windDeg = windDeg;
        }

        public List<Weather> getWeather() {
            return weather;
        }

        public void setWeather(List<Weather> weather) {
            this.weather = weather;
        }

        public long getClouds() {
            return clouds;
        }

        public void setClouds(long clouds) {
            this.clouds = clouds;
        }

        public double getPop() {
            return pop;
        }

        public void setPop(double pop) {
            this.pop = pop;
        }

        public double getUvi() {
            return uvi;
        }

        public void setUvi(double uvi) {
            this.uvi = uvi;
        }

        public double getRain() {
            return rain;
        }

        public void setRain(double rain) {
            this.rain = rain;
        }

        @Override
        public String toString() {
            return "Daily{" +
                    "dt=" + dt +
                    ", sunrise=" + sunrise +
                    ", sunset=" + sunset +
                    ", temp=" + temp +
                    ", feelsLike=" + feelsLike +
                    ", pressure=" + pressure +
                    ", humidity=" + humidity +
                    ", dewPoint=" + dewPoint +
                    ", windSpeed=" + windSpeed +
                    ", windDeg=" + windDeg +
                    ", weather=" + weather +
                    ", clouds=" + clouds +
                    ", pop=" + pop +
                    ", uvi=" + uvi +
                    ", rain=" + rain +
                    '}';
        }
    }

    public class Hourly {

        @SerializedName("dt")
        @Expose
        private long dt;
        @SerializedName("temp")
        @Expose
        private double temp;
        @SerializedName("feels_like")
        @Expose
        private double feelsLike;
        @SerializedName("pressure")
        @Expose
        private long pressure;
        @SerializedName("humidity")
        @Expose
        private long humidity;
        @SerializedName("dew_point")
        @Expose
        private double dewPoint;
        @SerializedName("clouds")
        @Expose
        private long clouds;
        @SerializedName("visibility")
        @Expose
        private long visibility;
        @SerializedName("wind_speed")
        @Expose
        private double windSpeed;
        @SerializedName("wind_deg")
        @Expose
        private long windDeg;
        @SerializedName("weather")
        @Expose
        private List<Weather> weather = null;
        @SerializedName("pop")
        @Expose
        private double pop;
        @SerializedName("rain")
        @Expose
        private Rain rain;

        public long getDt() {
            return dt;
        }

        public void setDt(long dt) {
            this.dt = dt;
        }

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getFeelsLike() {
            return feelsLike;
        }

        public void setFeelsLike(double feelsLike) {
            this.feelsLike = feelsLike;
        }

        public long getPressure() {
            return pressure;
        }

        public void setPressure(long pressure) {
            this.pressure = pressure;
        }

        public long getHumidity() {
            return humidity;
        }

        public void setHumidity(long humidity) {
            this.humidity = humidity;
        }

        public double getDewPoint() {
            return dewPoint;
        }

        public void setDewPoint(double dewPoint) {
            this.dewPoint = dewPoint;
        }

        public long getClouds() {
            return clouds;
        }

        public void setClouds(long clouds) {
            this.clouds = clouds;
        }

        public long getVisibility() {
            return visibility;
        }

        public void setVisibility(long visibility) {
            this.visibility = visibility;
        }

        public double getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
        }

        public long getWindDeg() {
            return windDeg;
        }

        public void setWindDeg(long windDeg) {
            this.windDeg = windDeg;
        }

        public List<Weather> getWeather() {
            return weather;
        }

        public void setWeather(List<Weather> weather) {
            this.weather = weather;
        }

        public double getPop() {
            return pop;
        }

        public void setPop(double pop) {
            this.pop = pop;
        }

        public Rain getRain() {
            return rain;
        }

        public void setRain(Rain rain) {
            this.rain = rain;
        }

        @Override
        public String toString() {
            return "Hourly{" +
                    "dt=" + dt +
                    ", temp=" + temp +
                    ", feelsLike=" + feelsLike +
                    ", pressure=" + pressure +
                    ", humidity=" + humidity +
                    ", dewPoint=" + dewPoint +
                    ", clouds=" + clouds +
                    ", visibility=" + visibility +
                    ", windSpeed=" + windSpeed +
                    ", windDeg=" + windDeg +
                    ", weather=" + weather +
                    ", pop=" + pop +
                    ", rain=" + rain +
                    '}';
        }
    }

    public class Weather {

        @SerializedName("id")
        @Expose
        private long id;
        @SerializedName("main")
        @Expose
        private String main;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("icon")
        @Expose
        private String icon;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

    }

    public class Temp {

        @SerializedName("day")
        @Expose
        private double day;
        @SerializedName("min")
        @Expose
        private double min;
        @SerializedName("max")
        @Expose
        private double max;
        @SerializedName("night")
        @Expose
        private double night;
        @SerializedName("eve")
        @Expose
        private double eve;
        @SerializedName("morn")
        @Expose
        private double morn;

        public double getDay() {
            return day;
        }

        public void setDay(double day) {
            this.day = day;
        }

        public double getMin() {
            return min;
        }

        public void setMin(double min) {
            this.min = min;
        }

        public double getMax() {
            return max;
        }

        public void setMax(double max) {
            this.max = max;
        }

        public double getNight() {
            return night;
        }

        public void setNight(double night) {
            this.night = night;
        }

        public double getEve() {
            return eve;
        }

        public void setEve(double eve) {
            this.eve = eve;
        }

        public double getMorn() {
            return morn;
        }

        public void setMorn(double morn) {
            this.morn = morn;
        }

    }

    public class FeelsLike {

        @SerializedName("day")
        @Expose
        private double day;
        @SerializedName("night")
        @Expose
        private double night;
        @SerializedName("eve")
        @Expose
        private double eve;
        @SerializedName("morn")
        @Expose
        private double morn;

        public double getDay() {
            return day;
        }

        public void setDay(double day) {
            this.day = day;
        }

        public double getNight() {
            return night;
        }

        public void setNight(double night) {
            this.night = night;
        }

        public double getEve() {
            return eve;
        }

        public void setEve(double eve) {
            this.eve = eve;
        }

        public double getMorn() {
            return morn;
        }

        public void setMorn(double morn) {
            this.morn = morn;
        }

    }

    public class Rain {

        @SerializedName("1h")
        @Expose
        private double _1h;

        public double get1h() {
            return _1h;
        }

        public void set1h(double _1h) {
            this._1h = _1h;
        }

    }
}
