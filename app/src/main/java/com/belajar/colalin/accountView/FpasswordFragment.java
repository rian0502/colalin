package com.belajar.colalin.accountView;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.belajar.colalin.R;
import com.belajar.colalin.databinding.FragmentFpasswordBinding;


public class FpasswordFragment extends Fragment {
    private FragmentFpasswordBinding binding;
    private NavController navController;
    public FpasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFpasswordBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        binding.buttonNext.setOnClickListener(view1 -> goneOTP());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                navController.navigate(R.id.action_fpasswordFragment_to_loginFragment);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }
    public void goneOTP(){
        binding.inputPhoneForgot.setVisibility(View.GONE);
        binding.imageForgot.setVisibility(View.GONE);
        binding.buttonNext.setVisibility(View.GONE);
        binding.imageOtp.setVisibility(View.VISIBLE);
        binding.buttonVertivikasi.setVisibility(View.VISIBLE);
    }
}