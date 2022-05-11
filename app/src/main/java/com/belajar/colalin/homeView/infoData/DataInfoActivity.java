package com.belajar.colalin.homeView.infoData;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.belajar.colalin.R;
import com.belajar.colalin.databinding.ActivityDataInfoBinding;
import com.belajar.colalin.homeView.Models.ModelData;

public class DataInfoActivity extends AppCompatActivity {
    private Bundle bundle;
    ActivityDataInfoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bundle = getIntent().getExtras();
        if (bundle.getString("jenis").equals("One Way")){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_data_counter, new FragmentDataOne()).commit();
        }else if (bundle.get("jenis").equals("Two Way")){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_data_counter, new FragmentDataTwo()).commit();
        }else if (bundle.getString("jenis").equals("Toll Road")){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_data_counter, new FragmentDataToll()).commit();
        }
    }
}