package com.walid.weather.ui.dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.walid.weather.data.model.response.CityWeather;
import com.walid.weather.databinding.DayForecastingDetailsDialogFragmentBinding;
import com.walid.weather.ui.fragment.weatherList.adapter.TodayForecastingAdapter;
import com.walid.weather.util.UiHelper;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

public class DayForecastingDetailsDialogFragment extends DialogFragment {

    private DayForecastingDetailsDialogFragmentBinding binding;

    public static DayForecastingDetailsDialogFragment newInstance() {
        return new DayForecastingDetailsDialogFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DayForecastingDetailsDialogFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CityWeather[] cityWeathers = (CityWeather[]) getArguments().getParcelableArray("cityWeatherList");
        CityWeather cityWeather = cityWeathers[0];

        String cityName = getArguments().getString("cityName");
        binding.setCityName(cityName);
        binding.setCityWeather(cityWeather);
        getDialog().getWindow().setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        if (!cityWeather.getWeather().isEmpty())
            if (cityWeather.getWeather().get(0).getDescription().isEmpty())
                binding.weatherDescribe.setText(cityWeather.getWeather().get(0).getDescription());

        Glide.with(getContext()).load(
                UiHelper.Companion
                        .getWeatherIcon(
                                Objects.requireNonNull(
                                        Objects.requireNonNull(cityWeather.getWeather()).get(0).getIcon()))
        ).into(binding.descImg);


        // set layout manger as linear to display items as a vertical view
        LinearLayoutManager forecastingLinearLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );


        //attach layout manger to recyclerview
        binding.hourlyRecyclerview.setLayoutManager(forecastingLinearLayoutManager);
        TodayForecastingAdapter forecastingAdapter = new TodayForecastingAdapter(Arrays.asList(cityWeathers));
        binding.hourlyRecyclerview.setAdapter(forecastingAdapter);


    }
}