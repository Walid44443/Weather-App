package com.paymob.weather.ui.fragment.weatherList;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayoutMediator;
import com.paymob.weather.R;
import com.paymob.weather.data.model.response.City;
import com.paymob.weather.databinding.CityWeatherFragmentBinding;
import com.paymob.weather.databinding.WeatherContainerFragmentBinding;
import com.paymob.weather.ui.fragment.weatherList.adapter.CitiesFragmentPagerAdapter;

public class WeatherContainerFragment extends Fragment {

    private CityWeatherViewModel mViewModel;
    private WeatherContainerFragmentBinding binding;

    public static WeatherContainerFragment newInstance() {
        return new WeatherContainerFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = WeatherContainerFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CityWeatherViewModel.class);

        City[] cities = (City[]) getArguments().getParcelableArray("cities");

        CitiesFragmentPagerAdapter citiesFragmentPagerAdapter =
                new CitiesFragmentPagerAdapter(getChildFragmentManager(), getLifecycle());

        citiesFragmentPagerAdapter.setCitiesArrayList(cities);
        binding.citiesViewPager.setAdapter(citiesFragmentPagerAdapter);
        new TabLayoutMediator(binding.citiesTabLayout, binding.citiesViewPager, (tab, position) -> {
            tab.setText((citiesFragmentPagerAdapter.getCitiesArrayList()[position].getName() == null)
                    ? getContext().getText(R.string.current_city) : citiesFragmentPagerAdapter.getCitiesArrayList()[position].getName());
        }).attach();

        binding.backBtn.setOnClickListener(view1->{
            getActivity().onBackPressed();
        });
    }
}