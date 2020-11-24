package com.narify.forecasty;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.narify.forecasty.data.local.db.AppDatabase;
import com.narify.forecasty.data.local.db.WeatherDao;
import com.narify.forecasty.data.remote.geonames.GeoNamesClient;
import com.narify.forecasty.data.remote.geonames.GeoNamesMapper;
import com.narify.forecasty.data.remote.geonames.GeoNamesService;
import com.narify.forecasty.data.remote.openweathermap.OpenWeatherClient;
import com.narify.forecasty.data.remote.openweathermap.OpenWeatherMapper;
import com.narify.forecasty.data.remote.openweathermap.OpenWeatherService;
import com.narify.forecasty.data.repository.LocationRepo;
import com.narify.forecasty.data.repository.WeatherRepo;
import com.narify.forecasty.di.ContextModule;
import com.narify.forecasty.di.ContextModule_GetAppContextFactory;
import com.narify.forecasty.di.DatabaseModule;
import com.narify.forecasty.di.DatabaseModule_ProvideDatabaseFactory;
import com.narify.forecasty.di.DatabaseModule_ProvideWeatherDaoFactory;
import com.narify.forecasty.di.ExecutorModule;
import com.narify.forecasty.di.RetrofitModule;
import com.narify.forecasty.di.RetrofitModule_ProvideGeoNamesServiceFactory;
import com.narify.forecasty.di.RetrofitModule_ProvideOpenWeatherServiceFactory;
import com.narify.forecasty.singletons.AppExecutors;
import com.narify.forecasty.ui.activities.MainActivity;
import com.narify.forecasty.ui.activities.PickPlaceActivity;
import com.narify.forecasty.ui.activities.PickPlaceActivity_MembersInjector;
import com.narify.forecasty.ui.activities.SettingsActivity;
import com.narify.forecasty.ui.activities.SplashActivity;
import com.narify.forecasty.ui.activities.SplashActivity_MembersInjector;
import com.narify.forecasty.ui.fragments.MasterForecastFragment;
import com.narify.forecasty.ui.viewmodels.LocationViewModel_AssistedFactory;
import com.narify.forecasty.ui.viewmodels.LocationViewModel_AssistedFactory_Factory;
import com.narify.forecasty.ui.viewmodels.PlaceViewModel_AssistedFactory;
import com.narify.forecasty.ui.viewmodels.PlaceViewModel_AssistedFactory_Factory;
import com.narify.forecasty.ui.viewmodels.WeatherViewModel_AssistedFactory;
import com.narify.forecasty.ui.viewmodels.WeatherViewModel_AssistedFactory_Factory;
import com.narify.forecasty.utils.NetworkConnectivity;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.MemoizedSentinel;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
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
public final class DaggerForecastyApplication_HiltComponents_ApplicationC extends ForecastyApplication_HiltComponents.ApplicationC {
  private final ApplicationContextModule applicationContextModule;

  private volatile Object appExecutors = new MemoizedSentinel();

  private volatile Object networkConnectivity = new MemoizedSentinel();

  private volatile Object context = new MemoizedSentinel();

  private volatile Object geoNamesService = new MemoizedSentinel();

  private volatile Object geoNamesClient = new MemoizedSentinel();

  private volatile Object locationRepo = new MemoizedSentinel();

  private volatile Provider<LocationRepo> locationRepoProvider;

  private volatile Provider<GeoNamesClient> geoNamesClientProvider;

  private volatile Provider<GeoNamesMapper> geoNamesMapperProvider;

  private volatile Object openWeatherService = new MemoizedSentinel();

  private volatile Object openWeatherClient = new MemoizedSentinel();

  private volatile Object appDatabase = new MemoizedSentinel();

  private volatile Object weatherRepo = new MemoizedSentinel();

  private volatile Provider<WeatherRepo> weatherRepoProvider;

  private volatile Provider<AppExecutors> appExecutorsProvider;

  private DaggerForecastyApplication_HiltComponents_ApplicationC(
      ApplicationContextModule applicationContextModuleParam) {
    this.applicationContextModule = applicationContextModuleParam;
  }

  public static Builder builder() {
    return new Builder();
  }

