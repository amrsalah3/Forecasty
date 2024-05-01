package com.narify.v2forecasty.data.remote.geonames;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Single;

import com.narify.v2forecasty.BuildConfig;
import com.narify.v2forecasty.data.remote.HttpsTrustManager;
import com.narify.v2forecasty.models.PlacesResponse;

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
