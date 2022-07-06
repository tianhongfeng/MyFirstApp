package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_table_layout3);

        Button button = findViewById(R.id.button1);
        button.setOnClickListener(v -> {
            EditText nickname = findViewById(R.id.nickname);
            String name = nickname.getText().toString();
            EditText pwdET = findViewById(R.id.pwd);
            String pwd = pwdET.getText().toString();
            EditText emailET = findViewById(R.id.email);
            String email = emailET.getText().toString();

            Log.i("会员昵称:", name);
            Log.i("密码:", pwd);
            Log.i("邮箱:", email);
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

    public void myclick(View view) {
        Toast toast = Toast.makeText(this, "您点击了图片", Toast.LENGTH_SHORT);
        toast.show();
    }

}