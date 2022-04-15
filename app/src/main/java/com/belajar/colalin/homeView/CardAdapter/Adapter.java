package com.belajar.colalin.homeView.CardAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.belajar.colalin.databinding.CardMenuBinding;
import com.belajar.colalin.homeView.Models.ListMenu;
import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Adapter.ListMenuHolder> {
    private ArrayList< ListMenu > data;
    private Context context;



    public Adapter(ArrayList< ListMenu > data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ListMenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListMenuHolder(CardMenuBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ListMenuHolder holder, int position) {
        ListMenu listMenu = data.get(position);
        holder.binding.titleMenu.setText(listMenu.getTitle());
        holder.binding.deskriptionMenu.setText(listMenu.getDesc());
        Glide.with(context).load(listMenu.getImage()).into(holder.binding.imageMenu);
        holder.binding.imageMenu.setOnClickListener(new OnItemClick(position, new OnItemClick.OnItemCallBack() {
            @Override
            public void OnItemClicked(View view, int position) {
                Toast.makeText(context,data.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ListMenuHolder extends RecyclerView.ViewHolder{
        private final CardMenuBinding binding;
        public ListMenuHolder(@NonNull CardMenuBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

