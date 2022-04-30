package com.belajar.colalin.apiService;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataCounter {
    @SerializedName("lokasi")
    @Expose
    private String lokasi;
    @SerializedName("jenis_jalan")
    @Expose
    private String jenisJalan;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("Kendaraan")
    @Expose
    private Kendaraan kendaraan;

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getJenisJalan() {
        return jenisJalan;
    }

    public void setJenisJalan(String jenisJalan) {
        this.jenisJalan = jenisJalan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

}
