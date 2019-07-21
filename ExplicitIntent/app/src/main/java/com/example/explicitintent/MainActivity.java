package com.example.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttton = findViewById(R.id.button);
        buttton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Activity2.class);
                intent.putExtra("samplekey","this message is sent from first activity");


                Person person = new Person();
                person.setFirstName("deepak");
                person.setLastName("kumar");
                person.setQualification("B.tech");
                intent.putExtra("person",person);
                startActivity(intent);
            }
        });
    }
}
