package com.narify.forecasty.data.remote.geonames;

import com.narify.forecasty.models.PlacesResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GeoNamesService {
    String BASE_URL = "http://api.geonames.org/";

    @GET("search?style=MEDIUM&type=json")
    Single<PlacesResponse> searchPlacesByName(@Query("name_equals") String name,
                                              @Query("username") String apiKey
    );

    @GET("findNearbyPlaceName?style=MEDIUM&type=json")
    Single<PlacesResponse> findPlaceByCoords(@Query("lat") String latitude,
                                             @Query("lng") String longitude,
                                             @Query("username") String apiKey
    );
}
