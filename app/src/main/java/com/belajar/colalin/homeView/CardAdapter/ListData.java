package com.belajar.colalin.homeView.CardAdapter;

import com.belajar.colalin.R;
import com.belajar.colalin.homeView.Models.ListMenu;

import java.util.ArrayList;

public class ListData {
    private static ArrayList< ListMenu >data = new ArrayList<>();
    public static void addData(){
        data.add(new ListMenu("Jalan Toll","Jalan toll satu arah",R.drawable.road));
        data.add(new ListMenu("Jalan Raya","Jalan Raya dua arah", R.drawable.motorway));
    }

    public static ArrayList< ListMenu > getData() {
        return data;
    }
}
