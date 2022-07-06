package com.example.myfirstapp;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity22 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_linear_layout16);

    }

    //创建一个继承Activity的内部类,用于在手机界面中通过Activity显示详细内容
    public static class DetailActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail);

            //判断是否为横屏,如果为横屏,则结束当前Activity,准备使用Fragment显示详细内容
            if (getResources().getConfiguration().orientation ==
                    Configuration.ORIENTATION_LANDSCAPE){
                finish();//结束当前Activity
                return;
            }

            if (savedInstanceState == null) {
                //在初始化时插入一个显示详细内容的Fragment
                DetailFragment details = new DetailFragment();
                //实例化DetailFragment的对象
                details.setArguments(getIntent().getExtras());
                //设置要传递的参数
                getFragmentManager().beginTransaction()
                        .add(android.R.id.content, details).commit(); //添加一一个显示详细内容的Fragment
            }
        }
    }
}


