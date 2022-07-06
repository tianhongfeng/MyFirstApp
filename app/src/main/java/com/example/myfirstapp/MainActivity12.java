package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity12 extends AppCompatActivity {

    private ProgressBar horizonP;//水 平进度条
    private ProgressBar circleP;//圆形进度条
    private int mProgressStatus = 0;// 完成进度
    private Handler mHandler;//声明一个用于处理消息的Handler类的对象

    @SuppressLint({"ClickableViewAccessibility", "HandlerLeak"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_linear_layout4);

        horizonP = findViewById(R.id.progressBar1);
        circleP = findViewById(R.id.progressBar2);

        mHandler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                if (msg.what == 0X111) {
                    horizonP.setProgress(mProgressStatus);
                } else {
                    Toast.makeText(MainActivity12.this, "耗时操作已完成", Toast.LENGTH_SHORT).show();
                    horizonP.setVisibility(View.GONE);
                    circleP.setVisibility(View.GONE);
                }
            }
        };

        // 另开启一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    mProgressStatus = doWork();
                    Message message = new Message();
                    if (mProgressStatus <100) {
                        message.what = 0X111;
                        mHandler.sendMessage(message);
                    }else {
                        message.what = 0X110;
                        mHandler.sendMessage(message);
                        break;
                    }

                }
            }

            private int doWork() {
                mProgressStatus += Math.random() * 10; //改变完成进
                try {
                    Thread.sleep(200);//线程休眠200毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return mProgressStatus;
            }
        }).start();
    }
}
