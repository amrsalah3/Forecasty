package com.narify.forecasty.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.narify.forecasty.data.repository.WeatherRepo;
import com.narify.forecasty.singletons.AppExecutors;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class WeatherViewModel_AssistedFactory implements ViewModelAssistedFactory<WeatherViewModel> {
  private final Provider<WeatherRepo> weatherRepo;

  private final Provider<AppExecutors> appExecutors;

  @Inject
  WeatherViewModel_AssistedFactory(Provider<WeatherRepo> weatherRepo,
      Provider<AppExecutors> appExecutors) {
    this.weatherRepo = weatherRepo;
    this.appExecutors = appExecutors;
  }

  @Override
  @NonNull
  public WeatherViewModel create(SavedStateHandle arg0) {
    return new WeatherViewModel(weatherRepo.get(), appExecutors.get());
  }
}
