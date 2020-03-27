package com.kellydouglass.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Fragment1 extends Fragment {

    Fragment2 fragment2;
    Fragment3 fragment3;
    Button to2Button;
    String passedText;
    TextView textView;

    public Fragment1(String passedText) {
        this.passedText = passedText;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        to2Button = view.findViewById(R.id.toFragment2Button);
        Button to3Button = view.findViewById(R.id.toFragment3Button);
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        textView = view.findViewById(R.id.passedTextView);
        textView.setText(this.passedText);

        to2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager manager = getFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                ft.replace(R.id.host_fragment, fragment2);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack("true");
                ft.commit();

            }
        });

        to3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                ft.replace(R.id.host_fragment, fragment3);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack("true");
                ft.commit();
            }
        });

    }
}
