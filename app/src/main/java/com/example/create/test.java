package com.example.create;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class test extends AppCompatActivity {

    EditText username, fullname, email, password;
    Button register;
    TextView txt_login;
    ImageView image;
    static int PReqcode = 1;
    static int REQUESCODE = 1;
    Uri pickedImageUri;
    FirebaseAuth auth;
    DatabaseReference reference;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);

        auth = FirebaseAuth.getInstance();




        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String str_email = email.getText().toString();
                String str_password = password.getText().toString();

                if((str_email.isEmpty()&&(str_password.isEmpty()) )) {
                    Toast.makeText(test.this, "Email, Password and User Name, User Image are empty",Toast.LENGTH_SHORT).show();
                }

                else if (str_email.isEmpty()) {
                    email.setError("Please Provide Your E-Mail address!");
                    email.requestFocus();

                }

                else if(str_password.isEmpty()) {
                    password.setError("Please Enter Your Password!");
                    password.requestFocus();
                }

                else if(str_password.length()<6) {
                    password.setError("Minimum 6 Characters");
                    password.requestFocus();
                }




                else {
                    pd = new ProgressDialog(test.this);
                    pd.setMessage("Registering your Account...");
                    pd.show();
                    register(str_email, str_password);
                }
            }
        });
    }




    public void register(final String email, String password){
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(test.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            String userID = firebaseUser.getUid();


                            reference = FirebaseDatabase.getInstance().getReference().child("Users").child(userID);
                            HashMap<String, Object> map = new HashMap<>();
                            map.put("id", userID);
                            map.put("imageurl", "https://firebasestorage.googleapis.com/v0/b/instagramtest-fcbef.appspot.com/o/placeholder.png?alt=media&token=b09b809d-a5f8-499b-9563-5252262e9a49");
                            map.put("bio", "");
                            map.put("email", email);
                            map.put("domain", "");
                            reference.setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        pd.dismiss();
                                        Toast.makeText(test.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(test.this, DetailsActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                    }
                                }
                            });
                        } else {
                            pd.dismiss();
                            Toast.makeText(test.this, "You can't register with this email or password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



}
