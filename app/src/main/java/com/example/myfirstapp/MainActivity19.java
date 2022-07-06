package com.example.myfirstapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity19 extends Activity {

    private ImageSwitcher is;

    private boolean[] checkedItems;//记录各列表项的状态
    private String[] items;// 各列表项要显示的内容


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_linear_layout12);

        //定义并初始化一个保存要显示图片id的数组
        final int imageId[] = new int[]{R.drawable.pic1, R.drawable.pic2,
                R.drawable.pic3, R.drawable.pic4,
                R.drawable.pic6};

        //定义并初始化保存列表项文字的数组
        final String[] title = new String[] { "程序管理", "保密设置", "安全设置","邮件设置", "铃声设置"};
        List<Map<String, Object>> listItems = new ArrayList <>();//创建-一个List 集合

        //通过for循环将图片id和列表项文字放到Map中,并添加到List集合中
        for (int i = 0; i < imageId.length; i++) {
            Map<String, Object> map = new HashMap<>();//实例化 map对象
            map.put("image", imageId[i]);
            map.put("title", title[i]);
            listItems.add(map);//将map对象添加到List集合中
        }

        //创建SimpLeAdapter
        final SimpleAdapter adapter = new SimpleAdapter(this, listItems,
                R.layout.item, new String[] { "title", "image" }, new int[] {R.id.textview1, R.id.imageView1 });


        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity19.this);
            builder.setIcon(R.drawable.pic1);//设置对话框的图标
            builder.setTitle("设置");// 设置对话框的标题
            //添加列表项
            builder . setAdapter (adapter, (dialog, which) -> Toast . makeText (MainActivity19. this,
                    "您选择了[ " + title [which]+" ]", Toast. LENGTH_SHORT). show());
            builder.create().show();//创建对话框并显示
        });




//        ImageButton imageButton = findViewById(R.id.imagebutton);
//
//        //为"显示带取消、中立和确定按钮的对话框"按钮添加单击事件监听器
//        imageButton.setOnClickListener(v -> {
//            AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
//            alert.setIcon(R.drawable.pic1);//设置对话框的图标
//            alert.setTitle("退出?");// 设置对话框的标题
//            alert.setMessage("真的要退出吗?");//设置要显示的内容
//
//            //添加"确定"按钮
//            alert.setButton(DialogInterface.BUTTON_POSITIVE, "确定", (dialog, which) -> {
//                finish();
//            });
//
//            //添加"取消"按钮
//            alert.setButton(DialogInterface.BUTTON_NEGATIVE, "手滑", (dialog, which) -> {
//            });
//            alert.show();//显示对话框
//        });


    }
}

