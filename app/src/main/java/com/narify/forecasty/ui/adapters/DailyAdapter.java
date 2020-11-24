package com.narify.forecasty.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.narify.forecasty.R;
import com.narify.forecasty.databinding.WeatherItemBinding;
import com.narify.forecasty.databinding.WeatherTodayItemBinding;
import com.narify.forecasty.models.SingleWeather;
import com.narify.forecasty.utils.WeatherFormat;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.ViewHolder> {
    private static final int TODAY_ITEM_VIEW_TYPE = 1;
    private static final int FUTURE_DAY_ITEM_VIEW_TYPE = 2;
    private final ListItemClickListener mListItemClickListener;
    private ArrayList<SingleWeather> mWeatherDataList;


    public DailyAdapter(List<SingleWeather> dataList, ListItemClickListener listItemClickListener) {
        this.mWeatherDataList = (ArrayList<SingleWeather>) dataList;
        this.mListItemClickListener = listItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType == TODAY_ITEM_VIEW_TYPE)
            view = inflater.inflate(R.layout.weather_today_item, parent, false);
        else
            view = inflater.inflate(R.layout.weather_item, parent, false);

        return new ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SingleWeather weather = mWeatherDataList.get(position);

        if (getItemViewType(position) == TODAY_ITEM_VIEW_TYPE)
            displayTodayForecast(holder, weather);
        else
            displayFutureDayForecast(holder, weather);
    }

    private void displayTodayForecast(ViewHolder holder, SingleWeather weather) {
        String[] condition = WeatherFormat.getFullCondition(weather);
        holder.mTodayBinding.tvTime.setText(WeatherFormat.getTime(weather));
        holder.mTodayBinding.tvTemperature.setText(WeatherFormat.getTemperature(weather));
        holder.mTodayBinding.tvCondition.setText(condition[0]);
        holder.mTodayBinding.tvDescription.setText(condition[1]);
        holder.mTodayBinding.ivIcon.setImageDrawable(WeatherFormat.getIconDrawable(weather, weather.getSunset()));
    }

    private void displayFutureDayForecast(ViewHolder holder, SingleWeather weather) {
        holder.mBinding.tvTime.setText(WeatherFormat.getTime(weather));
        holder.mBinding.tvTemperature.setText(WeatherFormat.getTemperature(weather));
        holder.mBinding.tvCondition.setText(WeatherFormat.getMainCondition(weather));
        holder.mBinding.ivIcon.setImageDrawable(WeatherFormat.getIconDrawable(weather, weather.getSunset()));
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return TODAY_ITEM_VIEW_TYPE;
        else
            return FUTURE_DAY_ITEM_VIEW_TYPE;
    }

    @Override
    public int getItemCount() {
        return mWeatherDataList.size();
    }

    public ArrayList<SingleWeather> getList() {
        return mWeatherDataList;
    }

    public void setList(List<SingleWeather> list) {
        mWeatherDataList = (ArrayList<SingleWeather>) list;
        notifyDataSetChanged();
    }

    public interface ListItemClickListener {
        void onItemClick(int position, View v);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        WeatherTodayItemBinding mTodayBinding;
        WeatherItemBinding mBinding;

        ViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);

            if (viewType == TODAY_ITEM_VIEW_TYPE)
                mTodayBinding = WeatherTodayItemBinding.bind(itemView);
            else
                mBinding = WeatherItemBinding.bind(itemView);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListItemClickListener.onItemClick(getAdapterPosition(), view);
        }
    }

}
