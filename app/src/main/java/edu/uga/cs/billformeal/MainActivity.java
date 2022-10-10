package edu.uga.cs.billformeal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * Main class that runs the app immediately once the app is opened.
 */
public class MainActivity extends AppCompatActivity {
    private EditText editNumDiners; // user input of number of diners
    private EditText editTotal; // user input of total
    private TextView billTotal; // final bill amount

    /**
     * Creates the app on start up. This is what will be shown on the screen.
     * @param savedInstanceState updates the current state of the application
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getting references to UI object
        billTotal= findViewById( R.id.billTotal);
        editTotal = (EditText) findViewById(R.id.editTotal);
        editNumDiners = (EditText) findViewById(R.id.editNumDiners);
        // 10%
        Button tenPercent = (Button) findViewById(R.id.tenPercent);
        // 15%
        Button fifteenPercent = (Button) findViewById(R.id.fifteenPercent);
        // 18%
        Button eighteenPercent = (Button) findViewById(R.id.eighteenPercent);

        tenPercent.setOnClickListener(new TenButtonClickListener());
        fifteenPercent.setOnClickListener(new FifteenButtonClickListener());
        eighteenPercent.setOnClickListener( new EighteenButtonClickListener());

    } // onCreate

    /**
    * Private class for when the user clicks on the '10' button.
    * This will apply the 10% tip to the final total of the bill. After that,
    * the program returns the bill with the tip added and divided by the number of party
    * members.
    */
    private class TenButtonClickListener implements View.OnClickListener {
        /**
        * Calculates the bill per person with 10% tip.
        * @param v new action event is applied
        */
        @Override
        public void onClick(View v) {
            double total; // get total
            int numDiners; // get num of diners
            double bill;

            try {
                // obtain the values entered by the user
                total = Double.parseDouble(editTotal.getText().toString());
                numDiners = Integer.parseInt(editNumDiners.getText().toString());
            } catch (NumberFormatException nfe) {
                // Toast is a short message displayed to the user
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Enter positive values",
                        Toast.LENGTH_SHORT);
                toast.show();
                billTotal.setText("$0.00");
                return;
            }

            // check if all values entered are positive
            if (total <= 0.0 || numDiners <= 0.0) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Enter positive values",
                        Toast.LENGTH_SHORT);
                toast.show();
                billTotal.setText("$0.00");
                return;
            } // if

            // compute and format the cost amount
            bill = (total + (.10*total))/numDiners;
            DecimalFormat df = new DecimalFormat("####0.00");

            // show the computed cost to the user
            billTotal.setText("$" + df.format( bill ));
        } // on click
    } // button click listener for ten percent

    /**
     * Private class for when the user clicks on the '15' button.
     * This will apply the 15% tip to the final total of the bill. After that,
     * the program returns the bill with the tip added and divided by the number of party
     * members.
     */
    private class FifteenButtonClickListener implements View.OnClickListener {
        /**
         * Calculates the bill per person with 15% tip.
         * @param v new action event is applied
         */
        @Override
        public void onClick(View v) {
            double total; // get total
            int numDiners; // get num of diners
            double bill;

            try {
                // obtain the values entered by the user
                total = Double.parseDouble(editTotal.getText().toString());
                numDiners = Integer.parseInt(editNumDiners.getText().toString());
            } catch (NumberFormatException nfe) {
                // Toast is a short message displayed to the user
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Enter positive values",
                        Toast.LENGTH_SHORT);
                toast.show();
                billTotal.setText("$0.00");
                return;
            }

            // check if all values entered are positive
            if (total <= 0.0 || numDiners <= 0.0) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Enter positive values",
                        Toast.LENGTH_SHORT);
                toast.show();
                billTotal.setText("$0.00");
                return;
            } // if

            // compute and format the cost amount
            bill = (total + (.15*total))/numDiners;
            DecimalFormat df = new DecimalFormat("####0.00");

            // show the computed cost to the user
            billTotal.setText("$" + df.format(bill));
        } // on click
    } // button click listener for fifteen percent

    /**
     * Private class for when the user clicks on the '18' button.
     * This will apply the 18% tip to the final total of the bill. After that,
     * the program returns the bill with the tip added and divided by the number of party
     * members.
     */
    private class EighteenButtonClickListener implements View.OnClickListener {
        /**
         * Calculates the bill per person with 18% tip.
         * @param v new action event is applied
         */
        @Override
        public void onClick(View v) {
            double total; // get total
            int numDiners; // get num of diners
            double bill;

            try {
                // obtain the values entered by the user
                total = Double.parseDouble(editTotal.getText().toString());
                numDiners = Integer.parseInt(editNumDiners.getText().toString());
            } catch (NumberFormatException nfe) {
                // Toast is a short message displayed to the user
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Enter positive values",
                        Toast.LENGTH_SHORT);
                toast.show();
                billTotal.setText("$0.00");
                return;
            }

            // check if all values entered are positive
            if (total <= 0.0 || numDiners <= 0.0) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Enter positive values",
                        Toast.LENGTH_SHORT);
                toast.show();
                billTotal.setText("$0.00");
                return;
            } // if

            // compute and format the cost amount
            bill = (total + (.18*total))/numDiners;
            DecimalFormat df = new DecimalFormat("####0.00");

            // show the computed cost to the user
            billTotal.setText("$" + df.format(bill));
        } // on click
    } // button click listener for eighteen percent
} // main