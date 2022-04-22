package com.belajar.colalin.homeView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.belajar.colalin.R;
import com.belajar.colalin.databinding.ActivityHomeBinding;
import com.belajar.colalin.homeView.CardAdapter.ListData;
import com.belajar.colalin.homeView.Models.ListMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private  ArrayList<ListMenu> data ;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.belajar.colalin.databinding.ActivityHomeBinding binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bundle = getIntent().getExtras();
        BottomNavigationView bottomNavigationView = binding.bottomNavigation;
        bottomNavigationView.setOnItemSelectedListener(navListener);
        ListData.addData();
        data = ListData.getData();
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_home_container, new HomeFragment(data)).commit();
        }
    }
    NavigationBarView.OnItemSelectedListener navListener = new NavigationBarView.OnItemSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()){
                case R.id.nav_data:
                    fragment = new DataFragment();
                    break;
                case R.id.nav_profile:
                    fragment = new ProfileFragment();
                    break;
                case R.id.nav_home:
                    fragment = new HomeFragment(data);
                    break;
            }
            assert fragment != null;
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_home_container, fragment).commit();
            return true;
        }
    };

    @Override
    public void onBackPressed() {
        data.clear();
        super.onBackPressed();
    }
}