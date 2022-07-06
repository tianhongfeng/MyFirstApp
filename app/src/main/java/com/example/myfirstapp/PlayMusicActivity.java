package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class PlayMusicActivity extends AppCompatActivity {

    private Button select,play,stop;
    private ProgressBar schedule;
    private TextView result;

    private MucicService musicService;
    private MucicService.MyBinder binder;

    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            musicService = ((MucicService.MyBinder)iBinder).getService();
            binder = (MucicService.MyBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            musicService = null;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        // 选择歌曲按钮
        select = findViewById(R.id.music_select);

        // 启动
        play = findViewById(R.id.button1);

        // 停止
        stop = findViewById(R.id.button2);

        // 播放进度
        schedule = findViewById(R.id.schedule1);

        // 启动监听
        play.setOnClickListener(v -> {
            musicService.play();
            schedule.setMax(MucicService.mp.getDuration());
            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask(){
                @Override
                public void run() {
                    schedule.setProgress(MucicService.mp.getCurrentPosition());
                }
            };
            timer.schedule(timerTask,0,10);
        });

        // 停止监听
        stop.setOnClickListener(v -> {
            try {
                musicService.stop();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void onDestroy() {
        unbindService(sc);
        super.onDestroy();
    }
}