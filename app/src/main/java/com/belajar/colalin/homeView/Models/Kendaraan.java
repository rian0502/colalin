package com.belajar.colalin.homeView.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Kendaraan implements Parcelable {

    private int golongan1;
    private int golongan2;
    private int golongan3;
    private int golongan4;
    private int golongan5A;
    private int golongan5B;
    private int golongan6A;
    private int golongan6B;
    private int golongan7A;
    private int golongan7B;
    private int golongan7C;
    private int golongan8;

    public Kendaraan(int golongan1, int golongan2, int golongan3, int golongan4, int golongan5A, int golongan5B, int golongan6A, int golongan6B, int golongan7A, int golongan7B, int golongan7C, int golongan8) {
        this.golongan1 = golongan1;
        this.golongan2 = golongan2;
        this.golongan3 = golongan3;
        this.golongan4 = golongan4;
        this.golongan5A = golongan5A;
        this.golongan5B = golongan5B;
        this.golongan6A = golongan6A;
        this.golongan6B = golongan6B;
        this.golongan7A = golongan7A;
        this.golongan7B = golongan7B;
        this.golongan7C = golongan7C;
        this.golongan8 = golongan8;
    }

    protected Kendaraan(Parcel in) {
        golongan1 = in.readInt();
        golongan2 = in.readInt();
        golongan3 = in.readInt();
        golongan4 = in.readInt();
        golongan5A = in.readInt();
        golongan5B = in.readInt();
        golongan6A = in.readInt();
        golongan6B = in.readInt();
        golongan7A = in.readInt();
        golongan7B = in.readInt();
        golongan7C = in.readInt();
        golongan8 = in.readInt();
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

    public int getGolongan1() {
        return golongan1;
    }

    public void setGolongan1(int golongan1) {
        this.golongan1 = golongan1;
    }

    public int getGolongan2() {
        return golongan2;
    }

    public void setGolongan2(int golongan2) {
        this.golongan2 = golongan2;
    }

    public int getGolongan3() {
        return golongan3;
    }

    public void setGolongan3(int golongan3) {
        this.golongan3 = golongan3;
    }

    public int getGolongan4() {
        return golongan4;
    }

    public void setGolongan4(int golongan4) {
        this.golongan4 = golongan4;
    }

    public int getGolongan5A() {
        return golongan5A;
    }

    public void setGolongan5A(int golongan5A) {
        this.golongan5A = golongan5A;
    }

    public int getGolongan5B() {
        return golongan5B;
    }

    public void setGolongan5B(int golongan5B) {
        this.golongan5B = golongan5B;
    }

    public int getGolongan6A() {
        return golongan6A;
    }

    public void setGolongan6A(int golongan6A) {
        this.golongan6A = golongan6A;
    }

    public int getGolongan6B() {
        return golongan6B;
    }

    public void setGolongan6B(int golongan6B) {
        this.golongan6B = golongan6B;
    }

    public int getGolongan7A() {
        return golongan7A;
    }

    public void setGolongan7A(int golongan7A) {
        this.golongan7A = golongan7A;
    }

    public int getGolongan7B() {
        return golongan7B;
    }

    public void setGolongan7B(int golongan7B) {
        this.golongan7B = golongan7B;
    }

    public int getGolongan7C() {
        return golongan7C;
    }

    public void setGolongan7C(int golongan7C) {
        this.golongan7C = golongan7C;
    }

    public int getGolongan8() {
        return golongan8;
    }

    public void setGolongan8(int golongan8) {
        this.golongan8 = golongan8;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(golongan1);
        parcel.writeInt(golongan2);
        parcel.writeInt(golongan3);
        parcel.writeInt(golongan4);
        parcel.writeInt(golongan5A);
        parcel.writeInt(golongan5B);
        parcel.writeInt(golongan6A);
        parcel.writeInt(golongan6B);
        parcel.writeInt(golongan7A);
        parcel.writeInt(golongan7B);
        parcel.writeInt(golongan7C);
        parcel.writeInt(golongan8);
    }
}
