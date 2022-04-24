package com.belajar.colalin.homeView.Menus;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.belajar.colalin.R;
import com.belajar.colalin.databinding.FragmentOneWayBinding;

public class FragmentOneWay extends Fragment implements View.OnClickListener {
    private FragmentOneWayBinding binding;
    private int gol1, gol2, gol3, gol4, gol5a, gol5b, gol6a, gol6b, gol7a, gol7b, gol7c, gol8;

    public FragmentOneWay() {
        // Required empty public constructor
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
        binding = FragmentOneWayBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindingButtonClick();
    }

    public void bindingButtonClick() {
        binding.golonganSatu.setOnClickListener(this);
        binding.golonganDua.setOnClickListener(this);
        binding.golonganTiga.setOnClickListener(this);
        binding.golonganEmpat.setOnClickListener(this);
        binding.golongan5a.setOnClickListener(this);
        binding.golongan5b.setOnClickListener(this);
        binding.golongan6A.setOnClickListener(this);
        binding.golongan6B.setOnClickListener(this);
        binding.golongan7A.setOnClickListener(this);
        binding.golongan7B.setOnClickListener(this);
        binding.golongan7C.setOnClickListener(this);
        binding.golongan8.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.golongan_satu:
                gol1++;
                binding.tvGol1.setText(String.valueOf(gol1));
                break;
            case R.id.golongan_dua:
                gol2++;
                binding.tvGol2.setText(String.valueOf(gol2));
                break;
            case R.id.golongan_tiga:
                gol3++;
                binding.tvGol3.setText(String.valueOf(gol3));
                break;
            case R.id.golongan_empat:
                gol4++;
                binding.tvGol4.setText(String.valueOf(gol4));
                break;
            case R.id.golongan_5a:
                gol5a++;
                binding.tvGol5A.setText(String.valueOf(gol5a));
                break;
            case R.id.golongan_5b:
                gol5b++;
                binding.tvGol5B.setText(String.valueOf(gol5b));
                break;
            case R.id.golongan_6A:
                gol6a++;
                binding.tvGol6A.setText(String.valueOf(gol6a));
                break;
            case R.id.golongan_6B:
                gol6b++;
                binding.tvGol6B.setText(String.valueOf(gol6b));
                break;
            case R.id.golongan_7A:
                gol7a++;
                binding.tvGol7A.setText(String.valueOf(gol7a));
                break;
            case R.id.golongan_7B:
                gol7b++;
                binding.tvGol7B.setText(String.valueOf(gol7b));
                break;
            case R.id.golongan_7C:
                gol7c++;
                binding.tvGol7C.setText(String.valueOf(gol7c));
                break;
            case R.id.golongan_8:
                gol8++;
                binding.tvGol8.setText(String.valueOf(gol8));
                break;
        }
    }

}