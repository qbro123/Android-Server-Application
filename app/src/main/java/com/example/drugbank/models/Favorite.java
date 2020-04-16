package com.example.drugbank.models;


public class Favorite {
    private String id;
    private String sodangky;
    private String tenthuoc;
    private String phanloai;
    private String tuoitho;
    private String hoatchat;
    private String dangbaoche;
    private String quycach;
    private String ctysx;
    private String tieuchuan;
    private String ctydk;
    private String ngaykekhai;
    private String donvi;
    private String giakekhai;
    private String dvt;
    private String image;

    public Favorite(String sodangky, String tenthuoc, String phanloai, String tuoitho,
                    String hoatchat, String dangbaoche, String quycach, String ctysx,
                    String tieuchuan, String ctydk, String ngaykekhai, String donvi,
                    String giakekhai, String dvt, String image) {
        this.sodangky = sodangky;
        this.tenthuoc = tenthuoc;
        this.phanloai = phanloai;
        this.tuoitho = tuoitho;
        this.hoatchat = hoatchat;
        this.dangbaoche = dangbaoche;
        this.quycach = quycach;
        this.ctysx = ctysx;
        this.tieuchuan = tieuchuan;
        this.ctydk = ctydk;
        this.ngaykekhai = ngaykekhai;
        this.donvi = donvi;
        this.giakekhai = giakekhai;
        this.dvt = dvt;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSodangky() {
        return sodangky;
    }

    public void setSodangky(String sodangky) {
        this.sodangky = sodangky;
    }

    public String getTenthuoc() {
        return tenthuoc;
    }

    public void setTenthuoc(String tenthuoc) {
        this.tenthuoc = tenthuoc;
    }

    public String getPhanloai() {
        return phanloai;
    }

    public void setPhanloai(String phanloai) {
        this.phanloai = phanloai;
    }

    public String getTuoitho() {
        return tuoitho;
    }

    public void setTuoitho(String tuoitho) {
        this.tuoitho = tuoitho;
    }

    public String getHoatchat() {
        return hoatchat;
    }

    public void setHoatchat(String hoatchat) {
        this.hoatchat = hoatchat;
    }

    public String getDangbaoche() {
        return dangbaoche;
    }

    public void setDangbaoche(String dangbaoche) {
        this.dangbaoche = dangbaoche;
    }

    public String getQuycach() {
        return quycach;
    }

    public void setQuycach(String quycach) {
        this.quycach = quycach;
    }

    public String getCtysx() {
        return ctysx;
    }

    public void setCtysx(String ctysx) {
        this.ctysx = ctysx;
    }

    public String getTieuchuan() {
        return tieuchuan;
    }

    public void setTieuchuan(String tieuchuan) {
        this.tieuchuan = tieuchuan;
    }

    public String getCtydk() {
        return ctydk;
    }

    public void setCtydk(String ctydk) {
        this.ctydk = ctydk;
    }

    public String getNgaykekhai() {
        return ngaykekhai;
    }

    public void setNgaykekhai(String ngaykekhai) {
        this.ngaykekhai = ngaykekhai;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public String getGiakekhai() {
        return giakekhai;
    }

    public void setGiakekhai(String giakekhai) {
        this.giakekhai = giakekhai;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
