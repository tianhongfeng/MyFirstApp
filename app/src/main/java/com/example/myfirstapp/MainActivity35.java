//package com.example.myfirstapp;
//
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.Toast;
//
//
//public class MainActivity35 extends Activity {
//
//    private IntentFilter intentFilter;
//    private NetworkChangeReceiver networkChangeReceiver;
//
//    private OrderedBroadcastReceiver orderedBroadcastReceiver;
//    private OrderedBroadcastReceiver1 orderedBroadcastReceiver1;
//    private OrderedBroadcastReceiver2 orderedBroadcastReceiver2;
//    private OrderedBroadcastReceiver3 orderedBroadcastReceiver3;
//
//
//    @SuppressLint("HandlerLeak")
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test_linear_layout19);//设置页面布局
//
////        Button button = findViewById(R.id.button7);
////        button.setOnClickListener(v -> {
////            Intent intent = new Intent(MainActivity.this, PlayMusicActivity.class);
////            startActivity(intent);
////        });
//
////        intentFilter = new IntentFilter();
////        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
////        networkChangeReceiver = new NetworkChangeReceiver();
//    //        registerReceiver(networkChangeReceiver, intentFilter);
//
////        Button button = findViewById(R.id.button8);
////        button.setOnClickListener(v -> {
////            Intent intent1 = new Intent("com.example.myfirstapp.MyBROADCAST");
////            intent1.setComponent(new
////                    ComponentName("com.example.myfirstapp", "com.example.myfirstapp.MyBroadcastReveive"));
////            sendBroadcast(intent1);
////        });
//
//        Button button = findViewById(R.id.button9);
//        button.setOnClickListener(v -> {
//            Intent intent = new Intent();
//            intent.setAction("com.android.broadcasttest.MY_OrderedBROADCAST");
//            sendOrderedBroadcast(intent, null);
//        });
//
//        //在配置清单中静态注册厂播接收者，会使接收者无法接收广播
//        orderedBroadcastReceiver = new OrderedBroadcastReceiver();
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("com.android.broadcasttest.MY_OrderedBROADCAST");
//        intentFilter.setPriority(88);
//        registerReceiver(orderedBroadcastReceiver, intentFilter);
//
//        /*
//            将orderedBroadcastReceiver1的优先级设置的比orderedBroadcastReceiver高，
//            则orderedBroadcastReceiver1先响应
//         */
//        orderedBroadcastReceiver1 = new OrderedBroadcastReceiver1();
//        IntentFilter intentFilter2 = new IntentFilter();
//        intentFilter2.addAction("com.android.broadcasttest.MY_OrderedBROADCAST");
//        intentFilter2.setPriority(100);
//        registerReceiver(orderedBroadcastReceiver1, intentFilter2);
//
//        /*
//        在orderedBroadcastReceiver2接收到广播之后,会截断广播, 会导致orderedBroadcastReceiver4
//        无法接收到广播
//         */
//        orderedBroadcastReceiver2 = new OrderedBroadcastReceiver2();
//        IntentFilter intentFilter3 = new IntentFilter();
//        intentFilter3.addAction("com.android.broadcasttest.MY_OrderedBROADCAST");
//        registerReceiver(orderedBroadcastReceiver2, intentFilter3);
//
//        orderedBroadcastReceiver3 = new OrderedBroadcastReceiver3();
//        IntentFilter intentFilter4 = new IntentFilter();
//        intentFilter3.addAction("com.android.broadcasttest.MY_OrderedBROADCAST");
//        registerReceiver(orderedBroadcastReceiver3, intentFilter4);
//
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        unregisterReceiver(networkChangeReceiver);
//    }
//
//    // 网络改变广播
//    class NetworkChangeReceiver extends BroadcastReceiver {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            ConnectivityManager connectionManager = (ConnectivityManager)
//                    getSystemService(Context.CONNECTIVITY_SERVICE);
//            NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
//            if (networkInfo != null && networkInfo.isAvailable()) {
//                Toast.makeText(context,
//                        "network is available",
//                        Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(context,
//                        "network is unavailable",
//                        Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//}
//
//
//
//
//
//
//
