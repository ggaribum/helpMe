package com.example.a301.myapplication;

import android.util.Log;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 301 on 2017-09-19.
 */
public class RetrofitClient {
    private static Retrofit retrofit =null;

    public static Retrofit getClient(String URL)
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.v("Testing","getClient");

        return retrofit;
    }
}