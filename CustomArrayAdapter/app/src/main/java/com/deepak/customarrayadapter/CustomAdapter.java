package com.deepak.customarrayadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    private static final String TAG = "CustomAdapter";
    ArrayList<Animal>animalslist=new ArrayList<>();// it have data


    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Animal> objects) {
        super(context, resource,objects);
        animalslist=objects;


    }

    @Override
    public int getCount() {
        Log.d(TAG, "getCount: "+animalslist.size());
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d(TAG, "getView:  started");
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        ImageView img= convertView.findViewById(R.id.animalimage);
        Log.d(TAG, "getView: "+getItem(position));
        img.setImageResource(animalslist.get(position).getImage());
        TextView countryName= convertView.findViewById(R.id.animalname);
        countryName.setText(animalslist.get(position).getName());
        return convertView;
    }
}
