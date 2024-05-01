package com.narify.v2forecasty.data.remote.geonames;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import com.narify.v2forecasty.models.Place;
import com.narify.v2forecasty.models.PlacesResponse;

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
