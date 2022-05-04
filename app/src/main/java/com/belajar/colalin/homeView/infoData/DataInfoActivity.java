package com.belajar.colalin.homeView.infoData;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.belajar.colalin.R;
import com.belajar.colalin.databinding.ActivityDataInfoBinding;
import com.belajar.colalin.homeView.Models.ModelData;

public class DataInfoActivity extends AppCompatActivity {
    private Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.belajar.colalin.databinding.ActivityDataInfoBinding binding = ActivityDataInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ModelData modelData = getIntent().getParcelableExtra("data");
        binding.imageJalan.setImageResource(modelData.getImageResource());
        binding.jenisJalan.setText(modelData.getJenisJalan());
        binding.lokasiPerhitungan.setText(modelData.getLokasi());
        binding.waktuPerhitungan.setText(modelData.getTanggal());
        binding.jamMulai.setText(modelData.getStart());
        binding.jamSelesai.setText(modelData.getEnd());
        binding.golongan1.setText(modelData.getKendaraan().getGol1());
        binding.golongan2.setText(modelData.getKendaraan().getGol2());
        binding.golongan3.setText(modelData.getKendaraan().getGol3());
        binding.golongan4.setText(modelData.getKendaraan().getGol4());
        binding.golongan5a.setText(modelData.getKendaraan().getGol5a());
        binding.golongan5b.setText(modelData.getKendaraan().getGol5b());
        binding.golongan6a.setText(modelData.getKendaraan().getGol6a());
        binding.golongan6b.setText(modelData.getKendaraan().getGol6b());
        binding.golongan7a.setText(modelData.getKendaraan().getGol7a());
        binding.golongan7b.setText(modelData.getKendaraan().getGol7b());
        binding.golongan7c.setText(modelData.getKendaraan().getGol7c());
        binding.golongan8.setText(modelData.getKendaraan().getGol8());
        getSupportFragmentManager().beginTransaction().replace(R.id.pie_container, new FragmentPie()).commit();
    }
}