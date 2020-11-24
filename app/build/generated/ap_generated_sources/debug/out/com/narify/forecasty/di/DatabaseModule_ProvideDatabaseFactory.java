package com.narify.forecasty.di;

import android.app.Application;
import com.narify.forecasty.data.local.db.AppDatabase;
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
public final class DatabaseModule_ProvideDatabaseFactory implements Factory<AppDatabase> {
  private final Provider<Application> applicationProvider;

  public DatabaseModule_ProvideDatabaseFactory(Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public AppDatabase get() {
    return provideDatabase(applicationProvider.get());
  }

  public static DatabaseModule_ProvideDatabaseFactory create(
      Provider<Application> applicationProvider) {
    return new DatabaseModule_ProvideDatabaseFactory(applicationProvider);
  }

  public static AppDatabase provideDatabase(Application application) {
    return Preconditions.checkNotNull(DatabaseModule.provideDatabase(application), "Cannot return null from a non-@Nullable @Provides method");
  }
}
