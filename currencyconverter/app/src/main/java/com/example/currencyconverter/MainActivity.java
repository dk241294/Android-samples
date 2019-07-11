package com.example.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button button;
    public void conversion(View view){
        EditText editText=findViewById(R.id.dollar);
        TextView textView=findViewById(R.id.rupee);
        String dollar = editText.getText().toString();
        Double ruppee = Double.parseDouble(dollar)*72;
        String inrupee = Double.toString(ruppee);
        editText.setText(dollar);
        textView.setText(inrupee);
        Toast.makeText(this, "$ "+dollar+" in rupee "+ ruppee,  Toast.LENGTH_SHORT).show();;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               conversion(v);
            }
        });
    }
}
