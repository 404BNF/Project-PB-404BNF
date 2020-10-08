package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class DetailActivity extends  AppCompatActivity{
    private TextView namaAngkot;
    private TextView rute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        initView();
        namaAngkot.setText(getIntent().getStringExtra("nama_angkot"));
        rute.setText(getIntent().getStringExtra("rute"));

    }

    private void initView() {
        namaAngkot = findViewById(R.id.tv_nama_angkot);
        rute = findViewById(R.id.tv_rute);
    }

}
