package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;


public class MainActivity30 extends AppCompatActivity implements Runnable {

    private Thread thread; //声明- -个线程对象
    private static MediaPlayer mp = null; //声明- 一个MediaPlayer对象

    private ImageView iv;//声明- 一个显示广“告图片的ImageView对象
    private Handler handler;//声明- - 个HandLer对象

    private int[] path = new int[]{R.drawable.pic1, R.drawable.pic2,
            R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
            R.drawable.pic6};//保存广告图片的数组

    private String[] title = new String[]{"编程词典系列产品", "高效开发", "快乐分享", "用户人群",
            "快速学习", "全方位查询"};//保存显示标题的数组


    @Override
    public void run() {
        int index = 0;
        while (!Thread.currentThread().isInterrupted()) {
            index = new Random().nextInt(path.length);//产生-一个随机数
            Message m = handler.obtainMessage();//获取一个Message
            m.arg1 = index;//保存要显示广告图片的索引值
            Bundle bundle = new Bundle();// 获取Bundle对象
            m.what = 0x101;// 设置消息标识
            bundle.putString("title", title[index]);//保存标题
            m.setData(bundle);//将BundLe对象保存到Message中
            handler.sendMessage(m);//发送消息
            try {
                Thread.sleep(2000);//线程休眠2秒钟
            } catch (InterruptedException e) {
                e.printStackTrace();//输出异常信息
            }
        }
    }


    @SuppressLint("HandlerLeak")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_linear_layout21);
        iv = findViewById(R.id.imageView1);//获取布局管理器中添加的ImageView

        Thread t = new Thread(this);// 创建新线程
        t.start();//开启线程

        //实例化一个Handler对象
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                //更新UI
                TextView tv = findViewById(R.id.textView1);//获取TextView组件
                if (msg.what == 0x101) {
                    tv.setText(msg.getData().getString("title"));//设置标题
                    iv.setImageResource(path[msg.arg1]);//设置要显示的图片
                }
                super.handleMessage(msg);
            }
        };


//        //创建一个新线程，用于从网络上获取图片
//        new Thread(() -> {
//            //从网络_上获取图片
//            final Bitmap bitmap = getPicture("https://cdn.pixabay.com/photo/2016/12/23/12/40/night-1927265__480.jpg");
//            try {
//                Thread.sleep(2000);//线程休眠2秒钟
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            //发送一个Runnable对象
//            iv.post(() -> {
//                iv.setImageBitmap(bitmap);//在ImageView中显示从网络上获取到的图片
//            });
//
//        }).start();//开启线程


//         LooperThread looperThread = new LooperThread();
//         looperThread.start();

//        Button startButton = findViewById(R.id.button1);//获取“开始”按钮
//        startButton.setOnClickListener(v -> {
//
//            v.setEnabled(false);
//            //创建-一个线程
//            thread = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    playBGSound();
//                }
//            });
//            thread.start();//开启线程
//        });
    }


    /**
     * 功能:根据网址获取图片对应的Bitmap对象
     *
     * @param path
     * @return 51
     */
    public Bitmap getPicture(String path) {
        Bitmap bm = null;
        try {
            URL url = new URL(path);// 创建URL对象)
            URLConnection conn = url.openConnection();//获取URL对象对应的连接
            conn.connect();//打开连接
            InputStream is = conn.getInputStream();//获取输入流对象
            bm = BitmapFactory.decodeStream(is);//根据输入流对象创建Bitmap对象
        } catch (MalformedURLException e1) {
            e1.printStackTrace();//输出异常信息
        } catch (IOException e) {
            e.printStackTrace();//输出异常信息
        }
        return bm;
    }


    private void playBGSound() {
        if (mp != null) {
            mp.release();//释放资源
        }

        mp = MediaPlayer.create(MainActivity30.this, R.raw.obj_3f);
        mp.start();//开始播放

        //为MediaPlayer添加播放完成事件监听器
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                try {
                    Thread.sleep(5000);//线程休眠5秒钟
                    playBGSound();//重新播放音乐
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    protected void onDestroy() {
        if (mp != null) {
            mp.stop(); //停止播放
            mp.release(); //释放资源
            mp = null;
            if (thread != null) {
                thread = null;
            }
        }
        super.onDestroy();//中断线程
    }
}







