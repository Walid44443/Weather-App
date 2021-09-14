package com.paymob.weather.data.network.repo;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.paymob.weather.data.model.response.CityForecastResponse;
import com.paymob.weather.data.model.response.CityWeather;
import com.paymob.weather.util.CONST;
import com.paymob.weather.util.GroupWeatherDatesByDay;
import com.paymob.weather.util.domain.Resource;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherForecastingRepo extends Repository<HashMap<Date, List<CityWeather>>> {
    private String cityName;

    public WeatherForecastingRepo(String cityName) {
        this.cityName = cityName;
        fetchFromNetwork();
    }

    @Override
    public void fetchFromNetwork() {
        GroupWeatherDatesByDay groupWeatherDatesByDay = new GroupWeatherDatesByDay();
        Call<CityForecastResponse> call =
                super.getApiInterface()
                        .getApi()
                        .getWeatherResponseForCity(cityName, CONST.API_ID,"metric");

        call.enqueue(new Callback<CityForecastResponse>() {
            @Override
            public void onResponse(Call<CityForecastResponse> call, Response<CityForecastResponse> response) {
                if (response.isSuccessful())
                    WeatherForecastingRepo.super.getResult()
                            .postValue(
                                    Resource.Companion.success(groupWeatherDatesByDay.parseTimeStamps(response.body().getList())));
                else
                    WeatherForecastingRepo.super.getResult()
                            .postValue(Resource.Companion.error("Error Code :" + response.code(), null));
            }

            @Override
            public void onFailure(Call<CityForecastResponse> call, Throwable t) {
                WeatherForecastingRepo.super.getResult()
                        .postValue(Resource.Companion.error("NETWORK_ERROR", null));
            }
        });
    }


    @Override
    public boolean shouldFetch(@Nullable HashMap<Date, List<CityWeather>> data) {
        if (data != null)
            return data.isEmpty();
        return true;
    }

    public MutableLiveData<Resource<HashMap<Date, List<CityWeather>>>> getResultLive() {
        return super.getResult();
    }
}
