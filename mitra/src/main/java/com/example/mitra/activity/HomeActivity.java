package com.example.mitra.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mitra.R;
import com.google.android.material.snackbar.Snackbar;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    CardView cdTrash, cdMaintenance, cdAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cdTrash = findViewById(R.id.card_trash);
        cdMaintenance = findViewById(R.id.card_maintenance);
        cdAdd = findViewById(R.id.card_add);

        cdTrash.setOnClickListener(this);
        cdMaintenance.setOnClickListener(this);
        cdAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String message = getString(R.string.feature_not_available);
        int duration = Snackbar.LENGTH_LONG;
        View object;
        switch (view.getId()) {
            case R.id.card_trash:
                Intent intent = new Intent(HomeActivity.this, GetTrashActivity.class);
                startActivity(intent);
                break;

            case R.id.card_maintenance:
                object = findViewById(R.id.card_maintenance);
                showSnackbar(object, message, duration);
                break;

            case R.id.card_add:
                Intent intentAdd = new Intent(HomeActivity.this, RegisterDevice.class);
                startActivity(intentAdd);
                break;
        }

    }

    public void showSnackbar(View view, String message, int duration)
    {
        Snackbar.make(view, message, duration).show();
    }
}
