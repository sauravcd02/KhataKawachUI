package com.mhvmedia.khatakawachui.Activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.mhvmedia.khatakawachui.R;
import com.mhvmedia.khatakawachui.databinding.ActivityNewInvoiceBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class NewInvoice extends AppCompatActivity {
    private ActivityNewInvoiceBinding binding;
    final Calendar myCalendar = Calendar.getInstance();

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
        getUnit();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        binding.date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(NewInvoice.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        binding.datetime.setText(sdf.format(myCalendar.getTime()));
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