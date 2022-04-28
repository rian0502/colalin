package com.belajar.colalin.accountView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.belajar.colalin.R;
import com.belajar.colalin.databinding.FragmentNewPasswordBinding;

public class NewPasswordFragment extends Fragment {
    private FragmentNewPasswordBinding binding;
    private NavController controller;
    public NewPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewPasswordBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = Navigation.findNavController(view);
        binding.buttonSubmit.setOnClickListener(view1 -> {chekSamePassword();});
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                controller.navigate(R.id.action_newPasswordFragment_to_loginFragment);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    private boolean etIsEmpty(){
        if(binding.inputNewPassword.getText().toString().trim().isEmpty()){
            binding.inputNewPassword.setError("Harus di isi");
            return false;
        }else if(binding.inputPasswordConf.getText().toString().trim().isEmpty()){
            binding.inputPasswordConf.setError("Harus di isi");
            return false;
        }else{
            return true;
        }
    }

    void chekSamePassword(){
        if (etIsEmpty()){
            Toast.makeText(getContext(), "Password tidak cocok", Toast.LENGTH_SHORT).show();
        }
    }
}