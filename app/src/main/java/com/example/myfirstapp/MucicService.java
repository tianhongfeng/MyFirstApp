package com.example.myfirstapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.security.Provider;

public class MucicService extends Service {

    // 音乐init
    public static MediaPlayer mp = new MediaPlayer();

    // 服务init
    private final IBinder binder = new MucicService.MyBinder();

    private String path;

    public class MyBinder extends Binder {
        MucicService getService(){
            return MucicService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        path = intent.getStringExtra("path");

        // 初始化音乐播放器
        init();
        return binder;
    }

    public void init(){
        try {
//            System.out.println("22222"+path);
            mp.setDataSource(path);
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 播放
    public void play(){
        mp.start();
    }

    // 停止
    public void stop() throws IOException {
        if (mp != null){
            mp.stop();
            mp.prepare();
            mp.seekTo(0);
        }
    }

}
