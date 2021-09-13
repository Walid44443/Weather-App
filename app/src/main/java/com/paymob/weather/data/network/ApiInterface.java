package com.paymob.weather.data.network;

import com.paymob.weather.data.model.response.CityForecastResponse;

import retrofit2.Response;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/HumanApp/api/Mobile/GetEmployeeAnnotation")
    public Response<CityForecastResponse> getWeatherResponseForCity();
}
