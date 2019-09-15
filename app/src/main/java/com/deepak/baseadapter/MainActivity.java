package com.deepak.baseadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    int[]animal={R.drawable.cat,R.drawable.dog,R.drawable.elephant,R.drawable.zebra};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.simplegrid);
        CustomAdapter customAdapter =new CustomAdapter(getApplicationContext(),animal);
        gridView.setAdapter(customAdapter);

    }
}
