package com.narify.forecasty.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.narify.forecasty.R;
import com.narify.forecasty.ui.activities.MainActivity;
import com.narify.forecasty.ui.adapters.DailyAdapter;
import com.narify.forecasty.ui.viewmodels.MasterDetailViewModel;
import com.narify.forecasty.ui.viewmodels.WeatherViewModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MasterForecastFragment extends Fragment implements DailyAdapter.ListItemClickListener {

    private FragmentActivity mActivity;
    private MasterDetailViewModel mSharedViewModel;
    private DailyAdapter mAdapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = requireActivity();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_master_forecast, container, false);

        mSharedViewModel = new ViewModelProvider(mActivity).get(MasterDetailViewModel.class);

        setupRecyclerView(rootView);

        observeForecast();

        return rootView;
    }

    private void setupRecyclerView(View rootView) {
        RecyclerView WeatherRecyclerView = rootView.findViewById(R.id.rv_weather_daily_list);
        WeatherRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        WeatherRecyclerView.setHasFixedSize(true);
        mAdapter = new DailyAdapter(new ArrayList<>(), this);
        WeatherRecyclerView.setAdapter(mAdapter);
    }

    /* Updates the adapter whenever there is a change in the database with new weather data */
    private void observeForecast() {
        WeatherViewModel weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        weatherViewModel.getWeather().observe(getViewLifecycleOwner(), weathers -> {
            if (!weathers.isEmpty()) mAdapter.setList(weathers);
        });
    }

    /* WeatherAdapter item click listener (param is the position of the item clicked) */
    @Override
    public void onItemClick(int position, View view) {
        // Update the shared ViewModel with the selected weather forecast day
        mSharedViewModel.selectWeather(mAdapter.getList().get(position));
        // Replace the current fragment with Detail fragment if the activity is one-pane
        if (MainActivity.isOnePane) {
            DetailForecastFragment.removeFragmentToUpdate = false;
            mActivity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.onepane_forecast_fragment_container, new DetailForecastFragment())
                    .addToBackStack(null)
                    .setReorderingAllowed(true)
                    .commit();
        }
    }

}