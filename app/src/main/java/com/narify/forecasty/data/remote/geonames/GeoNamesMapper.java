package com.narify.forecasty.data.remote.geonames;

import com.narify.forecasty.models.Place;
import com.narify.forecasty.models.PlacesResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class GeoNamesMapper {
    @Inject
    public GeoNamesMapper() {
    }

    public List<Place> mapToPlacesList(PlacesResponse response) {
        if (response == null) return new ArrayList<>();

        List<Place> places = new ArrayList<>();
        for (PlacesResponse.Geoname geoName : response.getGeonames()) {
            Place place = new Place();
            place.setName(geoName.getToponymName());
            place.setAdminName(geoName.getAdminName1());
            place.setCountryName(geoName.getCountryName());
            place.setLatitude(geoName.getLat());
            place.setLongitude(geoName.getLng());

            places.add(place);
        }

        return places;
    }

}
