package com.example.androidversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<AndroidFlavour> androidFlavours = new ArrayList<AndroidFlavour>();
        androidFlavours.add(new AndroidFlavour("Donut", R.drawable.donut, "1.6"));
        androidFlavours.add(new AndroidFlavour("eclair", R.drawable.eclair, "2.0-2.1"));
        androidFlavours.add(new AndroidFlavour("Froyo", R.drawable.froyo, "2.2-2.2.3"));
        androidFlavours.add(new AndroidFlavour("Ginger Bread", R.drawable.gingerbread, "2.3-2.3.7"));
        androidFlavours.add(new AndroidFlavour("Honey Comb", R.drawable.honeycomb, "3.0-3.2.6"));
        androidFlavours.add(new AndroidFlavour("Ice Cream ", R.drawable.icecream, "4.0-4.0.4"));
        androidFlavours.add(new AndroidFlavour("Jelly Bean", R.drawable.jellybean, "4.1-4.3.1"));
        androidFlavours.add(new AndroidFlavour("Kit Kat", R.drawable.kitkat, "4.4-4.4.4"));
        androidFlavours.add(new AndroidFlavour("Lollipop", R.drawable.lollipop, "5.0-5.1.1"));
        androidFlavours.add(new AndroidFlavour("Marshmallow", R.drawable.marshmallow, "6.0-6.0.1"));

        Log.i("this", "Android Flavour at index [0]:" + androidFlavours.get(0));

        AndroidFlavourAdapter androidFlavourAdapter = new AndroidFlavourAdapter(this,androidFlavours);

        ListView listView = findViewById(R.id.flavour_list);

        listView.setAdapter(androidFlavourAdapter);
    }
}
