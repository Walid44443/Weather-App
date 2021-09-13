package com.paymob.weather.data.network;

import com.paymob.weather.data.model.response.CityForecastResponse;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/data/2.5/forecast?q={city_name}&appid={API key}")
    public Response<CityForecastResponse> getWeatherResponseForCity(@Query("q") String cityName,
                                                                    @Query("appid") String appID);
}
