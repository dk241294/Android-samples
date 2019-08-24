package com.example.justforpractice;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class ToppingAdapter extends ArrayAdapter {
ArrayList<Topping> toppins;
    public ToppingAdapter(Activity context, ArrayList<Topping> toppings) {
        super(context, 0, toppings);
        this.toppins = toppings;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitem = convertView;
        if (listitem == null) {
            listitem = LayoutInflater.from(getContext()).inflate(R.layout.topping_list, parent, false);
        }
        Topping currentTopping = (Topping) toppins.get(position);

        CheckBox toppingName = listitem.findViewById(R.id.topping_checkbox);
        toppingName.setText(currentTopping.getToppingName());
        toppingName.setChecked(currentTopping.isSelected);
        TextView toppingPrice = listitem.findViewById(R.id.price_of_Topping);
        toppingPrice.setText(String.valueOf(currentTopping.getToppingPrice()));

        return listitem;


    }

    @Override
    public int getCount() {
        return toppins!=null?toppins.size():0;
    }

    public void setToppins(ArrayList<Topping> toppins) {
        this.toppins = toppins;
        notifyDataSetChanged();

    }
}
