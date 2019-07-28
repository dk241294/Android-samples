package com.example.earthquake;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Activity context,ArrayList<Earthquake>Earthquake) {
        super(context, 0, Earthquake);
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        Earthquake currentearthquake=getItem(position) ;
        View listitemView = convertView;
        if(listitemView==null){
            listitemView=LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item,parent,false);
        }
        TextView magnitudeTextView= listitemView.findViewById(R.id.magnitude);
        magnitudeTextView.setText(currentearthquake.getMagnitude());
        TextView locationView= listitemView.findViewById(R.id.location) ;
        locationView.setText(currentearthquake.getLocation());
        TextView timeTextView= listitemView.findViewById(R.id.time);
        timeTextView.setText(currentearthquake.getdate());
        return listitemView;

    }
}

