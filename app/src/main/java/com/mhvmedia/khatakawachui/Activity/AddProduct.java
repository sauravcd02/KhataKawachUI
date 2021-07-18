package com.mhvmedia.khatakawachui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.mhvmedia.khatakawachui.R;
import com.mhvmedia.khatakawachui.databinding.ActivityAddProductBinding;
import com.mhvmedia.khatakawachui.databinding.ActivityProductListBinding;

public class AddProduct extends AppCompatActivity {
    private ActivityAddProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddProductBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.toolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getUnit();
    }

    private void getUnit() {
        // Initializing and set marital status
        final String[][] gender_array = {new String[]{"Unit","Kg", "Gram", "Pound"}};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_design2, gender_array[0]);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_design2);
        binding.unitspinner.setAdapter(spinnerArrayAdapter);
        binding.unitspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String graphTime = String.valueOf(parent.getItemAtPosition(position));
                //Toast.makeText(getBaseContext(), religion, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}