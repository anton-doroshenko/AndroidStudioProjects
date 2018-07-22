package com.example.anton.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Formatter;

public class MainActivity extends AppCompatActivity {

    TextView textView3;
    Button buttonOK;
    Button buttonCncl;
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

        textView3 = (TextView) findViewById(R.id.textView3);
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

                if(radioButton.isChecked()) { message = f.format("Фирма: %s", radioButton.getText().toString()).toString();}
                else if(radioButton2.isChecked()) { message = f.format("Фирма: %s", radioButton2.getText().toString()).toString();}
                else if(radioButton3.isChecked()) { message = f.format("Фирма: %s", radioButton3.getText().toString()).toString();}
                f = new Formatter();
                if(radioButton4.isChecked()) { message += f.format("%nТип товара: %s", radioButton4.getText().toString()).toString();}
                else if(radioButton5.isChecked()) { message += f.format("%nТип товара: %s", radioButton5.getText().toString()).toString();}
                else if(radioButton6.isChecked()) { message += f.format("%nТип товара: %s", radioButton6.getText().toString()).toString();}
                textView3.setText(message);
            }
        };
        View.OnClickListener onClBtnCncl = new View.OnClickListener(){
          @Override
          public void onClick(View v)
          {
              textView3.setText("");
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
}
