package com.narify.v2forecasty.data.local;

import android.content.SharedPreferences;

import androidx.annotation.Nullable;
import androidx.preference.PreferenceManager;

import com.narify.v2forecasty.R;
import com.narify.v2forecasty.models.Place;
import com.narify.v2forecasty.singletons.AppContext;
import com.narify.v2forecasty.singletons.AppResources;
import com.narify.v2forecasty.utils.Converters;

import org.json.JSONException;

public final class DataManager {
    private final static SharedPreferences preferences =
            PreferenceManager.getDefaultSharedPreferences(AppContext.get());

    public static String getUnitSystem() {
        return preferences.getString(
                AppResources.get().getString(R.string.pref_units_key),
                AppResources.get().getString(R.string.pref_unit_metric_value)
        );
    }

    public static boolean isMetric() {
        return getUnitSystem().equals(AppContext.get().getString(R.string.pref_unit_metric_value));
    }

    @Nullable
    public static Place getLocation() {
        String jsonPlace = preferences.getString(
                AppResources.get().getString(R.string.pref_place_key),
                null);
        try {
            return Converters.jsonToObj(jsonPlace, Place.class);
        } catch (JSONException | NullPointerException e) {
            return null;
        }
    }

    public static void setLocation(Place place) {
        String jsonPlace = Converters.objToJson(place);
        preferences.edit()
                .putString(AppResources.get().getString(R.string.pref_place_key), jsonPlace)
                .apply();
    }

}
