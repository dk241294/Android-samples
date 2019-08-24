package com.example.justforpractice;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int quantity = 0;
    int finalPrice = 0;
    final static int PRICE_OF_QUANTITY = 100;
    ArrayList<Topping> toppings;
    HashSet<Topping> selected_topping;
    ArrayList<String> cofeeType;
    int dileveryPrice = 0;
    RadioGroup dileveryRg;
    RadioButton rb;
    boolean deliveryOptionSelected;
    boolean quantitySelected;
    boolean customerNameSelected;
    Button decrement;
    Button increment;
    ListView toppingListView;
    Button toolBarButtonReset = null;
    CheckBox topping_checkBox;
    TextView bill;
    int toppingprice = 0;
    ToppingAdapter toppingAdapter;
    Button orderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        typeOfTopping();
        coffeeOption();
        dileveryOption();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolBarButtonReset = findViewById(R.id.tool_bar_button);
        toolBarButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dileveryRg.clearCheck();
                for (int i = 0; i < dileveryRg.getChildCount(); i++) {
                    dileveryRg.getChildAt(i).setEnabled(true);
                }
                decrement.setEnabled(true);
                increment.setEnabled(true);
                toppingListView.setEnabled(true);
                if (toppingAdapter != null) {
                    for (Topping t : toppings) {
                        t.setSelected(false);
                    }
                    toppingAdapter.setToppins(toppings);

                }
                finalPrice = 0;
                dileveryPrice = 0;
                quantity = 0;
                toppingprice = 0;
                displayQuantity(quantity);
                orderButton.setEnabled(true);


            }
        });



        //setting on click listener on order button so that when button pressed it display quantity and price
        orderButton = findViewById(R.id.order_button);
        orderButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (deliveryOptionSelected && quantitySelected) {
                    for (int i = 0; i < dileveryRg.getChildCount(); i++) {
                        dileveryRg.getChildAt(i).setEnabled(false);
                    }
                    decrement.setEnabled(false);
                    increment.setEnabled(false);
                    orderButton.setEnabled(false);
                    toppingListView.setEnabled(false);
//                   for (Topping t : toppings) {
//                         t.setSelected(false);
//                    }



                    displayBill();
                } else {
                    if ((deliveryOptionSelected == true) && (quantitySelected == false)) {
                        Toast.makeText(MainActivity.this, "select atleast 1 quantity", Toast.LENGTH_SHORT).show();
                    } else {
                        if ((deliveryOptionSelected == false) && (quantitySelected == true)) {
                            Toast.makeText(MainActivity.this, "select dilevery option", Toast.LENGTH_LONG).show();

                        } else {

                            Toast.makeText(MainActivity.this, "select quantity , dilevery option and customer name please!!!", Toast.LENGTH_SHORT).show();
                        }

                    }

                }

            }
        });

        //setting on click listener on increment button to increment
        increment = findViewById(R.id.increment);
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
        decrement = findViewById(R.id.decrement);
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
        if (number > 0) {
            quantitySelected = true;

            tv.setText("" + number);
        } else {
            quantitySelected = false;

            tv.setText("" + number);
        }

    }

    // display the billname of (customer/quantity/topping/price)
    public void displayBill() {
        bill = findViewById(R.id.order_summary_tv);
        StringBuilder stringBuilder = new StringBuilder();
        bill.setText(customername());
        if (price() == 0) {
            bill.setText("\n " + NumberFormat.getCurrencyInstance().format(price()));
            bill.setTextColor(Color.parseColor("#FF0000"));
        } else {
            stringBuilder.append(customername()).append("\n").append(NumberFormat.getCurrencyInstance().format(price()));
            // bill.setText("\n "+customername()+"\n"+NumberFormat.getCurrencyInstance().format(price()));
            bill.setText(stringBuilder);
            bill.setTextColor(Color.parseColor("#000000"));
        }
    }

    //customer name
    public String customername() {
        EditText name = findViewById(R.id.name);
        String customer = name.getText().toString();
        return customer;
    }

    public int price() {

        if (quantity > 0) {

            finalPrice = quantity * (PRICE_OF_QUANTITY + toppingPrice()) + dileveryPrice;
        } else {
            Toast.makeText(MainActivity.this, "select quantity", Toast.LENGTH_SHORT).show();
        }
        return finalPrice;


    }

    public int toppingPrice() {
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
        toppingAdapter = new ToppingAdapter(this, toppings);
        toppingListView = findViewById(R.id.toppingList);
        toppingListView.setAdapter(toppingAdapter);
        selected_topping = new HashSet<>();
        toppingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, toppings.get(position).getToppingName(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, "topping list working", Toast.LENGTH_SHORT).show();

                topping_checkBox = view.findViewById(R.id.topping_checkbox);
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
        dileveryRg = findViewById(R.id.delivery_option);
        dileveryRg.clearCheck();
        dileveryRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                deliveryOptionSelected = true;
                rb = group.findViewById(checkedId);

                // Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
                if (checkedId == R.id.yes) {
                    dileveryPrice = 25;
                } else {
                    dileveryPrice = 0;

                }

            }
        });

    }


    public void coffeeOption() {
        Spinner spinner = findViewById(R.id.cofeetype);
        spinner.setOnItemSelectedListener(MainActivity.this);
        cofeeType = new ArrayList<>();
        cofeeType.add("latee");
        cofeeType.add("capuccino");
        cofeeType.add("espresso");

        ArrayAdapter<String> coffeeAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, cofeeType);
        coffeeAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(coffeeAdapter);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, cofeeType.get(position), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}