package com.myaplication.goangkot404bnf.model;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class AngkotModel {


    @SerializedName("rute_angkot")
    private ArrayList<AngkotItem> hasil;


    public void setHasil(ArrayList<AngkotItem> hasil){
        this.hasil = hasil;
    }

    public ArrayList<AngkotItem> getHasil(){
        return hasil;
    }

}