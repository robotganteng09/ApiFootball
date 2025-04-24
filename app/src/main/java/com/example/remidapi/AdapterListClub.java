package com.example.remidapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterListClub extends RecyclerView.Adapter<AdapterListClub.ViewHolder> {

    private final List<ModalClub> listClub;
    private final OnItemClickListener listener;

    // Interface klik item
    public interface OnItemClickListener {
        void onItemClick(ModalClub clubModel);
    }

    // Konstruktor
    public AdapterListClub(List<ModalClub> listClub, OnItemClickListener listener) {
        this.listClub = listClub;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Menginflate layout item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModalClub club = listClub.get(position);
        holder.tvNamaClub.setText(club.getNamaClub());
        holder.tvStadion.setText(club.getNamaStadium());

        // Menggunakan Glide untuk menampilkan gambar
        Glide.with(holder.itemView.getContext())
                .load(club.getImgUrl())
                .into(holder.imgClub);

        // Menangani klik item
        holder.itemView.setOnClickListener(v -> listener.onItemClick(club));
    }

    @Override
    public int getItemCount() {
        return listClub == null ? 0 : listClub.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaClub;
        TextView tvStadion;
        ImageView imgClub;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNamaClub = itemView.findViewById(R.id.tvNamaClub);
            tvStadion = itemView.findViewById(R.id.tvDeskripsiClub);
            imgClub = itemView.findViewById(R.id.imgClub);
        }
    }
}
