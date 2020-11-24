package com.narify.forecasty.ui.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.narify.forecasty.R;
import com.narify.forecasty.workers.ForecastWorkerScheduler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    public static boolean isOnePane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Remove elevation and shadow from app bar
        ActionBar appBar = getSupportActionBar();
        if (appBar != null) appBar.setElevation(0);

        isOnePane = getResources().getBoolean(R.bool.one_pane);

        // Prevent the activity from rotating to landscape if it is not a tablet
        if (isOnePane) setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ForecastWorkerScheduler.init();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            case R.id.action_location_management:
                startActivity(new Intent(this, PickPlaceActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}


