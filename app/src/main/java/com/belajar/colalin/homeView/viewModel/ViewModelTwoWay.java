package com.belajar.colalin.homeView.viewModel;

import androidx.annotation.NonNull;
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

public class ViewModelTwoWay extends ViewModel {
    private int gol_1, gol_2, gol_3, gol_4, gol_5a, gol_5b,
            gol_6a, gol_6b, gol_7a, gol_7b, gol_7c, gol_8;

    private int mgol_1, mgol_2, mgol_3, mgol_4, mgol_5a, mgol_5b,
            mgol_6a, mgol_6b, mol_7a, mgol_7b, mgol_7c, mgol_8;

    private String start;
    private String end;
    private String date;

    public ViewModelTwoWay (){
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

    public int getGol_1() {
        return gol_1;
    }

    public void setGol_1(int gol_1) {
        this.gol_1 = gol_1;
    }

    public int getGol_2() {
        return gol_2;
    }

    public void setGol_2(int gol_2) {
        this.gol_2 = gol_2;
    }

    public int getGol_3() {
        return gol_3;
    }

    public void setGol_3(int gol_3) {
        this.gol_3 = gol_3;
    }

    public int getGol_4() {
        return gol_4;
    }

    public void setGol_4(int gol_4) {
        this.gol_4 = gol_4;
    }

    public int getGol_5a() {
        return gol_5a;
    }

    public void setGol_5a(int gol_5a) {
        this.gol_5a = gol_5a;
    }

    public int getGol_5b() {
        return gol_5b;
    }

    public void setGol_5b(int gol_5b) {
        this.gol_5b = gol_5b;
    }

    public int getGol_6a() {
        return gol_6a;
    }

    public void setGol_6a(int gol_6a) {
        this.gol_6a = gol_6a;
    }

    public int getGol_6b() {
        return gol_6b;
    }

    public void setGol_6b(int gol_6b) {
        this.gol_6b = gol_6b;
    }

    public int getGol_7a() {
        return gol_7a;
    }

    public void setGol_7a(int gol_7a) {
        this.gol_7a = gol_7a;
    }

    public int getGol_7b() {
        return gol_7b;
    }

    public void setGol_7b(int gol_7b) {
        this.gol_7b = gol_7b;
    }

    public int getGol_7c() {
        return gol_7c;
    }

    public void setGol_7c(int gol_7c) {
        this.gol_7c = gol_7c;
    }

    public int getGol_8() {
        return gol_8;
    }

    public void setGol_8(int gol_8) {
        this.gol_8 = gol_8;
    }

    public int getMgol_1() {
        return mgol_1;
    }

    public void setMgol_1(int mgol_1) {
        this.mgol_1 = mgol_1;
    }

    public int getMgol_2() {
        return mgol_2;
    }

    public void setMgol_2(int mgol_2) {
        this.mgol_2 = mgol_2;
    }

    public int getMgol_3() {
        return mgol_3;
    }

    public void setMgol_3(int mgol_3) {
        this.mgol_3 = mgol_3;
    }

    public int getMgol_4() {
        return mgol_4;
    }

    public void setMgol_4(int mgol_4) {
        this.mgol_4 = mgol_4;
    }

    public int getMgol_5a() {
        return mgol_5a;
    }

    public void setMgol_5a(int mgol_5a) {
        this.mgol_5a = mgol_5a;
    }

    public int getMgol_5b() {
        return mgol_5b;
    }

    public void setMgol_5b(int mgol_5b) {
        this.mgol_5b = mgol_5b;
    }

    public int getMgol_6a() {
        return mgol_6a;
    }

    public void setMgol_6a(int mgol_6a) {
        this.mgol_6a = mgol_6a;
    }

    public int getMgol_6b() {
        return mgol_6b;
    }

    public void setMgol_6b(int mgol_6b) {
        this.mgol_6b = mgol_6b;
    }

    public int getMol_7a() {
        return mol_7a;
    }

    public void setMol_7a(int mol_7a) {
        this.mol_7a = mol_7a;
    }

    public int getMgol_7b() {
        return mgol_7b;
    }

    public void setMgol_7b(int mgol_7b) {
        this.mgol_7b = mgol_7b;
    }

    public int getMgol_7c() {
        return mgol_7c;
    }

    public void setMgol_7c(int mgol_7c) {
        this.mgol_7c = mgol_7c;
    }

    public int getMgol_8() {
        return mgol_8;
    }

    public void setMgol_8(int mgol_8) {
        this.mgol_8 = mgol_8;
    }

    public void clearData(){
        setGol_1(0);
        setGol_2(0);
        setGol_3(0);
        setGol_4(0);
        setGol_5a(0);
        setGol_5b(0);
        setGol_6a(0);
        setGol_6b(0);
        setGol_7a(0);
        setGol_7b(0);
        setGol_7c(0);
        setGol_8(0);
        setMgol_1(0);
        setMgol_2(0);
        setMgol_3(0);
        setMgol_4(0);
        setMgol_5a(0);
        setGol_5b(0);
        setMgol_6a(0);
        setMgol_6a(0);
        setMol_7a(0);
        setMgol_7b(0);
        setMgol_7c(0);
        setMgol_8(0);
    }
    public void saveData(String lokasi, int id){
        Call< ArrayList< StatusRespons > > saveTwo = ApiClient.getService().insert_two(
                lokasi,"Two Way", getDate(), getStart(), getEnd(),id,gol_1,gol_2,gol_3,gol_4,
                gol_5a, gol_5b, gol_6a, gol_6b, gol_7a, gol_7b, gol_7c, gol_8, mgol_1, mgol_2, mgol_3,
                mgol_4, mgol_5a, mgol_5b, mgol_6a, mgol_6b, mol_7a, mgol_7b, mgol_7c, mgol_8
        );
        saveTwo.enqueue(new Callback< ArrayList< StatusRespons > >() {
            @Override
            public void onResponse(@NonNull Call< ArrayList< StatusRespons > > call,
                                   @NonNull Response< ArrayList< StatusRespons > > response) {

            }

            @Override
            public void onFailure(@NonNull Call< ArrayList< StatusRespons > > call,
                                  @NonNull Throwable t) {

            }
        });
    }
}
