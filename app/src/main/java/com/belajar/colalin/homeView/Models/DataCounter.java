package com.belajar.colalin.homeView.Models;

import com.belajar.colalin.R;

import java.util.ArrayList;

public class DataCounter {
    private static final ArrayList<ModelData> kendaraan = new ArrayList<>();

    public static void addData(){
        kendaraan.add(new ModelData(
                "1",
                "Bekasi Timur",
                "22 april 2022",
                "One Way",
                new Kendaraan(3,5,6,7,9,6,
                        7,8,9,10,11,12),
                R.drawable.one_way
        ));
        kendaraan.add(new ModelData(
                "2",
                "Cikampek",
                "11 maret 2022",
                "Toll Road",
                new Kendaraan(1,2,3,4,5,6,
                        7,8,9,10,11,12),
                R.drawable.road
        ));
        kendaraan.add(new ModelData(
                "3",
                "Braga",
                "5 april 2022",
                "Two Way",
                new Kendaraan(1,2,3,4,5,6,
                        7,8,9,10,11,12),
                R.drawable.motorway
        ));
        kendaraan.add(new ModelData(
                "4",
                "Cipularang",
                "7 april 2022",
                "Toll Road",
                new Kendaraan(1,2,3,4,5,6,
                        7,8,9,10,11,12),
                R.drawable.road
        ));
        kendaraan.add(new ModelData(
                "5",
                "M.H Thamrin",
                "11 juni 2022",
                "Two Way",
                new Kendaraan(1,2,3,4,5,6,
                        7,8,9,10,11,12),
                R.drawable.motorway
        ));
        kendaraan.add(new ModelData(
                "6",
                "Pasteur",
                "12 april 2022",
                "Toll Road",
                new Kendaraan(1,2,3,4,5,6,
                        7,8,9,10,11,12),
                R.drawable.road
        ));
        kendaraan.add(new ModelData(
                "7",
                "JAGORAWI",
                "1 juli 2022",
                "Toll Road",
                new Kendaraan(1,2,3,4,5,6,
                        7,8,9,10,11,12),
                R.drawable.road
        ));
        kendaraan.add(new ModelData(
                "4",
                "Karawang Timur",
                "3 juli 2022",
                "One Way",
                new Kendaraan(10,8,12,7,5,9,
                        7,8,9,10,11,12),
                R.drawable.one_way
        ));
    }

    public static ArrayList< ModelData > getKendaraan() {
        return kendaraan;
    }

}
