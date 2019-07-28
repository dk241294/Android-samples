package com.example.earthquake;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        public static final String LOG_TAG = MainActivity.class.getName();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Create a  list of earthquake locations.
            ArrayList<Earthquake> earthquakes = new ArrayList<>();
            earthquakes.add(new Earthquake("7.2","San Francisco","feb 2 2018"));
            earthquakes.add(new Earthquake("4.2","London","jan 21 2019"));
            earthquakes.add(new Earthquake("6.8","Tokyo","mar 15 2016"));
            earthquakes.add(new Earthquake("4.9","Mexico City","apr 5 2014"));
            earthquakes.add(new Earthquake("5.6","Moscow","may 6 2015"));
            earthquakes.add(new Earthquake("4.5","Mexico City","apr 15 2014"));
            earthquakes.add(new Earthquake("5.7","Moscow","may 3 2015"));

            // Find a reference to the {@link ListView} in the layout
            ListView earthquakeListView = (ListView) findViewById(R.id.list);

            // Create a new {@link ArrayAdapter} of earthquakes
            EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

            // Set the adapter on the {@link ListView}
            // so the list can be populated in the user interface
            earthquakeListView.setAdapter(adapter);
    }
}
