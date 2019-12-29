package com.example.deskmate.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitInstance {

    private static Retrofit retrofit = null;

    private static  String BASE_URL = "http://192.168.0.28:3000";

    public static getFeedService getFeedService () {

        if (retrofit == null ) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(getFeedService.class);
    }
}
