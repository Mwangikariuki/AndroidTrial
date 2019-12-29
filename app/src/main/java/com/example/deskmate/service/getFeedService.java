package com.example.deskmate.service;

import com.example.deskmate.model.feedInfo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface getFeedService {

    @GET("/tester")
    Call <feedInfo> getFeed();
}
