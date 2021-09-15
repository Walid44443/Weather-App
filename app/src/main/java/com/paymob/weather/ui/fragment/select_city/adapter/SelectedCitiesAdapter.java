package com.paymob.weather.ui.fragment.select_city.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paymob.weather.data.model.response.City;
import com.paymob.weather.databinding.ItemSelectedCityLayoutBinding;

import java.util.List;

public class SelectedCitiesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<City> mDataSet;


    public void setDataSet(List<City> mDataSet) {
        this.mDataSet = mDataSet;
    }

    public List<City> getDataSet() {
        return mDataSet;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemSelectedCityLayoutBinding itemSelectedCityLayoutBinding =
                ItemSelectedCityLayoutBinding.inflate(layoutInflater, parent, false);
        return new CityViewHolder(itemSelectedCityLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        City city = this.mDataSet.get(position);
        CityViewHolder todayCityViewHolder = (CityViewHolder) holder;
        todayCityViewHolder.bind(city);
    }


    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    class CityViewHolder extends RecyclerView.ViewHolder {
        private ItemSelectedCityLayoutBinding itemSelectedCityLayoutBinding;

        public CityViewHolder(ItemSelectedCityLayoutBinding itemNextForecasting) {
            super(itemNextForecasting.getRoot());
            this.itemSelectedCityLayoutBinding = itemNextForecasting;
        }

        protected void bind(City city) {
            itemSelectedCityLayoutBinding.setCity(city);
        }
    }
}
