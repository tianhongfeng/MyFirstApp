package com.example.myfirstapp;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity16 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_linear_layout10);

        //定义并初始化保存图片id的数组
        int[] imageId = new int[]{R.drawable.gymnasium_a, R.drawable.gymnasium_a,
                R.drawable.gymnasium_a, R.drawable.gymnasium_a, R.drawable.gymnasium_a,
                R.drawable.gymnasium_a};

        Gallery gallery = findViewById(R.id.gallery1);//获取GridView组件

        // 创建BaseAdapter
        BaseAdapter adapter = new BaseAdapter() {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageview;//声明ImageView的对象
                if (convertView == null) {
                    imageview = new ImageView(MainActivity16.this);//实例化ImageView的对象
                    imageview.setScaleType(ImageView.ScaleType.FIT_XY);// 设置缩放方式
                    imageview.setLayoutParams(new Gallery.LayoutParams(300, 300));
                    TypedArray typedArray = obtainStyledAttributes(R.styleable.Gallery);
                    imageview.setPadding(5, 0, 5, 0);// 设置ImageView的内边距
                    imageview.setBackgroundResource(typedArray.getResourceId(
                            R.styleable.Gallery_android_galleryItemBackground, 0));
                } else {
                    imageview = (ImageView)convertView;
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
        gallery.setAdapter(adapter);
        gallery.setSelection(imageId.length / 2);
        gallery.setOnItemClickListener(
                (parent, vieW, position, id) -> Toast.makeText (MainActivity16. this, "您选择了第" + position + "张图片",
                Toast . LENGTH_SHORT). show()
        );
    }
}
