package com.example.toastdemo;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void clickme(View view){
        EditText editText=findViewById(R.id.editText);
        Toast.makeText(this, "hello"+editText.getText().toString(), Toast.LENGTH_SHORT).show();
        ImageView imageview=findViewById(R.id.imageView);
        imageview.setImageResource(R.drawable.hsscphoto);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
