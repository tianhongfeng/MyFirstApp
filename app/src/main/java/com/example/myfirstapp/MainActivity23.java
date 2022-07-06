package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity23 extends Activity {

    final int CODE = 0X717;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_linear_layout17);

//        Button button = findViewById(R.id.button2);
//
//        button.setOnClickListener(v -> {
//            //将输入的信息保存到Bundle中,并启动一个新的Activity显示输入的用户注册信息
//            Intent intent = new
//                    Intent(MainActivity23.this, PhoneBrightnessAdjustActivity.class);
////            Bundle bundle = new Bundle();// 创建并实例化一个Bundle对象
////            bundle.putCharSequence("tag1", "我是传递的字符串");// 保存用户名址
//            intent.putExtra("tag1", "我是传递的字符串");//将Bundle对象添加到Intent对象中
//            startActivityForResult(intent, CODE);//启动新的Activity
//        });
//
//
//        Button home = findViewById(R.id.home_button);//通过 id值获得按钮对象
//        //为按钮增加单击事件监忻器
//        home.setOnClickListener(v -> {
//            Intent intent = new Intent();// 创建Intent对象
//            intent.setAction(Intent.ACTION_MAIN);// 设置Intent动作
//            intent.addCategory(Intent.CATEGORY_HOME);//设置Intent种类
//            startActivity(intent);//将Intent传递给Activity
//        });
    }
}


