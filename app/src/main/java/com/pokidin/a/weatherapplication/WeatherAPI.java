package com.pokidin.a.weatherapplication;

import com.pokidin.a.weatherapplication.model.Forecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {

    @GET("/data/2.5/weather")
    Call<Forecast> getForecast(@Query("lat") double latitude,
                               @Query("lon") double longitude,
                               @Query("appid") String key);
}
