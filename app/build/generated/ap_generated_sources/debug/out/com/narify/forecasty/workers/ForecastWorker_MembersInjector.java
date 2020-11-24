package com.narify.forecasty.workers;

import com.narify.forecasty.data.repository.WeatherRepo;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
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
public final class ForecastWorker_MembersInjector implements MembersInjector<ForecastWorker> {
  private final Provider<WeatherRepo> weatherRepoProvider;

  public ForecastWorker_MembersInjector(Provider<WeatherRepo> weatherRepoProvider) {
    this.weatherRepoProvider = weatherRepoProvider;
  }

  public static MembersInjector<ForecastWorker> create(Provider<WeatherRepo> weatherRepoProvider) {
    return new ForecastWorker_MembersInjector(weatherRepoProvider);
  }

  @Override
  public void injectMembers(ForecastWorker instance) {
    injectWeatherRepo(instance, weatherRepoProvider.get());
  }

  @InjectedFieldSignature("com.narify.forecasty.workers.ForecastWorker.weatherRepo")
  public static void injectWeatherRepo(ForecastWorker instance, WeatherRepo weatherRepo) {
    instance.weatherRepo = weatherRepo;
  }
}
