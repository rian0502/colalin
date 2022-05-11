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
    @POST("register.php")
    Call< ArrayList< RegisterAccount > > registerUser(@Field("password") String password,
                                                      @Field("username") String username,
                                                      @Field("phone") String phone
    );
    @FormUrlEncoded
    @POST("insert_one.php")
    Call<ArrayList<StatusRespons>> insert_one(@Field("lokasi")String lokasi,
                                              @Field("jenis") String jenis,
                                              @Field("date") String date,
                                              @Field("start") String start,
                                              @Field("end") String end,
                                              @Field("id_akun") int id,
                                              @Field("gol1") int gol1,
                                              @Field("gol2") int gol2,
                                              @Field("gol3") int gol3,
                                              @Field("gol4") int gol4,
                                              @Field("gol5a") int gol5a,
                                              @Field("gol5b") int gol5b,
                                              @Field("gol6a") int gol6a,
                                              @Field("gol6b") int gol6b,
                                              @Field("gol7a") int gol7a,
                                              @Field("gol7b") int gol7b,
                                              @Field("gol7c") int gol7c,
                                              @Field("gol8") int gol8
    );
    @FormUrlEncoded
    @POST("insert_toll.php")
    Call<ArrayList<StatusRespons>> insert_toll(@Field("lokasi")String lokasi,
                                              @Field("jenis") String jenis,
                                              @Field("date") String date,
                                              @Field("start") String start,
                                              @Field("end") String end,
                                              @Field("id_akun") int id,
                                              @Field("gol2") int gol2,
                                              @Field("gol3") int gol3,
                                              @Field("gol4") int gol4,
                                              @Field("gol5a") int gol5a,
                                              @Field("gol5b") int gol5b,
                                              @Field("gol6a") int gol6a,
                                              @Field("gol6b") int gol6b,
                                              @Field("gol7a") int gol7a,
                                              @Field("gol7b") int gol7b,
                                              @Field("gol7c") int gol7c

    );
    @FormUrlEncoded
    @POST("insert_two.php")
    Call<ArrayList<StatusRespons>> insert_two(@Field("lokasi")String lokasi,
                                              @Field("jenis") String jenis,
                                              @Field("date") String date,
                                              @Field("start") String start,
                                              @Field("end") String end,
                                              @Field("id_akun") int id,
                                              @Field("gol1") int gol1,
                                              @Field("gol2") int gol2,
                                              @Field("gol3") int gol3,
                                              @Field("gol4") int gol4,
                                              @Field("gol5a") int gol5a,
                                              @Field("gol5b") int gol5b,
                                              @Field("gol6a") int gol6a,
                                              @Field("gol6b") int gol6b,
                                              @Field("gol7a") int gol7a,
                                              @Field("gol7b") int gol7b,
                                              @Field("gol7c") int gol7c,
                                              @Field("gol8") int gol8,
                                              @Field("mgol1") int mgol1,
                                              @Field("mgol2") int mgol2,
                                              @Field("mgol3") int mgol3,
                                              @Field("mgol4") int mgol4,
                                              @Field("mgol5a") int mgol5a,
                                              @Field("mgol5b") int mgol5b,
                                              @Field("mgol6a") int mgol6a,
                                              @Field("mgol6b") int mgol6b,
                                              @Field("mgol7a") int mgol7a,
                                              @Field("mgol7b") int mgol7b,
                                              @Field("mgol7c") int mgol7c,
                                              @Field("mgol8") int mgol8
    );
}
