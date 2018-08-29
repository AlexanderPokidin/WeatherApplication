package com.pokidin.a.weatherapplication;

import android.util.Log;

import com.pokidin.a.weatherapplication.model.Forecast;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private static final String TAG = "RestClient";
    private final static String BASE_URL = "https://api.openweathermap.org";
    private static final String KEY = "d96cb8dcee64ae658a8ccd5c09dcf58f";

    private double lat = 50.45466;
    private double lng = 30.5238;

    public static RestClient instance;

    public static RestClient getInstance(){
        if (instance == null){
            instance = new RestClient();
        }
        return instance;
    }

    private RestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherAPI weatherAPI = retrofit.create(WeatherAPI.class);
        weatherAPI.getForecast(lat, lng, KEY).enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, retrofit2.Response<Forecast> response) {
                Log.i(TAG, "" + response);

            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                Log.e(TAG, "" + t);
            }
        });
    }


}
