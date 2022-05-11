package com.belajar.colalin.apiService;

import com.belajar.colalin.apiService.Models.ListCounter;
import com.belajar.colalin.homeView.Models.ModelData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @GET("user_exist.php")
    Call< ArrayList< RegisterAccount > > userExistCheck(@Query("username") String username);

    @GET("phone_exist.php")
    Call< ArrayList< RegisterAccount > > phoneExsitCheck(@Query("phone") String phone);

    @GET("user_phone.php")
    Call<ArrayList<UserPhone>> getUserPhone(@Query("username") String username);

    @FormUrlEncoded
    @POST("update_pass.php")
    Call<ArrayList<RegisterAccount>> updatePass(@Field("username")String username,
                                                @Field("password")String password
    );

    @FormUrlEncoded
    @POST("login.php")
    Call< ArrayList< LoginAuth > > loginAuth(
            @Field("password") String password,
            @Field("username") String username
    );
    @FormUrlEncoded
    @POST("show_counter.php")
    Call<ArrayList< ListCounter >> getList(@Field("id_akun") int id);

    @FormUrlEncoded
    @POST("show_detail.php")
    Call<ArrayList<ListCounter>> getDetaill();

    @FormUrlEncoded
    @POST("register.php")
    Call< ArrayList< RegisterAccount > > registerUser(@Field("password") String password,
                                                      @Field("username") String username,
                                                      @Field("phone") String phone
    );

}
