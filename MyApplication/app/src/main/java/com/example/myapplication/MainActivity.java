package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int numberOfCoffee = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view){

        CheckBox whippedCreamCheckBox=findViewById(R.id.checkBox);
        boolean hasWippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity","haswippedCReam"+whippedCreamCheckBox);
        int price=calculatePrice();
        String priceMessage= createOrderSummary(price,hasWippedCream);
        displayMessage(priceMessage);


    }

    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice() {
         int price = numberOfCoffee * 5;
         return price;
    }
    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        numberOfCoffee= numberOfCoffee+1;
        display(numberOfCoffee);
    }
    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {

        numberOfCoffee = numberOfCoffee-1;
        display(numberOfCoffee);

    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
    private String createOrderSummary(int price,boolean addWhippedCream){
        String priceMessage="name :deepak kumar";
        priceMessage +="\nadd whipedCream ? " + addWhippedCream;
        priceMessage +="\nquantity: " + numberOfCoffee;
        priceMessage +="\ntotal price:" + price;
        return priceMessage;
    }
}
