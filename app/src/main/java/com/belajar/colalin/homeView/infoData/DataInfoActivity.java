package com.belajar.colalin.homeView.infoData;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.belajar.colalin.databinding.ActivityDataInfoBinding;
import com.belajar.colalin.homeView.Models.Kendaraan;
import com.belajar.colalin.homeView.Models.ModelData;

public class DataInfoActivity extends AppCompatActivity {
    private ActivityDataInfoBinding binding;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ModelData modelData = getIntent().getParcelableExtra("data");
        Kendaraan kendaraan = getIntent().getParcelableExtra("kendaraan");
        if (kendaraan != null){
            Toast.makeText(this, ""+kendaraan.getGolongan1(), Toast.LENGTH_SHORT).show();
        }

    }
}