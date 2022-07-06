package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.Timer;
import java.util.TimerTask;

public class DownloadMp3Activity extends AppCompatActivity {

    boolean state = true;
    private Handler handler;
    private static MediaPlayer mediaPlayer = null;
    private EditText et;
    private ProgressBar schedule = null;
    private ProgressBar schedule1 = null;
    private TextView times = null;
    private TextView result = null;

    private int iTimes = 0;


    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_mp3);

        // 启动按钮
        Button b1 = findViewById(R.id.button1);

        // 停止
        Button b2 = findViewById(R.id.button2);

        // 循环次数
        times = findViewById(R.id.number);

        //获取进度条
        schedule = findViewById(R.id.progressBar1);

        // 播放进度
        schedule1 = findViewById(R.id.schedule1);

        // 下载进度
        result = findViewById(R.id.resultm);

        // 歌曲网址
        et = findViewById(R.id.editText1);
//        et.setText("https://files.freemusicarchive.org/storage-freemusicarchive-org/tracks/rdGuYhSG9EscDCLXfoPz1YSN44JajuA09WMs773V.mp3?download=1&name=FMA%20-%20Music%20Insiders%20episode%202%20%28Simon%20Mathewson%29.mp3");
        et.setText("http://m701.music.126.net/20220629225906/b340bfbee87af683120302fe38a670c0/jdymusic/obj/w5zDlMODwrDDiGjCn8Ky/1512016089/a83c/350c/4c3e/bc41e3f7d38183cac29d02a860730d3f.mp3");

        b1.setOnClickListener(v -> {
            if (et.length() != 0) {
                if (state) {
                    new Thread(() -> display()).start();
                    state = false;
                } else {
                    Toast.makeText(DownloadMp3Activity.this, "正在下载", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(DownloadMp3Activity.this, "请输入下载地址", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(v -> {
            mediaPlayer.pause();
        });

        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                if (msg.what == 0x101){
                    schedule.setProgress(msg.arg1);
                    result.setText("已下载" + msg.arg1 + "%");
                    if (msg.arg1 == 100){
                        result.setText("下载完成！");
                    }
                }
                if (msg.what == 0x102){
                    schedule1.setProgress(msg.arg1);
                }
                super.handleMessage(msg);
            }
        };
    }


    // 下载
//    private void download() {
//        try {
//            //获取url链接并打开
//            URL url = new URL(et.getText().toString());
//            URLConnection urlConnection = url.openConnection();
//
//            //获取连接长度
//            int length = urlConnection.getContentLength();
//
//            //通过流来建立通道
//            ReadableByteChannel c = Channels.newChannel(url.openStream());
//
//            // TODO  这里面的目录是程序自己的私有目录
//            File file = new File("data/data/com.example.myfirstapp/test.mp3");
//
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//
//            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            FileChannel channel = fileOutputStream.getChannel();
//
//            //创建字节缓冲区
//            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//            int len;
//            int sum = 0;
//            while ((len = c.read(byteBuffer)) != -1) {
//                sum += len;
//                int progress = (sum * 100) / length;
//                byteBuffer.flip();
//                while (byteBuffer.hasRemaining()) {
//                    channel.write(byteBuffer);
//                }
//                byteBuffer.clear();
//
//                // 发送消息
//                Message m = handler.obtainMessage();
//                m.what = 0x101;
//                m.arg1 = progress;
//                handler.sendMessage(m);
//            }
//            display();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    private void display() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this, Uri.parse("data/data/com.example.myfirstapp/dahai_jitaban.mp3"));
        mediaPlayer.start();
        schedule1.setMax(mediaPlayer.getDuration());

        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask(){
            @Override
            public void run() {
                schedule1.setProgress(mediaPlayer.getCurrentPosition());
            }
        };
        timer.schedule(timerTask,0,10);

        iTimes++;
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                times.setText(""+iTimes);
                //因为没有开始按钮所以点击暂停完成播放自动开始下一次播放
                display();
            }
        });
    }
}