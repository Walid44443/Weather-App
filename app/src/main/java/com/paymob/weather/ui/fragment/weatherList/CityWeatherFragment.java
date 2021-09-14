package com.paymob.weather.ui.fragment.weatherList;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paymob.weather.data.network.repo.WeatherForecastingRepo;
import com.paymob.weather.databinding.CityWeatherFragmentBinding;
import com.paymob.weather.ui.fragment.weatherList.adapter.WeatherForecastingAdapter;

import java.util.HashMap;

public class CityWeatherFragment extends Fragment {

    private CityWeatherViewModel mViewModel;
    private CityWeatherFragmentBinding binding;

    public static CityWeatherFragment newInstance() {
        return new CityWeatherFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CityWeatherFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CityWeatherViewModel.class);


        // set layout manger as linear to display items as a vertical view
        LinearLayoutManager forecastingLinearLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );

        //attach layout manger to recyclerview
        binding.forecastingRecyclerview.setLayoutManager(forecastingLinearLayoutManager);

        WeatherForecastingAdapter forecastingAdapter = new WeatherForecastingAdapter(new HashMap<>());

        binding.forecastingRecyclerview.setAdapter(forecastingAdapter);


        WeatherForecastingRepo forecastingRepo = new WeatherForecastingRepo("Cairo");
        forecastingRepo.fetchFromNetwork();
        forecastingRepo.getResultLive().observe(getViewLifecycleOwner(), resource -> {
            switch (resource.component1()) {
                case ERROR:

                    break;
                case LOADING:
                    break;
                case SUCCESS:
                    requireActivity().runOnUiThread(() -> {
                        forecastingAdapter.setDataSet(resource.getData());
                        forecastingAdapter.notifyDataSetChanged();
                    });
                    break;
            }
        });
    }


}