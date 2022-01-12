package com.example.create;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.create.Fragments.Progress;
import com.google.firebase.auth.FirebaseUser;


public class ChatListActivity extends AppCompatActivity {

    ImageView image_profile;
    TextView username;
    FirebaseUser firebaseUser;
    String profileid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

    image_profile = findViewById(R.id.imageView8);

    image_profile.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ChatListActivity.this, Progress.class);
            startActivity(intent);
        }
    });

    }

}
