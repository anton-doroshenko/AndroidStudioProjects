package com.example.lab_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class OutputActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output);

        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.SAVED_TEXT);

        TextView textView = (TextView) findViewById(R.id.company);
        textView.setText(text);
    }
}
