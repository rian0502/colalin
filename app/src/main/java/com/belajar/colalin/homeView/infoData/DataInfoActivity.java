package com.belajar.colalin.homeView.infoData;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.belajar.colalin.R;
import com.belajar.colalin.databinding.ActivityDataInfoBinding;
import com.belajar.colalin.homeView.Models.Kendaraan;
import com.belajar.colalin.homeView.Models.ModelData;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class DataInfoActivity extends AppCompatActivity {
    private ActivityDataInfoBinding binding;
    private Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ModelData modelData = getIntent().getParcelableExtra("data");
        binding.imageJalan.setImageResource(modelData.getImageResource());
        binding.jenisJalan.setText(modelData.getJenis_jalan());
        binding.lokasiPerhitungan.setText(modelData.getLocation());
        binding.waktuPerhitungan.setText(modelData.getData());
        getSupportFragmentManager().beginTransaction().replace(R.id.pie_container, new FragmentPie()).commit();
    }
}