package com.narify.forecasty.data.remote.openweathermap;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class OpenWeatherMapper_Factory implements Factory<OpenWeatherMapper> {
  @Override
  public OpenWeatherMapper get() {
    return newInstance();
  }

  public static OpenWeatherMapper_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static OpenWeatherMapper newInstance() {
    return new OpenWeatherMapper();
  }

  private static final class InstanceHolder {
    private static final OpenWeatherMapper_Factory INSTANCE = new OpenWeatherMapper_Factory();
  }
}
