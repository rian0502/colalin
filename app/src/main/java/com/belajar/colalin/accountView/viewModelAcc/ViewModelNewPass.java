package com.belajar.colalin.accountView.viewModelAcc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;

import com.belajar.colalin.MainActivity;
import com.belajar.colalin.apiService.ApiClient;
import com.belajar.colalin.homeView.Models.RegisterAccount;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelNewPass extends ViewModel {
    private String username;
    private String password;
    @SuppressLint("StaticFieldLeak")
    private FragmentActivity context;

    public ViewModelNewPass() {

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

    public FragmentActivity getContext() {
        return context;
    }

    public void setContext(FragmentActivity context) {
        this.context = context;
    }

    public void reqUpdatePass(){
        Call< ArrayList< RegisterAccount > > reqPass =
                ApiClient.getService().updatePass(getUsername(), getPassword());
        reqPass.enqueue(new Callback< ArrayList< RegisterAccount > >() {
            @Override
            public void onResponse(@NonNull Call< ArrayList< RegisterAccount > > call,
                                   @NonNull Response< ArrayList< RegisterAccount > > response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    if (response.body().size() != 0) {
                        if (response.body().get(0).getStatus().equals("sukses")) {
                            Toast.makeText(context, "Berhasil", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                                    Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                    Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                        } else {
                            Toast.makeText(context, "Gagal Ganti Password",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call< ArrayList< RegisterAccount > > call,
                                  @NonNull Throwable t) {
                Toast.makeText(context,"Eror Internal",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
