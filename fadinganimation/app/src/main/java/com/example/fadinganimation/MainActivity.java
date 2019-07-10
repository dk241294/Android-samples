package com.example.fadinganimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView barterImageView=findViewById(R.id.bartsimpsonimageView);
    private ImageView homerImageView=findViewById(R.id.homersimpsonimageView);


    public void fade(View view) {
        barterImageView.animate().alpha(0).setDuration(2000);
        homerImageView.animate().alpha(1).setDuration(2000);
    }


    public void moveRight(View view) {
        barterImageView.animate().translationXBy(1000).setDuration(1000);
    }

    public void moveLeft(View view) {
        barterImageView.animate().translationXBy(-1000).setDuration(1000);
    }

    public void rotate(View view) {
        barterImageView.animate().rotation(18).setDuration(1000);
    }

    public void rotateOnYaxis(View view) {
        barterImageView.animate().rotationYBy(-1800).alpha(0).setDuration(1000);
    }

    public void scale(View view) {
        barterImageView.animate().scaleX(0.5f).scaleY(0.5f);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
