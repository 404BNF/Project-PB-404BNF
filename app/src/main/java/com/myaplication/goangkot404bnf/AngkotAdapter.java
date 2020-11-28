package com.myaplication.goangkot404bnf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.myaplication.goangkot404bnf.model.AngkotItem;

import java.util.ArrayList;

public class AngkotAdapter extends RecyclerView.Adapter<AngkotAdapter.ViewHolder> {

    private ArrayList<AngkotItem> angkotItems;
    private Context context;



    public AngkotAdapter(ArrayList<AngkotItem> angkotItems, Context context){
        this.angkotItems = angkotItems;
        this.context = context;
    }

    @NonNull
    @Override
    public AngkotAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AngkotAdapter.ViewHolder holder, final int position) {
        holder.tvTitle.setText("Trayek : " + angkotItems.get(position).getTrayekAngkot());

        Glide.with(context).load(angkotItems.get(position).getGambarAngkot()).error(R.drawable.ic_launcher_background)
                .override(512, 512)
                .into(holder.iv);

        holder.cvKlik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("trayek_angkot", angkotItems.get(position).getTrayekAngkot());
                intent.putExtra("nomor_angkot", angkotItems.get(position).getNomorAngkot());
                intent.putExtra("gambar_angkot", angkotItems.get(position).getGambarAngkot());
                intent.putExtra("lintasan_angkot", angkotItems.get(position).getLintasanAngkot());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return angkotItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tvTitle;

        private CardView cvKlik;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tvTitle = itemView.findViewById(R.id.tv_title);

            cvKlik = itemView.findViewById(R.id.cv_klik);
        }

    }
}