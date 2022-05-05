package com.belajar.colalin.homeView.Menus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import com.belajar.colalin.R;
import com.belajar.colalin.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMenuBinding binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bundle = getIntent().getExtras();
        changeFragment(bundle.getInt("pilihan"));
    }

    private void changeFragment(int pilihan) {
        Fragment fragment = null;
        switch (pilihan){
            case 0:
                fragment = new FragmentJalanTol();
                break;
            case 1:
                fragment = new FragmentTwoWay();
                break;
            case 2:
                fragment = new FragmentOneWay();
                break;
        }
        assert fragment != null;
        fragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_menu_counter, fragment).commit();
    }


}