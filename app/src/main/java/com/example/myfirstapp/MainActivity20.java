package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity20 extends Activity {

    final int CODE = 0X717;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_linear_layout13);


        // 提交
        Button button1 = findViewById(R.id.button1);

        button1.setOnClickListener(v -> {
            String user = ((EditText) findViewById(R.id.user)).getText().toString();//获取输入的用户名
            String pwd = ((EditText) findViewById(R.id.pwd)).getText().toString();//获取输入的密码
            String repwd = ((EditText) findViewById(R.id.repwd)).getText().toString();//获取 输入的确认密码
            String email = ((EditText) findViewById(R.id.email)).getText().toString();//获取 输入的E - mail地址

            if (!"".equals(user) && !"".equals(pwd) && !"".equals(email)) {
                if (!pwd.equals(repwd)) { //判断两次输入的密码是否一致
                    Toast.makeText(MainActivity20.this,
                            "两次输入的密码不一致, 请重新输入 !", Toast.LENGTH_LONG).show();

                    ((EditText) findViewById(R.id.pwd)).setText("");//清空密码 编辑框
                    ((EditText) findViewById(R.id.repwd)).setText("");//清空“确认密码”编辑框
                    ((EditText) findViewById(R.id.pwd)).requestFocus();//让 “密码”编辑框获得焦点
                } else {
                    //将输入的信息保存到Bundle中,并启动一个新的Activity显示输入的用户注册信息
                    Intent intent = new
                            Intent(MainActivity20.this, RegisterActivity.class);
                    Bundle bundle = new Bundle();// 创建并实例化一个Bundle对象
                    bundle.putCharSequence("user", user);// 保存用户名
                    bundle.putCharSequence("pwd", pwd);// 保存密码
                    bundle.putCharSequence("email", email);//保存E-mail地址
                    intent.putExtras(bundle);//将Bundle对象添加到Intent对象中
                    startActivityForResult(intent, CODE);//启动新的Activity
                }
            } else {
                Toast.makeText(MainActivity20.this, "请将注册信息输入完整 !", Toast.LENGTH_LONG).show();
            }

        });

        // 重置
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            ((EditText) findViewById(R.id.user)).setText("");//清空密码 编辑框
            ((EditText) findViewById(R.id.pwd)).setText("");//清空密码 编辑框
            ((EditText) findViewById(R.id.repwd)).setText("");//清空“确认密码”编辑框
            ((EditText) findViewById(R.id.email)).setText("");//清空“确认密码”编辑框
            ((EditText) findViewById(R.id.user)).requestFocus();//让 “密码”编辑框获得焦点
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE && resultCode == CODE) {
            ((EditText) findViewById(R.id.pwd)).setText("");//清空密码”编辑框
            ((EditText) findViewById(R.id.repwd)).setText("");//清空“确认密码”编辑框
        }
    }
}


