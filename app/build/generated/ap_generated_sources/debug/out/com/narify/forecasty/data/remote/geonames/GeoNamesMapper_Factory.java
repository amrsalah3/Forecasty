package com.narify.forecasty.data.remote.geonames;

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
public final class GeoNamesMapper_Factory implements Factory<GeoNamesMapper> {
  @Override
  public GeoNamesMapper get() {
    return newInstance();
  }

  public static GeoNamesMapper_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static GeoNamesMapper newInstance() {
    return new GeoNamesMapper();
  }

  private static final class InstanceHolder {
    private static final GeoNamesMapper_Factory INSTANCE = new GeoNamesMapper_Factory();
  }
}
