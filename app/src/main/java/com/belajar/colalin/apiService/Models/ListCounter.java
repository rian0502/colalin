package com.belajar.colalin.apiService.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListCounter {
    @SerializedName("id_counter")
    @Expose
    private String id_counter;

    @SerializedName("lokasi")
    @Expose
    private String lokasi;
    @SerializedName("type jalan")
    @Expose
    private String typeJalan;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("mulai")
    @Expose
    private String mulai;
    @SerializedName("selesai")
    @Expose
    private String selesai;
    @SerializedName("one_way")
    @Expose
    private OneWay oneWay;
    @SerializedName("two_way")
    @Expose
    private TwoWay twoWay;
    @SerializedName("toll_road")
    @Expose
    private TollRoad tollRoad;

    private int imageResource;
    public OneWay getOneWay() {
        return oneWay;
    }

    public void setOneWay(OneWay oneWay) {
        this.oneWay = oneWay;
    }

    public TwoWay getTwoWay() {
        return twoWay;
    }

    public void setTwoWay(TwoWay twoWay) {
        this.twoWay = twoWay;
    }

    public TollRoad getTollRoad() {
        return tollRoad;
    }

    public void setTollRoad(TollRoad tollRoad) {
        this.tollRoad = tollRoad;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getId_counter() {
        return id_counter;
    }

    public void setId_counter(String id_counter) {
        this.id_counter = id_counter;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }


    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTypeJalan() {
        return typeJalan;
    }

    public void setTypeJalan(String typeJalan) {
        this.typeJalan = typeJalan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getMulai() {
        return mulai;
    }

    public void setMulai(String mulai) {
        this.mulai = mulai;
    }

    public String getSelesai() {
        return selesai;
    }

    public void setSelesai(String selesai) {
        this.selesai = selesai;
    }
}
