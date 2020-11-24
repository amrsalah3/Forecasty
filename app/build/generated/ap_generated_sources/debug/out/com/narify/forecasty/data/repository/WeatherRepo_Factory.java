package com.narify.forecasty.data.repository;

import com.narify.forecasty.data.local.db.WeatherDao;
import com.narify.forecasty.data.remote.openweathermap.OpenWeatherClient;
import com.narify.forecasty.data.remote.openweathermap.OpenWeatherMapper;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class WeatherRepo_Factory implements Factory<WeatherRepo> {
  private final Provider<OpenWeatherClient> openWeatherClientProvider;

  private final Provider<WeatherDao> weatherDaoProvider;

  private final Provider<OpenWeatherMapper> openWeatherMapperProvider;

  public WeatherRepo_Factory(Provider<OpenWeatherClient> openWeatherClientProvider,
      Provider<WeatherDao> weatherDaoProvider,
      Provider<OpenWeatherMapper> openWeatherMapperProvider) {
    this.openWeatherClientProvider = openWeatherClientProvider;
    this.weatherDaoProvider = weatherDaoProvider;
    this.openWeatherMapperProvider = openWeatherMapperProvider;
  }

  @Override
  public WeatherRepo get() {
    return newInstance(openWeatherClientProvider.get(), weatherDaoProvider.get(), openWeatherMapperProvider.get());
  }

  public static WeatherRepo_Factory create(Provider<OpenWeatherClient> openWeatherClientProvider,
      Provider<WeatherDao> weatherDaoProvider,
      Provider<OpenWeatherMapper> openWeatherMapperProvider) {
    return new WeatherRepo_Factory(openWeatherClientProvider, weatherDaoProvider, openWeatherMapperProvider);
  }

  public static WeatherRepo newInstance(OpenWeatherClient openWeatherClient, WeatherDao weatherDao,
      OpenWeatherMapper openWeatherMapper) {
    return new WeatherRepo(openWeatherClient, weatherDao, openWeatherMapper);
  }
}
