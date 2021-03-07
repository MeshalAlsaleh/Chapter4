package com.example.chapter4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double conversionRate = 2.2;
    double weightEntered;
    double convertedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText weight = (EditText)findViewById(R.id.txtWeight);
        final RadioButton lbToKilo = (RadioButton)findViewById(R.id.radLbToKilo);
        final RadioButton kiloToLb = (RadioButton)findViewById(R.id.radKiloToLb);
        final TextView result = (TextView)findViewById(R.id.txtResult);

        Button convert = (Button)findViewById(R.id.button);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              weightEntered = Double.parseDouble(weight.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.#");
                if(weightEntered <=500){
                    if(lbToKilo.isChecked()){
                        convertedWeight = weightEntered / conversionRate;
                        result.setText(tenth.format(convertedWeight) + " Kilograms");
                    } else {
                        convertedWeight = weightEntered * conversionRate;
                        result.setText(tenth.format(convertedWeight) + " Pounds");
                    }

                    } else{
                        Toast.makeText(MainActivity.this,"Pounds must be less than 500", Toast.LENGTH_LONG).show();
                    }

            }
        });
    }
}