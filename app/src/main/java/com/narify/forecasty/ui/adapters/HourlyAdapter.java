package com.narify.forecasty.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.narify.forecasty.R;
import com.narify.forecasty.databinding.WeatherDayDetailItemBinding;
import com.narify.forecasty.databinding.WeatherItemBinding;
import com.narify.forecasty.models.SingleWeather;
import com.narify.forecasty.utils.WeatherFormat;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.ViewHolder> {

    private static final int DAY_DETAILS_ITEM_VIEW_TYPE = 1;
    private static final int HOUR_ITEM_VIEW_TYPE = 2;
    private SingleWeather mWrappingDayWeather;
    private ArrayList<SingleWeather> mWeatherDataList;

    public HourlyAdapter(List<SingleWeather> weatherList) {
        if (!weatherList.isEmpty()) mWrappingDayWeather = weatherList.get(0);
        mWeatherDataList = (ArrayList<SingleWeather>) weatherList;
    }

    @NonNull
    @Override
    public HourlyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        if (viewType == DAY_DETAILS_ITEM_VIEW_TYPE)
            view = inflater.inflate(R.layout.weather_day_detail_item, parent, false);
        else
            view = inflater.inflate(R.layout.weather_item, parent, false);

        return new ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyAdapter.ViewHolder holder, int position) {
        SingleWeather weather = mWeatherDataList.get(position);
        if (getItemViewType(position) == DAY_DETAILS_ITEM_VIEW_TYPE)
            displayWrappingDayDetails(holder);
        else
            displayHourlyForecast(holder, weather);
    }

    private void displayWrappingDayDetails(HourlyAdapter.ViewHolder holder) {
        holder.mDayBinding.tvTemperature.setText(WeatherFormat.getTemperature(mWrappingDayWeather));
        holder.mDayBinding.tvDescription.setText(WeatherFormat.getMainCondition(mWrappingDayWeather));
        holder.mDayBinding.tvPressure.setText(WeatherFormat.getPressure(mWrappingDayWeather));
        holder.mDayBinding.tvHumidity.setText(WeatherFormat.getHumidity(mWrappingDayWeather));
        holder.mDayBinding.tvWindSpeed.setText(WeatherFormat.getWindSpeed(mWrappingDayWeather));
        holder.mDayBinding.ivIcon.setImageDrawable(WeatherFormat.getIconDrawable(mWrappingDayWeather, mWrappingDayWeather.getSunset()));
    }

    private void displayHourlyForecast(HourlyAdapter.ViewHolder holder, SingleWeather weather) {
        holder.mBinding.tvTime.setText(WeatherFormat.getTime(weather));
        holder.mBinding.tvTemperature.setText(WeatherFormat.getTemperature(weather));
        holder.mBinding.tvCondition.setText(WeatherFormat.getMainCondition(weather));
        holder.mBinding.ivIcon.setImageDrawable(WeatherFormat.getIconDrawable(weather, mWrappingDayWeather.getSunset()));
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return DAY_DETAILS_ITEM_VIEW_TYPE;
        else return HOUR_ITEM_VIEW_TYPE;
    }

    @Override
    public int getItemCount() {
        return mWeatherDataList.size();
    }

    public List<SingleWeather> getList() {
        return mWeatherDataList;
    }

    public void setList(List<SingleWeather> weatherList) {
        if (!weatherList.isEmpty())
            mWrappingDayWeather = weatherList.get(0);
        mWeatherDataList = (ArrayList<SingleWeather>) weatherList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        WeatherDayDetailItemBinding mDayBinding;
        WeatherItemBinding mBinding;

        ViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);

            if (viewType == DAY_DETAILS_ITEM_VIEW_TYPE)
                mDayBinding = WeatherDayDetailItemBinding.bind(itemView);
            else
                mBinding = WeatherItemBinding.bind(itemView);

        }

    }


}
