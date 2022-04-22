package com.belajar.colalin.homeView.CardAdapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.belajar.colalin.databinding.ItemCounterBinding;
import com.belajar.colalin.homeView.Models.ModelData;

import java.util.ArrayList;

public class AdapterData extends RecyclerView.Adapter< AdapterData.HolderData > {
    private ArrayList< ModelData > modelData;

    public AdapterData(ArrayList< ModelData > modelData) {
        this.modelData = modelData;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderData(
                ItemCounterBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false
                ));
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        ModelData md = modelData.get(position);
        holder.itemCounterBinding.tvDate.setText(md.getData());
        holder.itemCounterBinding.tvLocation.setText(md.getLocation());
        holder.itemCounterBinding.tvJenisJalan.setText(md.getJenis_jalan());
    }

    @Override
    public int getItemCount() {
        return modelData.size();
    }

    public static class HolderData extends RecyclerView.ViewHolder {
        private ItemCounterBinding itemCounterBinding;

        public HolderData(@NonNull ItemCounterBinding itemCounterBinding) {
            super(itemCounterBinding.getRoot());
            this.itemCounterBinding = itemCounterBinding;
        }
    }
}