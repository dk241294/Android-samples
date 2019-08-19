package com.example.justforpractice;

import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    ArrayList<Topping> toppings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting on click listener on order button so that when button pressed it display quantity and price
        Button order = findViewById(R.id.order_button);
        order.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View v) {

//                CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream);
//                boolean hasWhipppedCream = whippedCreamCheckBox.isChecked();
//
//                CheckBox chocolateCheckBox = findViewById(R.id.add_chocolate);
//                boolean haschocalate = chocolateCheckBox.isChecked();
//
//                  displaymessage(createOrderSummary(quantity, haschocalate, hasWhipppedCream));
                displaymessage(createOrderSummary(quantity));


            }
        });

        //setting on click listener on increment button to increment
        Button increment = findViewById(R.id.increment);
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity < 10) {
                    quantity++;
                    display(quantity);
                } else {
                    Toast.makeText(MainActivity.this, "we take maximum order of 10", Toast.LENGTH_SHORT).show();
                }


            }
        });

        //setting on click listener to decrement button to decrement
        Button decrement = findViewById(R.id.decrement);
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity <= 0) {

                    Toast.makeText(MainActivity.this, "enter some quantity", Toast.LENGTH_SHORT).show();

                } else {

                    quantity--;
                    display(quantity);

                }
            }

        });

        toppings = new ArrayList<>();
        toppings.add(new Topping("chocolate",3));
        toppings.add(new Topping("whipped cream",1));
        ToppingAdapter toppingAdapter = new ToppingAdapter(this, toppings);
        ListView listView = findViewById(R.id.toppingList);
        listView.setAdapter(toppingAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               if( toppings.get(position).isSelected()){
                   toppings.get(position).setSelected(false);
               }else{
                   toppings.get(position).setSelected(true);
               }
                CheckBox c = view.findViewById(R.id.topping_checkbox);
               if(c.isChecked()){
                   c.setChecked(false);
               }else
                c.setChecked(true
                );
            }
        });

    }

    //method to display number  added in the quantity TextView
    public void display(int number) {
        final TextView tv = findViewById(R.id.no__of_Quantity);
        tv.setText("" + number);
    }

    // display the price
    public void displaymessage(String message) {
        TextView order_Summary = findViewById(R.id.order_summary_tv);
        order_Summary.setText(message);
    }

    //customer name
    public String customername() {
        EditText name = findViewById(R.id.name);
        String customer = name.getText().toString();
        return customer;
    }

    // calculating the price
//    public int price_calculate(boolean haschocoalate, boolean haswhippedcream) {
//        int baseprice = 10;
//        if (haschocoalate) {
//            baseprice = baseprice + 1;
//        }
//        if (haswhippedcream) {
//            baseprice = baseprice + 2;
//        }

    //        return quantity * baseprice;
//
//    }
    public int price_calculate() {
        int toppingsPrice=0;
        for(Topping t:toppings)
        {
            if(t.isSelected()){
              toppingsPrice += t.getToppingPrice();
            }
        }
       int finalPrice = quantity*(toppingsPrice + 10);
        return finalPrice;
    }

    //dispalying the bill and call at price_text_view
    @RequiresApi(api = Build.VERSION_CODES.N)
//    public String createOrderSummary(int i, boolean haschocalate, boolean hasWhipppedCream)
    public String createOrderSummary(int i) {
        String bill = customername() + "\n Quantity: " + quantity + "\n total " + NumberFormat.getCurrencyInstance().format(price_calculate()) + "\n Thank You";
        return bill;
    }


}