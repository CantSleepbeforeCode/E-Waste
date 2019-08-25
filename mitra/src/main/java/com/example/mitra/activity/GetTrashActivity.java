package com.example.mitra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.mitra.R;

public class GetTrashActivity extends AppCompatActivity {
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_trash);

        spinner = findViewById(R.id.spinner);

        String[] spinnerItem = this.getResources().getStringArray(R.array.place_spinner);
        final ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spinnerItem);
        spinner.setAdapter(adapterSpinner);
    }
}
