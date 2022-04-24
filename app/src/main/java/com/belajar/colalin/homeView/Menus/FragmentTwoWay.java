package com.belajar.colalin.homeView.Menus;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.belajar.colalin.databinding.FragmentTwoWayBinding;


public class FragmentTwoWay extends Fragment {

    private FragmentTwoWayBinding binding;
    public FragmentTwoWay() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTwoWayBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


}