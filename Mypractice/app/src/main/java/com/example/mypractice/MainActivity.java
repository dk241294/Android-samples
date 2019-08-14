package com.example.mypractice;

import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    int price_of_cup = 10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button order = findViewById(R.id.order_button);
        //setting on click listener on order button so that when button pressed it display quantity and price
        order.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View v) {
                displaymessage(createOrderSummary(quantity));


            }
        });

        Button increment = findViewById(R.id.increment);
        //setting on click listener on increment button to increment
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                display(quantity);


            }
        });



        Button decrement = findViewById(R.id.decrement);
        //setting on click listener to decrement button to decrement
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

    }

//   public void delivery() {
//            final RadioGroup radio =findViewById(R.id.delivery_option);
//            radio.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (radio=){}
//
//                }
//            });
//        }


    //method to display number  added in the quantity TextView
    public void display(int number) {
        final TextView tv = findViewById(R.id.no__of_Quantity);
        tv.setText("" + number);
    }

    //method to display price of coffee
    // @RequiresApi(api = Build.VERSION_CODES.N)
    //    public void price(int number) {
    //        price_textView = findViewById(R.id.price_text_view);
    //        price_textView.setText(NumberFormat.getCurrencyInstance().format(number));
    //    }


    // display the price
    public void displaymessage(String message) {
        TextView order_Summary = findViewById(R.id.order_summary_tv);
        order_Summary.setText(message);

    }
    //customer name
    public String customeername(){
        EditText name =findViewById(R.id.name);
        String customer=name.getText().toString();
        return customer;

    }

    // calculating the price
    public int price_calculate() {
        int price = quantity * price_of_cup;
        return price;
    }

    //dispalying the bill and call at price_text_view
    @RequiresApi(api = Build.VERSION_CODES.N)
    public String createOrderSummary(int i) {
        String bill = customeername()+ "\n Quantity: " + quantity + "\n total " + NumberFormat.getCurrencyInstance().format(price_calculate()) + "\n Thank You";
        return bill;
    }

}
