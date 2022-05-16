package com.belajar.colalin.homeView.infoData;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.belajar.colalin.databinding.FragmentDataTwoBinding;
import com.belajar.colalin.homeView.viewModel.ViewModelDataTwo;


public class FragmentDataTwo extends Fragment {
    private FragmentDataTwoBinding binding;
    private ViewModelDataTwo viewModelDataTwo;

    public FragmentDataTwo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDataTwoBinding.inflate(inflater, container, false);
        viewModelDataTwo = new ViewModelProvider(requireActivity()).get(ViewModelDataTwo.class);
        assert this.getArguments() != null;
        int id = Integer.parseInt(this.getArguments().getString("id_akun"));
        int counter = Integer.parseInt(this.getArguments().getString("id"));
        viewModelDataTwo.setData(id, counter);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModelDataTwo.getData().observe(requireActivity()    , listCounters -> {
            binding.lokasiPerhitungan.setText(listCounters.get(0).getLokasi());
            binding.waktuPerhitungan.setText(listCounters.get(0).getTanggal());
            binding.jamMulai.setText(listCounters.get(0).getMulai());
            binding.jamSelesai.setText(listCounters.get(0).getSelesai());
            binding.golongan1.setText(listCounters.get(0).getTwoWay().getGol1());
            binding.golongan2.setText(listCounters.get(0).getTwoWay().getGol2());
            binding.golongan3.setText(listCounters.get(0).getTwoWay().getGol3());
            binding.golongan4.setText(listCounters.get(0).getTwoWay().getGol4());
            binding.golongan5a.setText(listCounters.get(0).getTwoWay().getGol5a());
            binding.golongan5b.setText(listCounters.get(0).getTwoWay().getGol5b());
            binding.golongan6a.setText(listCounters.get(0).getTwoWay().getGol6a());
            binding.golongan6b.setText(listCounters.get(0).getTwoWay().getGol6b());
            binding.golongan7a.setText(listCounters.get(0).getTwoWay().getGol7a());
            binding.golongan7b.setText(listCounters.get(0).getTwoWay().getGol7b());
            binding.golongan7c.setText(listCounters.get(0).getTwoWay().getGol7c());
            binding.golongan8.setText(listCounters.get(0).getTwoWay().getGol8());

            binding.mgolongan1.setText(listCounters.get(0).getTwoWay().getMgol1());
            binding.mgolongan2.setText(listCounters.get(0).getTwoWay().getMgol2());
            binding.mgolongan3.setText(listCounters.get(0).getTwoWay().getMgol3());
            binding.mgolongan4.setText(listCounters.get(0).getTwoWay().getMgol4());
            binding.mgolongan5a.setText(listCounters.get(0).getTwoWay().getMgol5a());
            binding.mgolongan5b.setText(listCounters.get(0).getTwoWay().getMgol5b());
            binding.mgolongan6a.setText(listCounters.get(0).getTwoWay().getMgol6a());
            binding.mgolongan6b.setText(listCounters.get(0).getTwoWay().getMgol6b());
            binding.mgolongan7a.setText(listCounters.get(0).getTwoWay().getMgol7a());
            binding.mgolongan7b.setText(listCounters.get(0).getTwoWay().getMgol7b());
            binding.mgolongan7c.setText(listCounters.get(0).getTwoWay().getMgol7c());
            binding.mgolongan8.setText(listCounters.get(0).getTwoWay().getMgol8());
        });

    }
}