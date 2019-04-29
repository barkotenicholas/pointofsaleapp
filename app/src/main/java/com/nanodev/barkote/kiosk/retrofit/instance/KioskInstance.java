package com.nanodev.barkote.kiosk.retrofit.instance;

import com.nanodev.barkote.kiosk.retrofit.calls.NetworkCalls;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KioskInstance {
    private static final String BASE_URL ="http://localhost:5002";
    private static Retrofit retrofit = null;

    public static NetworkCalls getApiClient(){

        if(retrofit ==null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(NetworkCalls.class);
    }

}
