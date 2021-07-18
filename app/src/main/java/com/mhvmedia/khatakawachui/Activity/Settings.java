package com.mhvmedia.khatakawachui.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CompoundButton;

import com.mhvmedia.khatakawachui.R;
import com.mhvmedia.khatakawachui.databinding.ActivitySalesBinding;
import com.mhvmedia.khatakawachui.databinding.ActivitySettingsBinding;

public class Settings extends AppCompatActivity {
    private ActivitySettingsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.toolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        binding.passswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                if(isChecked){
                    binding.passchangelayout.setVisibility(View.VISIBLE);
                }else{
                    binding.passchangelayout.setVisibility(View.GONE);
                }
            }
        });

        binding.showPassBtnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.password.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                    //Show Password
                    binding.password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    binding.showPassBtnP.setColorFilter(ContextCompat.getColor(Settings.this, R.color.colorPrimary));
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
                    binding.showPassBtnCp.setColorFilter(ContextCompat.getColor(Settings.this, R.color.colorPrimary));
                } else {
                    //Hide Password
                    binding.confirmpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    binding.showPassBtnCp.setColorFilter(null);
                }
            }
        });
    }
}