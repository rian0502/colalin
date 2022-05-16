package com.belajar.colalin.homeView.Models;

import androidx.annotation.Keep;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Keep
public class StatusRespons {

    @SerializedName("status")
    @Expose
    private String status;

    public String getStatus() {
        return status;
    }

}
