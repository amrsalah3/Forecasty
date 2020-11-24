package com.narify.forecasty.ui.viewmodels;

import com.narify.forecasty.data.remote.bound.Resource;
import com.narify.forecasty.data.remote.geonames.GeoNamesClient;
import com.narify.forecasty.data.remote.geonames.GeoNamesMapper;
import com.narify.forecasty.models.Place;

import java.util.List;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import timber.log.Timber;

public class PlaceViewModel extends ViewModel {

    private MutableLiveData<Resource<List<Place>>> placesLiveData;
    private GeoNamesClient geoNamesClient;
    private GeoNamesMapper mapper;
    private CompositeDisposable composite;

    @ViewModelInject
    public PlaceViewModel(GeoNamesClient geoNamesClient, GeoNamesMapper geoNamesMapper) {
        this.geoNamesClient = geoNamesClient;
        this.mapper = geoNamesMapper;
        placesLiveData = new MutableLiveData<>();
        placesLiveData.setValue(Resource.loading(null));
        composite = new CompositeDisposable();
    }

    public synchronized void fetchPlaces(String place) {
        if (place.isEmpty()) return;
        geoNamesClient.searchPlacesByName(place)
                .map(mapper::mapToPlacesList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Place>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        placesLiveData.setValue(Resource.loading(null));
                    }

                    @Override
                    public void onSuccess(@NonNull List<Place> places) {
                        placesLiveData.setValue(Resource.success(places));
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Timber.d("GeneralLogKey: " + e);
                        placesLiveData.setValue(Resource.error(e.getLocalizedMessage(), null));
                    }
                });

    }

    public LiveData<Resource<List<Place>>> getPlacesLiveData() {
        return placesLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        composite.dispose();
    }
}
