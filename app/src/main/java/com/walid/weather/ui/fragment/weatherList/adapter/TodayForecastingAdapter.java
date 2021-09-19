package com.walid.weather.ui.fragment.weatherList.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.walid.weather.data.model.response.CityWeather;
import com.walid.weather.databinding.ItemHourForecastingForTodayLayoutBinding;
import com.walid.weather.util.UiHelper;

import java.util.List;
import java.util.Objects;

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
        private final ItemHourForecastingForTodayLayoutBinding itemNextForecasting;

        public ForecastingViewHolder(ItemHourForecastingForTodayLayoutBinding itemNextForecasting) {
            super(itemNextForecasting.getRoot());
            this.itemNextForecasting = itemNextForecasting;
        }

        protected void bind(CityWeather cityWeather) {
            itemNextForecasting.setCityWeather(cityWeather);

            Glide.with(itemNextForecasting.getRoot().getContext()).load(
                    UiHelper.Companion
                            .getWeatherIcon(
                                    Objects.requireNonNull(
                                            Objects.requireNonNull(cityWeather.getWeather()).get(0).getIcon()))
            ).into(itemNextForecasting.descImgThisHour);


        }
    }
}
