package com.belajar.colalin.apiService;

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

    @POST("update_pass.php")
    Call<ArrayList<RegisterAccount>> updatePass(@Query("username")String username,
                                                @Query("password")String password
    );

    @FormUrlEncoded
    @POST("login.php")
    Call< ArrayList< LoginAuth > > loginAuth(
            @Field("password") String password,
            @Field("username") String username
    );

    @FormUrlEncoded
    @POST("show_data.php")
    Call< ArrayList< ModelData > > showData(@Field("id_account") int id_account);

    @FormUrlEncoded
    @POST("register.php")
    Call< ArrayList< RegisterAccount > > registerUser(@Field("password") String password,
                                                      @Field("username") String username,
                                                      @Field("phone") String phone
    );
    @FormUrlEncoded
    @POST("insert.php")
    Call< ArrayList< RegisterAccount > > sendData(@Field("lokasi") String lokasi,
                                                  @Field("jenis_jalan") String jenis_jalan,
                                                  @Field("date") String tanggal,
                                                  @Field("start") String start,
                                                  @Field("end") String end,
                                                  @Field("gol_1") int gol1,
                                                  @Field("gol_2") int gol2,
                                                  @Field("gol_3") int gol3,
                                                  @Field("gol_4") int gol4,
                                                  @Field("gol_5a") int gol5a,
                                                  @Field("gol_5b") int gol5b,
                                                  @Field("gol_6a") int gol6a,
                                                  @Field("gol_6b") int gol6b,
                                                  @Field("gol_7a") int gol7a,
                                                  @Field("gol_7b") int gol7b,
                                                  @Field("gol_7c") int gol7c,
                                                  @Field("gol_8") int gol8,
                                                  @Field("id_account") int id_akun
    );
}
