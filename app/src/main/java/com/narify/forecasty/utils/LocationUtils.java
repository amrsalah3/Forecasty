package com.narify.forecasty.utils;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Criteria;
import android.location.LocationManager;
import android.provider.Settings;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.narify.forecasty.R;
import com.narify.forecasty.data.local.DataManager;
import com.narify.forecasty.singletons.AppContext;
import com.narify.forecasty.ui.activities.PickPlaceActivity;


public class LocationUtils {

    public static final String LOCATION_PERMISSION = Manifest.permission.ACCESS_FINE_LOCATION;
    public static final int LOCATION_PERMISSION_REQUEST_CODE = 15;
    public static final int LOCATION_GOOGLE_DIALOG_REQUEST_CODE = 10;
    public static final int LOCATION_MANUAL_DIALOG_REQUEST_CODE = 11;
    private static final LocationManager locationManager = (LocationManager) AppContext.get()
            .getSystemService(Context.LOCATION_SERVICE);

    /**
     * Checks if there is a cached location in the app, if not, checks location access permission
     *
     * @return True if no location is stored and location permission not granted
     */
    public static boolean isLocationMissing() {
        return DataManager.getLocation() == null;
    }

    public static boolean isPermissionGranted() {
        return PermissionUtils.isPermissionGranted(LOCATION_PERMISSION);
    }

    public static boolean isProviderEnabled() {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        return !locationManager.getProviders(criteria, true).isEmpty();
    }

    public static void askForProviders(Context context) {
        if (isGooglePlayServicesAvailable()) showGoogleLocationDialog(context);
        else showManualLocationDialog(context);
    }

    private static void showGoogleLocationDialog(Context context) {
        LocationRequest locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);
        builder.setAlwaysShow(true);

        LocationServices.getSettingsClient(context).checkLocationSettings(builder.build())
                .addOnFailureListener((Activity) context, e -> {
                    int statusCode = ((ApiException) e).getStatusCode();
                    switch (statusCode) {
                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                            try {
                                // Show the dialog by calling startResolutionForResult(), and check the
                                // result in onActivityResult().
                                ResolvableApiException rae = (ResolvableApiException) e;
                                rae.startResolutionForResult((Activity) context, LOCATION_GOOGLE_DIALOG_REQUEST_CODE);
                            } catch (IntentSender.SendIntentException sie) {
                                sie.printStackTrace();
                            }
                            break;
                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                            String errorMessage = "Location settings are inadequate, and cannot be " +
                                    "fixed here. Fix in Settings.";
                            Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show();
                    }
                });
    }


    private static void showManualLocationDialog(Context context) {
        Activity activity = (Activity) context;
        new AlertDialog.Builder(context)
                .setTitle(R.string.dialog_title_enable_location)
                .setMessage(R.string.dialog_message_enable_location)
                .setPositiveButton(R.string.dialog_pos_enable_location, (di, i) -> {
                    activity.startActivityForResult(
                            new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS),
                            LOCATION_MANUAL_DIALOG_REQUEST_CODE);
                })
                .setNegativeButton(R.string.dialog_neg_enable_location, (di, i) ->
                        activity.startActivity(new Intent(context, PickPlaceActivity.class)))
                .show();
    }


    public static boolean isGooglePlayServicesAvailable() {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = googleApiAvailability.isGooglePlayServicesAvailable(AppContext.get());
        return resultCode == ConnectionResult.SUCCESS;
    }

}
