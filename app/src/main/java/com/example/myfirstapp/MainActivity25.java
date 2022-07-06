package com.example.myfirstapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity25 extends AppCompatActivity {

    final int CODE = 0X717;

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_linear_layout18);

        // 隐藏 ActionBar
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().hide();
//        }
//
//        tv = findViewById(R.id.show);
//        registerForContextMenu(tv);


//        XmlResourceParser xrp = getResources().getXml(R.xml.customers);//获取XML文档
//        StringBuilder sb = new StringBuilder("");// 创建-一个空的字符串构建器
//        try {
//            // 如果没有到XML文档的结尾处
//            while (xrp.getEventType() != XmlResourceParser.END_DOCUMENT) {
//                if (xrp.getEventType() == XmlResourceParser.START_TAG) {//判断是否为开始标记
//                    String tagName = xrp.getName();//获取标记名
//                    if (tagName.equals("customer")) { // 如果标记名是customer
//                        sb.append("姓名: " + xrp.getAttributeValue(1) + " ");//获取客户姓名
//                        sb.append("联系电话:" + xrp.getAttributeValue(2) + " ");//获取联系电话
//                        sb.append("E-mail: " + xrp.getAttributeValue(0));//获取E-mail
//                        sb.append("\n");//添加换行符
//                    }
//                }
//                xrp.next();//下一个标记
//            }
//            TextView textView = findViewById(R.id.textview1);
//            textView.setText(sb.toString());
//        } catch (XmlPullParserException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //        final Button button1 = (Button) findViewById(R.id.button4);//获取布局文件中添加的button1
//        //为按钮添加单击事件监听器
//        button1.setOnClickListener(v -> {
//            Button b = (Button) v;//获取当前按钮
//            b.setEnabled(false);//让按钮变为不可用
//            b.setText("我是不可用按钮");//改变按钮上显示的文字
//            // 显示消息提示框
//            Toast.makeText(MainActivity.this, "按钮变为不可用", Toast.LENGTH_SHORT).show();
//        });
//
//
//        Button button2 = (Button) findViewById(R.id.button5);//获取布局文件中添加的button2
//        //为按钮添加单击事件监听器
//        button2.setOnClickListener(v -> {
//            button1.setEnabled(true);//让button1变为可用
//            button1.setText("我是可用按钮");//改变按钮上显示的文字
//        });


        //定义TextView组件的id数组
//        int[] tvID = new int[]{R.id.textview1, R.id.textview2, R.id.textview3,
//                R.id.textview4, R.id.textview5, R.id.textview6, R.id.textview7};
//
//        //使用颜色资源
//        int[] tvColor = new int[]{R.color.color1, R.color.color2, R.color.color3,
//                R.color.color4, R.color.color5, R.color.color6, R.color.color7};
//
//        for (int i = 0; i < 7; i++) {
//            TextView tv = findViewById(tvID[i]);//根据id获取TextView组件
//            tv.setGravity(Gravity.CENTER);//设置文字居中显示
//            tv.setBackgroundColor(getResources().getColor(tvColor[i]));//为TextView组件设置背景颜色
//            //为TextView 组件设置高度
//            tv.setHeight((int)(getResources().getDimension(R.dimen.basic)) * (i + 2) / 2);
//        }

    /*
       选项菜单
     */

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = new MenuInflater(this);//实例化 一个MenuInflater对象
//        inflater.inflate(R.menu.menus, menu); //解析菜单文件
//        return super.onCreateOptionsMenu(menu);
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
//        return super.onOptionsItemSelected(item);
//    }

    /*
       上下文菜单
     */
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        MenuInflater inflator = new MenuInflater(this);//实例化一个MenuInflater对象
//        inflator.inflate(R.menu.menus, menu);//解析菜单文件
//        menu.setHeaderIcon(R.drawable.pic1);//为菜单头设置图标
//        menu.setHeaderTitle("请选择");//为菜单头设置标题
//    }
//
//    @Override
//    public boolean onContextItemSelected(@NonNull MenuItem item) {
//        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
//        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflator = new MenuInflater(this);//实例化一个MenuInflater对象
        inflator.inflate(R.menu.contexmenus, menu);//解析菜单文件
        menu.setHeaderIcon(R.drawable.gymnasium);//为菜单头设置图标
        menu.setHeaderTitle("请选择文字颜色");//为菜单头设置标题
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.color1:// 当选择红颜色时
                tv.setTextColor(Color.rgb(255, 0, 0));
                break;
            case R.id.color2:// 当选择绿颜色时
                tv.setTextColor(Color.rgb(0, 255, 0));
                break;
            case R.id.color3://当选择蓝颜色时
                tv.setTextColor(Color.rgb(0, 0, 255));
                break;
            case R.id.color4:// 当选择橙色时
                tv.setTextColor(Color.rgb(255, 180, 0));
                break;
            default:
                tv.setTextColor(Color.rgb(0, 0, 0));
        }
        return true;
    }
}


