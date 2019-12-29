package com.example.deskmate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class feedInfo {

    @SerializedName("response")
    @Expose
    private feedResponse response;

    public feedResponse getResponse() {
        return response;
    }

    public void setResponse(feedResponse response) {
        this.response = response;
    }
}
