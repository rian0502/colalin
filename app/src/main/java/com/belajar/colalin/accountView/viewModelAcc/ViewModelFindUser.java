package com.belajar.colalin.accountView.viewModelAcc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;

import com.belajar.colalin.R;
import com.belajar.colalin.accountView.FragmentAuth;
import com.belajar.colalin.apiService.ApiClient;
import com.belajar.colalin.homeView.Models.UserPhone;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelFindUser extends ViewModel {
    private String username;
    private final Fragment fragment;
    public ViewModelFindUser() {
       fragment = new FragmentAuth();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void findUser(Button button, ProgressBar progressBar, FragmentActivity context){
        button.setText("");
        button.setClickable(false);
        progressBar.setVisibility(View.VISIBLE);

        Call< ArrayList< UserPhone > > findUser =
                ApiClient.getService().getUserPhone(getUsername());
        findUser.enqueue(new Callback< ArrayList< UserPhone > >() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call< ArrayList< UserPhone > > call,
                                   @NonNull Response< ArrayList< UserPhone > > response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    if (response.body().get(0).getUsername().equals(getUsername())){
                        Bundle bundle = new Bundle();
                        bundle.putString("username",response.body().get(0).getUsername());
                        bundle.putString("phone",response.body().get(0).getPhone());
                        fragment.setArguments(bundle);
                        context.getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container_account_view, fragment)
                                .addToBackStack(null)
                                .commit();
                    }else{
                        Toast.makeText(context, "username tidak ada", Toast.LENGTH_SHORT).show();

                    }
                }
                button.setText("Next");
                button.setClickable(true);
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(@NonNull Call< ArrayList< UserPhone > > call,
                                  @NonNull Throwable t) {
                Toast.makeText(context, "Eror Internal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
