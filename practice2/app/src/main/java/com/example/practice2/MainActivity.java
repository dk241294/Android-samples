package com.example.practice2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice2.R;

public class MainActivity extends AppCompatActivity {
    int pointA = 0;
    int pointB = 0;
    Button point3;
    Button point2;
    Button point1;
    Button point3B;
    Button point2B;
    Button point1B;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button point3 to give score point 3

        point3 = findViewById(R.id.point3);
        point3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointA += 3;
                display(pointA);
            }
        });

        //button point2 to give point 2
        point2 = findViewById(R.id.point2);
        point2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointA += 2;
                display(pointA);
            }
        });

        point1 = findViewById(R.id.freethrow);
        point1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointA += 1;
                display(pointA);
            }
        });

        // button to display point 3 for team B
        point3B = findViewById(R.id.Bpoint3);
        point3B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointB = pointB + 3;
                diplayB(pointB);

            }
        });

        point2B = findViewById(R.id.Bpoint2);
        point2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointB = pointB + 2;
                diplayB(pointB);
            }
        });

        point1B = findViewById(R.id.Bfreethrow);
        point1B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointB = pointB + 1;
                diplayB(pointB);
            }
        });

        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointA = 0;
                pointB = 0;
                display(pointA);
                diplayB(pointB);
                point3B.setEnabled(true);
                point2B.setEnabled(true);
                point1B.setEnabled(true);
                point1.setEnabled(true);
                point3.setEnabled(true);
                point2.setEnabled(true);

            }
        });


    }

    public void display(int i) {
        TextView A_tv = findViewById(R.id.score_A);
        if (i >= 50) {
            A_tv.setText("" + i);
            Toast.makeText(MainActivity.this, " A is winner", Toast.LENGTH_SHORT).show();
            point3.setEnabled(false);
            point2.setEnabled(false);
            point1.setEnabled(false);
            point3B.setEnabled(false);
            point2B.setEnabled(false);
            point1B.setEnabled(false);

        } else {
            A_tv.setText("" + i);


        }
    }


    public void diplayB(int i) {
        TextView B_tv = findViewById(R.id.score_B);

        if (i >= 50) {

            Toast.makeText(MainActivity.this, " B is winner", Toast.LENGTH_SHORT).show();

            point3B.setEnabled(false);
            point2B.setEnabled(false);
            point1B.setEnabled(false);
            point1.setEnabled(false);
            point3.setEnabled(false);
            point2.setEnabled(false);

        } else {

            B_tv.setText("" + i);
        }
    }


}