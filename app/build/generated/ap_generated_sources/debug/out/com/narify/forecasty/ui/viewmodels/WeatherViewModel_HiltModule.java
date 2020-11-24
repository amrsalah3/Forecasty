package com.narify.forecasty.ui.viewmodels;

import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.codegen.OriginatingElement;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import javax.annotation.Generated;

@Generated("androidx.hilt.AndroidXHiltProcessor")
@Module
@InstallIn(ActivityRetainedComponent.class)
@OriginatingElement(
    topLevelClass = WeatherViewModel.class
)
public interface WeatherViewModel_HiltModule {
  @Binds
  @IntoMap
  @StringKey("com.narify.forecasty.ui.viewmodels.WeatherViewModel")
  ViewModelAssistedFactory<? extends ViewModel> bind(WeatherViewModel_AssistedFactory factory);
}
