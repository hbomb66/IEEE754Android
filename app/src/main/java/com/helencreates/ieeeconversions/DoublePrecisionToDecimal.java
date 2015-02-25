package com.helencreates.ieeeconversions;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.math.BigInteger;


public class DoublePrecisionToDecimal extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_precision_to_decimal);
    }

    public void binToDec(View v) {

        EditText signInput = (EditText)findViewById(R.id.signToDec);
        String signFloat = signInput.getText().toString();
        EditText expInput = (EditText)findViewById(R.id.expToDec);
        String expFloat = expInput.getText().toString();
        EditText manInput = (EditText)findViewById(R.id.manToDec);
        String manFloat = manInput.getText().toString();

        String fullInput = signFloat + expFloat + manFloat;

        double fullDouble = Double.longBitsToDouble(new BigInteger(fullInput, 2).longValue());

        String finalDouble = String.valueOf(fullDouble);

        EditText convertedDec = (EditText)findViewById(R.id.finalDec);
        convertedDec.setText(finalDouble);
    }

    public void clearFields2 (View v) {
        EditText binInput = (EditText)findViewById(R.id.signToDec);
        EditText expInput = (EditText)findViewById(R.id.expToDec);
        EditText manInput = (EditText)findViewById(R.id.manToDec);
        EditText convertedDec = (EditText)findViewById(R.id.finalDec);

        binInput.setText("");
        expInput.setText("");
        manInput.setText("");
        convertedDec.setText("");
    }

    public void changePage(View v) {
        Intent i = new Intent(DoublePrecisionToDecimal.this, MainActivity.class);
        startActivity(i);
    }

    public void changePageToSinglePrec(View v) {
        Intent i = new Intent(DoublePrecisionToDecimal.this, BinaryToDecimal.class);
        startActivity(i);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_double_precision_to_decimal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
