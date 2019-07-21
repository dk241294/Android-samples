package com.example.intentsusingparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Activity2.class);
                intent.putExtra("samplekey","this is the second activity");

                Person person =new Person();
                person.setFirstName("deepak");
                person.setLastName("kumar");
                person.setQualification("b.tech");
                intent.putExtra("person",person);
                startActivity(intent);
            }
        }));

    }
}
