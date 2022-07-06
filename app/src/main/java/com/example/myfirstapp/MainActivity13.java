package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity13 extends AppCompatActivity {

    private static final String[] COUNTRIES = new String[] {
            "android", "android app", "android 开发", "开发应用", "开发者"};

    @SuppressLint({"ClickableViewAccessibility", "HandlerLeak"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_linear_layout5);

        AutoCompleteTextView act = findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        act.setAdapter(adapter);

        Button bt = findViewById(R.id.button1);
        bt.setOnClickListener(v -> {
            Toast.makeText(MainActivity13.this, act.getText().toString(), Toast.LENGTH_SHORT).show();
        });
    }
}