  private AppExecutors getAppExecutors() {
    Object local = appExecutors;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = appExecutors;
        if (local instanceof MemoizedSentinel) {
          local = new AppExecutors();
          appExecutors = DoubleCheck.reentrantCheck(appExecutors, local);
        }
      }
    }
    return (AppExecutors) local;
  }

  private NetworkConnectivity getNetworkConnectivity() {
    Object local = networkConnectivity;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = networkConnectivity;
        if (local instanceof MemoizedSentinel) {
          local = new NetworkConnectivity(getAppExecutors());
          networkConnectivity = DoubleCheck.reentrantCheck(networkConnectivity, local);
        }
      }
    }
    return (NetworkConnectivity) local;
  }

  private Context getContext() {
    Object local = context;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = context;
        if (local instanceof MemoizedSentinel) {
          local = ContextModule_GetAppContextFactory.getAppContext(ApplicationContextModule_ProvideApplicationFactory.provideApplication(applicationContextModule));
          context = DoubleCheck.reentrantCheck(context, local);
        }
      }
    }
    return (Context) local;
  }

  private GeoNamesService getGeoNamesService() {
    Object local = geoNamesService;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = geoNamesService;
        if (local instanceof MemoizedSentinel) {
          local = RetrofitModule_ProvideGeoNamesServiceFactory.provideGeoNamesService();
          geoNamesService = DoubleCheck.reentrantCheck(geoNamesService, local);
        }
      }
    }
    return (GeoNamesService) local;
  }

  private GeoNamesClient getGeoNamesClient() {
    Object local = geoNamesClient;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = geoNamesClient;
        if (local instanceof MemoizedSentinel) {
          local = new GeoNamesClient(getGeoNamesService());
          geoNamesClient = DoubleCheck.reentrantCheck(geoNamesClient, local);
        }
      }
    }
    return (GeoNamesClient) local;
  }

  private LocationRepo getLocationRepo() {
    Object local = locationRepo;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = locationRepo;
        if (local instanceof MemoizedSentinel) {
          local = new LocationRepo(getContext(), getGeoNamesClient(), new GeoNamesMapper());
          locationRepo = DoubleCheck.reentrantCheck(locationRepo, local);
        }
      }
    }
    return (LocationRepo) local;
  }

  private Provider<LocationRepo> getLocationRepoProvider() {
    Object local = locationRepoProvider;
    if (local == null) {
      local = new SwitchingProvider<>(0);
      locationRepoProvider = (Provider<LocationRepo>) local;
    }
    return (Provider<LocationRepo>) local;
  }

  private Provider<GeoNamesClient> getGeoNamesClientProvider() {
    Object local = geoNamesClientProvider;
    if (local == null) {
      local = new SwitchingProvider<>(1);
      geoNamesClientProvider = (Provider<GeoNamesClient>) local;
    }
    return (Provider<GeoNamesClient>) local;
  }

  private Provider<GeoNamesMapper> getGeoNamesMapperProvider() {
    Object local = geoNamesMapperProvider;
    if (local == null) {
      local = new SwitchingProvider<>(2);
      geoNamesMapperProvider = (Provider<GeoNamesMapper>) local;
    }
    return (Provider<GeoNamesMapper>) local;
  }

  private OpenWeatherService getOpenWeatherService() {
    Object local = openWeatherService;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = openWeatherService;
        if (local instanceof MemoizedSentinel) {
          local = RetrofitModule_ProvideOpenWeatherServiceFactory.provideOpenWeatherService();
          openWeatherService = DoubleCheck.reentrantCheck(openWeatherService, local);
        }
      }
    }
    return (OpenWeatherService) local;
  }

  private OpenWeatherClient getOpenWeatherClient() {
    Object local = openWeatherClient;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = openWeatherClient;
        if (local instanceof MemoizedSentinel) {
          local = new OpenWeatherClient(getOpenWeatherService());
          openWeatherClient = DoubleCheck.reentrantCheck(openWeatherClient, local);
        }
      }
    }
    return (OpenWeatherClient) local;
  }

  private AppDatabase getAppDatabase() {
    Object local = appDatabase;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = appDatabase;
        if (local instanceof MemoizedSentinel) {
          local = DatabaseModule_ProvideDatabaseFactory.provideDatabase(ApplicationContextModule_ProvideApplicationFactory.provideApplication(applicationContextModule));
          appDatabase = DoubleCheck.reentrantCheck(appDatabase, local);
        }
      }
    }
    return (AppDatabase) local;
  }

  private WeatherDao getWeatherDao() {
    return DatabaseModule_ProvideWeatherDaoFactory.provideWeatherDao(getAppDatabase());
  }

  private WeatherRepo getWeatherRepo() {
    Object local = weatherRepo;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = weatherRepo;
        if (local instanceof MemoizedSentinel) {
          local = new WeatherRepo(getOpenWeatherClient(), getWeatherDao(), new OpenWeatherMapper());
          weatherRepo = DoubleCheck.reentrantCheck(weatherRepo, local);
        }
      }
    }
    return (WeatherRepo) local;
  }

  private Provider<WeatherRepo> getWeatherRepoProvider() {
    Object local = weatherRepoProvider;
    if (local == null) {
      local = new SwitchingProvider<>(3);
      weatherRepoProvider = (Provider<WeatherRepo>) local;
    }
    return (Provider<WeatherRepo>) local;
  }

  private Provider<AppExecutors> getAppExecutorsProvider() {
    Object local = appExecutorsProvider;
    if (local == null) {
      local = new SwitchingProvider<>(4);
      appExecutorsProvider = (Provider<AppExecutors>) local;
    }
    return (Provider<AppExecutors>) local;
  }

  @Override
  public void injectForecastyApplication(ForecastyApplication forecastyApplication) {
  }

  @Override
  public ActivityRetainedComponentBuilder retainedComponentBuilder() {
    return new ActivityRetainedCBuilder();
  }

  @Override
  public ServiceComponentBuilder serviceComponentBuilder() {
    return new ServiceCBuilder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder contextModule(ContextModule contextModule) {
      Preconditions.checkNotNull(contextModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder databaseModule(DatabaseModule databaseModule) {
      Preconditions.checkNotNull(databaseModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder executorModule(ExecutorModule executorModule) {
      Preconditions.checkNotNull(executorModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder retrofitModule(RetrofitModule retrofitModule) {
      Preconditions.checkNotNull(retrofitModule);
      return this;
    }

    public ForecastyApplication_HiltComponents.ApplicationC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new DaggerForecastyApplication_HiltComponents_ApplicationC(applicationContextModule);
    }
  }

  private final class ActivityRetainedCBuilder implements ForecastyApplication_HiltComponents.ActivityRetainedC.Builder {
    @Override
    public ForecastyApplication_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl();
    }
  }

  private final class ActivityRetainedCImpl extends ForecastyApplication_HiltComponents.ActivityRetainedC {
    private ActivityRetainedCImpl() {

    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder();
    }

    private final class ActivityCBuilder implements ForecastyApplication_HiltComponents.ActivityC.Builder {
      private Activity activity;

      @Override
      public ActivityCBuilder activity(Activity activity) {
        this.activity = Preconditions.checkNotNull(activity);
        return this;
      }

      @Override
      public ForecastyApplication_HiltComponents.ActivityC build() {
        Preconditions.checkBuilderRequirement(activity, Activity.class);
        return new ActivityCImpl(activity);
      }
    }

    private final class ActivityCImpl extends ForecastyApplication_HiltComponents.ActivityC {
      private final Activity activity;

      private volatile Provider<LocationViewModel_AssistedFactory> locationViewModel_AssistedFactoryProvider;

      private volatile Provider<PlaceViewModel_AssistedFactory> placeViewModel_AssistedFactoryProvider;

      private volatile Provider<WeatherViewModel_AssistedFactory> weatherViewModel_AssistedFactoryProvider;

      private ActivityCImpl(Activity activityParam) {
        this.activity = activityParam;
      }

      private LocationViewModel_AssistedFactory getLocationViewModel_AssistedFactory() {
        return LocationViewModel_AssistedFactory_Factory.newInstance(DaggerForecastyApplication_HiltComponents_ApplicationC.this.getLocationRepoProvider());
      }

      private Provider<LocationViewModel_AssistedFactory> getLocationViewModel_AssistedFactoryProvider(
          ) {
        Object local = locationViewModel_AssistedFactoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(0);
          locationViewModel_AssistedFactoryProvider = (Provider<LocationViewModel_AssistedFactory>) local;
        }
        return (Provider<LocationViewModel_AssistedFactory>) local;
      }

      private PlaceViewModel_AssistedFactory getPlaceViewModel_AssistedFactory() {
        return PlaceViewModel_AssistedFactory_Factory.newInstance(DaggerForecastyApplication_HiltComponents_ApplicationC.this.getGeoNamesClientProvider(), DaggerForecastyApplication_HiltComponents_ApplicationC.this.getGeoNamesMapperProvider());
      }

      private Provider<PlaceViewModel_AssistedFactory> getPlaceViewModel_AssistedFactoryProvider() {
        Object local = placeViewModel_AssistedFactoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(1);
          placeViewModel_AssistedFactoryProvider = (Provider<PlaceViewModel_AssistedFactory>) local;
        }
        return (Provider<PlaceViewModel_AssistedFactory>) local;
      }

      private WeatherViewModel_AssistedFactory getWeatherViewModel_AssistedFactory() {
        return WeatherViewModel_AssistedFactory_Factory.newInstance(DaggerForecastyApplication_HiltComponents_ApplicationC.this.getWeatherRepoProvider(), DaggerForecastyApplication_HiltComponents_ApplicationC.this.getAppExecutorsProvider());
      }

      private Provider<WeatherViewModel_AssistedFactory> getWeatherViewModel_AssistedFactoryProvider(
          ) {
        Object local = weatherViewModel_AssistedFactoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(2);
          weatherViewModel_AssistedFactoryProvider = (Provider<WeatherViewModel_AssistedFactory>) local;
        }
        return (Provider<WeatherViewModel_AssistedFactory>) local;
      }

      private Map<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>> getMapOfStringAndProviderOfViewModelAssistedFactoryOf(
          ) {
        return MapBuilder.<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>>newMapBuilder(3).put("com.narify.forecasty.ui.viewmodels.LocationViewModel", (Provider) getLocationViewModel_AssistedFactoryProvider()).put("com.narify.forecasty.ui.viewmodels.PlaceViewModel", (Provider) getPlaceViewModel_AssistedFactoryProvider()).put("com.narify.forecasty.ui.viewmodels.WeatherViewModel", (Provider) getWeatherViewModel_AssistedFactoryProvider()).build();
      }

      private ViewModelProvider.Factory getProvideFactory() {
        return ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory.provideFactory(activity, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerForecastyApplication_HiltComponents_ApplicationC.this.applicationContextModule), getMapOfStringAndProviderOfViewModelAssistedFactoryOf());
      }

      @Override
      public void injectMainActivity(MainActivity mainActivity) {
      }

      @Override
      public void injectPickPlaceActivity(PickPlaceActivity pickPlaceActivity) {
        injectPickPlaceActivity2(pickPlaceActivity);
      }

      @Override
      public void injectSettingsActivity(SettingsActivity settingsActivity) {
      }

      @Override
      public void injectSplashActivity(SplashActivity splashActivity) {
        injectSplashActivity2(splashActivity);
      }

      @Override
      public Set<ViewModelProvider.Factory> getActivityViewModelFactory() {
        return Collections.<ViewModelProvider.Factory>singleton(getProvideFactory());
      }

      @Override
      public FragmentComponentBuilder fragmentComponentBuilder() {
        return new FragmentCBuilder();
      }

      @Override
      public ViewComponentBuilder viewComponentBuilder() {
        return new ViewCBuilder();
      }

      private PickPlaceActivity injectPickPlaceActivity2(PickPlaceActivity instance) {
        PickPlaceActivity_MembersInjector.injectNetworkConnectivity(instance, DaggerForecastyApplication_HiltComponents_ApplicationC.this.getNetworkConnectivity());
        return instance;
      }

      private SplashActivity injectSplashActivity2(SplashActivity instance) {
        SplashActivity_MembersInjector.injectNetworkConnectivity(instance, DaggerForecastyApplication_HiltComponents_ApplicationC.this.getNetworkConnectivity());
        return instance;
      }

      private final class FragmentCBuilder implements ForecastyApplication_HiltComponents.FragmentC.Builder {
        private Fragment fragment;

        @Override
        public FragmentCBuilder fragment(Fragment fragment) {
          this.fragment = Preconditions.checkNotNull(fragment);
          return this;
        }

        @Override
        public ForecastyApplication_HiltComponents.FragmentC build() {
          Preconditions.checkBuilderRequirement(fragment, Fragment.class);
          return new FragmentCImpl(fragment);
        }
      }

      private final class FragmentCImpl extends ForecastyApplication_HiltComponents.FragmentC {
        private final Fragment fragment;

        private FragmentCImpl(Fragment fragmentParam) {
          this.fragment = fragmentParam;
        }

        private ViewModelProvider.Factory getProvideFactory() {
          return ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory.provideFactory(fragment, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerForecastyApplication_HiltComponents_ApplicationC.this.applicationContextModule), ActivityCImpl.this.getMapOfStringAndProviderOfViewModelAssistedFactoryOf());
        }

        @Override
        public void injectMasterForecastFragment(MasterForecastFragment masterForecastFragment) {
        }

        @Override
        public Set<ViewModelProvider.Factory> getFragmentViewModelFactory() {
          return Collections.<ViewModelProvider.Factory>singleton(getProvideFactory());
        }

        @Override
        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
          return new ViewWithFragmentCBuilder();
        }

        private final class ViewWithFragmentCBuilder implements ForecastyApplication_HiltComponents.ViewWithFragmentC.Builder {
          private View view;

          @Override
          public ViewWithFragmentCBuilder view(View view) {
            this.view = Preconditions.checkNotNull(view);
            return this;
          }

          @Override
          public ForecastyApplication_HiltComponents.ViewWithFragmentC build() {
            Preconditions.checkBuilderRequirement(view, View.class);
            return new ViewWithFragmentCImpl(view);
          }
        }

        private final class ViewWithFragmentCImpl extends ForecastyApplication_HiltComponents.ViewWithFragmentC {
          private ViewWithFragmentCImpl(View view) {

          }
        }
      }

      private final class ViewCBuilder implements ForecastyApplication_HiltComponents.ViewC.Builder {
        private View view;

        @Override
        public ViewCBuilder view(View view) {
          this.view = Preconditions.checkNotNull(view);
          return this;
        }

        @Override
        public ForecastyApplication_HiltComponents.ViewC build() {
          Preconditions.checkBuilderRequirement(view, View.class);
          return new ViewCImpl(view);
        }
      }

      private final class ViewCImpl extends ForecastyApplication_HiltComponents.ViewC {
        private ViewCImpl(View view) {

        }
      }

      private final class SwitchingProvider<T> implements Provider<T> {
        private final int id;

        SwitchingProvider(int id) {
          this.id = id;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T get() {
          switch (id) {
            case 0: // com.narify.forecasty.ui.viewmodels.LocationViewModel_AssistedFactory 
            return (T) ActivityCImpl.this.getLocationViewModel_AssistedFactory();

            case 1: // com.narify.forecasty.ui.viewmodels.PlaceViewModel_AssistedFactory 
            return (T) ActivityCImpl.this.getPlaceViewModel_AssistedFactory();

            case 2: // com.narify.forecasty.ui.viewmodels.WeatherViewModel_AssistedFactory 
            return (T) ActivityCImpl.this.getWeatherViewModel_AssistedFactory();

            default: throw new AssertionError(id);
          }
        }
      }
    }
  }

  private final class ServiceCBuilder implements ForecastyApplication_HiltComponents.ServiceC.Builder {
    private Service service;

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public ForecastyApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(service);
    }
  }

  private final class ServiceCImpl extends ForecastyApplication_HiltComponents.ServiceC {
    private ServiceCImpl(Service service) {

    }
  }

  private final class SwitchingProvider<T> implements Provider<T> {
    private final int id;

    SwitchingProvider(int id) {
      this.id = id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get() {
      switch (id) {
        case 0: // com.narify.forecasty.data.repository.LocationRepo 
        return (T) DaggerForecastyApplication_HiltComponents_ApplicationC.this.getLocationRepo();

        case 1: // com.narify.forecasty.data.remote.geonames.GeoNamesClient 
        return (T) DaggerForecastyApplication_HiltComponents_ApplicationC.this.getGeoNamesClient();

        case 2: // com.narify.forecasty.data.remote.geonames.GeoNamesMapper 
        return (T) new GeoNamesMapper();

        case 3: // com.narify.forecasty.data.repository.WeatherRepo 
        return (T) DaggerForecastyApplication_HiltComponents_ApplicationC.this.getWeatherRepo();

        case 4: // com.narify.forecasty.singletons.AppExecutors 
        return (T) DaggerForecastyApplication_HiltComponents_ApplicationC.this.getAppExecutors();

        default: throw new AssertionError(id);
      }
    }
  }
}
