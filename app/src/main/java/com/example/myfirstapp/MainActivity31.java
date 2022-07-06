package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;


public class MainActivity31 extends Activity {

    private Handler handler;//声明- - 个HandLer对象
    private static TextView[] tv = new TextView[14];
    private static LinearLayout layout;
    int[] bgColor = new int[]{R.color.color1, R.color.color2, R.color.color3,
            R.color.color4, R.color.color5, R.color.color3, R.color.color7};//使用颜色资源
    private int index = 0;//当前颜色 值

    @SuppressLint("HandlerLeak")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_linear_layout21);
        layout = findViewById(R.id.ll);//获取线性布局管理器
        int height = this.getResources().getDisplayMetrics().heightPixels;//获取屏幕的高度

        // 添加文本到布局中
        for (int i = 0; i < tv.length; i++) {
            tv[i] = new TextView(this);// 创建一个文本框对象
            tv[i].setWidth(this.getResources().getDisplayMetrics().widthPixels);//设置文本框的宽度
            tv[i].setHeight(height / tv.length);//设置文本框的高度
            layout.addView(tv[i]);//将TextView组件添加到线性布局管理器中
        }

        // 开启线程 用于发送消息
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                Message m = handler.obtainMessage();//获取- - 个Message
                m.what = 0x101;//设置消息标识
                handler.sendMessage(m);//发送消息
                try {
                    Thread.sleep(new Random().nextInt(1000));//休眠1秒钟
                } catch (InterruptedException e) {
                    e.printStackTrace();//输出异常信息
                }
            }
        });
        t.start();//开启线程


        //处理消息
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                int temp = 0;//临时变量
                if (msg.what == 0x101) {
                    for (int i = 0; i < tv.length; i++) {
                        temp = new Random().nextInt(bgColor.length);//产生-个随机数
                        //去掉重复的并且相邻的颜色
                        if (index == temp) {
                            temp++;
                            if (temp == bgColor.length){
                                temp = 0;
                            }
                        }
                        index = temp;
                        //为文本框设置背景
                        tv[i].setBackgroundColor(getResources().getColor(bgColor[index]));
                    }
                }
                super.handleMessage(msg);
            }
        };


    }
}







