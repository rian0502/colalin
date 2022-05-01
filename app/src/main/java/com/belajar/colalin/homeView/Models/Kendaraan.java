package com.belajar.colalin.homeView.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kendaraan implements Parcelable {

    @SerializedName("gol_1")
    @Expose
    private String gol1;
    @SerializedName("gol_2")
    @Expose
    private String gol2;
    @SerializedName("gol_3")
    @Expose
    private String gol3;
    @SerializedName("gol_4")
    @Expose
    private String gol4;
    @SerializedName("gol_5a")
    @Expose
    private String gol5a;
    @SerializedName("gol_5b")
    @Expose
    private String gol5b;
    @SerializedName("gol_6a")
    @Expose
    private String gol6a;
    @SerializedName("gol_6b")
    @Expose
    private String gol6b;
    @SerializedName("gol_7a")
    @Expose
    private String gol7a;
    @SerializedName("gol_7b")
    @Expose
    private String gol7b;
    @SerializedName("gol_7c")
    @Expose
    private String gol7c;
    @SerializedName("gol_8")
    @Expose
    private String gol8;

    protected Kendaraan(Parcel in) {
        gol1 = in.readString();
        gol2 = in.readString();
        gol3 = in.readString();
        gol4 = in.readString();
        gol5a = in.readString();
        gol5b = in.readString();
        gol6a = in.readString();
        gol6b = in.readString();
        gol7a = in.readString();
        gol7b = in.readString();
        gol7c = in.readString();
        gol8 = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(gol1);
        dest.writeString(gol2);
        dest.writeString(gol3);
        dest.writeString(gol4);
        dest.writeString(gol5a);
        dest.writeString(gol5b);
        dest.writeString(gol6a);
        dest.writeString(gol6b);
        dest.writeString(gol7a);
        dest.writeString(gol7b);
        dest.writeString(gol7c);
        dest.writeString(gol8);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator< Kendaraan > CREATOR = new Creator< Kendaraan >() {
        @Override
        public Kendaraan createFromParcel(Parcel in) {
            return new Kendaraan(in);
        }

        @Override
        public Kendaraan[] newArray(int size) {
            return new Kendaraan[size];
        }
    };

    public String getGol1() {
        return gol1;
    }

    public void setGol1(String gol1) {
        this.gol1 = gol1;
    }

    public String getGol2() {
        return gol2;
    }

    public void setGol2(String gol2) {
        this.gol2 = gol2;
    }

    public String getGol3() {
        return gol3;
    }

    public void setGol3(String gol3) {
        this.gol3 = gol3;
    }

    public String getGol4() {
        return gol4;
    }

    public void setGol4(String gol4) {
        this.gol4 = gol4;
    }

    public String getGol5a() {
        return gol5a;
    }

    public void setGol5a(String gol5a) {
        this.gol5a = gol5a;
    }

    public String getGol5b() {
        return gol5b;
    }

    public void setGol5b(String gol5b) {
        this.gol5b = gol5b;
    }

    public String getGol6a() {
        return gol6a;
    }

    public void setGol6a(String gol6a) {
        this.gol6a = gol6a;
    }

    public String getGol6b() {
        return gol6b;
    }

    public void setGol6b(String gol6b) {
        this.gol6b = gol6b;
    }

    public String getGol7a() {
        return gol7a;
    }

    public void setGol7a(String gol7a) {
        this.gol7a = gol7a;
    }

    public String getGol7b() {
        return gol7b;
    }

    public void setGol7b(String gol7b) {
        this.gol7b = gol7b;
    }

    public String getGol7c() {
        return gol7c;
    }

    public void setGol7c(String gol7c) {
        this.gol7c = gol7c;
    }

    public String getGol8() {
        return gol8;
    }

    public void setGol8(String gol8) {
        this.gol8 = gol8;
    }

}
