package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ResultActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView sex = findViewById(R.id.textView1); //获取显示性别的文本框
        TextView stature = findViewById(R.id.textView2); //获取显示身高的文本框
        TextView weight = findViewById(R.id.textView3); //获取显示标准体重的文本框
        TextView age = findViewById(R.id.textView4); //获取显示标准体重的文本框

        Intent intent = getIntent(); //获取Intent对象

        sex.setText("int:" + intent.getIntExtra("int", 15));
        stature.setText("byte:" + intent.getByteExtra("byte", (byte) 0));
        weight.setText("Serializable:" + intent.getSerializableExtra("Serializable"));
        age.setText("String:" + intent.getStringExtra("String"));

    }

//    private String getWeight(String sex, float stature) {
//        String weight = "";// 保存体重
//        NumberFormat format = new DecimalFormat();
//        if (sex.equals("男")) {//计算男士标准体重
//            weight = format.format((stature - 80) * 0.7);
//        } else {
//            // 计算女士标准体重
//            weight = format.format((stature - 70) * 0.6);
//        }
//        return weight;
//    }

}