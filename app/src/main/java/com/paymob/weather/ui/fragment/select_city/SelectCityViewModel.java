package com.paymob.weather.ui.fragment.select_city;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.paymob.weather.data.model.response.City;

import java.util.LinkedList;
import java.util.List;

public class SelectCityViewModel extends ViewModel {
    protected MutableLiveData<List<City>> listLiveData = new MutableLiveData<>(new LinkedList<>());
}