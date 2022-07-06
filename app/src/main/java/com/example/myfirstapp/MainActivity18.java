package com.example.myfirstapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class MainActivity18 extends Activity {

    //定义并初始化一个保存要显示图片id的数组
    final private int imageId[] = new int[]{R.drawable.pic1, R.drawable.pic2,
            R.drawable.pic3, R.drawable.pic4,
            R.drawable.pic6};

    private ImageSwitcher is;

    private boolean[] checkedItems;//记录各列表项的状态
    private String[] items;// 各列表项要显示的内容


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_linear_layout11);

        //获取"显示带取消、中立和确定按钮的对话框"按钮
        Button button1 = (Button) findViewById(R.id.button1);

        //为"显示带取消、中立和确定按钮的对话框"按钮添加单击事件监听器
        button1.setOnClickListener(v -> {
            AlertDialog alert = new AlertDialog.Builder(MainActivity18.this).create();
            alert.setIcon(R.drawable.pic1);//设置对话框的图标
            alert.setTitle("系统提示: ");// 设置对话框的标题
            alert.setMessage("带取消、中立和确定按钮的对话框!");//设置要显示的内容


            //添加"确定"按钮
            alert.setButton(DialogInterface.BUTTON_POSITIVE, "确定", (dialog, which) -> {
                Toast.makeText(MainActivity18.this, "您单击了确定按钮", Toast.LENGTH_SHORT).show();
            });

            //添加"取消"按钮
            alert.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", (dialog, which) -> {
                Toast.makeText(MainActivity18.this, "您单击了取消按钮", Toast.LENGTH_SHORT).show();
            });

            //添加"中立"按钮
            alert.setButton(DialogInterface.BUTTON_NEUTRAL, "中立", (dialog, which) -> {
            });

            alert.show();//显示对话框

        });

        Button button2 = (Button) findViewById(R.id.button2);//获取”显示带列表的对话框"按钮
        button2.setOnClickListener(v -> {
            final String[] items = new String[]{"跑步", "羽毛球", "乒乓球", "网球", "体操"};
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity18.this);
            builder.setIcon(R.drawable.pic1);//设置对话框的图标
            builder.setTitle("请选择你喜欢的运动项目: ");// 设置对话框的标题
            //添加列表项
            builder.setItems(items, (dialog, which) -> Toast.makeText(
                    MainActivity18.this, "您选择了" + items[which], Toast.LENGTH_SHORT).show());
            builder.create().show();//创建对话框并显示
        });


        Button button3 = (Button) findViewById(R.id.button3);//获取"显示带单选列表项的对话框"按钮
        button3.setOnClickListener(v -> {
            final String[] items = new String[]{"标准", "无声", "会议", "户外", "离线"};
            // 显示带单选列表项的对话框
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity18.this);
            builder.setIcon(R.drawable.pic1);//设置对话框的图标
            builder.setTitle("请选择要使用的情景模式: ");// 设置对话框的标题

            //显示选择结果
            builder.setSingleChoiceItems(items, 0, (dialog, which) -> Toast.makeText(
                    MainActivity18.this, "您选择了" + items[which], Toast.LENGTH_SHORT).show());

            builder.setPositiveButton("确定", null);//添加"确定”按钮
            builder.create().show();//创建对话框并显示
        });

        Button button4 = (Button) findViewById(R.id.button4);//获取”显示带多选列表项的对话框"按钮
        button4.setOnClickListener(v -> {
            checkedItems = new boolean[]{false, false, false, false, false};// 记录各列表功的状态

            items = new String[]{"植物大战僵尸", "愤怒的小鸟", "泡泡龙", "开心农场", "超级玛丽"};// 各列表项要显示的内容

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity18.this);//显示带单选列表项的对话框

            builder.setIcon(R.drawable.pic1);//设置对话框的图标
            builder.setTitle("请选择您喜爱的游戏:");//设置对话框的标题
            builder.setMultiChoiceItems(items, checkedItems, (dialog, which, isChecked) -> {
                checkedItems[which] = isChecked;//改变被操作列表项的状态
            });

            //为对话框添加”确定"按钮
            builder.setPositiveButton("确定", (dialog, which) -> {
                String result = "";//用于保存选 择结果
                for (int i = 0; i < checkedItems.length; i++) {
                    if (checkedItems[i]) {//当选项被选择时
                        result += items[i] + "、";//将选项的内容添加到result中
                    }
                }
                //当result不为空时,通过消息提示框显示选择的结果
                if (!"".equals(result)) {
                    result = result.substring(0, result.length() - 1);//去掉最后面的 "、" 号
                    Toast.makeText(MainActivity18.this,
                            "您选择了[ " + result + " ]", Toast.LENGTH_LONG).show();
                }
            });
            builder.create().show();//创建对话框并显示
        });
    }
}

