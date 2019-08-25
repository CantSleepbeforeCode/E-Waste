package com.example.mitra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.mitra.R;
import com.example.mitra.database.UserHelper;

public class MainActivity extends AppCompatActivity {
    UserHelper userHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userHelper = new UserHelper(this);

        if (!userHelper.isEmailExists("mitra@gmail.com", getApplicationContext())) {
            userHelper.insertAdmin();
        }

        int splash_time = 2000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(splashIntent);
                finish();
            }
        }, splash_time);
    }
}
