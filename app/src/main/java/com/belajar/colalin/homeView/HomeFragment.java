package com.belajar.colalin.homeView;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.belajar.colalin.homeView.CardAdapter.ListData;
import com.belajar.colalin.homeView.Models.ListMenu;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private final ArrayList< ListMenu > menus;
    private SharedPreferences preferences;
    public HomeFragment() {
        ListData.getData().clear();
        ListData.addData();
        menus = ListData.getData();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = requireActivity().getSharedPreferences("session", Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentHomeBinding binding =
                FragmentHomeBinding.inflate(inflater, container, false);
        Adapter adapter = new Adapter(menus, getContext(), preferences.getString("ID",""));
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