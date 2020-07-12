package com.sparsh.vote;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreatePoll extends AppCompatActivity {
EditText PollName, Opt1, Opt2, Opt3;
Button btnAdd;
Poll poll;
DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_poll);
        PollName= (EditText) findViewById(R.id.poll_name);
        Opt1= (EditText) findViewById(R.id.option1_et);
        Opt2= (EditText) findViewById(R.id.option2_et);
        Opt3= (EditText) findViewById(R.id.option3_et);
btnAdd= (Button) findViewById(R.id.publish_poll);
poll = new Poll();
reff= FirebaseDatabase.getInstance().getReference().child("Poll");
btnAdd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        poll.getPoll(PollName.getText().toString().trim());
        poll.getOpt1(Opt1.getText().toString().trim());
        poll.getOpt2(Opt2.getText().toString().trim());
        poll.getOpt3(Opt3.getText().toString().trim());
        reff.push().setValue(poll);
        Toast.makeText(CreatePoll.this,"Added",Toast.LENGTH_SHORT).show();
    }
});
    }
}