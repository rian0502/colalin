package com.belajar.colalin.homeView.profileMenu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.belajar.colalin.R;
import com.belajar.colalin.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.belajar.colalin.databinding.ActivityProfileBinding binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle = getIntent().getExtras();
        changeProfilePage(bundle.getInt("menu"));
    }

    private void changeProfilePage(int menu) {
        Fragment fragment = null;
        switch (menu) {
            case 0:
                fragment = new FragmentInfo();
                break;
            case 1:
                fragment = new AboutFragment();
                break;
        }
        assert fragment != null;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_profile, fragment)
                .commit();
    }

}