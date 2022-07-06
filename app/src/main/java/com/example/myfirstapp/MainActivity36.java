//package com.example.myfirstapp;
//
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.Toast;
//
//import androidx.localbroadcastmanager.content.LocalBroadcastManager;
//
//
//public class MainActivity36 extends Activity {
//
//    private LocalBroadcastManager localBroadcastManager;
//    private LocalBroadcastTest localBroadcastTest;
//
//
//    @SuppressLint("HandlerLeak")
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test_linear_layout19);//设置页面布局
//
//        localBroadcastManager =
//                LocalBroadcastManager.getInstance(MainActivity36.this);
//        localBroadcastTest = new LocalBroadcastTest();
//        Button button = findViewById(R.id.button10);
//        button.setOnClickListener(v -> {
//            Intent intent = new Intent();
//            intent.setAction("com.android.localbroadcastmanager.MY_LOCALBROADCAST");
//            localBroadcastManager.sendBroadcast(intent);
//        });
//
//        //动态注册厂播接收者
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("com.android.localbroadcastmanager.MY_LOCALBROADCAST");
//        localBroadcastManager.registerReceiver(localBroadcastTest, intentFilter);
//    }
//
//    private class LocalBroadcastTest extends BroadcastReceiver {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            Toast.makeText(MainActivity36.this,
//                    "This is localbroadcast" , Toast .LENGTH_LONG). show();
//        }
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        localBroadcastManager.unregisterReceiver(localBroadcastTest);
//    }
//
//}
//
//
//
//
//
//
//
