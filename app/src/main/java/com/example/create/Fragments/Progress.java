package com.example.create.Fragments;
import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.create.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Progress extends Fragment {

    ImageView popup_add;
    ProgressBar popup_progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_progress, container, false);

        popup_add = view.findViewById(R.id.popup_add);
        popup_progressBar = view.findViewById(R.id.popup_progressBar);

        popup_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup_add.setVisibility(View.INVISIBLE);
                popup_progressBar.setVisibility(View.VISIBLE);

                //    if(some task successful) {
                //       popup_progressBar.setVisibility(View.INVISIBLE);
                //       popup_add.setVisibility(View.VISIBLE);
                //   }

                //  else {
                //      popup_progressBar.setVisibility(View.INVISIBLE);
                //       popup_add.setVisibility(View.VISIBLE);
                //  }

            }
        });

        return view;
    }



}
