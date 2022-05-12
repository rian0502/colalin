package com.belajar.colalin.homeView.infoData;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.belajar.colalin.R;
import com.belajar.colalin.apiService.Models.ListCounter;
import com.belajar.colalin.databinding.FragmentDataTollBinding;
import com.belajar.colalin.homeView.viewModel.ViewModelDataToll;

import java.util.ArrayList;

public class FragmentDataToll extends Fragment {
    private FragmentDataTollBinding binding;
    private ViewModelDataToll viewModelDataToll;
    public FragmentDataToll() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDataTollBinding.inflate(inflater, container, false);
        viewModelDataToll = new ViewModelProvider(getActivity()).get(ViewModelDataToll.class);
        int id = Integer.parseInt(this.getArguments().getString("id_akun"));
        int counter = Integer.parseInt(this.getArguments().getString("id"));
        viewModelDataToll.setData(id, counter);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModelDataToll.getData().observe(getActivity(), listCounters -> {
            binding.lokasiPerhitungan.setText(listCounters.get(0).getLokasi());
            binding.waktuPerhitungan.setText(listCounters.get(0).getTanggal());
            binding.jamMulai.setText(listCounters.get(0).getMulai());
            binding.jamSelesai.setText(listCounters.get(0).getSelesai());

            binding.golongan2.setText(listCounters.get(0).getTollRoad().getGol2());
            binding.golongan3.setText(listCounters.get(0).getTollRoad().getGol3());
            binding.golongan4.setText(listCounters.get(0).getTollRoad().getGol4());
            binding.golongan5a.setText(listCounters.get(0).getTollRoad().getGol5a());
            binding.golongan5b.setText(listCounters.get(0).getTollRoad().getGol5b());
            binding.golongan6a.setText(listCounters.get(0).getTollRoad().getGol6a());
            binding.golongan6b.setText(listCounters.get(0).getTollRoad().getGol6b());
            binding.golongan7a.setText(listCounters.get(0).getTollRoad().getGol7a());
            binding.golongan7b.setText(listCounters.get(0).getTollRoad().getGol7b());
            binding.golongan7c.setText(listCounters.get(0).getTollRoad().getGol7c());
        });
    }
}