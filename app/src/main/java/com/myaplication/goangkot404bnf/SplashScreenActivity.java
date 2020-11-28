package com.myaplication.goangkot404bnf;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        new Handler().postDelayed(new Runnable() {

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void run() {
                finishAffinity();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        }, 4000);
    }
}