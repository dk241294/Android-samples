package com.example.androidversion;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AndroidFlavourAdapter extends ArrayAdapter<AndroidFlavour> {
    public AndroidFlavourAdapter(Activity context, ArrayList<AndroidFlavour>androidFlavours) {
        super(context, 0,androidFlavours);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        AndroidFlavour currentAndroidFlavour = getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.version_Name);
        nameTextView.setText(currentAndroidFlavour.getVersionName());

        TextView numberTextView = listItemView.findViewById(R.id.version_Number);
        numberTextView.setText(currentAndroidFlavour.getVersionNumber());

        ImageView imageView = listItemView.findViewById(R.id.version_image);
        imageView.setImageResource(currentAndroidFlavour.getImageResourceId());

        return listItemView;
    }
}
