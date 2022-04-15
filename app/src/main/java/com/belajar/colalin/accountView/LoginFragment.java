package com.belajar.colalin.accountView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.belajar.colalin.R;
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
            Intent intent = new Intent(getActivity(), HomeActivity.class);
            startActivity(intent);
        });
    }

}