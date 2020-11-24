package com.narify.forecasty.data.remote.openweathermap;

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
public final class OpenWeatherClient_Factory implements Factory<OpenWeatherClient> {
  private final Provider<OpenWeatherService> openWeatherServiceProvider;

  public OpenWeatherClient_Factory(Provider<OpenWeatherService> openWeatherServiceProvider) {
    this.openWeatherServiceProvider = openWeatherServiceProvider;
  }

  @Override
  public OpenWeatherClient get() {
    return newInstance(openWeatherServiceProvider.get());
  }

  public static OpenWeatherClient_Factory create(
      Provider<OpenWeatherService> openWeatherServiceProvider) {
    return new OpenWeatherClient_Factory(openWeatherServiceProvider);
  }

  public static OpenWeatherClient newInstance(OpenWeatherService openWeatherService) {
    return new OpenWeatherClient(openWeatherService);
  }
}
