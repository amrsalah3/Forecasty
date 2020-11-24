package com.narify.forecasty.ui.activities;

import com.narify.forecasty.utils.NetworkConnectivity;
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
public final class SplashActivity_MembersInjector implements MembersInjector<SplashActivity> {
  private final Provider<NetworkConnectivity> networkConnectivityProvider;

  public SplashActivity_MembersInjector(Provider<NetworkConnectivity> networkConnectivityProvider) {
    this.networkConnectivityProvider = networkConnectivityProvider;
  }

  public static MembersInjector<SplashActivity> create(
      Provider<NetworkConnectivity> networkConnectivityProvider) {
    return new SplashActivity_MembersInjector(networkConnectivityProvider);
  }

  @Override
  public void injectMembers(SplashActivity instance) {
    injectNetworkConnectivity(instance, networkConnectivityProvider.get());
  }

  @InjectedFieldSignature("com.narify.forecasty.ui.activities.SplashActivity.networkConnectivity")
  public static void injectNetworkConnectivity(SplashActivity instance,
      NetworkConnectivity networkConnectivity) {
    instance.networkConnectivity = networkConnectivity;
  }
}
