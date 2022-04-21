package com.belajar.colalin.accountView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.belajar.colalin.R;
import com.belajar.colalin.accountView.Sessions.SessionManagement;
import com.belajar.colalin.accountView.Sessions.UserLogged;
import com.belajar.colalin.databinding.FragmentLoginBinding;
import com.belajar.colalin.homeView.HomeActivity;


public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController controller = Navigation.findNavController(view);
        binding.textButtonForgotPassword.setOnClickListener(view1 -> controller.navigate(R.id.action_loginFragment_to_fpasswordFragment));
        binding.textButtonCreateAccount.setOnClickListener(view1 -> controller.navigate(R.id.action_loginFragment_to_registerFragment));
        binding.buttonLogin.setOnClickListener(view1 -> {
            login();
            Intent intent = new Intent(getActivity(), HomeActivity.class);
            intent.putExtra("username",binding.inputUsername.getText().toString().trim());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            getActivity().finish();
        });
    }

    private void login() {
        UserLogged user = new UserLogged(binding.inputUsername.getText().toString(), 1);
        SessionManagement sessionManagement = new SessionManagement(getActivity());
        sessionManagement.saveSession(user);
    }

    @Override
    public void onStart() {
        super.onStart();
        SessionManagement sessionManagement = new SessionManagement(getActivity());
        sessionManagement.getSession();
        String isUserLogged = sessionManagement.getSession();
        if (!isUserLogged.equals("null")){
            Intent intent = new Intent(getActivity(), HomeActivity.class);
            intent.putExtra("username",binding.inputUsername.getText().toString().trim());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}