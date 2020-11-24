package com.narify.forecasty.ui.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.narify.forecasty.R;
import com.narify.forecasty.ui.viewmodels.LocationViewModel;
import com.narify.forecasty.ui.viewmodels.WeatherViewModel;
import com.narify.forecasty.utils.LocationUtils;
import com.narify.forecasty.utils.NetworkConnectivity;
import com.narify.forecasty.utils.PermissionUtils;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;

import static com.narify.forecasty.data.remote.bound.Status.ERROR;
import static com.narify.forecasty.data.remote.bound.Status.SUCCESS;

@AndroidEntryPoint
public class SplashActivity extends AppCompatActivity {

    @Inject
    NetworkConnectivity networkConnectivity;
    private LocationViewModel locationViewModel;
    private WeatherViewModel weatherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (LocationUtils.isLocationMissing()) {
            setupViewModels();
            observeLocation();
        } else startMainActivity();
    }

    private void setupViewModels() {
        locationViewModel = new ViewModelProvider(this).get(LocationViewModel.class);
        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
    }


    private void observeLocation() {
        locationViewModel.updateLocation().observe(this, resource -> {
            if (resource.getStatus() == SUCCESS) {
                weatherViewModel.refreshWeather();
                startMainActivity();
            } else if (resource.getStatus() == ERROR) {
                if (LocationUtils.isPermissionGranted()) {
                    if (LocationUtils.isProviderEnabled()) {
                        networkConnectivity.checkInternetConnection(isConnected -> {
                            if (!isConnected) showConnectionToast();
                            startPickPlaceActivity();
                        });
                    } else LocationUtils.askForProviders(SplashActivity.this);
                } else PermissionUtils.requestLocationPermission(SplashActivity.this);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LocationUtils.LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (LocationUtils.isProviderEnabled()) observeLocation();
                else LocationUtils.askForProviders(this);
            } else startPickPlaceActivity();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LocationUtils.LOCATION_GOOGLE_DIALOG_REQUEST_CODE) {
            if (resultCode == RESULT_OK) observeLocation();
            else startPickPlaceActivity();
        } else if (requestCode == LocationUtils.LOCATION_MANUAL_DIALOG_REQUEST_CODE) {
            if (LocationUtils.isProviderEnabled()) observeLocation();
            else startPickPlaceActivity();
        }
    }

    private void startMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void startPickPlaceActivity() {
        startActivity(new Intent(this, PickPlaceActivity.class));
        finish();
    }

    private void showConnectionToast() {
        Toast.makeText(this, getString(R.string.msg_no_connection), Toast.LENGTH_LONG).show();
    }

}