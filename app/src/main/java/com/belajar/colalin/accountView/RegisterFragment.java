package com.belajar.colalin.accountView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.belajar.colalin.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;
    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonRegister.setOnClickListener(view1 -> cekField(binding.inputUsernameRegister, binding.inputPasswordRegister, binding.inputPhoneRegister));
    }
    private void cekField(EditText username, EditText password, EditText phone){
        if (username.getText().toString().trim().isEmpty()){
            username.setError("Username harus di isi");
        }else if(password.getText().toString().trim().isEmpty()){
            password.setError("Password harus di isi");
        }else if(phone.getText().toString().trim().isEmpty()){
            phone.setError("Phone number harus di isi");
        }
    }
}