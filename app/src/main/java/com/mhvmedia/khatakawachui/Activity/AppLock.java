package com.mhvmedia.khatakawachui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mhvmedia.khatakawachui.databinding.ActivityAddProductBinding;
import com.mhvmedia.khatakawachui.databinding.ActivityAddStuffBinding;
import com.mhvmedia.khatakawachui.databinding.ActivityAppLockBinding;

public class AppLock extends AppCompatActivity {
    private ActivityAppLockBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppLockBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), FirstScreen.class);
                startActivity(intent);
            }
        });

    }
}