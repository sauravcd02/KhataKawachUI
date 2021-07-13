package com.mhvmedia.khatakawachui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.mhvmedia.khatakawachui.databinding.ActivityLoginBinding;
import com.mhvmedia.khatakawachui.databinding.ActivityNewInvoiceBinding;
import com.mhvmedia.khatakawachui.databinding.ActivityRegistrationBinding;

public class NewInvoice extends AppCompatActivity {
    private ActivityNewInvoiceBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewInvoiceBinding.inflate(getLayoutInflater());
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