package com.belajar.colalin.accountView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.belajar.colalin.R;
import com.belajar.colalin.apiService.ApiClient;
import com.belajar.colalin.apiService.RegisterAccount;
import com.belajar.colalin.databinding.FragmentRegisterBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;
    private NavController navController;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        binding.buttonRegister
                .setOnClickListener(view1 -> {
                   if ( cekField(binding.inputUsernameRegister,
                           binding.inputPasswordRegister,
                           binding.inputPhoneRegister)){
                       registerAccountService();
                   }
                });
    }

    private void registerAccountService() {
        Call< ArrayList< RegisterAccount > > registCall = ApiClient.getService().registerUser(
                binding.inputPasswordRegister.getText().toString().trim(),
                binding.inputUsernameRegister.getText().toString().trim(),
                binding.inputPhoneRegister.getText().toString().trim()
        );
        registCall.enqueue(new Callback< ArrayList< RegisterAccount > >() {
            @Override
            public void onResponse(Call< ArrayList< RegisterAccount > > call,
                                   Response< ArrayList< RegisterAccount > > response) {
                if (response.isSuccessful()){
                    if (response.body().get(0).getStatus().equals("sukses")){
                        binding.inputPasswordRegister.getText().clear();
                        binding.inputUsernameRegister.getText().clear();
                        binding.inputPhoneRegister.getText().clear();
                        Toast.makeText(getContext(), "Berhasil Mendaftar",
                                Toast.LENGTH_SHORT).show();
                        navController.navigate(R.id.action_registerFragment_to_loginFragment);
                    }else{
                        Toast.makeText(getContext(), "Akun gagal dibuat",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call< ArrayList< RegisterAccount > > call, Throwable t) {
                Toast.makeText(getContext(), "Jaringan Eror", Toast.LENGTH_SHORT).show();
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
