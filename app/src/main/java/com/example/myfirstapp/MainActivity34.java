package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.widget.Button;


public class MainActivity34 extends Activity {

    Messenger messenger;
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
            Intent intent = new Intent(MainActivity34.this, CurrentTimeService2.class);
            bindService(intent, connection, BIND_AUTO_CREATE);// 绑定服务
            if (bound) {
                Message message = Message.obtain(null, CurrentTimeService2.CURRENT_TIME,
                        0, 0);
                try {
                    messenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (bound) {
            bound = false;
            unbindService(connection);//解绑定
        }
    }

    private ServiceConnection connection = new ServiceConnection( ) {
        public void onServiceDisconnected (ComponentName name) {
            messenger = null;
            bound = false;
        }
        public void onServiceConnected ( ComponentName name, IBinder service) {
            messenger = new Messenger(service);
            bound = true ;
        }
    };
}







