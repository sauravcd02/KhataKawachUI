package com.mhvmedia.khatakawachui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.mhvmedia.khatakawachui.databinding.ActivityAddProductBinding;
import com.mhvmedia.khatakawachui.databinding.ActivityAddStuffBinding;

public class AddStuff extends AppCompatActivity {
    private ActivityAddStuffBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddStuffBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.toolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}