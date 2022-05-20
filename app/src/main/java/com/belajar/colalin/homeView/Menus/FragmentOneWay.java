package com.belajar.colalin.homeView.Menus;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
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
import com.belajar.colalin.databinding.FragmentOneWayBinding;
import com.belajar.colalin.homeView.viewModel.ViewModelOneWay;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FragmentOneWay extends Fragment implements View.OnClickListener {
    private FragmentOneWayBinding binding;
    private ViewModelOneWay counter;

    public FragmentOneWay() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOneWayBinding.inflate(inflater, container, false);
        counter = new ViewModelProvider(requireActivity()).get(ViewModelOneWay.class);
        bindingTvViewModel();
        bindingButtonClick();
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
                    if (counter.getGol_1() == 0 && counter.getGol_2() == 0 && counter.getGol_3() == 0
                            && counter.getGol_4() == 0 && counter.getGol_5a() == 0 && counter.getGol_5b() == 0
                            && counter.getGol_6a() == 0 && counter.getGol_6b() == 0 && counter.getGol_7a() == 0
                            && counter.getGol_7b() == 0 && counter.getGol_7c() == 0 && counter.getGol_8() == 0) {
                        Toast.makeText(getContext(),
                                "Tidak dapat menyimpan data yang kosong", Toast.LENGTH_LONG).show();
                    } else {
                        counter.setEnd(DateTimeFormatter.ofPattern("HH:mm").format(LocalDateTime.now()));
                        new AlertDialog.Builder(getContext())
                                .setTitle("Lokasi")
                                .setMessage("Masukkan lokasi anda saat ini !")
                                .setPositiveButton("Yes", (dialogInterface, i) -> {
                                    assert getArguments() != null;
                                    counter.saveData(lokasi.getText().toString().trim(),
                                            Integer.parseInt(getArguments().getString("id")),
                                            getActivity());
                                }).setNegativeButton("No", (dialogInterface, i) ->
                                        dialogInterface.cancel()).setView(lokasi)
                                .setOnDismissListener(dialogInterface ->
                                        ((ViewGroup) lokasi.getParent()).removeView(lokasi)).show();
                    }
                    return true;
                case R.id.nav_clear:
                    counter.resetValue();
                    bindingTvViewModel();
                    return true;
            }
            return false;
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.golongan_satu:
                counter.addGol_1();
                binding.tvGol1.setText(String.valueOf(counter.getGol_1()));
                break;
            case R.id.golongan_dua:
                counter.addGol_2();
                binding.tvGol2.setText(String.valueOf(counter.getGol_2()));
                break;
            case R.id.golongan_tiga:
                counter.addGol_3();
                binding.tvGol3.setText(String.valueOf(counter.getGol_3()));
                break;
            case R.id.golongan_empat:
                counter.addGol_4();
                binding.tvGol4.setText(String.valueOf(counter.getGol_4()));
                break;
            case R.id.golongan_5a:
                counter.addGol_5a();
                binding.tvGol5A.setText(String.valueOf(counter.getGol_5a()));
                break;
            case R.id.golongan_5b:
                counter.addGol_5b();
                binding.tvGol5B.setText(String.valueOf(counter.getGol_5b()));
                break;
            case R.id.golongan_6A:
                counter.addGol_6a();
                binding.tvGol6A.setText(String.valueOf(counter.getGol_6a()));
                break;
            case R.id.golongan_6B:
                counter.addGol_6b();
                binding.tvGol6B.setText(String.valueOf(counter.getGol_6b()));
                break;
            case R.id.golongan_7A:
                counter.addGol_7a();
                binding.tvGol7A.setText(String.valueOf(counter.getGol_7a()));
                break;
            case R.id.golongan_7B:
                counter.addGol_7b();
                binding.tvGol7B.setText(String.valueOf(counter.getGol_7b()));
                break;
            case R.id.golongan_7C:
                counter.addGol_7c();
                binding.tvGol7C.setText(String.valueOf(counter.getGol_7c()));
                break;
            case R.id.golongan_8:
                counter.addGol_8();
                binding.tvGol8.setText(String.valueOf(counter.getGol_8()));
                break;
        }
    }

    public void bindingTvViewModel() {
        binding.tvGol1.setText(String.valueOf(counter.getGol_1()));
        binding.tvGol2.setText(String.valueOf(counter.getGol_2()));
        binding.tvGol3.setText(String.valueOf(counter.getGol_3()));
        binding.tvGol4.setText(String.valueOf(counter.getGol_4()));
        binding.tvGol5A.setText(String.valueOf(counter.getGol_5a()));
        binding.tvGol5B.setText(String.valueOf(counter.getGol_5b()));
        binding.tvGol6A.setText(String.valueOf(counter.getGol_6a()));
        binding.tvGol6B.setText(String.valueOf(counter.getGol_6b()));
        binding.tvGol7A.setText(String.valueOf(counter.getGol_7a()));
        binding.tvGol7B.setText(String.valueOf(counter.getGol_7b()));
        binding.tvGol7C.setText(String.valueOf(counter.getGol_7c()));
        binding.tvGol8.setText(String.valueOf(counter.getGol_8()));
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

}