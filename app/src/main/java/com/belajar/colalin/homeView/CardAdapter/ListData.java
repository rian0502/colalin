package com.belajar.colalin.homeView.CardAdapter;

import android.graphics.Color;

import com.belajar.colalin.R;
import com.belajar.colalin.homeView.Models.ListMenu;

import java.util.ArrayList;

public class ListData {
    private static ArrayList< ListMenu >data = new ArrayList<>();
    public static void addData(){
        data.add(new ListMenu("Jalan Toll","Jalan toll satu arah",R.drawable.road,Color.parseColor("#9C0F48")));
        data.add(new ListMenu("Jalan Raya","Jalan Raya dua arah", R.drawable.motorway,Color.parseColor("#113906")));
        data.add(new ListMenu("Jalan Raya", "Jalan Raya satu arah", R.drawable.one_way, Color.parseColor("#06113C")));
    }

    public static ArrayList< ListMenu > getData() {
        return data;
    }
}
