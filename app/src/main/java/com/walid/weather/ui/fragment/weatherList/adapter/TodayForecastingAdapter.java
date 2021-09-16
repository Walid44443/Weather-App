package com.walid.weather.ui.fragment.weatherList.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.walid.weather.data.model.response.CityWeather;
import com.walid.weather.databinding.ItemHourForecastingForTodayLayoutBinding;
import com.walid.weather.databinding.ItemNextForecastingLayoutBinding;
import com.walid.weather.databinding.ItemTodayForecastingLayoutBinding;

import java.util.List;

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
