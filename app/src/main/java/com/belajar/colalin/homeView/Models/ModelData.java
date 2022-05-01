package com.belajar.colalin.homeView.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelData implements Parcelable {

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
    private int imageResource;

    protected ModelData(Parcel in) {
        lokasi = in.readString();
        jenisJalan = in.readString();
        tanggal = in.readString();
        kendaraan = in.readParcelable(Kendaraan.class.getClassLoader());
        imageResource = in.readInt();
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(lokasi);
        dest.writeString(jenisJalan);
        dest.writeString(tanggal);
        dest.writeParcelable(kendaraan, flags);
        dest.writeInt(imageResource);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator< ModelData > CREATOR = new Creator< ModelData >() {
        @Override
        public ModelData createFromParcel(Parcel in) {
            return new ModelData(in);
        }

        @Override
        public ModelData[] newArray(int size) {
            return new ModelData[size];
        }
    };

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
