package com.belajar.colalin.homeView;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.belajar.colalin.databinding.FragmentHomeBinding;
import com.belajar.colalin.homeView.CardAdapter.Adapter;
import com.belajar.colalin.homeView.Models.ListMenu;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private final ArrayList< ListMenu > menus;

    public HomeFragment(ArrayList< ListMenu > menus) {
        this.menus = menus;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        com.belajar.colalin.databinding.FragmentHomeBinding binding = FragmentHomeBinding.inflate(inflater, container, false);
        if (menus.size() >= 4){
            menus.remove(5);
            menus.remove(4);
            menus.remove(3);
        }
        Adapter adapter = new Adapter(menus, getContext());
        binding.containerViewHome.setHasFixedSize(true);
        binding.containerViewHome.setAdapter(adapter);
        binding.containerViewHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}