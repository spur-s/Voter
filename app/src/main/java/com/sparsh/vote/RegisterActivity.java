package com.sparsh.vote;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText eFullName, eAge, ePassword, eAddress, ePhone;
    Button Savebtn;
    FirebaseAuth fAuth;
    //ProgressBar progressBar;
    FirebaseFirestore fStore;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eFullName= findViewById(R.id.txtname);
        ePassword= findViewById(R.id.txtpassword);
        eAddress= findViewById(R.id.txtaddress);
        eAge=findViewById(R.id.txtage);
        ePhone=findViewById(R.id.txtphone);
        Savebtn= findViewById(R.id.btnreg);

        fAuth= FirebaseAuth.getInstance();
        fStore= FirebaseFirestore.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();



        if (fAuth.getCurrentUser() !=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        Savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String password = ePassword.getText().toString().trim();
                final String fullname = eFullName.getText().toString();
                final String address = eAddress.getText().toString();
                final String age = eAge.getText().toString().trim();
                final String phone = ePhone.getText().toString();


                if (TextUtils.isEmpty(fullname)){
                    eFullName.setError("Full Name must be entered");
                    return;
                }

                if (TextUtils.isEmpty(address)){
                    eAddress.setError("Address cannot be left");
                    return;
                }
                if (TextUtils.isEmpty(phone)){
                    ePhone.setError("Enter Phone Number");
                    return;
                }
                if (TextUtils.isEmpty(age)){
                    eAge.setError("Enter Your Age");
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    ePassword.setError("Password is required");
                    return;
                }

                if (password.length()<6){
                    ePassword.setError("Password must be more than six characters");
                    return;
                }



                //registering the user in firebase

                fAuth.createUserWithEmailAndPassword(fullname,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "User has been registered", Toast.LENGTH_SHORT).show();
                            String userID = fAuth.getCurrentUser().getUid();
                            DatabaseReference current_user = databaseReference.child(userID);
                            current_user.child("name").setValue(fullname);
                            current_user.child("password").setValue(password);
                            current_user.child("address").setValue(address);
                            current_user.child("phone").setValue(phone);
                            current_user.child("age").setValue(age);

                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        }else {
                            Toast.makeText(RegisterActivity.this, "Error!" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                           // progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }})
        ;}}