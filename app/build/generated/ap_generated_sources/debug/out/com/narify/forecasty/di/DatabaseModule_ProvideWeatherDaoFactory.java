package com.narify.forecasty.di;

import com.narify.forecasty.data.local.db.AppDatabase;
import com.narify.forecasty.data.local.db.WeatherDao;
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
public final class DatabaseModule_ProvideWeatherDaoFactory implements Factory<WeatherDao> {
  private final Provider<AppDatabase> appDatabaseProvider;

  public DatabaseModule_ProvideWeatherDaoFactory(Provider<AppDatabase> appDatabaseProvider) {
    this.appDatabaseProvider = appDatabaseProvider;
  }

  @Override
  public WeatherDao get() {
    return provideWeatherDao(appDatabaseProvider.get());
  }

  public static DatabaseModule_ProvideWeatherDaoFactory create(
      Provider<AppDatabase> appDatabaseProvider) {
    return new DatabaseModule_ProvideWeatherDaoFactory(appDatabaseProvider);
  }

  public static WeatherDao provideWeatherDao(AppDatabase appDatabase) {
    return Preconditions.checkNotNull(DatabaseModule.provideWeatherDao(appDatabase), "Cannot return null from a non-@Nullable @Provides method");
  }
}
