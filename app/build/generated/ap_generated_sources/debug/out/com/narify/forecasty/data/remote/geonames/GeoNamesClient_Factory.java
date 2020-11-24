package com.narify.forecasty.data.remote.geonames;

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
public final class GeoNamesClient_Factory implements Factory<GeoNamesClient> {
  private final Provider<GeoNamesService> geoNamesServiceProvider;

  public GeoNamesClient_Factory(Provider<GeoNamesService> geoNamesServiceProvider) {
    this.geoNamesServiceProvider = geoNamesServiceProvider;
  }

  @Override
  public GeoNamesClient get() {
    return newInstance(geoNamesServiceProvider.get());
  }

  public static GeoNamesClient_Factory create(Provider<GeoNamesService> geoNamesServiceProvider) {
    return new GeoNamesClient_Factory(geoNamesServiceProvider);
  }

  public static GeoNamesClient newInstance(GeoNamesService geoNamesService) {
    return new GeoNamesClient(geoNamesService);
  }
}
