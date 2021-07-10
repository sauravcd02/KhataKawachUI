package com.mhvmedia.khatakawachui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.mhvmedia.khatakawachui.R;
import com.mhvmedia.khatakawachui.databinding.ActivityRegistrationBinding;
import com.mhvmedia.khatakawachui.databinding.ActivitySliderBinding;

public class Registration extends AppCompatActivity {
    private ActivityRegistrationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}