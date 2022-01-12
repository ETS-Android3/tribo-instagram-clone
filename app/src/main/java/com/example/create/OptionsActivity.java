package com.example.create;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.IntDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.create.Fragments.ProfileFragment;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class OptionsActivity extends AppCompatActivity {

    TextView logout, about;

    String currentUserID;
    private FirebaseAuth mAuth;

    float x1, x2, y1, y2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        mAuth = FirebaseAuth.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Options");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        logout = findViewById(R.id.logout);
        about = findViewById(R.id.about);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OptionsActivity.this, About.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.getInstance().signOut();

                try {
                    final ProgressDialog pd = new ProgressDialog(OptionsActivity.this);
                    pd.setMessage("Taking you out!");
                    pd.show();

                } catch (Exception e) {
                    Intent intent = new Intent(OptionsActivity.this, LoginActivity.class);
                    startActivity(intent);
                }


             //   startActivity(new Intent(OptionsActivity.this, LoginActivity.class));



              //  startActivity(new Intent(OptionsActivity.this, LoginActivity.class)
                     //  .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
    }


}
