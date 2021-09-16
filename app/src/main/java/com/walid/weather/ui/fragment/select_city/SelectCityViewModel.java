package com.walid.weather.ui.fragment.select_city;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.walid.weather.data.model.response.City;

import java.util.LinkedList;
import java.util.List;

public class SelectCityViewModel extends ViewModel {
    protected MutableLiveData<List<City>> listLiveData = new MutableLiveData<>(new LinkedList<>());
}