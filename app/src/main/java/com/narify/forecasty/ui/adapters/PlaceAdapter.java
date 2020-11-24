package com.narify.forecasty.ui.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.narify.forecasty.R;
import com.narify.forecasty.databinding.PlaceItemBinding;
import com.narify.forecasty.models.Place;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private List<Place> mPlacesList;
    private ListItemClickListener mListItemClickListener;

    public PlaceAdapter(List<Place> list, ListItemClickListener mListItemClickListener) {
        this.mPlacesList = list;
        this.mListItemClickListener = mListItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.place_item, parent, false);

        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Place place = mPlacesList.get(position);

        holder.mBinding.tvPlacePath.setText(place.getName() + ", " + place.getAdminName() + ", " + place.getCountryName());
        holder.mBinding.tvPlaceCoordinates.setText("lat: " + place.getLatitude() + ", long: " + place.getLongitude());
    }

    public List<Place> getList() {
        return mPlacesList;
    }

    public void setList(List<Place> places) {
        mPlacesList = places;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mPlacesList.size();
    }

    public interface ListItemClickListener {
        void onPlaceClicked(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        PlaceItemBinding mBinding;

        public ViewHolder(View itemView) {
            super(itemView);
            mBinding = PlaceItemBinding.bind(itemView);

            itemView.setOnClickListener(v -> mListItemClickListener.onPlaceClicked(getAdapterPosition()));
        }

    }

}