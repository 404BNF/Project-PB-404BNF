package com.myaplication.goangkot404bnf.rest;

import com.myaplication.goangkot404bnf.model.AngkotModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("purwakarta/ruteangkot")  //end point
    Call<AngkotModel> getData();
}
