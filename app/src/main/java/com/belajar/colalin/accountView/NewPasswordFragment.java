package com.belajar.colalin.accountView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.belajar.colalin.databinding.FragmentNewPasswordBinding;
import java.util.Objects;

public class NewPasswordFragment extends Fragment {
    private FragmentNewPasswordBinding binding;

    public NewPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewPasswordBinding.inflate(inflater, container, false);
        Toast.makeText(getContext(), this.getArguments().getString("username")+" "+this.getArguments().getString("phone"), Toast.LENGTH_SHORT).show();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonSubmit.setOnClickListener(view1 -> {chekSamePassword();});
    }

    private boolean etIsEmpty(){
        if(Objects.requireNonNull(binding.inputNewPassword.getText()).toString().trim().isEmpty()){
            binding.inputNewPassword.setError("Harus di isi");
            return false;
        }else if(Objects.requireNonNull(binding.inputPasswordConf.getText()).toString().trim().isEmpty()){
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