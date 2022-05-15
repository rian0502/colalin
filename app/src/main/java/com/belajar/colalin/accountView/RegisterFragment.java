package com.belajar.colalin.accountView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.belajar.colalin.R;
import com.belajar.colalin.accountView.viewModelAcc.ViewModelRegister;
import com.belajar.colalin.databinding.FragmentRegisterBinding;

import java.util.Objects;

public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;
    private NavController navController;
    private ViewModelRegister modelRegister;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        modelRegister = new ViewModelProvider(this).get(ViewModelRegister.class);
        modelRegister.setContext(getActivity());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        binding.buttonRegister
                .setOnClickListener(view1 -> {
                    if (cekField(binding.inputUsernameRegister,
                            binding.inputPasswordRegister,
                            binding.inputPhoneRegister)) {
                        modelRegister.setPassword(Objects.requireNonNull(binding.inputPasswordRegister
                                .getText()).toString().trim());
                        modelRegister.setPhone(Objects.requireNonNull(binding.inputPhoneRegister
                                .getText()).toString().trim());
                        modelRegister.setUsername(Objects.requireNonNull(binding.inputUsernameRegister
                                .getText()).toString().trim());
                        binding.buttonRegister.setClickable(false);
                        binding.buttonRegister.setText("");
                        binding.progressRegister.setVisibility(View.VISIBLE);
                        modelRegister.
                                checkUsername(binding.buttonRegister, binding.progressRegister);
                    }
                });
    }

    private boolean cekField(EditText username, EditText password, EditText phone) {
        if (username.getText().toString().trim().isEmpty()) {
            username.setError("Username harus di isi");
            return false;
        } else if (password.getText().toString().trim().isEmpty()) {
            password.setError("Password harus di isi");
            return false;
        } else if (phone.getText().toString().trim().isEmpty()) {
            phone.setError("Phone number harus di isi");
            return false;
        }
        return true;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                navController.navigate(R.id.action_registerFragment_to_loginFragment);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }
}
