package com.narify.v2forecasty.ui.activities;

import dagger.hilt.android.AndroidEntryPoint;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import com.narify.v2forecasty.R;
import com.narify.v2forecasty.data.local.DataManager;
import com.narify.v2forecasty.ui.fragments.DetailForecastFragment;
import com.narify.v2forecasty.ui.viewmodels.WeatherViewModel;

@AndroidEntryPoint
public class SettingsActivity extends AppCompatActivity implements
        SharedPreferences.OnSharedPreferenceChangeListener {

    private WeatherViewModel weatherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);


        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);

        PreferenceManager.getDefaultSharedPreferences(this)
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(getString(R.string.pref_units_key))) {
            boolean toImperial = !DataManager.isMetric();
            weatherViewModel.updateUnits(toImperial);
            DetailForecastFragment.removeFragmentToUpdate = true;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(this)
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            addPreferencesFromResource(R.xml.fragment_preferences);
        }
    }

}
