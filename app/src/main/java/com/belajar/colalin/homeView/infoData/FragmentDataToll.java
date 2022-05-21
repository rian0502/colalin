package com.belajar.colalin.homeView.infoData;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.belajar.colalin.databinding.FragmentDataTollBinding;
import com.belajar.colalin.homeView.viewModel.ViewModelDataToll;

public class FragmentDataToll extends Fragment{
    private FragmentDataTollBinding binding;
    private ViewModelDataToll viewModelDataToll;
    public FragmentDataToll() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDataTollBinding.inflate(inflater, container, false);
        viewModelDataToll = new ViewModelProvider(requireActivity()).get(ViewModelDataToll.class);
        assert this.getArguments() != null;
        int id = Integer.parseInt(this.getArguments().getString("id_akun"));
        int counter = Integer.parseInt(this.getArguments().getString("id"));
        viewModelDataToll.setData(id, counter);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModelDataToll.getData().observe(requireActivity(), listCounters -> {
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