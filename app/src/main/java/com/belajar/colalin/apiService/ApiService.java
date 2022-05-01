package com.belajar.colalin.apiService;

import android.util.Log;

import com.belajar.colalin.homeView.Models.ModelData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("login.php")
    Call< ArrayList<LoginAuth> > loginAuth(
            @Field("password") String password,
            @Field("username") String username
    );
    @FormUrlEncoded
    @POST("show_data.php")
    Call<ArrayList<ModelData>> showData(@Field("id_account") int id_account);

}
