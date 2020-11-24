package com.narify.forecasty.di;

import com.narify.forecasty.data.remote.geonames.GeoNamesService;
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
public final class RetrofitModule_ProvideGeoNamesServiceFactory implements Factory<GeoNamesService> {
  @Override
  public GeoNamesService get() {
    return provideGeoNamesService();
  }

  public static RetrofitModule_ProvideGeoNamesServiceFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static GeoNamesService provideGeoNamesService() {
    return Preconditions.checkNotNull(RetrofitModule.provideGeoNamesService(), "Cannot return null from a non-@Nullable @Provides method");
  }

  private static final class InstanceHolder {
    private static final RetrofitModule_ProvideGeoNamesServiceFactory INSTANCE = new RetrofitModule_ProvideGeoNamesServiceFactory();
  }
}
