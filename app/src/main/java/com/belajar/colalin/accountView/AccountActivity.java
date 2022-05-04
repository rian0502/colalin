package com.belajar.colalin.accountView;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.belajar.colalin.databinding.ActivityAccountBinding;


public class AccountActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.belajar.colalin.databinding.ActivityAccountBinding binding = ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

}