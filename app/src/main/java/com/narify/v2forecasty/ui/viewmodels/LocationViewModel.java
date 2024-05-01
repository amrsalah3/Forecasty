package com.narify.v2forecasty.ui.viewmodels;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.narify.v2forecasty.data.remote.bound.Resource;
import com.narify.v2forecasty.data.repository.LocationRepo;
import com.narify.v2forecasty.models.Place;

public class LocationViewModel extends ViewModel {
    private LocationRepo locationRepo;
    private MutableLiveData<Resource<Place>> placeLiveData;

    @ViewModelInject
    public LocationViewModel(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
        this.placeLiveData = locationRepo.placeLiveData;
    }

    public LiveData<Resource<Place>> updateLocation() {
        locationRepo.updateLocation();

        return placeLiveData;
    }


}
