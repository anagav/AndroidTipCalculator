package com.personal.sample.TipCalculator;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {

    EditText inputNumber;
    TextView result;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        inputNumber = (EditText) findViewById(R.id.inputNumber);

        result = (TextView) findViewById(R.id.result);
        findViewById(R.id.percent_10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAndCalculate(10);
            }
        });

        findViewById(R.id.percent_20).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAndCalculate(20);
            }
        });

        findViewById(R.id.percent_30).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAndCalculate(30);
            }
        });


    }

    private void checkAndCalculate(int i) {
        if (!checkIfValid()) {
            return;
        }
        result.setText(calculateTip(i, Float.valueOf(inputNumber.getText().toString())));
        result.setVisibility(View.VISIBLE);
        result.setTextColor(Color.GREEN);
    }

    private boolean checkIfValid() {
        if (inputNumber.getText() == null || inputNumber.getText().toString().trim().equals("")) {
            result.setText("    enter  a number");
            result.setTextColor(Color.RED);
            result.setVisibility(View.VISIBLE);
            return false;
        }
        return true;
    }

    public String calculateTip(int percentage, float total) {
        return Float.toString((total * percentage) / 100);
    }


}
