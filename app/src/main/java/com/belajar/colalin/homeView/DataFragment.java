package com.belajar.colalin.homeView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.belajar.colalin.databinding.FragmentDataBinding;
import com.belajar.colalin.homeView.CardAdapter.AdapterData;
import com.belajar.colalin.homeView.Models.DataCounter;
import com.belajar.colalin.homeView.Models.ModelData;

import java.util.ArrayList;


public class DataFragment extends Fragment {

    private FragmentDataBinding binding;
    private ArrayList< ModelData > modelData;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDataBinding.inflate(inflater, container, false);
        modelData = new ArrayList<>();
        DataCounter.addData();
        modelData = DataCounter.getKendaraan();
        Toast.makeText(getActivity(), ""+modelData.size(), Toast.LENGTH_SHORT).show();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AdapterData data = new AdapterData(modelData);
        binding.containerDataFragment.setHasFixedSize(true);
        binding.containerDataFragment.setAdapter(data);
        binding.containerDataFragment.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onDestroyView() {
        modelData.clear();
        super.onDestroyView();
    }
}