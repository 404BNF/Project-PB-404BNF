package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.myapplication.model.MainDataModel;
import com.example.myapplication.model.MainModel;
import com.example.myapplication.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private MainAdapter mainAdapter;
    private List<MainModel> mainModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mainModels = new ArrayList<>();
        mainAdapter = new MainAdapter(this,mainModels);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(mainAdapter);

        setData();

    }
    private void setData() {
        List<MainModel> dummyData = MainDataModel.gamesList();
        mainAdapter.updateData(dummyData);
    }
    private void initView() {
        rv = findViewById(R.id.recyclerview);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}