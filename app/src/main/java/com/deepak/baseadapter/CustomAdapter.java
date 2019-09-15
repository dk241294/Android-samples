package com.deepak.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {

   Context context;
   //LayoutInflater inflater;
   int animal[];

    public CustomAdapter(Context context, int[] animal) {
        this.context = context;
        this.animal = animal;
    }

    @Override
    public int getCount() {
        return animal.length;
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
        convertView=LayoutInflater.from(context).inflate(R.layout.grid_item_view,parent,false);
       // convertView= inflater.inflate(R.layout.grid_item_view,parent,false);
        ImageView icon = convertView.findViewById(R.id.image);
        icon.setImageResource(animal[position]);
        return convertView;
    }
}
