package com.souto.rcircuitcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edtVin, edtR1, edtR2; // Import the input values
    TextView txtResult, txtVout; // Import the output value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This would remove the navigation and status bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION); // Navigation
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Status

        // The next 2 lines remove the status bar on top of the screen
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        // this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide(); // Removes the action bar on top

        setContentView(R.layout.activity_main);

        edtVin = findViewById(R.id.edtVin); // Attributing EditText edtVin to the view
        edtR1 = findViewById(R.id.edtR1);   // Attributing EditText edtR1 to the view
        edtR2 = findViewById(R.id.edtR2);   // Attributing EditText edtR2 to the view

        txtResult = findViewById(R.id.txtResult); // Attributing EditText txtVout to the view
        txtVout = findViewById(R.id.txtVout);
    }

    public void calculate(View view) {
        double vin = Double.parseDouble(edtVin.getText().toString());
        double r1 = Double.parseDouble(edtR1.getText().toString());
        double r2 = Double.parseDouble(edtR2.getText().toString());

        double vout = vin * (r2/(r1+r2));

        // Format the output with 2 decimal numbers
        DecimalFormat decimal = new DecimalFormat("0.00");
        String trueValue = decimal.format(vout);

        // Set the text output from each view
        txtResult.setText(trueValue + " ohm");
        txtVout.setText("Vout:");
    }


}