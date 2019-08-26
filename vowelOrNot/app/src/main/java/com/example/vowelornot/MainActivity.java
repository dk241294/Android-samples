package com.example.vowelornot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean isVowel;
    TextView tv;
    EditText charEtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        charEtv = findViewById(R.id.character_et);
        final Button checkButton = findViewById(R.id.check_button);
        tv = findViewById(R.id.yesOrNo);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              char ch=  mIsVowel(charEtv.getText().toString().trim().charAt(0));

                if (isVowel == true) {
                    tv.setText(ch+" is a vowel");

                } else {
                    if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z'))
                    tv.setText(ch+" is a consonant");
                    else{
                        tv.setText(ch+" is Not a Alphabate");
                    }
                }
                checkButton.setEnabled(false);

            }
        });
        Button resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("");
                charEtv.setText("");
                checkButton.setEnabled(true);
            }
        });

        charEtv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                Log.e(" before text", " before text");

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("changed text", " changed text");
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("after text", " after text");

            }
        });
    }

    public char mIsVowel(char ch) {

        isVowel = false;
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                isVowel = true;
        }

            return ch;
    }
}
