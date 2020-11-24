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
public final class PickPlaceActivity_MembersInjector implements MembersInjector<PickPlaceActivity> {
  private final Provider<NetworkConnectivity> networkConnectivityProvider;

  public PickPlaceActivity_MembersInjector(
      Provider<NetworkConnectivity> networkConnectivityProvider) {
    this.networkConnectivityProvider = networkConnectivityProvider;
  }

  public static MembersInjector<PickPlaceActivity> create(
      Provider<NetworkConnectivity> networkConnectivityProvider) {
    return new PickPlaceActivity_MembersInjector(networkConnectivityProvider);
  }

  @Override
  public void injectMembers(PickPlaceActivity instance) {
    injectNetworkConnectivity(instance, networkConnectivityProvider.get());
  }

  @InjectedFieldSignature("com.narify.forecasty.ui.activities.PickPlaceActivity.networkConnectivity")
  public static void injectNetworkConnectivity(PickPlaceActivity instance,
      NetworkConnectivity networkConnectivity) {
    instance.networkConnectivity = networkConnectivity;
  }
}
