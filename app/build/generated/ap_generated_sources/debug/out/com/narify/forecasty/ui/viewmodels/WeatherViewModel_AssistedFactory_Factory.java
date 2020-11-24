package com.narify.forecasty.ui.viewmodels;

import com.narify.forecasty.data.repository.WeatherRepo;
import com.narify.forecasty.singletons.AppExecutors;
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
public final class WeatherViewModel_AssistedFactory_Factory implements Factory<WeatherViewModel_AssistedFactory> {
  private final Provider<WeatherRepo> weatherRepoProvider;

  private final Provider<AppExecutors> appExecutorsProvider;

  public WeatherViewModel_AssistedFactory_Factory(Provider<WeatherRepo> weatherRepoProvider,
      Provider<AppExecutors> appExecutorsProvider) {
    this.weatherRepoProvider = weatherRepoProvider;
    this.appExecutorsProvider = appExecutorsProvider;
  }

  @Override
  public WeatherViewModel_AssistedFactory get() {
    return newInstance(weatherRepoProvider, appExecutorsProvider);
  }

  public static WeatherViewModel_AssistedFactory_Factory create(
      Provider<WeatherRepo> weatherRepoProvider, Provider<AppExecutors> appExecutorsProvider) {
    return new WeatherViewModel_AssistedFactory_Factory(weatherRepoProvider, appExecutorsProvider);
  }

  public static WeatherViewModel_AssistedFactory newInstance(Provider<WeatherRepo> weatherRepo,
      Provider<AppExecutors> appExecutors) {
    return new WeatherViewModel_AssistedFactory(weatherRepo, appExecutors);
  }
}
