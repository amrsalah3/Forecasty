package com.narify.forecasty.utils;

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
public final class NetworkConnectivity_Factory implements Factory<NetworkConnectivity> {
  private final Provider<AppExecutors> appExecutorsProvider;

  public NetworkConnectivity_Factory(Provider<AppExecutors> appExecutorsProvider) {
    this.appExecutorsProvider = appExecutorsProvider;
  }

  @Override
  public NetworkConnectivity get() {
    return newInstance(appExecutorsProvider.get());
  }

  public static NetworkConnectivity_Factory create(Provider<AppExecutors> appExecutorsProvider) {
    return new NetworkConnectivity_Factory(appExecutorsProvider);
  }

  public static NetworkConnectivity newInstance(AppExecutors appExecutors) {
    return new NetworkConnectivity(appExecutors);
  }
}
