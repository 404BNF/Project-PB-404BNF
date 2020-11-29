package com.myaplication.goangkot404bnf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.myaplication.goangkot404bnf.Notification.AlarmActivity;
import com.myaplication.goangkot404bnf.model.AngkotModel;
import com.myaplication.goangkot404bnf.model.AngkotItem;
import com.myaplication.goangkot404bnf.rest.ApiConfig;
import com.myaplication.goangkot404bnf.rest.ApiService;
import com.myaplication.goangkot404bnf.DbCatat.CatatActivity;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_status:
                Intent inten = new Intent(MainActivity.this,
                        AlarmActivity.class);
                startActivity(inten);
                return true;
            case R.id.action_favorites:
                Intent inte = new Intent(MainActivity.this,
                        AboutActivity.class);
                startActivity(inte);
                return true;
            case R.id.action_catat:
                Intent inter = new Intent(MainActivity.this,
                        CatatActivity.class);
                startActivity(inter);
                return true;
            default:
                // Do nothing
        }

        return super.onOptionsItemSelected(item);
    }
}