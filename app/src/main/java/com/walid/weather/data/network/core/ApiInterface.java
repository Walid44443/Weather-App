package com.walid.weather.data.network.core;

import com.walid.weather.data.model.response.CityForecastResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/data/2.5/forecast")
    public Call<CityForecastResponse>
    getWeatherResponseForCityByName(@Query("q") String cityName,
                                    @Query("appid") String appID,
                                    @Query("units") String units);


    @GET("/data/2.5/forecast")
    public Call<CityForecastResponse>
    getWeatherResponseForCityByLocation(@Query("lat") Double latitude,
                                        @Query("lon") Double longitude,
                                        @Query("appid") String appID,
                                        @Query("units") String units);
}
