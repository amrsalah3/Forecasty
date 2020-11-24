package com.narify.forecasty.di;

import android.app.Application;
import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class ContextModule_GetAppContextFactory implements Factory<Context> {
  private final Provider<Application> applicationProvider;

  public ContextModule_GetAppContextFactory(Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public Context get() {
    return getAppContext(applicationProvider.get());
  }

  public static ContextModule_GetAppContextFactory create(
      Provider<Application> applicationProvider) {
    return new ContextModule_GetAppContextFactory(applicationProvider);
  }

  public static Context getAppContext(Application application) {
    return Preconditions.checkNotNull(ContextModule.getAppContext(application), "Cannot return null from a non-@Nullable @Provides method");
  }
}
