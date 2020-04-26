package com.example.drugbank.models;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.stream.Stream;


public class Pill {
//
//    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
//        @SuppressLint("SyntheticAccessor")
//        public Pill createFromParcel(Parcel input) {
//            return new Pill(input);
//        }
//        public Pill[] newArray(int size) {
//            return new Pill[size];
//        }
//    };

    @SerializedName("_id")
    private String id;
    @SerializedName("sodangky")
    private String sodangky;
    @SerializedName("tenthuoc")
    private String tenthuoc;
    @SerializedName("phanloai")
    private String phanloai;
    @SerializedName("tuoitho")
    private String tuoitho;
    @SerializedName("hoatchat")
    private String hoatchat;
    @SerializedName("dangbaoche")
    private String dangbaoche;
    @SerializedName("quycach")
    private String quycach;
    @SerializedName("ctysx")
    private String ctysx;
    @SerializedName("tieuchuan")
    private String tieuchuan;
    @SerializedName("ctydk")
    private String ctydk;
    @SerializedName("ngaykekhai")
    private String ngaykekhai;
    @SerializedName("donvi")
    private String donvi;
    @SerializedName("giakekhai")
    private String giakekhai;
    @SerializedName("dvt")
    private String dvt;
    @SerializedName("image")
    private String image;
    private String[] item;
    public Pill() {
    }
    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable String id) {
        this.id = id;
    }
    @Nullable
    public String getSodangky() {
        return sodangky;
    }

    public void setSodangky(@Nullable String sodangky) {
        this.sodangky = sodangky;
    }
    @Nullable
    public String getTenthuoc() {
        return tenthuoc;
    }

    public void setTenthuoc(@Nullable String tenthuoc) {
        this.tenthuoc = tenthuoc;
    }
    @Nullable
    public String getPhanloai() {
        return phanloai;
    }

    public void setPhanloai(@Nullable String phanloai) {
        this.phanloai = phanloai;
    }
    @Nullable
    public String getTuoitho() {
        return tuoitho;
    }

    public void setTuoitho(@Nullable String tuoitho) {
        this.tuoitho = tuoitho;
    }
    @Nullable
    public String getHoatchat() {
        return hoatchat;
    }

    public void setHoatchat(@Nullable String hoatchat) {
        this.hoatchat = hoatchat;
    }
    @Nullable
    public String getDangbaoche() {
        return dangbaoche;
    }

    public void setDangbaoche(@Nullable String dangbaoche) {
        this.dangbaoche = dangbaoche;
    }
    @Nullable
    public String getQuycach() {
        return quycach;
    }

    public void setQuycach(@Nullable String quycach) {
        this.quycach = quycach;
    }
    @Nullable
    public String getCtysx() {
        return ctysx;
    }

    public void setCtysx(@Nullable String ctysx) {
        this.ctysx = ctysx;
    }
    @Nullable
    public String getTieuchuan() {
        return tieuchuan;
    }

    public void setTieuchuan(@Nullable String tieuchuan) {
        this.tieuchuan = tieuchuan;
    }
    @Nullable
    public String getCtydk() {
        return ctydk;
    }

    public void setCtydk(@Nullable String ctydk) {
        this.ctydk = ctydk;
    }
    @Nullable
    public String getNgaykekhai() {
        return ngaykekhai;
    }
    @Nullable
    public void setNgaykekhai(@Nullable String ngaykekhai) {
        this.ngaykekhai = ngaykekhai;
    }

    @Nullable
    public String getDonvi() {
        return donvi;
    }
    public void setDonvi(@Nullable String donvi) {
        this.donvi = donvi;
    }

    @Nullable
    public String getGiakekhai() {
        return giakekhai;
    }

    public void setGiakekhai(@Nullable String giakekhai) {
        this.giakekhai = giakekhai;
    }

    @Nullable
    public String getDvt() {
        return dvt;
    }

    public void setDvt(@Nullable String dvt) {
        this.dvt = dvt;
    }

    @Nullable
    public String getImage() {
        return image;
    }

    public void setImage(@Nullable String image) {
        this.image = image;
    }

    public Pill getPillModel (String id, String sodangky, String tenthuoc, String phanloai,
                              String tuoitho, String hoatchat, String dangbaoche, String quycach,
                              String ctysx, String tieuchuan, String ctydk, String ngaykekhai,
                              String donvi, String giakekhai, String dvt, String image) {
                Pill pill = new Pill();
                pill.id = id;
                pill.sodangky = sodangky;
                pill.tenthuoc = tenthuoc;
                pill.phanloai = phanloai;
                pill.tuoitho = tuoitho;
                pill.hoatchat = hoatchat;
                pill.dangbaoche = dangbaoche;
                pill.quycach = quycach;
                pill.ctysx = ctysx;
                pill.tieuchuan = tieuchuan;
                pill.ctydk = ctydk;
                pill.ngaykekhai = ngaykekhai;
                pill.donvi = donvi;
                pill.giakekhai = giakekhai;
                pill.dvt = dvt;
                pill.image = image;
            return pill;
    }
//    private Pill (Parcel input) {
//        item = new String[]{id, sodangky, tenthuoc, phanloai, tuoitho, hoatchat,
//                dangbaoche, quycach, ctysx,tieuchuan, ctydk, ngaykekhai, donvi, giakekhai, dvt, image};
//        for(int i = 0; i< item.length; i++) {
//            item[i] = input.readString();
//        }
//    }
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(@Nullable Parcel input, int flags) {
//        item = new String[]{id, sodangky, tenthuoc, phanloai, tuoitho, hoatchat,
//                dangbaoche, quycach, ctysx,tieuchuan, ctydk, ngaykekhai, donvi, giakekhai, dvt, image};
//        for (String s : item) {
//            if (input != null) {
//                input.writeString(s);
//            }
//        }
//    }
}
