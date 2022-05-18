package com.belajar.colalin.homeView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.belajar.colalin.MainActivity;
import com.belajar.colalin.accountView.Sessions.SessionManagement;
import com.belajar.colalin.databinding.FragmentProfileBinding;
import com.belajar.colalin.homeView.profileMenu.ProfileActivity;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    private SharedPreferences sharedPreferences;
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = requireActivity().getSharedPreferences("session", Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentProfileBinding.inflate(inflater, container, false);

        binding.tvUsernameView.setText(sharedPreferences.getString("usernameKEY",""));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonLogout.setOnClickListener(view1 -> {
            SessionManagement sessionManagement = new SessionManagement(requireActivity());
            sessionManagement.removeSession();
            Intent intent = new Intent(requireActivity(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                    Intent.FLAG_ACTIVITY_CLEAR_TASK |
                    Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            requireActivity().finish();
        });

        binding.menuInfo.setOnClickListener(view1 -> {
            Intent intent = new Intent(requireActivity(), ProfileActivity.class);
            intent.putExtra("menu", 0);
            startActivity(intent);
        });

        binding.menuAbout.setOnClickListener(view1 -> {
            Intent intent = new Intent(requireActivity(), ProfileActivity.class);
            intent.putExtra("menu", 1);
            startActivity(intent);
        });
    }
}