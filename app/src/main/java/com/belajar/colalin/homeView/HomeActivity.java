package com.belajar.colalin.homeView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.belajar.colalin.R;
import com.belajar.colalin.databinding.ActivityHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView bottomNavigationView = binding.bottomNavigation;
        bottomNavigationView.setOnItemSelectedListener(navListener);
        if (savedInstanceState == null) {
            Fragment fragment = new HomeFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_home_container, fragment)
                    .commit();
        }
    }

    @SuppressLint("NonConstantResourceId")
    NavigationBarView.OnItemSelectedListener
            navListener = item -> {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_data:
                        fragment = new DataFragment();
                        break;
                    case R.id.nav_profile:
                        fragment = new ProfileFragment();
                        break;
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;
                }
                assert fragment != null;
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_home_container, fragment)
                        .commit();
                return true;
            };

}