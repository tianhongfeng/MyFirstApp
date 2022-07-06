package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity33 extends Activity {

    CurrentTimeService3 cts;
    boolean bound;

    @SuppressLint("HandlerLeak")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_linear_layout22);//设置页面布局
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button button = findViewById(R.id.current_time);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity33.this, CurrentTimeService3.class);
            bindService(intent, sc, BIND_AUTO_CREATE);//绑定服务
            if (bound) {// 如果绑定则显示当前时间
                Toast.makeText(MainActivity33.this, cts.getCurrentTime(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (bound) {
            bound = false;
            unbindService(sc);//解绑定
        }
    }

    private ServiceConnection sc = new ServiceConnection() {
        public void onServiceDisconnected(ComponentName name) {
            bound = false;
        }

        public void onServiceConnected(ComponentName name, IBinder service) {
            CurrentTimeService3.LocalBinder binder = (CurrentTimeService3.LocalBinder) service;//获得 自定义的LocalBinder对象
            cts = binder.getService();//获得CurrentTimeService对象
            bound = true;
        }
    };
}







