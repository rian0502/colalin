package com.belajar.colalin.accountView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.belajar.colalin.R;
import com.belajar.colalin.databinding.ActivityAccountBinding;


public class AccountActivity extends AppCompatActivity {
    private ActivityAccountBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}