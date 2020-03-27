package com.kellydouglass.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String passedText = "Passed text to Fragment 1";

        Fragment fragment = new Fragment1(passedText);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.host_fragment, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }
}
