package com.example.buddybuilding.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClass {

    public static final String BASE_URL =
            "http://192.168.43.254/BuddyBuilding/";


    public static Retrofit getRetroInstance(){
        Gson gson = new GsonBuilder().setLenient().create();
        return new
                Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }

    public static APIService getApiService() {
        return getRetroInstance().create(APIService.class);
    }
}
