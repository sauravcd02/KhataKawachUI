package com.mhvmedia.khatakawachui.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mhvmedia.khatakawachui.databinding.FragmentClientProfileBinding;

public class ClientProfile extends Fragment {
    FragmentClientProfileBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentClientProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        // code here

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

    }
}
