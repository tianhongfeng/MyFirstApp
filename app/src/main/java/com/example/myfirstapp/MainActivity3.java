package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        // 获取xml中定义的布局管理器
        LinearLayout layout = (LinearLayout)findViewById(R.id.Layout);

        final RabbitView rabbitView = new RabbitView(this);
        // 添加触摸事件
        rabbitView.setOnTouchListener((v, event) -> {
            rabbitView.x = event.getX();
            rabbitView.y = event.getY();
            rabbitView.invalidate();
            return true;
        });

        layout.addView(rabbitView);
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