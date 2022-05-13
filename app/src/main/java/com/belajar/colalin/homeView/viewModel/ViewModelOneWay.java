package com.belajar.colalin.homeView.viewModel;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;

import com.belajar.colalin.apiService.ApiClient;
import com.belajar.colalin.apiService.StatusRespons;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelOneWay extends ViewModel {
    private int gol_1, gol_2, gol_3, gol_4, gol_5a, gol_5b,
            gol_6a, gol_6b, gol_7a, gol_7b, gol_7c, gol_8;

    private String start;
    private String end;
    private String date;

    public ViewModelOneWay() {
        this.start = DateTimeFormatter.ofPattern("HH:mm").format(LocalDateTime.now());
        this.date = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDate.now());
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void addGol_1() {
        this.gol_1 = this.gol_1 + 1;
    }

    public int getGol_1() {
        return gol_1;
    }

    public int getGol_2() {
        return gol_2;
    }

    public int getGol_3() {
        return gol_3;
    }

    public int getGol_4() {
        return gol_4;
    }

    public int getGol_5a() {
        return gol_5a;
    }

    public int getGol_5b() {
        return gol_5b;
    }

    public int getGol_6a() {
        return gol_6a;
    }

    public int getGol_6b() {
        return gol_6b;
    }

    public int getGol_7a() {
        return gol_7a;
    }

    public int getGol_7b() {
        return gol_7b;
    }

    public int getGol_7c() {
        return gol_7c;
    }

    public int getGol_8() {
        return gol_8;
    }

    public void addGol_2() {
        this.gol_2++;
    }

    public void addGol_3() {
        this.gol_3++;
    }

    public void addGol_4() {
        this.gol_4++;
    }

    public void addGol_5a() {
        this.gol_5a++;
    }

    public void addGol_5b() {
        this.gol_5b++;
    }

    public void addGol_6a() {
        this.gol_6a++;
    }

    public void addGol_6b() {
        this.gol_6b++;
    }

    public void addGol_7a() {
        this.gol_7a++;
    }

    public void addGol_7b() {
        this.gol_7b++;
    }

    public void addGol_7c() {
        this.gol_7c++;
    }

    public void addGol_8() {
        this.gol_8++;
    }

    public void resetValue(){
        gol_1 = 0;
        gol_2 = 0;
        gol_3 = 0;
        gol_4 = 0;
        gol_5a = 0;
        gol_5b = 0;
        gol_6a = 0;
        gol_6b = 0;
        gol_7a = 0;
        gol_7b = 0;
        gol_7c = 0;
        gol_8 = 0;

    }
    public void saveData(String lokasi, int id, FragmentActivity context){
        Call<ArrayList< StatusRespons >> saveOne = ApiClient.getService().insert_one(
                lokasi, "One Way",getDate(),getStart(), getEnd(),id,
                gol_1, gol_2, gol_3, gol_4, gol_5a, gol_5b, gol_6a, gol_6b,
                gol_7a, gol_7b, gol_7c, gol_8
        );
        saveOne.enqueue(new Callback< ArrayList< StatusRespons > >() {
            @Override
            public void onResponse(@NonNull Call< ArrayList< StatusRespons > > call,
                                   @NonNull Response< ArrayList< StatusRespons > > response) {
                if (response.isSuccessful()){
                    if (response.body().get(0).getStatus().equals("sukses")){
                        Toast.makeText(context, "Data Berhasil di simpan",
                                Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(context,"Data gagal disimpan",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call< ArrayList< StatusRespons > > call,
                                  @NonNull Throwable t) {
                Toast.makeText(context, "Eror internal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
