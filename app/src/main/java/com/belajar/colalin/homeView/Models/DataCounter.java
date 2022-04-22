package com.belajar.colalin.homeView.Models;

import java.util.ArrayList;

public class DataCounter {
    private static ArrayList<ModelData> kendaraan = new ArrayList<>();

    public static void addData(){
        kendaraan.add(new ModelData(
                "1",
                "Bekasi",
                "22 april 2022",
                "One Way",
                new Kendaraan(1,2,3,4,5,6,7,8,9,10,11,12)
        ));
        kendaraan.add(new ModelData(
                "2",
                "Cikampek",
                "11 maret 2022",
                "Jalan Toll",
                new Kendaraan(1,2,3,4,5,6,7,8,9,10,11,12)
        ));
        kendaraan.add(new ModelData(
                "3",
                "Braga",
                "5 april 2022",
                "Two Way",
                new Kendaraan(1,2,3,4,5,6,7,8,9,10,11,12)
        ));
        kendaraan.add(new ModelData(
                "4",
                "Cipularang",
                "7 april 2022",
                "Jalan Toll",
                new Kendaraan(1,2,3,4,5,6,7,8,9,10,11,12)
        ));
    }

    public static ArrayList< ModelData > getKendaraan() {
        return kendaraan;
    }

}
