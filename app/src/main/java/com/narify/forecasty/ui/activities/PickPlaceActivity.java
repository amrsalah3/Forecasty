package com.narify.forecasty.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.narify.forecasty.R;
import com.narify.forecasty.data.local.DataManager;
import com.narify.forecasty.databinding.ActivityPickPlaceBinding;
import com.narify.forecasty.models.Place;
import com.narify.forecasty.ui.adapters.PlaceAdapter;
import com.narify.forecasty.ui.viewmodels.PlaceViewModel;
import com.narify.forecasty.ui.viewmodels.WeatherViewModel;
import com.narify.forecasty.utils.LocationUtils;
import com.narify.forecasty.utils.NetworkConnectivity;
import com.narify.forecasty.utils.PermissionUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import dagger.hilt.android.AndroidEntryPoint;

import static com.narify.forecasty.data.remote.bound.Status.SUCCESS;
import static com.narify.forecasty.utils.LocationUtils.LOCATION_PERMISSION;

@AndroidEntryPoint
public class PickPlaceActivity extends AppCompatActivity implements
        PlaceAdapter.ListItemClickListener,
        View.OnClickListener {

    @Inject
    NetworkConnectivity networkConnectivity;
    private ActivityPickPlaceBinding mBinding;
    private PlaceViewModel mPlaceViewModel;
    private PlaceAdapter mAdapter;
    private WeatherViewModel weatherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityPickPlaceBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);

        setTextForCurrentLocation();

        observePlaces();

        setupRecyclerView();

        mBinding.fabSearch.setOnClickListener(this);
        mBinding.btnAutoDetectLocation.setOnClickListener(this);
    }

    private void setTextForCurrentLocation() {
        Place place = DataManager.getLocation();
        String locationTxt;
        if (place == null) locationTxt = getString(R.string.no_location);
        else locationTxt = String.format(getString(R.string.location_name),
                place.getName(),
                place.getAdminName(),
                place.getCountryName());

        mBinding.tvCurrentLocation.setText(locationTxt);
    }

    private void observePlaces() {
        mPlaceViewModel = new ViewModelProvider(this).get(PlaceViewModel.class);
        mPlaceViewModel.getPlacesLiveData().observe(this, places -> {
            if (places.getStatus() == SUCCESS) mAdapter.setList(places.getData());
        });
    }

    private void setupRecyclerView() {
        mAdapter = new PlaceAdapter(new ArrayList<>(), this);
        mBinding.rvPlaceList.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvPlaceList.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_search:
                searchPlace();
                break;
            case R.id.btn_auto_detect_location:
                autoDetectLocation();
                break;
        }
    }

    private void searchPlace() {
        networkConnectivity.checkInternetConnection(isConnected -> {
            if (isConnected) {
                String place = mBinding.etSearchPlace.getText().toString();
                mPlaceViewModel.fetchPlaces(place);
            } else
                Toast.makeText(this, R.string.msg_no_connection, Toast.LENGTH_SHORT).show();
        });
    }

    private void autoDetectLocation() {
        networkConnectivity.checkInternetConnection(isConnected -> {
            if (isConnected) {
                // If user previously ticked "Never show again", request permission from settings
                // Otherwise, splash activity is gonna request it normally
                if (!LocationUtils.isPermissionGranted() &&
                        !ActivityCompat.shouldShowRequestPermissionRationale(this, LOCATION_PERMISSION)) {
                    PermissionUtils.requestPermissionFromSettings(this);
                } else {
                    DataManager.setLocation(null);
                    startSplashActivity();
                }
            } else
                Toast.makeText(this, R.string.msg_no_connection, Toast.LENGTH_SHORT).show();
        });
    }


    @Override
    public void onPlaceClicked(int position) {
        networkConnectivity.checkInternetConnection(isConnected -> {
            if (isConnected) {
                Place place = mAdapter.getList().get(position);
                DataManager.setLocation(place);
                weatherViewModel.refreshWeather();
                finish();
            } else
                Toast.makeText(this, R.string.msg_no_connection, Toast.LENGTH_SHORT).show();
        });

    }

    private void startSplashActivity() {
        startActivity(new Intent(this, SplashActivity.class).setFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
        finish();
    }


}