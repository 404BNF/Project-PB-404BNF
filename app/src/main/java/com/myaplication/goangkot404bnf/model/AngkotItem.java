package com.myaplication.goangkot404bnf.model;

import com.google.gson.annotations.SerializedName;

public class AngkotItem {

    @SerializedName("lintasan")
    private String lintasanAngkot;

    @SerializedName("trayek")
    private String trayekAngkot;

    @SerializedName("nomor_angkot")
    private String nomorAngkot;

    @SerializedName("gambar_url")
    private String gambarAngkot;

    @SerializedName("id")
    private Integer id;


    public void setLintasanAngkot(String lintasanAngkot){
        this.lintasanAngkot = lintasanAngkot;
    }

    public String getLintasanAngkot(){
        return lintasanAngkot;
    }


    public void setTrayekAngkot(String trayekAngkot){
        this.trayekAngkot = trayekAngkot;
    }

    public String getTrayekAngkot(){
        return trayekAngkot;
    }

    public void setNomorAngkot(String nomorAngkot){
        this.nomorAngkot = nomorAngkot;
    }

    public String getNomorAngkot(){
        return nomorAngkot;
    }

    public void setGambarAngkot(String gambarAngkot){
        this.gambarAngkot = gambarAngkot;
    }

    public String getGambarAngkot(){
        return gambarAngkot;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }
    
}