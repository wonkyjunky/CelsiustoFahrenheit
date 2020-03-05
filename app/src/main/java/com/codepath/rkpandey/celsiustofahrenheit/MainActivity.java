package com.codepath.rkpandey.celsiustofahrenheit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText celsiusIn;
    private Button ConvertButton;
    private TextView convertedValue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        celsiusIn = findViewById(R.id.editTextCelsiusIn);
        ConvertButton = findViewById(R.id.button);
        convertedValue = findViewById(R.id.textViewConverValue);

        ConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double value = 0.0;
                value = getCelsiusValue(celsiusIn);
                value = convertCtoF(value);
                updateDisplay(convertedValue, value);
            }
        });

        ConvertButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FahrenheittoCelsius.class);
                startActivity(intent);

                return false;
            }
        });
    }

    private void updateDisplay(TextView convertedValue, double value) {
        convertedValue.setText(value+"F");
    }

    private double convertCtoF(double value) {
        double fahrenheitValue = 0.0;
        fahrenheitValue = value * (9.0/5.0);
        fahrenheitValue += 32;

        return fahrenheitValue;
    }

    private double getCelsiusValue(EditText celsiusIn) {
        double celsiusValue = 0.0;

        try {
            celsiusValue = Double.parseDouble(celsiusIn.getText().toString());
        } catch (NumberFormatException e){
            System.out.println("conversion error..."+e);
        }

        return celsiusValue;
    }
}
