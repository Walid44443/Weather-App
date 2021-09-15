package com.paymob.weather.ui.fragment.weatherList.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.paymob.weather.data.model.response.City;
import com.paymob.weather.ui.fragment.weatherList.CityWeatherFragment;

public class CitiesFragmentPagerAdapter extends FragmentStateAdapter {
    private City[] citiesArrayList;

    public CitiesFragmentPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    public City[] getCitiesArrayList() {
        return citiesArrayList;
    }

    public void setCitiesArrayList(City[] citiesArrayList) {
        this.citiesArrayList = citiesArrayList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        CityWeatherFragment cityWeatherFragment = new CityWeatherFragment();

        Bundle bundle = new Bundle();

        bundle.putParcelable("city", citiesArrayList[position]);

        cityWeatherFragment.setArguments(bundle);

        return cityWeatherFragment;
    }

    @Override
    public int getItemCount() {
        return citiesArrayList.length;
    }
}