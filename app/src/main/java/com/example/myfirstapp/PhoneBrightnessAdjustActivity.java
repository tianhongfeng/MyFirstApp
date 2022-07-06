package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class PhoneBrightnessAdjustActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_brightness_adjust);
        Intent intent = getIntent();
        // 从获取Intent 对象
//        Bundle bundle = intent.getExtras();//获取传递的数据包
//        Toast.makeText(PhoneBrightnessAdjustActivity.this,
//                bundle.getString("tag1"), Toast.LENGTH_LONG).show();

        Toast.makeText(PhoneBrightnessAdjustActivity.this,
                intent.getStringExtra("tag1"), Toast.LENGTH_LONG).show();
    }
}