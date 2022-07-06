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


public class MainActivity26 extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_linear_layout18);

//        tv = findViewById(R.id.show);
//        registerForContextMenu(tv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflator = new MenuInflater(MainActivity26.this);//实例化一个MenuInflater对象
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflator = new MenuInflater(MainActivity.this);//实例化一个MenuInflater对象
//        inflator.inflate(R.menu.optionmenus, menu);//解析菜单文件
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getGroupId() == R.id.setting) {//判断是否选择了“参数设置”菜单项
//            if (item.isChecked()) {//若菜单项已经被选中
//                item.setChecked(false);//设置菜单项不被选中
//            } else {
//                item.setChecked(true);//设置菜单项被选中
//            }
//        }
//
//        if (item.getItemId() != R.id.item2) {//弹出消息提示框显示选择的菜单项的标题
//            Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
//        }
//        return true;
//    }
}


