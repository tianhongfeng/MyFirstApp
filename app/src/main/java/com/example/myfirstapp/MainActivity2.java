package com.example.myfirstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private ImageView[] img = new ImageView[12];
    private int[] path = new int[]{R.drawable.gymnasium, R.drawable.gymnasium, R.drawable.gymnasium};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        // 获取xml中定义的布局管理器
        LinearLayout layout = (LinearLayout)findViewById(R.id.Layout);

        for (int i = 0; i < path.length; i++) {
            img[i] = new ImageView(this);
            img[i].setImageResource(path[i]);
            img[i].setPadding(5, 5, 5, 5);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(253, 148);
            img[i].setLayoutParams(params);
            layout.addView(img[i]);
        }
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