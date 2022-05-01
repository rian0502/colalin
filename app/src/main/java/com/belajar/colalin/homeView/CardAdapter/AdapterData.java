package com.belajar.colalin.homeView.CardAdapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.belajar.colalin.databinding.ItemCounterBinding;
import com.belajar.colalin.homeView.Models.ModelData;
import com.belajar.colalin.homeView.infoData.DataInfoActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterData extends RecyclerView.Adapter< AdapterData.HolderData > {
    private Context context;
    private ArrayList<ModelData> modelData = new ArrayList<>();
    public AdapterData(Context context) {
        this.context = context;
    }
    public void updateData(ArrayList<ModelData> modelData){
        this.modelData.clear();
        this.modelData = modelData;
        notifyDataSetChanged();
    }

    public ArrayList< ModelData > getModelData() {
        return modelData;
    }

    public void setModelData(ArrayList< ModelData > modelData) {
        this.modelData = modelData;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
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
        Glide.with(context)
                .load(md.getImageResource())
                .into(holder.itemCounterBinding.gambarJalan);
        holder.itemCounterBinding.arrowEnter.setOnClickListener(new OnItemClick(position,((view, position1) -> {
            Intent intent = new Intent(context, DataInfoActivity.class);
            intent.putExtra("data", md);
            intent.putExtra("kendaraan", md.getKendaraan());
            context.startActivity(intent);
        })));
    }

    @Override
    public int getItemCount() {
        return modelData.size();
    }

    public static class HolderData extends RecyclerView.ViewHolder {
        private final ItemCounterBinding itemCounterBinding;

        public HolderData(@NonNull ItemCounterBinding itemCounterBinding) {
            super(itemCounterBinding.getRoot());
            this.itemCounterBinding = itemCounterBinding;
        }
    }
}
