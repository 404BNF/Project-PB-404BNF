package com.myaplication.goangkot404bnf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.myaplication.goangkot404bnf.model.AngkotModel;
import com.myaplication.goangkot404bnf.model.AngkotItem;
import com.myaplication.goangkot404bnf.rest.ApiConfig;
import com.myaplication.goangkot404bnf.rest.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<AngkotItem> angkotItems;
    private AngkotAdapter angkotAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_angkot);

        initView();
        getData();
    }

    private void getData() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getData()
                .enqueue(new Callback<AngkotModel>() {
                    @Override
                    public void onResponse(Call<AngkotModel> call, Response<AngkotModel> response) {
                        if(response.isSuccessful()){
                            angkotItems = (ArrayList<AngkotItem>) response.body().getHasil();
                            angkotAdapter = new AngkotAdapter(angkotItems, getApplicationContext());
                            angkotAdapter.notifyDataSetChanged();
                            rv.setAdapter(angkotAdapter);
                            rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        }
                    }

                    @Override
                    public void onFailure(Call<AngkotModel> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initView() {
        rv = findViewById(R.id.rv);
    }

    }

