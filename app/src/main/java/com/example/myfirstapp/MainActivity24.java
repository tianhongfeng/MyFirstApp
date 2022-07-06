package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity24 extends Activity {

    final int CODE = 0X717;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        EditText numberTV = (EditText) findViewById(R.id.editText); //通过id值获得编辑框对象
        Button dial = (Button) findViewById(R.id.button2);//通过id值获得按钮对象

        dial.setOnClickListener(v -> {
            final String number = numberTV.getText().toString();//获得输入的电话号码
            Intent intent = new Intent();//创建Intent对象
            intent.setAction(Intent.ACTION_CALL);//为Intent 设置动作
            intent.setData(Uri.parse("tel:" + number));//为 Intent设置数据
            startActivity(intent);//将Intent传递给Activity
        });

        Button button = (Button) findViewById(R.id.button3);//通过id值获得按钮对象
        button.setOnClickListener(v -> {
            Intent intent = new Intent();// 创建Intent对象
            intent.setAction(Intent.ACTION_VIEW);// 为Intent设置动作
            intent.setData(Uri.parse("http://www.baidu.com")); //为Intent设置数据
            startActivity(intent);//将Intent传递给Activity
        });


        Button button1 = (Button) findViewById(R.id.button1);//通过id值获得按钮对象
        // 为按钮增加单击事件监听器
        button1.setOnClickListener(v -> {
            Intent intent = new Intent();// 创建Intent对象
            intent.setAction("test_action");//为 Intent设置动作
            startActivity(intent);//将Intent传递给Activity
        });

    }
}


