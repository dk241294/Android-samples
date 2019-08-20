package com.example.justforpractice;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    int finalPrice = 0;
    final static int PRICE_OF_QUANTITY = 100;
    ArrayList<Topping> toppings;
    ArrayList<Topping> selected_topping;
    int dileveryPrice=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        typeOfTopping();

        //setting on click listener on order button so that when button pressed it display quantity and price
        Button order = findViewById(R.id.order_button);
        order.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View v) {
                displayBill();
                dileveryOption();


            }
        });

        //setting on click listener on increment button to increment
        Button increment = findViewById(R.id.increment);
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity < 10) {
                    quantity++;
                    displayQuantity(quantity);
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
                    displayQuantity(quantity);

                }
            }

        });


    }

    //method to display number  added in the quantity TextView
    public void displayQuantity(int number) {
        final TextView tv = findViewById(R.id.no__of_Quantity);
        tv.setText("" + number);
    }

    // display the billname of (customer/quantity/topping/price)
    public void displayBill() {
        TextView bill = findViewById(R.id.order_summary_tv);
        bill.setText(customername() + "\n" + price());
    }

    //customer name
    public String customername() {
        EditText name = findViewById(R.id.name);
        String customer = name.getText().toString();
        return customer;
    }

    public String price() {

        finalPrice = quantity * (PRICE_OF_QUANTITY + toppingPrice());
        return NumberFormat.getCurrencyInstance().format(finalPrice);

    }

    //    public int toppingPrice() {
//        int toppingprice = 0;
//        for (Topping t : toppings) {
//            if (t.isSelected) {
//                toppingprice = toppingprice + t.getToppingPrice();
//            }
//        }
//        return toppingprice;
//
//    }
    public int toppingPrice() {
        int toppingprice = 0;
        for (Topping t : selected_topping) {
            toppingprice = toppingprice + t.getToppingPrice();
        }
        return toppingprice;

    }

    public void typeOfTopping() {
        toppings = new ArrayList<Topping>();
        toppings.add(new Topping("whipped cream", 10));
        toppings.add(new Topping("chocolate", 20));
        toppings.add(new Topping("cinnamon", 30));
        toppings.add(new Topping("ice cream", 50));
        toppings.add(new Topping("milk", 40));
        ToppingAdapter toppingAdapter = new ToppingAdapter(this, toppings);
        ListView listView = findViewById(R.id.toppingList);
        listView.setAdapter(toppingAdapter);
        selected_topping = new ArrayList<>();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, toppings.get(position).getToppingName(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "topping list working", Toast.LENGTH_SHORT).show();

                CheckBox topping_checkBox = view.findViewById(R.id.topping_checkbox);
                if (topping_checkBox.isChecked()) {
                    topping_checkBox.setChecked(false);
                    //    toppings.get(position).setSelected(false);
                    selected_topping.remove(toppings.get(position));


                } else {
                    topping_checkBox.setChecked(true);
                    //   toppings.get(position).setSelected(true);
                    selected_topping.add(toppings.get(position));


                }


            }
        });


    }

    public void dileveryOption() {
        final RadioGroup dilevery = findViewById(R.id.delivery_option);
        dilevery.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

              //  int selectedId = dilevery.getCheckedRadioButtonId();
                RadioButton yes = findViewById(R.id.yes);
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dileveryPrice = 24;
                    }
                });
                RadioButton no = findViewById(R.id.no);
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dileveryPrice=0;
                    }
                });


            }
        });

    }


}