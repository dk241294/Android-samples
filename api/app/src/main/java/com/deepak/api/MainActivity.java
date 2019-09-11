package com.deepak.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button requestQuery;
    public static TextView response;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQuery=findViewById(R.id.query_Button);
        response=findViewById(R.id.response_view);
        requestQuery.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: button click");
        Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();
        Retrivedata process = new Retrivedata();
        process.execute();
    }
}