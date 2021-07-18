package com.mhvmedia.khatakawachui.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
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

        binding.signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Login.class);
                startActivity(intent);
            }
        });

        binding.showPassBtnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.password.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                    //Show Password
                    binding.password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    binding.showPassBtnP.setColorFilter(ContextCompat.getColor(Registration.this, R.color.colorPrimary));
                } else {
                    //Hide Password
                    binding.password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    binding.showPassBtnP.setColorFilter(null);
                }
            }
        });
        
        binding.showPassBtnCp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.confirmpassword.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                    //Show Password
                    binding.confirmpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    binding.showPassBtnCp.setColorFilter(ContextCompat.getColor(Registration.this, R.color.colorPrimary));
                } else {
                    //Hide Password
                    binding.confirmpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    binding.showPassBtnCp.setColorFilter(null);
                }
            }
        });

    }
}