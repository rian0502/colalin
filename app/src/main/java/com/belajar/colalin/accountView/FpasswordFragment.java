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
import android.widget.Toast;

import com.belajar.colalin.R;
import com.belajar.colalin.databinding.FragmentFpasswordBinding;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;


public class FpasswordFragment extends Fragment {
    private FragmentFpasswordBinding binding;
    private NavController navController;
    private FirebaseAuth mAuth;

    public FpasswordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFpasswordBinding.inflate(inflater, container, false);
        mAuth = FirebaseAuth.getInstance();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        binding.buttonNext.setOnClickListener(view1 -> goneOTP());
        binding.buttonVertivikasi.setOnClickListener(view1 -> navController.navigate(R.id.action_fpasswordFragment_to_newPasswordFragment));
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

    public void goneOTP() {
        binding.inputPhoneForgot.setVisibility(View.GONE);
        binding.imageForgot.setVisibility(View.GONE);
        binding.buttonNext.setVisibility(View.GONE);
        binding.tvForgotPassword.setVisibility(View.GONE);
        binding.etCountryCode.setVisibility(View.GONE);
        binding.tvPhoneNumber.setVisibility(View.GONE);

        binding.imageOtp.setVisibility(View.VISIBLE);
        binding.buttonVertivikasi.setVisibility(View.VISIBLE);
        binding.tvSendingOTP.setVisibility(View.VISIBLE);
        binding.tvOTP.setVisibility(View.VISIBLE);
        binding.inputOtp.setVisibility(View.VISIBLE);
        binding.layoutOtpInput.setVisibility(View.VISIBLE);
    }

    private void sendOTP(String number) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+62" + number)
                        .setTimeout(60l, TimeUnit.SECONDS)
                        .setActivity(getActivity())
                        .setCallbacks(mCallBack)
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack =
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                    final String code = phoneAuthCredential.getSmsCode();

                    if (code.trim().equals("")) {
                        vertifOTP(code);
                    }
                }

                @Override
                public void onVerificationFailed(@NonNull FirebaseException e) {
                    Toast.makeText(getContext(), "Kode OTP salah", Toast.LENGTH_SHORT).show();
                }
            };


    private void vertifOTP(String code) {

    }

}