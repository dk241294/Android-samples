package com.example.videodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView = findViewById(R.id.videoView2);

        videoView.setVideoPath("android.resource://"+ getPackageName() + "/" + R.raw.demo);
        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}
