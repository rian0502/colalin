package com.belajar.colalin.homeView.Menus;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.belajar.colalin.R;
import com.belajar.colalin.databinding.FragmentTwoWayBinding;
import com.belajar.colalin.homeView.viewModel.ViewModelTwoWay;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FragmentTwoWay extends Fragment implements View.OnClickListener {
    private FragmentTwoWayBinding binding;
    private ViewModelTwoWay modelTwoWay;

    public FragmentTwoWay() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requireActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTwoWayBinding.inflate(inflater, container, false);
        modelTwoWay = new ViewModelProvider(this).get(ViewModelTwoWay.class);
        bindingTv();
        bindingButton();
        bindingTvMiror();
        bindingButtonMiror();
        return binding.getRoot();
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText lokasi = new EditText(getContext());
        binding.menubar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_save:
                    if (modelTwoWay.getGol_1() == 0 && modelTwoWay.getGol_2() == 0 && modelTwoWay.getGol_3() == 0
                            && modelTwoWay.getGol_4() == 0 && modelTwoWay.getGol_5a() == 0 && modelTwoWay.getGol_5b() == 0
                            && modelTwoWay.getGol_6a() == 0 && modelTwoWay.getGol_6b() == 0 && modelTwoWay.getGol_7a() == 0
                            && modelTwoWay.getGol_7b() == 0 && modelTwoWay.getGol_7c() == 0 && modelTwoWay.getGol_8() == 0 &&

                            modelTwoWay.getMgol_1() == 0 && modelTwoWay.getMgol_2() == 0 && modelTwoWay.getMgol_3() == 0
                            && modelTwoWay.getMgol_4() == 0 && modelTwoWay.getMgol_5a() == 0 && modelTwoWay.getMgol_5b() == 0
                            && modelTwoWay.getMgol_6a() == 0 && modelTwoWay.getMgol_6b() == 0 && modelTwoWay.getMol_7a() == 0
                            && modelTwoWay.getMgol_7b() == 0 && modelTwoWay.getMgol_7c() == 0 && modelTwoWay.getMgol_8() == 0) {
                        Toast.makeText(getContext(),
                                "Tidak dapat menyimpan data yang kosong", Toast.LENGTH_LONG).show();
                    } else {
                        modelTwoWay.setEnd(DateTimeFormatter.ofPattern("HH:mm").format(LocalDateTime.now()));
                        new AlertDialog.Builder(getContext())
                                .setTitle("Lokasi")
                                .setMessage("Masukkan lokasi anda saat ini !")
                                .setPositiveButton("Yes", (dialogInterface, i) -> {
                                    assert getArguments() != null;
                                    modelTwoWay.saveData(lokasi.getText().toString().trim(),
                                            Integer.parseInt(getArguments().getString("id")),
                                            getActivity());
                                }).setNegativeButton("No", (dialogInterface, i) ->
                                        dialogInterface.cancel()).setView(lokasi)
                                .setOnDismissListener(dialogInterface ->
                                        ((ViewGroup) lokasi.getParent()).removeView(lokasi)).show();
                    }
                    return true;
                case R.id.nav_clear:
                    modelTwoWay.clearData();
                    bindingTv();
                    bindingTvMiror();
                    return true;
            }
            return false;
        });
    }

    public void bindingTv() {
        binding.gol1.setText(String.valueOf(modelTwoWay.getGol_1()));
        binding.gol2.setText(String.valueOf(modelTwoWay.getGol_2()));
        binding.gol3.setText(String.valueOf(modelTwoWay.getGol_3()));
        binding.gol4.setText(String.valueOf(modelTwoWay.getGol_4()));
        binding.gol5A.setText(String.valueOf(modelTwoWay.getGol_5a()));
        binding.gol5B.setText(String.valueOf(modelTwoWay.getGol_5b()));
        binding.gol6A.setText(String.valueOf(modelTwoWay.getGol_6a()));
        binding.gol6B.setText(String.valueOf(modelTwoWay.getGol_6b()));
        binding.gol7A.setText(String.valueOf(modelTwoWay.getGol_7a()));
        binding.gol7B.setText(String.valueOf(modelTwoWay.getGol_7b()));
        binding.gol7C.setText(String.valueOf(modelTwoWay.getGol_7c()));
        binding.gol8.setText(String.valueOf(modelTwoWay.getGol_8()));
    }

    public void bindingTvMiror() {
        binding.mirorGol1.setText(String.valueOf(modelTwoWay.getMgol_1()));
        binding.mirorGol2.setText(String.valueOf(modelTwoWay.getMgol_2()));
        binding.mirorGol3.setText(String.valueOf(modelTwoWay.getMgol_3()));
        binding.mirorGol4.setText(String.valueOf(modelTwoWay.getMgol_4()));
        binding.mirorGol5a.setText(String.valueOf(modelTwoWay.getMgol_5a()));
        binding.miror5b.setText(String.valueOf(modelTwoWay.getMgol_5b()));
        binding.mirorGol6a.setText(String.valueOf(modelTwoWay.getMgol_6a()));
        binding.mirorGol6b.setText(String.valueOf(modelTwoWay.getMgol_6b()));
        binding.mirorGol7a.setText(String.valueOf(modelTwoWay.getMol_7a()));
        binding.mirorGol7b.setText(String.valueOf(modelTwoWay.getMgol_7b()));
        binding.mirorGol7c.setText(String.valueOf(modelTwoWay.getMgol_7c()));
        binding.mirorGol8.setText(String.valueOf(modelTwoWay.getMgol_8()));
    }

    public void bindingButton() {
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

    public void bindingButtonMiror() {
        binding.mirorBtnGol1.setOnClickListener(this);
        binding.mirorBtnGol2.setOnClickListener(this);
        binding.mirorBtnGol3.setOnClickListener(this);
        binding.mirorBtnGol4.setOnClickListener(this);
        binding.mirorBtnGol5a.setOnClickListener(this);
        binding.mirorBtnGol5b.setOnClickListener(this);
        binding.mirorBtnGol6a.setOnClickListener(this);
        binding.mirorBtnGol6b.setOnClickListener(this);
        binding.mirorBtnGol7a.setOnClickListener(this);
        binding.mirorBtnGol7b.setOnClickListener(this);
        binding.mirorBtnGol7c.setOnClickListener(this);
        binding.mirorBtnGo8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.golongan_satu) {
            modelTwoWay.setGol_1(modelTwoWay.getGol_1() + 1);
        } else if (view.getId() == R.id.golongan_dua) {
            modelTwoWay.setGol_2(modelTwoWay.getGol_2() + 1);
        } else if (view.getId() == R.id.golongan_tiga) {
            modelTwoWay.setGol_3(modelTwoWay.getGol_3() + 1);
        } else if (view.getId() == R.id.golongan_empat) {
            modelTwoWay.setGol_4(modelTwoWay.getGol_4() + 1);
        } else if (view.getId() == R.id.golongan_5a) {
            modelTwoWay.setGol_5a(modelTwoWay.getGol_5a() + 1);
        } else if (view.getId() == R.id.golongan_5b) {
            modelTwoWay.setGol_5b(modelTwoWay.getGol_5b() + 1);
        } else if (view.getId() == R.id.golongan_6A) {
            modelTwoWay.setGol_6a(modelTwoWay.getGol_6a() + 1);
        } else if (view.getId() == R.id.golongan_6B) {
            modelTwoWay.setGol_6b(modelTwoWay.getGol_6b() + 1);
        } else if (view.getId() == R.id.golongan_7A) {
            modelTwoWay.setGol_7a(modelTwoWay.getGol_7a() + 1);
        } else if (view.getId() == R.id.golongan_7B) {
            modelTwoWay.setGol_7b(modelTwoWay.getGol_7b() + 1);
        } else if (view.getId() == R.id.golongan_7C) {
            modelTwoWay.setGol_7c(modelTwoWay.getGol_7c() + 1);
        } else if (view.getId() == R.id.golongan_8) {
            modelTwoWay.setGol_8(modelTwoWay.getGol_8() + 1);
        } else if (view.getId() == R.id.miror_btn_gol1) {
            modelTwoWay.setMgol_1(modelTwoWay.getMgol_1() + 1);
        } else if (view.getId() == R.id.miror_btn_gol2) {
            modelTwoWay.setMgol_2(modelTwoWay.getMgol_2() + 1);
        } else if (view.getId() == R.id.miror_btn_gol3) {
            modelTwoWay.setMgol_3(modelTwoWay.getMgol_3() + 1);
        } else if (view.getId() == R.id.miror_btn_gol4) {
            modelTwoWay.setMgol_4(modelTwoWay.getMgol_4() + 1);
        } else if (view.getId() == R.id.miror_btn_gol5a) {
            modelTwoWay.setMgol_5a(modelTwoWay.getMgol_5a() + 1);
        } else if (view.getId() == R.id.miror_btn_gol5b) {
            modelTwoWay.setMgol_5b(modelTwoWay.getMgol_5b() + 1);
        } else if (view.getId() == R.id.miror_btn_gol6a) {
            modelTwoWay.setMgol_6a(modelTwoWay.getMgol_6a() + 1);
        } else if (view.getId() == R.id.miror_btn_gol6b) {
            modelTwoWay.setMgol_6b(modelTwoWay.getMgol_6b() + 1);
        } else if (view.getId() == R.id.miror_btn_gol7a) {
            modelTwoWay.setMol_7a(modelTwoWay.getMol_7a() + 1);
        } else if (view.getId() == R.id.miror_btn_gol7b) {
            modelTwoWay.setMgol_7b(modelTwoWay.getMgol_7b() + 1);
        } else if (view.getId() == R.id.miror_btn_gol7c) {
            modelTwoWay.setMgol_7c(modelTwoWay.getMgol_7c() + 1);
        } else if (view.getId() == R.id.miror_btn_go8) {
            modelTwoWay.setMgol_8(modelTwoWay.getMgol_8() + 1);
        }
        bindingTv();
        bindingTvMiror();
    }
}