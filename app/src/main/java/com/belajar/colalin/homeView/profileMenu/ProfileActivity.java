package com.belajar.colalin.homeView.profileMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.belajar.colalin.R;
import com.belajar.colalin.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {
    private ActivityProfileBinding binding;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bundle = getIntent().getExtras();
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
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_profile, fragment)
                .commit();
    }

}