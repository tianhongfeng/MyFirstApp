package com.example.myfirstapp;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test_frame_layout);

        /**
         * 通过代码生成UI界面
         */
        // 创建帧布局管理器
        FrameLayout frameLayout = new FrameLayout(this);
        // 设置在Activity中显示frameLayout
        setContentView(frameLayout);
        TextView text1 = new TextView(this);
        text1.setText("在代码中控制UI界面");
        text1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24);
        text1.setTextColor(Color.rgb(1, 1, 1));
        // 将text1添加到布局管理器
        frameLayout.addView(text1);


        TextView text2 = new TextView(this);
        text2.setText("单击进入Android");
        text2.setTextSize(TypedValue.COMPLEX_UNIT_PX, 24);
        text2.setTextColor(Color.rgb(1, 1, 1));


        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        params.gravity = Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL;
        text2.setLayoutParams(params);

        // 为text2添加点击事件
        text2.setOnClickListener(v -> new AlertDialog.Builder(MainActivity1.this)
                //设置对话的标题
                .setTitle("系统提示")
                //设置对话框显示内容
                .setMessage("Android是一个丰富的世界，确定要进入吗？")
                // 设置对话框按钮

                .setPositiveButton("确定", (dialog, which) -> {
                    Log.i("Android", "进入"); // 输出消息日志
                })
                .setNegativeButton("退出",  (dialog, which) -> {
                    Log.i("Android", "退出"); // 输出消息日志
                    finish();
                }).show());

        // 将text2添加到布局管理器
        frameLayout.addView(text2);

    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
//        // Do something in response to button
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
    }

}