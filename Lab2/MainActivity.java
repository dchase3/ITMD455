package com.example.densi.itmd455hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button calculate;
    private EditText meal;
    private EditText tax;
    private EditText tip;
    private EditText totalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate = findViewById(R.id.CalculateTotalCost);
        meal = findViewById(R.id.MealCostInput);
        tax = findViewById(R.id.TaxInput);
        tip = findViewById(R.id.TipInput);
        totalCost = findViewById(R.id.TotalOutput);

        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makeCalculation();
            }
        });
    }

    private void makeCalculation() {
        double ml = Double.valueOf(meal.getText().toString());
        double tx = Double.valueOf(tax.getText().toString());
        double tp = Double.valueOf(tip.getText().toString());
        double result = ml+(ml*(tx/100))+(ml*(tp/100));
        totalCost.setText(Double.toString(result));
    }

}
