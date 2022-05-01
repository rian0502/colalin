package com.belajar.colalin.accountView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.belajar.colalin.R;
import com.belajar.colalin.accountView.Sessions.SessionManagement;
import com.belajar.colalin.accountView.Sessions.UserLogged;
import com.belajar.colalin.apiService.ApiClient;
import com.belajar.colalin.apiService.LoginAuth;
import com.belajar.colalin.databinding.FragmentLoginBinding;
import com.belajar.colalin.homeView.HomeActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
        binding.textButtonForgotPassword
                .setOnClickListener(view1 -> controller.
                        navigate(R.id.action_loginFragment_to_fpasswordFragment));
        binding.textButtonCreateAccount.
                setOnClickListener(view1 -> controller.
                        navigate(R.id.action_loginFragment_to_registerFragment));

        binding.buttonLogin.setOnClickListener(view1 -> {
            if (validateFrom()) {
                loginAuth();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        SessionManagement sessionManagement = new SessionManagement(getActivity());
        sessionManagement.getSession();
        String isUserLogged = sessionManagement.getSession();
        if (!isUserLogged.equals("null")) {
            Intent intent = new Intent(getActivity(), HomeActivity.class);
            intent.putExtra("username", isUserLogged);
            intent.putExtra("id", String.valueOf(sessionManagement.getIdSession()));
            Log.e("id", String.valueOf(sessionManagement.getIdSession()));
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |
                    Intent.FLAG_ACTIVITY_NEW_TASK |
                    Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }

    private void loginAuth() {
        Call< ArrayList< LoginAuth > >
                authCall = ApiClient.getService().loginAuth(
                Objects.requireNonNull(binding.inputPassword.getText())
                        .toString()
                        .trim(),
                Objects.requireNonNull(binding.inputUsername.getText())
                        .toString()
                        .trim()
        );

        authCall.enqueue(new Callback< ArrayList< LoginAuth > >() {
            @Override
            public void onResponse(@NonNull Call< ArrayList< LoginAuth > > call,
                                   @NonNull Response< ArrayList< LoginAuth > > response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    if (response.body().get(0).getStatus().equals("berhasil")) {
                        login(response.body().get(0).getId());
                    } else {
                        Toast.makeText(getContext(),
                                "Username atau Password salah", Toast.LENGTH_SHORT)
                                .show();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call< ArrayList< LoginAuth > > call,
                                  @NonNull Throwable t) {
                Log.e("eror 2", t.getMessage());
                Log.e("eror stack : ", Arrays.toString(t.getStackTrace()));
            }
        });
    }

    private void login(String id) {
        String username = binding.inputUsername.getText().toString().trim();
        UserLogged user = new UserLogged(username, Integer.parseInt(id));
        SessionManagement sessionManagement = new SessionManagement(getActivity());
        sessionManagement.saveSession(user);
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        intent.putExtra("username", username);
        intent.putExtra("id", id);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TOP
        );
        startActivity(intent);
        getActivity().finish();
    }

    private boolean validateFrom() {
        if (Objects.requireNonNull(binding.inputUsername.getText())
                .toString()
                .trim()
                .isEmpty()) {
            binding.inputUsername.setError("Username harus di isi");
            return false;
        } else if (Objects.requireNonNull(binding.inputPassword.getText())
                .toString()
                .trim()
                .isEmpty()) {
            binding.inputPassword.setError("Password harus di isi");
            return false;
        }
        return true;
    }
}