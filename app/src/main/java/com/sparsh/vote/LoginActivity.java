package com.sparsh.vote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button logbtn;
    ProgressBar progressBar;
    TextView textView;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.txtusername);
        password=findViewById(R.id.txtpass);
        logbtn=findViewById(R.id.btnlog);
        progressBar=findViewById(R.id.progressBar2);
        textView=findViewById(R.id.regbtn);
        fAuth=FirebaseAuth.getInstance();
    }
}
