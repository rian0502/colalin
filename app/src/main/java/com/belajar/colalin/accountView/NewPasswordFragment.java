package com.belajar.colalin.accountView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.belajar.colalin.accountView.viewModelAcc.ViewModelNewPass;
import com.belajar.colalin.databinding.FragmentNewPasswordBinding;

import java.util.Objects;

public class NewPasswordFragment extends Fragment {
    private FragmentNewPasswordBinding binding;
    private ViewModelNewPass viewModelNewPass;
    public NewPasswordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewPasswordBinding.inflate(inflater, container, false);
        viewModelNewPass = new ViewModelProvider(this).get(ViewModelNewPass.class);
        viewModelNewPass.setContext(getActivity());
        assert this.getArguments() != null;
        viewModelNewPass.setUsername(this.getArguments().getString("username"));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonSubmit.setOnClickListener(view1 -> chekSamePassword());
    }

    private boolean etIsEmpty(){
        if(Objects.requireNonNull(binding.inputNewPassword.getText()).toString().trim().isEmpty()){
            binding.inputNewPassword.setError("Harus di isi");
            return false;
        }else if(Objects.requireNonNull(binding.inputPasswordConf.getText()).toString().trim().isEmpty()){
            binding.inputPasswordConf.setError("Harus di isi");
            return false;
        }else{
            viewModelNewPass.setPassword(binding.inputNewPassword.getText().toString().trim());
            return true;
        }
    }

    void chekSamePassword(){
        if (etIsEmpty()){
            if (Objects.requireNonNull(binding.inputNewPassword.getText()).toString().trim()
                    .equals(Objects.requireNonNull
                            (binding.inputPasswordConf.getText()).toString().trim())){
                viewModelNewPass.reqUpdatePass();
            }else{
               binding.inputPasswordConf.setError("Password tidak cocok");
            }
        }
    }

}