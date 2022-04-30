package com.belajar.colalin.apiService;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginAuth {
    @SerializedName("status")
    @Expose
    private String status;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
