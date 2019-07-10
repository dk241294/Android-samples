package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        getSupportActionBar().setTitle("Number");

      //  String words[]=new String[]{"one","two","three","four","five","six","seven","eight","nine","ten"};
      /**  String words[]=new String[10];
        words[0]="one";
        words[1]="two";
        words[2]="three";
        words[3]="four";
        words[4]="five";
        words[5]="six";
        words[6]="seven";
        words[7]="eight";
        words[8]="nine";
        words[9]="ten";
        Log.v("numberActivity","words:" + words[0]); **/
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "lutti"));
        words.add(new Word("two", "otiiko"));
        words.add(new Word("three", "tolookosu"));
        words.add(new Word("four", "oyyisa"));
        words.add(new Word("five", "massokka"));
        words.add(new Word("six", "temmokka"));
        words.add(new Word("seven", "kenekaku"));
        words.add(new Word("eight", "kawinta"));
        words.add(new Word("nine", "wo’e"));
        words.add(new Word("ten", "na’aacha"));


        /** LinearLayout rootView = findViewById(R.id.rootview);

         int index = 0;
         while(index< words.size()){
             TextView wordView = new TextView(this);
              wordView.setText(words.get(index));
              rootView.addView(wordView);
             index++;
         } **/
        WordAdapter  adapter=new WordAdapter(this,words);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}
