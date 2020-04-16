package com.example.drugbank.models;

import com.google.gson.annotations.SerializedName;

public class ItemSlider {
    @SerializedName("_id")
    private String id;
    @SerializedName("nguoidang")
    private String nguoidang;
    @SerializedName("tentin")
    private String tentin;
    @SerializedName("noidung")
    private String noidung;
    @SerializedName("ngaydang")
    private String ngaydang;
    @SerializedName("hinhanh")
    private String hinhanh;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNguoidang() {
        return nguoidang;
    }

    public void setNguoidang(String nguoidang) {
        this.nguoidang = nguoidang;
    }

    public String getTentin() {
        return tentin;
    }

    public void setTentin(String tentin) {
        this.tentin = tentin;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getNgaydang() {
        return ngaydang;
    }

    public void setNgaydang(String ngaydang) {
        this.ngaydang = ngaydang;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}
