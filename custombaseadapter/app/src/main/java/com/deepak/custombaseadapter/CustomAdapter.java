package com.deepak.custombaseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private int[] image;
    private String[] countryName;

    CustomAdapter(Context context, int[] image, String[] countryName) {
        this.context = context;
        this.image = image;
        this.countryName = countryName;
    }

    @Override
    public int getCount() {
        return countryName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        ImageView countryimage = convertView.findViewById(R.id.flag_image);
        countryimage.setImageResource(image[position]);
        TextView Name = convertView.findViewById(R.id.country_name);
       Name.setText(countryName[position]);

        return convertView;
    }
}
