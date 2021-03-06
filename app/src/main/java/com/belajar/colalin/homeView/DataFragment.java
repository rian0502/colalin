package com.belajar.colalin.homeView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.belajar.colalin.homeView.Models.ListCounter;
import com.belajar.colalin.databinding.FragmentDataBinding;
import com.belajar.colalin.homeView.CardAdapter.AdapterData;
import com.belajar.colalin.homeView.viewModel.ViewModelData;

import java.util.ArrayList;


public class DataFragment extends Fragment {
    private FragmentDataBinding binding;
    private ViewModelData viewModelData;
    private AdapterData adapter;
    private SharedPreferences sharedPreferences;
    public DataFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = requireActivity().getSharedPreferences("session", Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDataBinding.inflate(inflater, container, false);
        viewModelData = new ViewModelProvider(this).get(ViewModelData.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new AdapterData(getContext(), sharedPreferences.getString("ID",""));
        binding.containerDataFragment.setAdapter(adapter);
        binding.containerDataFragment.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModelData.setModelData(sharedPreferences.getString("ID",""));
        viewModelData.getModelData().observe(requireActivity(), dataObserver);
        binding.containerDataFragment.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private final Observer< ArrayList< ListCounter > > dataObserver = new Observer< ArrayList< ListCounter > >() {
        @Override
        public void onChanged(ArrayList< ListCounter > modelData) {
            adapter.updateData(modelData);
        }
    };
}