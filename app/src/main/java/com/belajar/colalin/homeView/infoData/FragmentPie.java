package com.belajar.colalin.homeView.infoData;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.belajar.colalin.R;
import com.belajar.colalin.databinding.FragmentPieBinding;
import com.github.mikephil.charting.charts.PieChart;


public class FragmentPie extends Fragment {
    private PieChart pieChart;
    private FragmentPieBinding binding;

    public FragmentPie() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPieBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pieChart = view.findViewById(R.id.chart_kendaraan);

    }


}