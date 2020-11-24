package com.narify.forecasty.data.repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.narify.forecasty.R;
import com.narify.forecasty.data.local.DataManager;
import com.narify.forecasty.data.remote.bound.Resource;
import com.narify.forecasty.data.remote.geonames.GeoNamesClient;
import com.narify.forecasty.data.remote.geonames.GeoNamesMapper;
import com.narify.forecasty.models.Place;
import com.narify.forecasty.utils.LocationUtils;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import timber.log.Timber;

@Singleton
public class LocationRepo {
    public MutableLiveData<Resource<Place>> placeLiveData;
    private Context context;
    private GeoNamesClient geoNamesClient;
    private GeoNamesMapper mapper;

    @Inject
    public LocationRepo(Context appContext, GeoNamesClient geoNamesClient, GeoNamesMapper geoNamesMapper) {
        this.context = appContext;
        this.geoNamesClient = geoNamesClient;
        this.mapper = geoNamesMapper;
        this.placeLiveData = new MutableLiveData<>();
    }


    public void updateLocation() {
        placeLiveData.setValue(Resource.loading(null));
        if (LocationUtils.isLocationMissing()) {
            if (LocationUtils.isPermissionGranted() && LocationUtils.isProviderEnabled()) {
                if (LocationUtils.isGooglePlayServicesAvailable()) updateWithFusedLocation();
                else updateWithLocationManager();
            } else {
                String errorMsg = context.getString(R.string.error_msg_permission_and_providers);
                placeLiveData.setValue(Resource.error(errorMsg, null));
            }
        } else placeLiveData.setValue(Resource.success(DataManager.getLocation()));
    }

    @SuppressLint("MissingPermission")
    private void updateWithFusedLocation() {
        FusedLocationProviderClient locationProvider =
                LocationServices.getFusedLocationProviderClient(context);

        LocationRequest request = LocationRequest.create();
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationCallback callback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                locationProvider.removeLocationUpdates(this);
                if (locationResult != null) {
                    Location location = locationResult.getLastLocation();
                    String latitude = String.valueOf(location.getLatitude());
                    String longitude = String.valueOf(location.getLongitude());
                    queryAndSavePlace(latitude, longitude);
                }
            }
        };
        locationProvider.requestLocationUpdates(request, callback, null);

        // If the delay time is passed without detecting location, remove updates
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (LocationUtils.isLocationMissing()) {
                    locationProvider.removeLocationUpdates(callback);
                    new Handler(Looper.getMainLooper()).post(() -> updateWithLocationManager());
                }
            }
        }, 4000);
    }

    @SuppressLint("MissingPermission")
    private void updateWithLocationManager() {
        LocationManager locationManager = (LocationManager)
                context.getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);

        LocationListener listener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                locationManager.removeUpdates(this);
                String latitude = String.valueOf(location.getLatitude());
                String longitude = String.valueOf(location.getLongitude());
                queryAndSavePlace(latitude, longitude);
            }
        };
        locationManager.requestLocationUpdates(5000, 5000,
                criteria, listener, null);

        // If the delay time is passed without detecting location, remove updates
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (LocationUtils.isLocationMissing()) locationManager.removeUpdates(listener);
                placeLiveData.postValue(
                        Resource.error(context.getString(R.string.msg_cant_find_location), null)
                );
            }
        }, 4000);

    }

    private void queryAndSavePlace(String latitude, String longitude) {
        geoNamesClient.findPlaceByCoords(latitude, longitude)
                .map(mapper::mapToPlacesList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Place>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Place> places) {
                        if (!places.isEmpty()) {
                            Place place = places.get(0);
                            DataManager.setLocation(place);
                            placeLiveData.setValue(Resource.success(place));
                        } else {
                            placeLiveData.setValue(Resource.error(
                                    context.getString(R.string.msg_cant_find_location),
                                    null)
                            );
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.d("GeneralLogKey: " + e);
                        placeLiveData.setValue(Resource.error(e.getLocalizedMessage(), null));
                    }
                });
    }

}
