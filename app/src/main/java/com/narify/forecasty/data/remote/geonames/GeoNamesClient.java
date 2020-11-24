package com.narify.forecasty.data.remote.geonames;

import com.narify.forecasty.BuildConfig;
import com.narify.forecasty.data.remote.HttpsTrustManager;
import com.narify.forecasty.models.PlacesResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Single;

@Singleton
public class GeoNamesClient {

    private GeoNamesService geoNamesService;

    @Inject
    public GeoNamesClient(GeoNamesService geoNamesService) {
        this.geoNamesService = geoNamesService;
        HttpsTrustManager.allowAllSSL();
    }

    public Single<PlacesResponse> searchPlacesByName(String place) {
        return geoNamesService.searchPlacesByName(place, BuildConfig.GEONAMES_API_KEY);
    }

    public Single<PlacesResponse> findPlaceByCoords(String latitude, String longitude) {
        return geoNamesService.findPlaceByCoords(
                latitude,
                longitude,
                BuildConfig.GEONAMES_API_KEY
        );
    }


}
