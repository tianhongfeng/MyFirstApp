package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity32 extends Activity {

    @SuppressLint("HandlerLeak")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_linear_layout22);//设置页面布局
        Button currentTime = findViewById(R.id.current_time); //通过ID值获得按钮对象
        //为按钮增加单击事件监听器
        currentTime.setOnClickListener(v -> {
            startService(new Intent(MainActivity32.this,
                    CurrentTimeService1.class));// 启动服务
        });


//        setContentView(R.layout.activity_test_linear_layout19);
//        Button button = findViewById(R.id.button6);
//        button.setOnClickListener(v -> {
//            Intent intent = new Intent(this, DownloadMp3Activity.class);
//            startActivity(intent);
//        });

    }
}







