package com.pokidin.a.weatherapplication;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private final static String BASE_URL = "api.openweathermap.org";

    private static WeatherAPI sWeatherAPI;

    public static WeatherAPI getClient() {
        if (sWeatherAPI == null) {
            OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    return chain.proceed(chain.request());
                }
            });

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            sWeatherAPI = retrofit.create(WeatherAPI.class);
        }
        return sWeatherAPI;
    }
}
