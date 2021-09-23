package com.example.loancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextView finalTotal;
    private EditText editPrice;
    private EditText editDownPayment;
    private EditText editInterestRate;
    private EditText editLengthLoan;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        finalTotal = findViewById(R.id.finalTotal);
        editPrice = findViewById(R.id.editPrice);
        editDownPayment = findViewById(R.id.editDownPayment);
        editInterestRate = findViewById(R.id.editInterestRate);
        editLengthLoan = findViewById(R.id.editLengthLoan);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double price = Double.parseDouble((editPrice.getText().toString()));
                double down = Double.parseDouble(editDownPayment.getText().toString());
                price -= down;
                double intr = Double.parseDouble(editInterestRate.getText().toString())/100;
                double length = Double.parseDouble(editLengthLoan.getText().toString());
                double p = intr*price/(1-Math.pow(1+intr,length));
//                double p = Math.pow(intr * price / (1 - (1 + intr)), -length);
                finalTotal.setText("Total: $" + p);
            }
        });
    }
}