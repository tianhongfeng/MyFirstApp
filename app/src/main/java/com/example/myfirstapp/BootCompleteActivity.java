package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BootCompleteActivity extends AppCompatActivity {

    private TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot_complete);

        tv1 = findViewById(R.id.memory1);
        tv2 = findViewById(R.id.memory2);

        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);

        //存放内存信息的对象
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();

        //传入参数，将获得数据保存在memInfo对象中
        activityManager.getMemoryInfo(memInfo);

        //可用内存
        long availMem = memInfo.availMem/1000000;

        //总内存
        long totalMem = memInfo.totalMem/1000000;

        tv1.setText(new StringBuilder().append("totalMem:").append(totalMem).append("\n")
                .append("availMem:").append(availMem));

    }

}