package com.example.myfirstapp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity15 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_linear_layout9);

        GridView gridview = findViewById(R.id.gridview1);//获取GridView组件

        //定义并初始化保存图片id的数组
        int[] imageId = new int[]{R.drawable.gymnasium_a, R.drawable.gymnasium_a,
                R.drawable.gymnasium_a, R.drawable.gymnasium_a};

        //定义并初始化保存说明文字的数组
//        String[] title = new String[]{"智能手机", "运营商认证", "自动化测试", "系统升级"};

//        //创建- - 个List集合
//        List<Map<String, Object>> listItems = new ArrayList<>();
//
//        //通过for循环将图片id和列表项文字放到Map中,并添加到List集合中
//        for (int i = 0; i < imageId.length; i++) {
//            Map<String, Object> map = new HashMap<>();
//            map.put("image", imageId[i]);
//            map.put("title", title[i]);
//            listItems.add(map);//将map对象添加到List集合中
//        }

//        // 创建SimpleAdapter
//        SimpleAdapter adapter = new SimpleAdapter(
//                this, listItems, R.layout.item1, new String[] {"title",
//                "image"},new int[]{R.id.textview1, R.id.imageView1});

        // 创建BaseAdapter
        BaseAdapter adapter = new BaseAdapter() {
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

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageview;//声明ImageView的对象
                if (convertView == null) {
                    imageview = new ImageView(MainActivity15.this);//实例化ImageView的对象
                    imageview.setScaleType(ImageView.ScaleType.CENTER_INSIDE);// 设置缩放方式
                    imageview.setPadding(5, 0, 5, 0);// 设置ImageView的内边距
                    imageview.setLayoutParams(new LinearLayout.LayoutParams(100, 100));
                } else {
                    imageview = (ImageView)convertView;
                }
                imageview.setImageResource(imageId[position]);//为ImageView设置要显示的图片
                return imageview;// 返回ImageView
            }
        };
        gridview.setAdapter(adapter);
    }
}
