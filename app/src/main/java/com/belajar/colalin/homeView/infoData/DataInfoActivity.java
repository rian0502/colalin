package com.belajar.colalin.homeView.infoData;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.belajar.colalin.R;
import com.belajar.colalin.databinding.ActivityDataInfoBinding;

public class DataInfoActivity extends AppCompatActivity {
    private Bundle bundle;
    ActivityDataInfoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bundle = getIntent().getExtras();
        changeFragmentInfoData();
    }

    private void changeFragmentInfoData() {
        Fragment fragment = null;
        if (bundle.getString("jenis").equals("One Way")){
            fragment = new FragmentDataOne();
            fragment.setArguments(bundle);
        }else if (bundle.get("jenis").equals("Two Way")){
            fragment = new FragmentDataTwo();
            fragment.setArguments(bundle);
        }else if (bundle.getString("jenis").equals("Toll Road")){
            fragment = new FragmentDataToll();
            fragment.setArguments(bundle);
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_data_counter, fragment).commit();
    }
}