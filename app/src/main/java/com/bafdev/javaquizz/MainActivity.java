package com.bafdev.javaquizz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StartFragment startFragment = new StartFragment();
        MainFragment mainFragment = new MainFragment();
        FinishFragment finishFragment = new FinishFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout,startFragment).commit();
    }

    public void replaceFragments(Fragment fragmentClass) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragmentClass).addToBackStack(null).commit();
    }
}