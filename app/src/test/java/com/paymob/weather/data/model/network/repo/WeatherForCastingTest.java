package com.paymob.weather.data.model.network.repo;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.paymob.weather.data.model.response.City;
import com.paymob.weather.data.model.response.Coord;
import com.paymob.weather.data.network.repo.WeatherForecastingRepo;
import com.paymob.weather.util.domain.Status;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.mockwebserver.MockWebServer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;


public class WeatherForCastingTest {

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    City city = new City();
    Coord coord = new Coord(31.2516999 , 29.9582763);
    City city2 = new City();

    public MockWebServer mockWebServer;

    @Before
    public void setup() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        city2.setCoord(coord);
        city.setName("cairo");
    }

    @After
    public void tearDown() throws IOException{
        mockWebServer.shutdown();
    }

    @Test
    public void assertCityCountryNotNull(){
        assertNotNull("City Name is exist", city.getName());
    }

    @Test
    public void assertCityLocationNotNull(){
        assertNotNull("City Location is exist", city2.getCoord());
    }

    @Test
    public void callWeatherAPIWithCityName_returnSuccessResource() throws InterruptedException {
        WeatherForecastingRepo testWeather = new WeatherForecastingRepo(city);
        testWeather.fetchFromNetwork();
        mockWebServer.takeRequest(10L , TimeUnit.SECONDS); /* We tell our server to block for 10 second before continue the test and
                After 10 second we assume the the our resource will return Success and this indicates that our api is success and completed with non issue
        */
        assertSame(Objects.requireNonNull(testWeather.getResultLive().getValue()).getStatus(), Status.SUCCESS);
        assertNotNull(testWeather.getResultLive());
    }


//    @Test
//    public void callWeatherAPIWithCityName2() throws InterruptedException {
//        WeatherForecastingRepo testWeather = new WeatherForecastingRepo(city);
//        testWeather.fetchFromNetwork();
//        mockWebServer.takeRequest(10L , TimeUnit.SECONDS);
//
//        LiveDataUtilClass<List<CityWeather>> live = new LiveDataUtilClass<>();
//        live.getValue(testWeather.getResultLive().);
//
//        assertSame(Objects.requireNonNull(live.getValue().getStatus(), Status.SUCCESS));
//        assertNotNull(testWeather.getResultLive());
//    }


    @Test
    public void callWeatherAPIWithoutCityName_returnSuccessResource() throws InterruptedException {
        WeatherForecastingRepo testWeather = new WeatherForecastingRepo(city2);
        testWeather.fetchFromNetwork();
        mockWebServer.takeRequest(10L , TimeUnit.SECONDS);
        assertSame(Objects.requireNonNull(testWeather.getResultLive().getValue()).getStatus(), Status.SUCCESS);
        assertNotNull(testWeather.getResultLive());
    }

}
