package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


    // 复选框单击监听事件
    private CompoundButton.OnCheckedChangeListener check_boxListener = (buttonView, isChecked) -> {
        if (isChecked) {
            Log.i("您选择的是", buttonView.getText().toString());
        }

    };


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_linear_layout1);

        RadioGroup radioGroup = findViewById(R.id.radiogroup1);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton r = findViewById(checkedId);
            Log.i("您选择的是", r.getText().toString());
        });

        Button button = findViewById(R.id.button1);
        button.setOnClickListener(v -> {
            for (int i = 0; i < radioGroup.getChildCount(); i++) {
                RadioButton r = (RadioButton) radioGroup.getChildAt(i);
                if (r.isChecked()) {
                    Log.i("您选择的是", r.getText().toString());
                    break;
                }
            }
        });


        CheckBox l1 = findViewById(R.id.like1);
        CheckBox l2 = findViewById(R.id.like2);
        CheckBox l3 = findViewById(R.id.like3);

        // 为复选框添加改变监听器
        l1.setOnCheckedChangeListener(check_boxListener);
        l2.setOnCheckedChangeListener(check_boxListener);
        l3.setOnCheckedChangeListener(check_boxListener);


        // 复选框提交按钮
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> {

            StringBuilder sb = new StringBuilder();
            if (l1.isChecked()) {
                sb.append(l1.getText().toString());
                sb.append(" ");
            }

            if (l2.isChecked()) {
                sb.append(l2.getText().toString());
                sb.append(" ");
            }

            if (l3.isChecked()) {
                sb.append(l3.getText().toString());
                sb.append(" ");
            }
            Log.i("您选择的是", sb.toString());
        });

    }




    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
//        // Do something in response to button
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
    }

}