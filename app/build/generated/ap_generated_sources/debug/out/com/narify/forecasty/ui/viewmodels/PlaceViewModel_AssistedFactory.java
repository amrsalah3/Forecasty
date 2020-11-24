package com.narify.forecasty.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.narify.forecasty.data.remote.geonames.GeoNamesClient;
import com.narify.forecasty.data.remote.geonames.GeoNamesMapper;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class PlaceViewModel_AssistedFactory implements ViewModelAssistedFactory<PlaceViewModel> {
  private final Provider<GeoNamesClient> geoNamesClient;

  private final Provider<GeoNamesMapper> geoNamesMapper;

  @Inject
  PlaceViewModel_AssistedFactory(Provider<GeoNamesClient> geoNamesClient,
      Provider<GeoNamesMapper> geoNamesMapper) {
    this.geoNamesClient = geoNamesClient;
    this.geoNamesMapper = geoNamesMapper;
  }

  @Override
  @NonNull
  public PlaceViewModel create(SavedStateHandle arg0) {
    return new PlaceViewModel(geoNamesClient.get(), geoNamesMapper.get());
  }
}
