package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;


public class MainActivity extends Activity {

    private IntentFilter intentFilter;

    private BootCompleteReceiver bootCompleteReceiver;

    @SuppressLint("HandlerLeak")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_linear_layout19);//设置页面布局

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
        bootCompleteReceiver = new BootCompleteReceiver();
        registerReceiver(bootCompleteReceiver, intentFilter);

        Button button = findViewById(R.id.button8);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BootCompleteActivity.class);
            startActivity(intent);
        });

    }

    class BootCompleteReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

            ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);

            //存放内存信息的对象
            ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();

            //传入参数，将获得数据保存在memInfo对象中
            activityManager.getMemoryInfo(memInfo);

            //可用内存
            long availMem = memInfo.availMem/1000000;

            //总内存
            long totalMem = memInfo.totalMem/1000000;

            intent = new Intent(context, BootCompleteActivity.class);

            Bundle memoryInfo = new Bundle();
            memoryInfo.putString("totalMem", String.valueOf(totalMem));
            memoryInfo.putString("availMem", String.valueOf(availMem));
            intent.putExtras(memoryInfo);
            context.startActivity(intent);

        }
    }
}







