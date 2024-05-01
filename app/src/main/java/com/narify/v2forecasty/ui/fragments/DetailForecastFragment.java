package com.narify.v2forecasty.ui.fragments;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.narify.v2forecasty.R;
import com.narify.v2forecasty.models.SingleWeather;
import com.narify.v2forecasty.ui.activities.MainActivity;
import com.narify.v2forecasty.ui.adapters.HourlyAdapter;
import com.narify.v2forecasty.ui.viewmodels.MasterDetailViewModel;


public class DetailForecastFragment extends Fragment {

    public static boolean removeFragmentToUpdate = false;
    private HourlyAdapter mAdapter;
    private TextView textViewEmptyList;
    private FragmentActivity mActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = requireActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail_forecast, container, false);

        setupRecyclerView(rootView);

        setupViewModel();

        return rootView;
    }

    private void setupRecyclerView(View rootView) {
        RecyclerView mWeatherRecyclerView = rootView.findViewById(R.id.rv_weather_details_list);
        mWeatherRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mWeatherRecyclerView.setHasFixedSize(true);
        mAdapter = new HourlyAdapter(new ArrayList<>());
        mWeatherRecyclerView.setAdapter(mAdapter);

        textViewEmptyList = rootView.findViewById(R.id.tv_empty_hourly_forecasts);
    }

    private void setupViewModel() {
        // Instantiate ViewModel shared between master and detail fragments (Daily and Detail fragments)
        MasterDetailViewModel sharedViewModel =
                new ViewModelProvider(mActivity).get(MasterDetailViewModel.class);

        // Start observing for the master daily forecast item clicks in its list
        sharedViewModel.getSelectedWeatherLiveData()
                .observe(getViewLifecycleOwner(), this::setAdapterListFromWrappingDay);
    }


    private void setAdapterListFromWrappingDay(SingleWeather weatherDay) {
        if (weatherDay != null) {
            List<SingleWeather> dayDetailWeatherList = new ArrayList<>();
            dayDetailWeatherList.add(weatherDay);
            dayDetailWeatherList.addAll(weatherDay.getHoursList());
            mAdapter.setList(dayDetailWeatherList);
            // Show text if no hourly forecasts in the adapter
            if (dayDetailWeatherList.size() <= 1) textViewEmptyList.setVisibility(View.VISIBLE);
            else textViewEmptyList.setVisibility(View.GONE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (removeFragmentToUpdate) {
            if (MainActivity.isOnePane) {
                mActivity.getSupportFragmentManager().beginTransaction()
                        .remove(this)
                        .commit();
                mActivity.getSupportFragmentManager().popBackStack();
            } else {
                mAdapter.setList(new ArrayList<>());
            }
        }
    }

}
