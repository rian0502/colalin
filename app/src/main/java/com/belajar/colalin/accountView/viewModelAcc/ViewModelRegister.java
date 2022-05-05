package com.belajar.colalin.accountView.viewModelAcc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;

import com.belajar.colalin.MainActivity;
import com.belajar.colalin.R;
import com.belajar.colalin.accountView.LoginFragment;
import com.belajar.colalin.apiService.ApiClient;
import com.belajar.colalin.apiService.RegisterAccount;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelRegister extends ViewModel {
    private String username;
    private String password;
    private String phone;
    private FragmentActivity context;
    private boolean suksess;

    public boolean isSuksess() {
        return suksess;
    }

    public void setSuksess(boolean suksess) {
        this.suksess = suksess;
    }


    public FragmentActivity getContext() {
        return context;
    }

    public void setContext(FragmentActivity context) {
        this.context = context;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void checkUsername(Button button, ProgressBar progressBar){
        Call<ArrayList<RegisterAccount>> user = ApiClient.getService().userExistCheck(getUsername());
        user.enqueue(new Callback< ArrayList< RegisterAccount > >() {
            @Override
            public void onResponse(@NonNull Call< ArrayList< RegisterAccount > > call,
                                   @NonNull Response< ArrayList< RegisterAccount > > response) {
                if (response.isSuccessful() && response.body().size() != 0){
                    if (response.body().get(0).getStatus().equals("ready")){
                        checkPhone(button, progressBar);
                    }else{
                        Toast.makeText(context, "Username Sudah terdaftar",
                                Toast.LENGTH_SHORT).show();
                        button.setClickable(true);
                        button.setText("Register");
                        progressBar.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call< ArrayList< RegisterAccount > > call,
                                  @NonNull Throwable t) {
                Toast.makeText(context, "Eror Internal", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void checkPhone(Button button, ProgressBar progressBar){
        Call<ArrayList<RegisterAccount>>  phone =
                ApiClient.getService().phoneExsitCheck(getPhone());
        phone.enqueue(new Callback< ArrayList< RegisterAccount > >() {
            @Override
            public void onResponse(Call< ArrayList< RegisterAccount > > call,
                                   @NonNull Response< ArrayList< RegisterAccount > > response) {
                if (response.isSuccessful() && response.body().size() != 0){
                    if (response.body().get(0).getStatus().equals("ready")){
                        registrasi(button, progressBar);
                    }else{
                        Toast.makeText(context, "No Handphone Sudah terdaftar",
                                Toast.LENGTH_LONG).show();
                        button.setClickable(true);
                        button.setText("Register");
                        progressBar.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call< ArrayList< RegisterAccount > > call,
                                  @NonNull Throwable t) {
                Toast.makeText(context, "Eror Internal", Toast.LENGTH_SHORT).show();
                button.setClickable(true);
                button.setText("Register");
                progressBar.setVisibility(View.GONE);
            }
        });
    }


    public void registrasi(Button button, ProgressBar progressBar){
        Call< ArrayList< RegisterAccount > > register =
                ApiClient.getService().registerUser(getPassword(), getUsername(), getPhone());
        register.enqueue(new Callback< ArrayList< RegisterAccount > >() {
            @Override
            public void onResponse(@NonNull Call< ArrayList< RegisterAccount > > call,
                                   @NonNull Response< ArrayList< RegisterAccount > > response) {
                if (response.isSuccessful()){
                    if (response.body().get(0).getStatus().equals("sukses")){
                        Toast.makeText(context, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                        button.setClickable(true);
                        button.setText("Register");
                        progressBar.setVisibility(View.GONE);
                        Intent intent = new Intent(context, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                                Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }else {
                        Toast.makeText(context, "Registrasi Gagal", Toast.LENGTH_SHORT).show();
                        setSuksess(false);

                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call< ArrayList< RegisterAccount > > call,
                                  @NonNull Throwable t) {
                Toast.makeText(context, "Eror Internal", Toast.LENGTH_SHORT).show();
                setSuksess(false);
                button.setClickable(true);
                button.setText("Register");
                progressBar.setVisibility(View.GONE);
            }
        });
    }

}
