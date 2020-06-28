package com.sparsh.vote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity {

    EditText txtname,txtaddress,txtphone,txtpassword,txtage;
    Button btnreg;
    DatabaseReference reff;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtname=findViewById(R.id.txtname);
        txtaddress=findViewById(R.id.txtaddress);
        txtphone=findViewById(R.id.txtphone);
        txtpassword=findViewById(R.id.txtpassword);
        txtage=findViewById(R.id.txtage);
        btnreg=findViewById(R.id.btnreg);
        member = new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer agee=Integer.parseInt(txtage.getText().toString().trim());
                Long phno=Long.parseLong(txtphone.getText().toString().trim());
                if (TextUtils.isEmpty(txtname.getText().toString())) {
                    txtname.setError("Required field");
                    return;
                }
                if (TextUtils.isEmpty(txtphone.getText().toString())) {
                    txtphone.setError("Required field");
                    return;
                }
                if (TextUtils.isEmpty(txtaddress.getText().toString())) {
                    txtaddress.setError("Required field");
                    return;
                }
                if (TextUtils.isEmpty(txtpassword.getText().toString())) {
                    txtpassword.setError("Required field");
                    return;
                }
                if (TextUtils.isEmpty(txtage.getText().toString())) {
                    txtage.setError("Required field");
                    return;
                }

                member.setName(txtname.getText().toString().trim());
                member.setAddress(txtaddress.getText().toString().trim());
                member.setPassword(txtpassword.getText().toString().trim());
                member.setAge(agee);
                member.setPhone(phno);
                reff.push().setValue(member);
                Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
            }



        });
    }

}
