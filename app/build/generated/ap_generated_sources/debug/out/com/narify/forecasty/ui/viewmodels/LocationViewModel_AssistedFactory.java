package com.narify.forecasty.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.narify.forecasty.data.repository.LocationRepo;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class LocationViewModel_AssistedFactory implements ViewModelAssistedFactory<LocationViewModel> {
  private final Provider<LocationRepo> locationRepo;

  @Inject
  LocationViewModel_AssistedFactory(Provider<LocationRepo> locationRepo) {
    this.locationRepo = locationRepo;
  }

  @Override
  @NonNull
  public LocationViewModel create(SavedStateHandle arg0) {
    return new LocationViewModel(locationRepo.get());
  }
}
