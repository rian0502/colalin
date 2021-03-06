package com.belajar.colalin.homeView.CardAdapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.belajar.colalin.homeView.Models.ListCounter;
import com.belajar.colalin.databinding.ItemCounterBinding;
import com.belajar.colalin.homeView.infoData.DataInfoActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterData extends RecyclerView.Adapter< AdapterData.HolderData > {
    private Context context;
    private ArrayList< ListCounter > modelData = new ArrayList<>();
    private String id_akun;
    public AdapterData(Context context, String id_akun) {
        this.context = context;
        this.id_akun = id_akun;
    }
    public void updateData(ArrayList<ListCounter> modelData){
        this.modelData.clear();
        this.modelData = modelData;
        notifyDataSetChanged();
    }

    public ArrayList< ListCounter > getModelData() {
        return modelData;
    }

    public void setModelData(ArrayList< ListCounter > modelData) {
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
        ListCounter md = modelData.get(position);
        holder.itemCounterBinding.tvDate.setText(md.getTanggal());
        holder.itemCounterBinding.tvLocation.setText(md.getLokasi());
        holder.itemCounterBinding.tvJenisJalan.setText(md.getTypeJalan());
        Glide.with(context)
                .load(md.getImageResource())
                .into(holder.itemCounterBinding.gambarJalan);
        holder.itemCounterBinding.arrowEnter.setOnClickListener(new OnItemClick(position, ((view, position1) -> {
            Intent intent = new Intent(context, DataInfoActivity.class);
            if (md.getTypeJalan().equals("One Way")){
                intent.putExtra("jenis", md.getTypeJalan());
            }else if (md.getTypeJalan().equals("Two Way")){
                intent.putExtra("jenis", md.getTypeJalan());
            }else if (md.getTypeJalan().equals("Toll Road")){
                intent.putExtra("jenis", md.getTypeJalan());
            }
            intent.putExtra("id",md.getId_counter());
            intent.putExtra("id_akun", id_akun);
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
