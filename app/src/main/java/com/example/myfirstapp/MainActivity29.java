package com.example.myfirstapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity29 extends AppCompatActivity implements Runnable {

    private Thread thread;
    private int i;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_linear_layout21);

//        Button button = findViewById(R.id.button5);
//
//        button.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this, BookkeepingActivity.class);
//            startActivity(intent);
//        });

        Button startButton = findViewById(R.id.button1);//获取“开始”按钮
        startButton.setOnClickListener(v -> {
            i = 0;
            thread = new Thread(MainActivity29.this);//创建-一个线程
            thread.start();//开启线程
        });

        Button stopButton = findViewById(R.id.button2);//获取“停止”按钮
        stopButton.setOnClickListener(v -> {
            if (thread != null) {
                thread.interrupt();//中断线程
            }
            Log.i("提示:", "中断线程");
        });

    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            i++;
            try {
                Thread.sleep(1000);
                Log.i("循环变量：","" + i);
            }catch (InterruptedException e){
                e.printStackTrace();
                thread.interrupt();
            }
        }
    }

    @Override
    protected void onDestroy() {
        System.out.println("onDestroy");
        super.onDestroy();//中断线程
    }
}





