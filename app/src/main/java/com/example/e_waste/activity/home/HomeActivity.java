package com.example.e_waste.activity.home;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.e_waste.R;
import com.example.e_waste.activity.nearestfragment.NearestFragment;
import com.example.e_waste.activity.globalfragment.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.e_waste.activity.baseappcompat.BaseAppCompatActivity.KEY_FRAGMENT;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private Fragment pageContent = new GlobalFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_layout_home, pageContent)
                    .commit();
        } else {
            pageContent = getSupportFragmentManager().getFragment(savedInstanceState, KEY_FRAGMENT);
            getSupportFragmentManager().beginTransaction().replace(R.id.container_layout_home, pageContent);
        }
    }

    protected void onSaveInstanceState(Bundle bundle){
        getSupportFragmentManager().putFragment(bundle, KEY_FRAGMENT, pageContent);
        super.onSaveInstanceState(bundle);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_global:
                pageContent = new GlobalFragment();
                break;
            case R.id.navigation_nearest:
                pageContent = new NearestFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_layout_home, pageContent)
                .commit();
        return true;
    }
}
