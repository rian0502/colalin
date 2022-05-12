package com.belajar.colalin.homeView.infoData;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.belajar.colalin.databinding.FragmentDataOneBinding;
import com.belajar.colalin.homeView.viewModel.ViewModelDataOne;

public class FragmentDataOne extends Fragment {
    private FragmentDataOneBinding binding;
    private ViewModelDataOne viewModelDataOne;
    public FragmentDataOne() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDataOneBinding.inflate(inflater, container, false);
        viewModelDataOne = new ViewModelProvider(this).get(ViewModelDataOne.class);
        assert this.getArguments() != null;
        int id = Integer.parseInt(this.getArguments().getString("id_akun"));
        int counter = Integer.parseInt(this.getArguments().getString("id"));
        viewModelDataOne.setData(id, counter);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModelDataOne.getData().observe(getActivity(), listCounters -> {
            binding.lokasiPerhitungan.setText(listCounters.get(0).getLokasi());
            binding.waktuPerhitungan.setText(listCounters.get(0).getTanggal());
            binding.jamMulai.setText(listCounters.get(0).getMulai());
            binding.jamSelesai.setText(listCounters.get(0).getSelesai());
            binding.golongan1.setText(listCounters.get(0).getOneWay().getGol1());
            binding.golongan2.setText(listCounters.get(0).getOneWay().getGol2());
            binding.golongan3.setText(listCounters.get(0).getOneWay().getGol3());
            binding.golongan4.setText(listCounters.get(0).getOneWay().getGol4());
            binding.golongan5a.setText(listCounters.get(0).getOneWay().getGol5a());
            binding.golongan5b.setText(listCounters.get(0).getOneWay().getGol5b());
            binding.golongan6a.setText(listCounters.get(0).getOneWay().getGol6a());
            binding.golongan6b.setText(listCounters.get(0).getOneWay().getGol6b());
            binding.golongan7a.setText(listCounters.get(0).getOneWay().getGol7a());
            binding.golongan7b.setText(listCounters.get(0).getOneWay().getGol7b());
            binding.golongan7c.setText(listCounters.get(0).getOneWay().getGol7c());
            binding.golongan8.setText(listCounters.get(0).getOneWay().getGol8());
        });
    }

}