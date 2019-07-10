package com.example.miwok;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView numbers = findViewById(R.id.number_textView);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NumberActivity.class);
                startActivity(intent);

            }
        });
        final TextView colors = findViewById(R.id.colors_textView);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(intent);

            }
        });
        TextView familyName = findViewById(R.id.familyname_textView);
        familyName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FamilyActivity.class);
                startActivity(intent);

            }
        });
        TextView phrase = findViewById(R.id.phrases_textView);
        phrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(intent);

            }
        });


    }
}
