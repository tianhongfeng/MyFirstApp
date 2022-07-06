package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity7 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_linear_layout2);

        ListView listView = findViewById(R.id.listview1);
        // 为listView创建 适配器
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.ctype, android.R.layout.simple_list_item_checked
        );
        listView.setAdapter(adapter);

        // 定义listview点击事件监听
        listView.setOnItemClickListener((parent, view, position, id) -> {
            // 获取点击选项值
            String result = parent.getItemAtPosition(position).toString();
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        });

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