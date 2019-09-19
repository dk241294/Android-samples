package com.deepak.customarrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ArrayList<Animal> animalslist=new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list);
        animalslist.add(new Animal("chimpanze",R.drawable.chimpanze));

        animalslist.add(new Animal("goat",R.drawable.goat));
        animalslist.add(new Animal("horse",R.drawable.horse));
        animalslist.add(new Animal("kangaroo",R.drawable.kangaroo));
        animalslist.add(new Animal("lion",R.drawable.lion));
        animalslist.add(new Animal("mouse",R.drawable.mouse));
        animalslist.add(new Animal("otter",R.drawable.otter));
        animalslist.add(new Animal("ox",R.drawable.ox));
        animalslist.add(new Animal("panda",R.drawable.panda));
        animalslist.add(new Animal("sqirrel",R.drawable.sqirrel));

        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),R.layout.list_item,animalslist);

        listView.setAdapter(adapter);
    }


}
