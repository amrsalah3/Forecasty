package com.narify.forecasty.ui.viewmodels;

import com.narify.forecasty.data.repository.LocationRepo;
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
public final class LocationViewModel_AssistedFactory_Factory implements Factory<LocationViewModel_AssistedFactory> {
  private final Provider<LocationRepo> locationRepoProvider;

  public LocationViewModel_AssistedFactory_Factory(Provider<LocationRepo> locationRepoProvider) {
    this.locationRepoProvider = locationRepoProvider;
  }

  @Override
  public LocationViewModel_AssistedFactory get() {
    return newInstance(locationRepoProvider);
  }

  public static LocationViewModel_AssistedFactory_Factory create(
      Provider<LocationRepo> locationRepoProvider) {
    return new LocationViewModel_AssistedFactory_Factory(locationRepoProvider);
  }

  public static LocationViewModel_AssistedFactory newInstance(Provider<LocationRepo> locationRepo) {
    return new LocationViewModel_AssistedFactory(locationRepo);
  }
}
