package com.mhvmedia.khatakawachui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mhvmedia.khatakawachui.BuildConfig;
import com.mhvmedia.khatakawachui.Slider;
import com.mhvmedia.khatakawachui.databinding.ActivitySplashBinding;

public class Splash extends AppCompatActivity {
    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getBaseContext(), Slider.class);
                startActivity(intent);
                finish();
            }
        }, 4000);

        String versionName = BuildConfig.VERSION_NAME;
        binding.version.setText("Version - " + versionName);
    }
}