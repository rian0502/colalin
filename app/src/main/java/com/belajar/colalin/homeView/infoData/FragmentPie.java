package com.belajar.colalin.homeView.infoData;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.belajar.colalin.R;
import com.belajar.colalin.homeView.Models.Kendaraan;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class FragmentPie extends Fragment {
    private PieChart pieChart;
    private Kendaraan kendaraan;
    public FragmentPie() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pieChart = view.findViewById(R.id.chart_kendaraan);
        kendaraan = getActivity().getIntent().getParcelableExtra("kendaraan");
        Toast.makeText(getActivity(), ""+kendaraan.getGolongan1(), Toast.LENGTH_SHORT).show();
        setUpPieChart();
        loadPieChart();


    }

    private void loadPieChart() {
        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelTextSize(12);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setCenterText("Volume Kendaraan");
        pieChart.setCenterTextSize(24);
        pieChart.getDescription().setEnabled(false);
        Legend legend = pieChart.getLegend();
        legend.setDrawInside(false);
        legend.setEnabled(false);

    }

    private void setUpPieChart() {
        ArrayList< PieEntry > entries = new ArrayList<>();

        entries.add(new PieEntry(kendaraan.getGolongan1(), "Gol-1"));
        entries.add(new PieEntry(kendaraan.getGolongan2(), "Gol-2"));
        entries.add(new PieEntry(kendaraan.getGolongan3(), "Gol-3"));
        entries.add(new PieEntry(kendaraan.getGolongan4(), "Gol-4"));
        entries.add(new PieEntry(kendaraan.getGolongan5A(), "Gol-5A"));
        entries.add(new PieEntry(kendaraan.getGolongan5B(), "Gol-5B"));
        entries.add(new PieEntry(kendaraan.getGolongan6A(), "Gol-6A"));
        entries.add(new PieEntry(kendaraan.getGolongan6B(), "Gol-6B"));
        entries.add(new PieEntry(kendaraan.getGolongan7A(), "Gol-7A"));
        entries.add(new PieEntry(kendaraan.getGolongan7B(), "Gol-7B"));
        entries.add(new PieEntry(kendaraan.getGolongan7C(), "Gol-7C"));
        entries.add(new PieEntry(kendaraan.getGolongan8(), "Gol-8"));
        ArrayList<Integer> colors = new ArrayList<>();
        for (int color: ColorTemplate.MATERIAL_COLORS){
            colors.add(color);
        }
        for (int color: ColorTemplate.VORDIPLOM_COLORS){
            colors.add(color);
        }
        PieDataSet dataSet = new PieDataSet(entries,"");
        dataSet.setColors(colors);
        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);
        pieChart.setData(data);
        pieChart.invalidate();
    }
}