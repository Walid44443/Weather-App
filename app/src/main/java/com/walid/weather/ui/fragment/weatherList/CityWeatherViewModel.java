package com.walid.weather.ui.fragment.weatherList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.walid.weather.data.model.response.City;
import com.walid.weather.util.domain.ViewState;

public class CityWeatherViewModel extends ViewModel {
    public MutableLiveData<ViewState> viewStateMutableLiveData = new MutableLiveData<>();
    protected MutableLiveData<City> cityLiveData = new MutableLiveData<>();
}