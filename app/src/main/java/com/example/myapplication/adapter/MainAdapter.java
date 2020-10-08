package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DetailActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.MainDataModel;
import com.example.myapplication.model.MainModel;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private Context context;
    private List<MainModel> mainModel = new ArrayList<>();

    public MainAdapter(Context context, List<MainModel> mainModel) {
        this.context = context;
        this.mainModel = mainModel;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_angkot, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        MainModel mainModels = mainModel.get(position);
        holder.namaAngkot.setText(mainModels.getName());
        holder.rute.setText(String.valueOf(mainModels.getRute()));
        holder.angkot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("nama_angkot", holder.namaAngkot.getText().toString().trim());
                intent.putExtra("rute", holder.rute.getText().toString().trim());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mainModel.size();
    }

    public void updateData(List<MainModel> angkotList) {
        this.mainModel = angkotList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView namaAngkot;
        private TextView rute;
        private CardView angkot;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaAngkot = itemView.findViewById(R.id.tv_nama_angkot);
            rute = itemView.findViewById(R.id.tv_rute);
            angkot = itemView.findViewById(R.id.angkot);
        }
    }
}
