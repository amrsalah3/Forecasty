package com.narify.v2forecasty.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.narify.v2forecasty.R;
import com.narify.v2forecasty.singletons.AppContext;

public class PermissionUtils {

    /**
     * Checks whether a given permission is granted or not
     *
     * @return Boolean true if granted, otherwise false
     */
    public static boolean isPermissionGranted(String permission) {
        return ContextCompat.checkSelfPermission(AppContext.get(), permission)
                == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Handles location permission denial (show rationale, request again or open settings).
     * When user cancels permission request, this shows a rationale dialog.
     * When user clicks Exit, close the app.
     * When user clicks Continue:
     * if user has not clicked "Don't ask again" before, request the permission again.
     * if user has clicked "Don't ask again" before, open app's android settings to give the permission
     *
     * @param activity Activity at which the denial will be handled
     */
    public static void requestPermissionFromSettings(Activity activity) {
        new AlertDialog.Builder(activity)
                .setTitle(R.string.dialog_title_location_permission)
                .setMessage(R.string.dialog_message_location_permission)
                .setPositiveButton(activity.getString(R.string.dialog_continue),
                        (dialog, which) -> {
                            // User checked "Don't ask again", thus open app settings instead
                            openAppSystemSettings(activity);
                        }
                )
                .setNegativeButton(activity.getString(R.string.dialog_cancel),
                        (dialog, which) -> dialog.dismiss()
                )
                .show();
    }

    /**
     * Prompts the user to give the app access to location
     *
     * @param activity Activity at which the request will be created
     */
    public static void requestLocationPermission(Activity activity) {
        ActivityCompat.requestPermissions(activity,
                new String[]{LocationUtils.LOCATION_PERMISSION},
                LocationUtils.LOCATION_PERMISSION_REQUEST_CODE);
    }

    /**
     * Opens this app's android settings
     *
     * @param activity Activity from which it will open the settings
     */
    public static void openAppSystemSettings(Activity activity) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
        intent.setData(uri);
        activity.startActivityForResult(intent, 16);
    }
}
