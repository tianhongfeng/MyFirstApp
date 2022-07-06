package com.example.myfirstapp;


import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class LooperThread extends Thread {

    public Handler handler1;//声明一个Handler,对象

    @SuppressLint("HandlerLeak")
    @Override
    public void run() {
        super.run();
        Looper.prepare();//初始化Looper对象

        //实例化一个Handler对象
        handler1 = new Handler() {
            public void handleMessage(Message msg) {
                Log.i("ThunderSoft_Looper", String.valueOf(msg.what));
            }
        };
        Message m = handler1.obtainMessage(); //获取- -个消息
        m.what = 0x11;//设置Message的what属性的值
        handler1.sendMessage(m);//发送消息
        Looper.loop();//启动Looper
    }

}
