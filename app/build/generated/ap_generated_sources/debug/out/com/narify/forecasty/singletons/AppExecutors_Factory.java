package com.narify.forecasty.singletons;

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
public final class AppExecutors_Factory implements Factory<AppExecutors> {
  @Override
  public AppExecutors get() {
    return newInstance();
  }

  public static AppExecutors_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AppExecutors newInstance() {
    return new AppExecutors();
  }

  private static final class InstanceHolder {
    private static final AppExecutors_Factory INSTANCE = new AppExecutors_Factory();
  }
}
