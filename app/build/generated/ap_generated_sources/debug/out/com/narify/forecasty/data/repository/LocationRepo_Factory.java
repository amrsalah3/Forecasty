package com.narify.forecasty.data.repository;

import android.content.Context;
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
public final class LocationRepo_Factory implements Factory<LocationRepo> {
  private final Provider<Context> appContextProvider;

  private final Provider<GeoNamesClient> geoNamesClientProvider;

  private final Provider<GeoNamesMapper> geoNamesMapperProvider;

  public LocationRepo_Factory(Provider<Context> appContextProvider,
      Provider<GeoNamesClient> geoNamesClientProvider,
      Provider<GeoNamesMapper> geoNamesMapperProvider) {
    this.appContextProvider = appContextProvider;
    this.geoNamesClientProvider = geoNamesClientProvider;
    this.geoNamesMapperProvider = geoNamesMapperProvider;
  }

  @Override
  public LocationRepo get() {
    return newInstance(appContextProvider.get(), geoNamesClientProvider.get(), geoNamesMapperProvider.get());
  }

  public static LocationRepo_Factory create(Provider<Context> appContextProvider,
      Provider<GeoNamesClient> geoNamesClientProvider,
      Provider<GeoNamesMapper> geoNamesMapperProvider) {
    return new LocationRepo_Factory(appContextProvider, geoNamesClientProvider, geoNamesMapperProvider);
  }

  public static LocationRepo newInstance(Context appContext, GeoNamesClient geoNamesClient,
      GeoNamesMapper geoNamesMapper) {
    return new LocationRepo(appContext, geoNamesClient, geoNamesMapper);
  }
}
