package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button button = (Button) findViewById(R.id.button);//通过id值获得按钮对象
        button.setOnClickListener(new View.OnClickListener() {// 为按钮增加单击事件监听器
            public void onClick(View v) {
                Intent intent = new Intent();// 创建Intent对象
                intent.setAction(Intent.ACTION_VIEW);//为 Intent设置动作
                startActivity(intent);//将Intent传递给Activity
            }
        });
    }
}

