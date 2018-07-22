package com.example.lab_2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Formatter;

public class MainActivity extends AppCompatActivity {

    TextView company;
    TextView typeOfProduct;
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

        Fragment fragment1 = new Fragment1();
        Fragment fragment2 = new Fragment2();
        Fragment fragment3 = new Fragment3();

        FragmentTransaction ft = getFragmentManager().beginTransaction();

        ft.add(R.id.fragment1, fragment1);
        ft.add(R.id.fragment2, fragment2);
        ft.add(R.id.fragment3, fragment3);

        ft.commit();
    }

    public void onClick(View v)
    {
        Formatter f = new Formatter();

        Fragment fragment3 = getFragmentManager().findFragmentById(R.id.fragment3);
        Fragment fragment2 = getFragmentManager().findFragmentById(R.id.fragment2);
        Fragment fragment1 = getFragmentManager().findFragmentById(R.id.fragment1);

        company = (TextView) fragment3.getView().findViewById(R.id.company);
        typeOfProduct = (TextView) fragment3.getView().findViewById(R.id.typeOfProduct);
        radioButton = (RadioButton) fragment1.getView().findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) fragment1.getView().findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) fragment1.getView().findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) fragment2.getView().findViewById(R.id.radioButton4);
        radioButton5 = (RadioButton) fragment2.getView().findViewById(R.id.radioButton5);
        radioButton6 = (RadioButton) fragment2.getView().findViewById(R.id.radioButton6);

        if(radioButton.isChecked()) { company.setText(f.format("Фирма: %s", radioButton.getText().toString()).toString());}
        else if(radioButton2.isChecked()) { company.setText(f.format("Фирма: %s", radioButton2.getText().toString()).toString());}
        else if(radioButton3.isChecked()) { company.setText(f.format("Фирма: %s", radioButton3.getText().toString()).toString());}
        f = new Formatter();
        if(radioButton4.isChecked()) { typeOfProduct.setText(f.format("Тип товара: %s", radioButton4.getText().toString()).toString());}
        else if(radioButton5.isChecked()) { typeOfProduct.setText(f.format("Тип товара: %s", radioButton5.getText().toString()).toString());}
        else if(radioButton6.isChecked()) { typeOfProduct.setText(f.format("Тип товара: %s", radioButton6.getText().toString()).toString());}
    }

    public void onClick2(View v)
    {
        Fragment fragment3 = getFragmentManager().findFragmentById(R.id.fragment3);
        Fragment fragment2 = getFragmentManager().findFragmentById(R.id.fragment2);
        Fragment fragment1 = getFragmentManager().findFragmentById(R.id.fragment1);
        ((TextView) fragment3.getView().findViewById(R.id.company)).setText("Фирма: ");
        ((TextView) fragment3.getView().findViewById(R.id.typeOfProduct)).setText("Тип товара: ");
        ((RadioButton) fragment1.getView().findViewById(R.id.radioButton)).setChecked(false);
        ((RadioButton) fragment1.getView().findViewById(R.id.radioButton2)).setChecked(false);
        ((RadioButton) fragment1.getView().findViewById(R.id.radioButton3)).setChecked(false);
        ((RadioButton) fragment2.getView().findViewById(R.id.radioButton4)).setChecked(false);
        ((RadioButton) fragment2.getView().findViewById(R.id.radioButton5)).setChecked(false);
        ((RadioButton) fragment2.getView().findViewById(R.id.radioButton6)).setChecked(false);
    }
}
