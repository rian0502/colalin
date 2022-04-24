package com.belajar.colalin.homeView.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelData implements Parcelable {
    private String id;
    private String location;
    private String data;
    private String jenis_jalan;
    private Kendaraan kendaraan;
    private int imageResource;


    public ModelData(String id, String location, String data, String jenis_jalan, Kendaraan kendaraan, int imageResource) {
        this.id = id;
        this.location = location;
        this.data = data;
        this.jenis_jalan = jenis_jalan;
        this.kendaraan = kendaraan;
        this.imageResource = imageResource;
    }

    protected ModelData(Parcel in) {
        id = in.readString();
        location = in.readString();
        data = in.readString();
        jenis_jalan = in.readString();
        imageResource = in.readInt();
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

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getJenis_jalan() {
        return jenis_jalan;
    }

    public void setJenis_jalan(String jenis_jalan) {
        this.jenis_jalan = jenis_jalan;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.data);
        parcel.writeString(this.jenis_jalan);
        parcel.writeString(this.location);
        parcel.writeInt(this.imageResource);
    }
}
