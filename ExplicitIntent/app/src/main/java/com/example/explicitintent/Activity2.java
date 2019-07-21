package com.example.explicitintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
private TextView textView,textViewPerson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        textView=findViewById(R.id.text2);
        textViewPerson=findViewById(R.id.textViewPerson);
        //to fetch message from 1st activity
        String message = getIntent().getStringExtra("samplekey");
        textView.setText(message);


        Person person =(Person) getIntent().getSerializableExtra("person");
        textViewPerson.setText(person.getFirstName()+","+person.getLastName()+","+person.getQualification());
    }
}
