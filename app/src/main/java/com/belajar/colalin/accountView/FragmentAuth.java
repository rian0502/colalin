package com.belajar.colalin.accountView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.belajar.colalin.accountView.viewModelAcc.ViewModelAuth;
import com.belajar.colalin.databinding.FragmentAuthBinding;

import java.util.Objects;


public class FragmentAuth extends Fragment {
    private FragmentAuthBinding binding;
    private ViewModelAuth viewModelAuth;
    public FragmentAuth() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAuthBinding.inflate(inflater, container, false);
        viewModelAuth = new ViewModelProvider(this).get(ViewModelAuth.class);
        viewModelAuth.setContext(getActivity());
        assert this.getArguments() != null;
        viewModelAuth.setUsername(this.getArguments().getString("username"));
        viewModelAuth.setPhone(this.getArguments().getString("phone"));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModelAuth.sendOTP();
        binding.buttonVertivikasi.setOnClickListener(view1 -> {
            if (binding.inputOtp.getText().toString().trim().isEmpty()){
                binding.inputOtp.setError("OTP harus di isi");
            }else {
                viewModelAuth.vertifOTP(Objects.requireNonNull(binding.inputOtp.getText())
                        .toString()
                        .trim());
            }
        });

    }
}