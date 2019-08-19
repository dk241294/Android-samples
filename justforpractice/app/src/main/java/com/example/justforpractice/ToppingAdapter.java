package com.example.justforpractice;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ToppingAdapter extends ArrayAdapter {

    public ToppingAdapter(Activity context, ArrayList<Topping> toppings) {
        super(context, 0, toppings);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitem = convertView;
        if (listitem == null) {
            listitem = LayoutInflater.from(getContext()).inflate(R.layout.topping_list, parent, false);
        }
        Topping currentTopping = (Topping) getItem(position);
        TextView toppingName = listitem.findViewById(R.id.topping_checkbox);
        toppingName.setText(currentTopping.getToppingName());

        //TextView toppingPrice = listitem.findViewById(R.id.price_of_Topping);
       // toppingPrice.setText(currentTopping.getToppingPrice());

        return listitem;


    }
}
