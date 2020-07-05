package com.sparsh.vote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText username, pass;
    Button logbtn;
    ProgressBar progressBar;
    TextView textView;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.txtusername);
        pass=findViewById(R.id.txtpass);
        logbtn=findViewById(R.id.btnlog);
        progressBar=findViewById(R.id.progressBar2);
        textView=findViewById(R.id.regbtn);
        fAuth=FirebaseAuth.getInstance();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = username.getText().toString().trim();
                String password = pass.getText().toString().trim();

                if (TextUtils.isEmpty(fullname)){
                    username.setError("Full Name must be entered");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    pass.setError("Full Name must be entered");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                fAuth.signInWithEmailAndPassword(fullname,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Logged In", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));}
                        else{
                            Toast.makeText(LoginActivity.this, "Error!" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }
                });
            }

        });
    }
}
