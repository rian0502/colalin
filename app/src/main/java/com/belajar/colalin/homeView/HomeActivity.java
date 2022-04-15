package com.belajar.colalin.homeView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import com.belajar.colalin.databinding.ActivityHomeBinding;
import com.belajar.colalin.homeView.CardAdapter.Adapter;
import com.belajar.colalin.homeView.CardAdapter.ListData;
import com.belajar.colalin.homeView.Models.ListMenu;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private ArrayList< ListMenu > menus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ListData.addData();
        menus = ListData.getData();
        Adapter adapter = new Adapter(menus, this);
        binding.containerViewHome.setHasFixedSize(true);
        binding.containerViewHome.setAdapter(adapter);
        binding.containerViewHome.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
    }
}