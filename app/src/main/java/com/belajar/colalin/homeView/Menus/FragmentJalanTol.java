package com.belajar.colalin.homeView.Menus;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.belajar.colalin.R;
import com.belajar.colalin.databinding.FragmentJalanTolBinding;


public class FragmentJalanTol extends Fragment implements View.OnClickListener {
    private int gol2, gol3, gol4, gol5a, gol5b, gol6a, gol6b, gol7a, gol7b, gol7c;
    private FragmentJalanTolBinding binding;

    public FragmentJalanTol() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentJalanTolBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindingButtonClick();
    }

    public void bindingButtonClick() {
        binding.golonganDua.setOnClickListener(this);
        binding.golonganTiga.setOnClickListener(this);
        binding.golonganEmpat.setOnClickListener(this);
        binding.golonganLimaA.setOnClickListener(this);
        binding.golonganLimaB.setOnClickListener(this);
        binding.golonganEnamA.setOnClickListener(this);
        binding.golonganEnamB.setOnClickListener(this);
        binding.golonganTujuhA.setOnClickListener(this);
        binding.golonganTujuhB.setOnClickListener(this);
        binding.golonganTujuhC.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
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
            case R.id.golongan_limaA:
                gol5a++;
                binding.tvGol5A.setText(String.valueOf(gol5a));
                break;
            case R.id.golongan_limaB:
                gol5b++;
                binding.tvGol5B.setText(String.valueOf(gol5b));
                break;
            case R.id.golongan_enamA:
                gol6a++;
                binding.tvGol6A.setText(String.valueOf(gol6a));
                break;
            case R.id.golongan_enamB:
                gol6b++;
                binding.tvGol6B.setText(String.valueOf(gol6b));
                break;
            case R.id.golongan_tujuhA:
                gol7a++;
                binding.tvGol7A.setText(String.valueOf(gol7a));
                break;
            case R.id.golongan_tujuhB:
                gol7b++;
                binding.tvGol7B.setText(String.valueOf(gol7b));
                break;
            case R.id.golongan_tujuhC:
                gol7c++;
                binding.tvGol7C.setText(String.valueOf(gol7c));
                break;
        }
    }
}