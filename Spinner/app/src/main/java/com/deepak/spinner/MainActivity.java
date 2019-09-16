package com.deepak.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = "MainActivity";
    Spinner list;
    ArrayList<String>listItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.spinner);
        list.setOnItemSelectedListener(this);
        listItem=new ArrayList<String>();
        listItem.add("deepak");
        listItem.add("kumar");
        listItem.add("singh");
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),R.layout.list_item,listItem);
        //have the textview in dropdown manner in simple_spinner_dropdown_item layout
        //here we have textview which we which we show in android.R.layout.simple_spinner_dropdown_item manner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        list.setAdapter(adapter);


}

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),"item selected"+listItem.get(position),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
