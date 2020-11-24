package com.narify.forecasty.ui.viewmodels;

import com.narify.forecasty.data.remote.geonames.GeoNamesClient;
import com.narify.forecasty.data.remote.geonames.GeoNamesMapper;
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
public final class PlaceViewModel_AssistedFactory_Factory implements Factory<PlaceViewModel_AssistedFactory> {
  private final Provider<GeoNamesClient> geoNamesClientProvider;

  private final Provider<GeoNamesMapper> geoNamesMapperProvider;

  public PlaceViewModel_AssistedFactory_Factory(Provider<GeoNamesClient> geoNamesClientProvider,
      Provider<GeoNamesMapper> geoNamesMapperProvider) {
    this.geoNamesClientProvider = geoNamesClientProvider;
    this.geoNamesMapperProvider = geoNamesMapperProvider;
  }

  @Override
  public PlaceViewModel_AssistedFactory get() {
    return newInstance(geoNamesClientProvider, geoNamesMapperProvider);
  }

  public static PlaceViewModel_AssistedFactory_Factory create(
      Provider<GeoNamesClient> geoNamesClientProvider,
      Provider<GeoNamesMapper> geoNamesMapperProvider) {
    return new PlaceViewModel_AssistedFactory_Factory(geoNamesClientProvider, geoNamesMapperProvider);
  }

  public static PlaceViewModel_AssistedFactory newInstance(Provider<GeoNamesClient> geoNamesClient,
      Provider<GeoNamesMapper> geoNamesMapper) {
    return new PlaceViewModel_AssistedFactory(geoNamesClient, geoNamesMapper);
  }
}
