package com.paymob.weather.ui.fragment.weatherList.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paymob.weather.data.model.response.CityWeather;
import com.paymob.weather.databinding.ItemHourForecastingForTodayLayoutBinding;
import com.paymob.weather.databinding.ItemNextForecastingLayoutBinding;
import com.paymob.weather.databinding.ItemTodayForecastingLayoutBinding;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TodayForecastingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<CityWeather> mDataSet;


    public TodayForecastingAdapter(List<CityWeather> mDataSet) {
        this.mDataSet = mDataSet;
    }

    public void setDataSet(List<CityWeather> mDataSet) {
        this.mDataSet = mDataSet;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            ItemHourForecastingForTodayLayoutBinding itemHourForecastingForTodayLayoutBinding
                    = ItemHourForecastingForTodayLayoutBinding.inflate(layoutInflater, parent, false);
            return new ForecastingViewHolder(itemHourForecastingForTodayLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //here we get the first cityWeather object from each day
        CityWeather cityWeather = this.mDataSet.get(position);
        ForecastingViewHolder todayForecastingViewHolder = (ForecastingViewHolder) holder;
        todayForecastingViewHolder.bind(cityWeather);
    }


    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    class ForecastingViewHolder extends RecyclerView.ViewHolder {
        private ItemHourForecastingForTodayLayoutBinding itemNextForecasting;

        public ForecastingViewHolder(ItemHourForecastingForTodayLayoutBinding itemNextForecasting) {
            super(itemNextForecasting.getRoot());
            this.itemNextForecasting = itemNextForecasting;
        }

        protected void bind(CityWeather cityWeather) {
            itemNextForecasting.setCityWeather(cityWeather);
        }
    }
}
