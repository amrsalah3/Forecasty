package com.narify.forecasty.di;

import com.narify.forecasty.data.remote.openweathermap.OpenWeatherService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RetrofitModule_ProvideOpenWeatherServiceFactory implements Factory<OpenWeatherService> {
  @Override
  public OpenWeatherService get() {
    return provideOpenWeatherService();
  }

  public static RetrofitModule_ProvideOpenWeatherServiceFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static OpenWeatherService provideOpenWeatherService() {
    return Preconditions.checkNotNull(RetrofitModule.provideOpenWeatherService(), "Cannot return null from a non-@Nullable @Provides method");
  }

  private static final class InstanceHolder {
    private static final RetrofitModule_ProvideOpenWeatherServiceFactory INSTANCE = new RetrofitModule_ProvideOpenWeatherServiceFactory();
  }
}
