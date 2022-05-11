package com.belajar.colalin.homeView.viewModel;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.belajar.colalin.apiService.ApiClient;
import com.belajar.colalin.apiService.RegisterAccount;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelTollRoad extends ViewModel {
    private int gol2, gol3, gol4, gol5a, gol5b, gol6a, gol6b, gol7a, gol7b, gol7c;
    private String start;
    private String end;
    private String date;

    public ViewModelTollRoad() {
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

    public void addGol2() {
        this.gol2 += 1;
    }

    public void addGol3() {
        this.gol3 += 1;
    }

    public void addGol4() {
        this.gol4 += 1;
    }

    public void addGol5a() {
        this.gol5a += 1;
    }

    public void addGol5b() {
        this.gol5b += 1;
    }

    public void addGol6a() {
        this.gol6a += 1;
    }

    public void addGol6b() {
        this.gol6b += 1;
    }

    public void addGol7a() {
        this.gol7a += 1;
    }

    public void addGol7b() {
        this.gol7b += 1;
    }

    public void addGol7c() {
        this.gol7c += 1;
    }

    public int getGol2() {
        return gol2;
    }

    public int getGol3() {
        return gol3;
    }

    public int getGol4() {
        return gol4;
    }

    public int getGol5a() {
        return gol5a;
    }

    public int getGol5b() {
        return gol5b;
    }

    public int getGol6a() {
        return gol6a;
    }

    public int getGol6b() {
        return gol6b;
    }

    public int getGol7a() {
        return gol7a;
    }

    public int getGol7b() {
        return gol7b;
    }

    public int getGol7c() {
        return gol7c;
    }

    public void resetValue() {
        gol2 = 0;
        gol3 = 0;
        gol4 = 0;
        gol5a = 0;
        gol5b = 0;
        gol6a = 0;
        gol6b = 0;
        gol7a = 0;
        gol7b = 0;
        gol7c = 0;
    }


}
