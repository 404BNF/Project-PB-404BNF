package com.myaplication.goangkot404bnf;

import android.os.Bundle;

import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private ImageView ivDetail;

    private TextView tvNomor;
    private TextView tvLintasan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_angkot);
        initView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        getSupportActionBar().setTitle(getIntent().getStringExtra("trayek_angkot"));
        tvNomor.setText("No Angkot : " + getIntent().getStringExtra("nomor_angkot"));
        tvLintasan.setText("Lintasan : " + getIntent().getStringExtra( "lintasan_angkot"));


        Glide.with(getApplicationContext()).load(getIntent().getStringExtra("gambar_angkot")).error(R.drawable.ic_launcher_background)
                .override(512, 512)
                .into(ivDetail);



    }

    private void initView() {
        ivDetail = findViewById(R.id.iv_detail);

        tvNomor = findViewById(R.id.tv_nomor);
        tvLintasan = findViewById(R.id.tv_lintasan);
    }
}