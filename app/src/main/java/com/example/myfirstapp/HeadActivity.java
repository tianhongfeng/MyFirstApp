package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HeadActivity extends AppCompatActivity {


    //定义并初始化一个保存要显示图片id的数组
    final private int imageId[] = new int[]{R.drawable.pic1, R.drawable.pic2,
            R.drawable.pic3, R.drawable.pic4,
            R.drawable.pic6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);

        GridView gridview = findViewById(R.id.gridview1);//获取GridView组件

        // 创建BaseAdapter
        BaseAdapter adapter = new BaseAdapter() {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageview;//声明ImageView的对象
                if (convertView == null) {
                    imageview = new ImageView(HeadActivity.this);//实例化ImageView的对象
                    imageview.setMaxHeight(150);
                    imageview.setMaxWidth(158);
                    imageview.setAdjustViewBounds(true);

//                    imageview.setScaleType(ImageView.ScaleType.CENTER_INSIDE);// 设置缩放方式
                    imageview.setPadding(5, 5, 5, 5);// 设置ImageView的内边距
//                    imageview.setLayoutParams(new LinearLayout.LayoutParams(100, 100));
                } else {
                    imageview = (ImageView) convertView;
                }
                imageview.setImageResource(imageId[position]);//为ImageView设置要显示的图片
                return imageview;// 返回ImageView
            }

            @Override
            public int getCount() {
                return imageId.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }
        };
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = getIntent();//获取 Intent对象
            Bundle bundle = new Bundle();//实例化传递的数据包
            bundle.putInt("imageId", imageId[position]);// 显示选中的图片
            intent.putExtras(bundle);//将数据包保存到intent中
            setResult(0x12, intent);//设置返回的结果码,并返回调用该Activity的Activity
            finish();//关闭当前Activity
        });
    }
}