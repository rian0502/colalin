package com.belajar.colalin.apiService.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListCounter {
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

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    private int imageResource;
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
