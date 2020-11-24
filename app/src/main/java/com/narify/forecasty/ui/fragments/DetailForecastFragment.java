package com.narify.forecasty.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.narify.forecasty.R;
import com.narify.forecasty.models.SingleWeather;
import com.narify.forecasty.ui.activities.MainActivity;
import com.narify.forecasty.ui.adapters.HourlyAdapter;
import com.narify.forecasty.ui.viewmodels.MasterDetailViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class DetailForecastFragment extends Fragment {

    public static boolean removeFragmentToUpdate = false;
    private HourlyAdapter mAdapter;
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

    private void setupViewModel() {
        // Instantiate ViewModel shared between master and detail fragments (Daily and Detail fragments)
        MasterDetailViewModel sharedViewModel =
                new ViewModelProvider(mActivity).get(MasterDetailViewModel.class);

        // Start observing for the master daily forecast item clicks in its list
        sharedViewModel.getSelectedWeatherLiveData()
                .observe(getViewLifecycleOwner(), this::setAdapterListFromWrappingDay);
    }

    private void setupRecyclerView(View rootView) {
        RecyclerView mWeatherRecyclerView = rootView.findViewById(R.id.rv_weather_details_list);
        mWeatherRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mWeatherRecyclerView.setHasFixedSize(true);
        mAdapter = new HourlyAdapter(new ArrayList<>());
        mWeatherRecyclerView.setAdapter(mAdapter);
    }

    private void setAdapterListFromWrappingDay(SingleWeather weatherDay) {
        if (weatherDay != null) {
            List<SingleWeather> dayDetailWeatherList = new ArrayList<>();
            dayDetailWeatherList.add(weatherDay);
            dayDetailWeatherList.addAll(weatherDay.getHoursList());
            mAdapter.setList(dayDetailWeatherList);
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