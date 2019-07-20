package com.example.activitylifecycle;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String  TAG = MainActivity.class.getSimpleName();
   private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"method onCreate");
        editText = findViewById(R.id.edit_text);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"method onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"method on resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"mehod onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"method onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"method onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"method on Destroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG,"method onSavedInstance state");
        outState.putString("sample key",editText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"method onRestoreInstance state");
        editText.setText(savedInstanceState.getString("sample key"));

    }
}

