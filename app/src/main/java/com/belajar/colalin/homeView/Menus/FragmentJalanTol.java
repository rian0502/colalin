package com.belajar.colalin.homeView.Menus;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.belajar.colalin.R;
import com.belajar.colalin.databinding.FragmentJalanTolBinding;
import com.belajar.colalin.homeView.viewModel.ViewModelTollRoad;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FragmentJalanTol extends Fragment implements View.OnClickListener {
    private FragmentJalanTolBinding binding;
    private ViewModelTollRoad viewmodel;

    public FragmentJalanTol() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentJalanTolBinding.inflate(inflater, container, false);
        viewmodel = new ViewModelProvider(requireActivity()).get(ViewModelTollRoad.class);
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
                case R.id.nav_clear:
                    viewmodel.resetValue();
                    bindingTvViewModel();
                    return true;
                case R.id.nav_save:
                    viewmodel.setEnd(DateTimeFormatter.ofPattern("HH:mm").format(LocalDateTime.now()));
                    new AlertDialog.Builder(getContext())
                            .setTitle("Lokasi")
                            .setMessage("Masukkan lokasi anda saat ini !")
                            .setPositiveButton("Yes", (dialogInterface, i) -> {
                                assert getArguments() != null;
                                viewmodel.saveData(lokasi.getText().toString().trim(),
                                        Integer.parseInt(getArguments().getString("id")));
                            }).setNegativeButton("No", (dialogInterface, i) ->
                                    dialogInterface.cancel()).setView(lokasi)
                            .setOnDismissListener(dialogInterface ->
                                    ((ViewGroup)lokasi.getParent()).removeView(lokasi)).show();
                    return true;
            }
            return false;
        });

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

    public void bindingTvViewModel() {
        binding.tvGol2.setText(String.valueOf(viewmodel.getGol2()));
        binding.tvGol3.setText(String.valueOf(viewmodel.getGol3()));
        binding.tvGol4.setText(String.valueOf(viewmodel.getGol4()));
        binding.tvGol5A.setText(String.valueOf(viewmodel.getGol5a()));
        binding.tvGol5B.setText(String.valueOf(viewmodel.getGol5b()));
        binding.tvGol6A.setText(String.valueOf(viewmodel.getGol6a()));
        binding.tvGol6B.setText(String.valueOf(viewmodel.getGol6b()));
        binding.tvGol7A.setText(String.valueOf(viewmodel.getGol7a()));
        binding.tvGol7B.setText(String.valueOf(viewmodel.getGol7b()));
        binding.tvGol7C.setText(String.valueOf(viewmodel.getGol7c()));
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.golongan_dua:
                viewmodel.addGol2();
                binding.tvGol2.setText(String.valueOf(viewmodel.getGol2()));
                break;
            case R.id.golongan_tiga:
                viewmodel.addGol3();
                binding.tvGol3.setText(String.valueOf(viewmodel.getGol3()));
                break;
            case R.id.golongan_empat:
                viewmodel.addGol4();
                binding.tvGol4.setText(String.valueOf(viewmodel.getGol4()));
                break;
            case R.id.golongan_limaA:
                viewmodel.addGol5a();
                binding.tvGol5A.setText(String.valueOf(viewmodel.getGol5a()));
                break;
            case R.id.golongan_limaB:
                viewmodel.addGol5b();
                binding.tvGol5B.setText(String.valueOf(viewmodel.getGol5b()));
                break;
            case R.id.golongan_enamA:
                viewmodel.addGol6a();
                binding.tvGol6A.setText(String.valueOf(viewmodel.getGol6a()));
                break;
            case R.id.golongan_enamB:
                viewmodel.addGol6b();
                binding.tvGol6B.setText(String.valueOf(viewmodel.getGol6b()));
                break;
            case R.id.golongan_tujuhA:
                viewmodel.addGol7a();
                binding.tvGol7A.setText(String.valueOf(viewmodel.getGol7a()));
                break;
            case R.id.golongan_tujuhB:
                viewmodel.addGol7b();
                binding.tvGol7B.setText(String.valueOf(viewmodel.getGol7b()));
                break;
            case R.id.golongan_tujuhC:
                viewmodel.addGol7c();
                binding.tvGol7C.setText(String.valueOf(viewmodel.getGol7c()));
                break;
        }
    }
}