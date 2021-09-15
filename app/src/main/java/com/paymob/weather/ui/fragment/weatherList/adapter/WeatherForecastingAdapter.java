package com.paymob.weather.ui.fragment.weatherList.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.paymob.weather.data.model.response.CityWeather;
import com.paymob.weather.databinding.ItemNextForecastingLayoutBinding;
import com.paymob.weather.databinding.ItemTodayForecastingLayoutBinding;
import com.paymob.weather.util.ItemClickListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WeatherForecastingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private HashMap<Date, List<CityWeather>> mDataSet;
    private ItemClickListener<List<CityWeather>> cityWeatherItemClickListener;

    public WeatherForecastingAdapter(HashMap<Date, List<CityWeather>> mDataSet, final ItemClickListener<List<CityWeather>> cityWeatherItemClickListener) {
        this.mDataSet = mDataSet;
        this.cityWeatherItemClickListener = cityWeatherItemClickListener;
    }

    public void setDataSet(HashMap<Date, List<CityWeather>> mDataSet) {
        this.mDataSet = mDataSet;
    }

    @Override
    public int getItemViewType(int position) {
        //returns 0 if it's the today's forecasting and 1 if it's any day else
        return (position == 0) ? 0 : 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            ItemTodayForecastingLayoutBinding itemTodayForecastingLayoutBinding
                    = ItemTodayForecastingLayoutBinding.inflate(layoutInflater, parent, false);
            return new TodayForecastingViewHolder(itemTodayForecastingLayoutBinding);
        } else {
            ItemNextForecastingLayoutBinding itemNextForecastingLayoutBinding
                    = ItemNextForecastingLayoutBinding.inflate(layoutInflater, parent, false);
            return new AnyDayForecastingViewHolder(itemNextForecastingLayoutBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //here we get the first cityWeather object from each day
        CityWeather cityWeather = this.mDataSet.get(mDataSet.keySet().toArray()[position]).get(0);
        if (holder instanceof TodayForecastingViewHolder) {
            TodayForecastingViewHolder todayForecastingViewHolder = (TodayForecastingViewHolder) holder;
            todayForecastingViewHolder.bind(cityWeather, this.mDataSet.get(mDataSet.keySet().toArray()[position]));
        } else {
            AnyDayForecastingViewHolder anyDayForecastingViewHolder = (AnyDayForecastingViewHolder) holder;
            anyDayForecastingViewHolder.bind(cityWeather, this.mDataSet.get(mDataSet.keySet().toArray()[position]));
        }
    }


    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    class TodayForecastingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemTodayForecastingLayoutBinding itemTodayForecastingLayoutBinding;
        private CityWeather cityWeather;
        private List<CityWeather> cityWeatherList;

        public TodayForecastingViewHolder(ItemTodayForecastingLayoutBinding itemView) {
            super(itemView.getRoot());
            this.itemTodayForecastingLayoutBinding = itemView;
        }

        protected void bind(CityWeather cityWeather, List<CityWeather> cityWeatherList) {
            this.cityWeather = cityWeather;
            this.cityWeatherList = cityWeatherList;

            itemTodayForecastingLayoutBinding.setCityWeather(cityWeather);

            // set layout manger as linear to display items as a vertical view
            LinearLayoutManager forecastingLinearLayoutManager = new LinearLayoutManager(
                    itemView.getContext(),
                    LinearLayoutManager.HORIZONTAL,
                    false
            );


            //attach layout manger to recyclerview
            itemTodayForecastingLayoutBinding.hourlyRecyclerview.setLayoutManager(forecastingLinearLayoutManager);
            TodayForecastingAdapter forecastingAdapter = new TodayForecastingAdapter(cityWeatherList);
            itemTodayForecastingLayoutBinding.hourlyRecyclerview.setAdapter(forecastingAdapter);
            itemTodayForecastingLayoutBinding.getRoot().setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            cityWeatherItemClickListener.onClick(cityWeatherList, view);
        }
    }

    class AnyDayForecastingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemNextForecastingLayoutBinding itemNextForecasting;
        private List<CityWeather> cityWeatherList;

        public AnyDayForecastingViewHolder(ItemNextForecastingLayoutBinding itemNextForecasting) {
            super(itemNextForecasting.getRoot());
            this.itemNextForecasting = itemNextForecasting;
        }

        protected void bind(CityWeather cityWeather, List<CityWeather> cityWeatherList) {
            this.cityWeatherList = cityWeatherList;

            itemNextForecasting.setCityWeather(cityWeather);
            if (getLayoutPosition() == 1)
                itemNextForecasting.nextForecastingHeader.setVisibility(View.VISIBLE);
            else
                itemNextForecasting.nextForecastingHeader.setVisibility(View.GONE);
            itemNextForecasting.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            cityWeatherItemClickListener.onClick(cityWeatherList, view);
        }
    }
}
