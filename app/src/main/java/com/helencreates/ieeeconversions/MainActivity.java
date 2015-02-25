package com.helencreates.ieeeconversions;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;



public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void decToSingle (View v) {

        EditText et_input = (EditText)findViewById(R.id.dec2convert);
        float singleFloat = Float.parseFloat(et_input.getText().toString());
        int singleInt = Float.floatToIntBits(singleFloat);
        String singleString = Integer.toBinaryString(singleInt);

        String finalString = "";

        EditText et_sign = (EditText)findViewById(R.id.sign);
        EditText et_exp = (EditText)findViewById(R.id.exponent);
        EditText et_man = (EditText)findViewById(R.id.mantissa);

        if (singleFloat >= 0) {
            et_sign.setText("0");
            finalString = "0000000000000000000000000000000".substring(singleString.length()) + singleString; //makes sure it's 31 digits long
        } else {
            et_sign.setText("1");
            finalString = singleString.substring(1);
        }

        String exponentString = finalString.substring(0,8);
        String mantissaString = finalString.substring(8,31);
        et_man.setText(mantissaString);
        et_exp.setText(exponentString);
    }

    public void decToDouble (View v) {

        EditText et_input = (EditText)findViewById(R.id.dec2convert);
        double doubleDouble = Double.parseDouble(et_input.getText().toString());
        String intBit = Long.toBinaryString(Double.doubleToLongBits(doubleDouble));

        String finalString = "";

        EditText et_sign = (EditText)findViewById(R.id.sign);
        EditText et_exp = (EditText)findViewById(R.id.exponent);
        EditText et_man = (EditText)findViewById(R.id.mantissa);

        if (doubleDouble >=0) {
            et_sign.setText("0");
            finalString = "000000000000000000000000000000000000000000000000000000000000000".substring(intBit.length()) + intBit; //makes sure it's 63 digits long
        } else {
            et_sign.setText("1");
            finalString = intBit.substring(1);
        }

        String exponentString = finalString.substring(0,11);
        String mantissaString = finalString.substring(11, 63);

        et_man.setText(mantissaString);
        et_exp.setText(exponentString);
    }

    public void clearFields (View v) {
        EditText et_input = (EditText)findViewById(R.id.dec2convert);
        EditText et_sign = (EditText)findViewById(R.id.sign);
        EditText et_exp = (EditText)findViewById(R.id.exponent);
        EditText et_man = (EditText)findViewById(R.id.mantissa);

        et_input.setText("");
        et_exp.setText("");
        et_sign.setText("");
        et_man.setText("");
    }

    public void changePage(View v) {
        Intent i = new Intent(MainActivity.this, BinaryToDecimal.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
