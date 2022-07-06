package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity10 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private int year, month, hour, day, minute;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_linear_layout3);

        // 计时器
//        Chronometer ch = findViewById(R.id.chronometer1);
//        ch.setBase(SystemClock.elapsedRealtime());
//        ch.setFormat("已用时间：%s");
//        ch.start();
//        ch.setOnChronometerTickListener(chronometer -> {
//            if (SystemClock.elapsedRealtime() - ch.getBase() >= 10000) {
//                ch.stop();
//            }
//        });

        //
//        ImageButton imageButton = findViewById(R.id.start);
//        imageButton.setOnClickListener(v -> {
//            Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show();
//        });

        //
        ListView ll =  findViewById(R.id.listview1);

        // 图片数组
        int[] imgid = new int[]{R.drawable.gymnasium, R.drawable.gymnasium_a};
        // 文字数组
        String[] title = new String[]{"密码", "邮件"};

        List<Map<String, Object>> list = new ArrayList<>();

        for (int i = 0; i < imgid.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", imgid[i]);
            map.put("title", title[i]);
            list.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.item, new String[]{
                "title", "image"}, new int[]{R.id.textview1, R.id.imageView1});

        ll.setAdapter(adapter);
    }

}