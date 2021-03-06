package com.belajar.colalin.accountView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.belajar.colalin.R;
import com.belajar.colalin.accountView.viewModelAcc.ViewModelFindUser;
import com.belajar.colalin.databinding.FragmentFpasswordBinding;

import java.util.Objects;


public class FpasswordFragment extends Fragment {
    private FragmentFpasswordBinding binding;
    private NavController navController;
    private ViewModelFindUser viewModelFindUser;

    public FpasswordFragment() {
        // Required empty public constructor
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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFpasswordBinding.inflate(inflater, container, false);
        viewModelFindUser = new ViewModelProvider(this).get(ViewModelFindUser.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        binding.buttonNext.setOnClickListener(view1 -> {
            if (Objects.requireNonNull(binding.inputUsernameForgot.getText()).toString().isEmpty()) {
                binding.inputUsernameForgot.setError("Username Harus di isi");
            } else {
                viewModelFindUser
                        .setUsername(binding.inputUsernameForgot.getText().toString().trim());
                viewModelFindUser.findUser(binding.buttonNext,
                        binding.progressFindUsername,
                        getActivity());
            }
        });
    }


}