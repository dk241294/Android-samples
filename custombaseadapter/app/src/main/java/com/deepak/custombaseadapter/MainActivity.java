package com.deepak.custombaseadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String []countryName={"afganistam","albania","australia","austria","madagascar","malawi",
            "maurities","mexico"};
    int[]image={R.drawable.albania,R.drawable.afghanistan,R.drawable.australia,R.drawable.austria,
            R.drawable.madagascar,R.drawable.maurities,R.drawable.malawi,R.drawable.mexico};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list);
        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),image,countryName);
        listView.setAdapter(customAdapter);



    }
}
