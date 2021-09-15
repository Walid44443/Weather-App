package com.paymob.weather.data.network.core;

import com.paymob.weather.data.model.response.CityForecastResponse;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/data/2.5/forecast")
    public Call<CityForecastResponse>
    getWeatherResponseForCity(@Query("q") String cityName,
                              @Query("appid") String appID,
                              @Query("units") String units);
}