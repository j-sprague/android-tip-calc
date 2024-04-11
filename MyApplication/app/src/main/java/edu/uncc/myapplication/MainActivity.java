package edu.uncc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView answer = findViewById(R.id.answer);
        Button button = findViewById(R.id.button);
        EditText billInput = findViewById(R.id.bill);
        EditText tipInput = findViewById(R.id.tip);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double tipPercent = Double.parseDouble(tipInput.getText().toString());
                    double bill = Double.parseDouble(billInput.getText().toString());

                    double tipCalc = bill * tipPercent * .01;
                    double totalCalc = bill + (bill * tipPercent * .01);

                    String statement = "The total bill is $" +
                            String.format("%.2f",totalCalc) +
                            " and the tip is $" +
                            String.format("%.2f",tipCalc);
                    answer.setText(statement);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Please fill out both fields", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}