package com.example.lab_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.Formatter;

import static android.content.Intent.EXTRA_TEXT;

public class MainActivity extends AppCompatActivity {

    public static final String SAVED_TEXT = "saved_text";

    Button buttonOK;
    Button buttonCncl;
    Button buttonOpen;
    RadioButton radioButton;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioButton radioButton5;
    RadioButton radioButton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOK = (Button) findViewById(R.id.buttonOK);
        buttonCncl = (Button) findViewById(R.id.buttonCncl);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        radioButton5 = (RadioButton) findViewById(R.id.radioButton5);
        radioButton6 = (RadioButton) findViewById(R.id.radioButton6);

        View.OnClickListener onClBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Formatter f = new Formatter();
                String message = "";


                SharedPreferences sPref = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor ed = sPref.edit();


                //Toast.makeText(this, "Text saved", Toast.LENGTH_LONG).show();
                if(radioButton.isChecked()) { message = f.format("Фирма: %s", radioButton.getText().toString()).toString();}
                else if(radioButton2.isChecked()) { message = f.format("Фирма: %s", radioButton2.getText().toString()).toString();}
                else if(radioButton3.isChecked()) { message = f.format("Фирма: %s", radioButton3.getText().toString()).toString();}
                f = new Formatter();
                if(radioButton4.isChecked()) { message += f.format("%nТип товара: %s", radioButton4.getText().toString()).toString();}
                else if(radioButton5.isChecked()) { message += f.format("%nТип товара: %s", radioButton5.getText().toString()).toString();}
                else if(radioButton6.isChecked()) { message += f.format("%nТип товара: %s", radioButton6.getText().toString()).toString();}
                ed.putString(SAVED_TEXT, message);
                ed.commit();
            }
        };
        View.OnClickListener onClBtnCncl = new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                radioButton.setChecked(false);
                radioButton2.setChecked(false);
                radioButton3.setChecked(false);
                radioButton4.setChecked(false);
                radioButton5.setChecked(false);
                radioButton6.setChecked(false);
            }
        };
        buttonOK.setOnClickListener(onClBtnOk);
        buttonCncl.setOnClickListener(onClBtnCncl);
    }
    public void onClick(View v)
    {
        SharedPreferences sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "");
        Toast.makeText(this, savedText, Toast.LENGTH_SHORT).show();
        try{
        Intent intent = new Intent(this, OutputActivity.class);
        intent.putExtra(SAVED_TEXT, savedText);
        // intent.putExtra(EXTRA_SIZE, str2);
        startActivity(intent);}
        catch(Exception e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
