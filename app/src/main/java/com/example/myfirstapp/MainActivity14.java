package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity14 extends AppCompatActivity {

    // 图像索引
    private int index = 0;

    private ImageSwitcher is;

    private int[] imgid = new int[]{R.drawable.gymnasium_a, R.drawable.gymnasium};

    @SuppressLint({"ClickableViewAccessibility", "HandlerLeak"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_linear_layout8);

//        TextView textView = findViewById(R.id.textView1);
//
//
//        // 拖动条
//        SeekBar seekBar = findViewById(R.id.seekBar1);
//
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                textView.setText("当前值:" + progress);
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(MainActivity.this, "开始滑动", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(MainActivity.this, "结束滑动", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        // 星级条
//        RatingBar ratingBar = findViewById(R.id.ratingBar1);
//        Button button = findViewById(R.id.button1);
//
//        button.setOnClickListener(v -> {
//            int result = ratingBar.getProgress(); // 获取进度
//            float rating = ratingBar.getRating(); //获取等级
//            float step = ratingBar.getStepSize(); //获取每次最少要改变多少个星级
//            Log.i("星级评分条", "step=" + step + " result=" + result + " rating=" + rating);
//            Toast.makeText(MainActivity.this, "你得到了" + rating + "颗星",
//                    Toast.LENGTH_SHORT).show();
//        });

        // 选项卡
//        TabHost tabHost = findViewById(android.R.id.tabhost);
//        tabHost.setup(); // 初始化组件
//
//        //
//        LayoutInflater inflater = LayoutInflater . from(this);//声明并实例化一个LayoutInflater对象
//        inflater. inflate(R. layout. tab1, tabHost . getTabContentView());
//        inflater. inflate(R. layout. tab2, tabHost. getTabContentView());
//
//        tabHost. addTab(tabHost . newTabSpec ("tab01" )
//                . setIndicator("智能设备")
//                . setContent(R.id.linearLayout01));//添加第一个标签页
//
//        tabHost . addTab (tabHost . newTabSpec ("tab02")
//                . setIndicator("智慧城市")
//                . setContent (R.id.linearLayout02));//添加第二个标签页
//

        /**
         * 图像切换器
         */
        // 图像切换器对象
        is = (ImageSwitcher) findViewById(R. id. imageSwitcher1);
        //设置动画效果
        //设置淡入动画
        is.setInAnimation (AnimationUtils. loadAnimation(this , android.R.anim.fade_in));
        //设置淡出动画
        is.setOutAnimation (AnimationUtils. loadAnimation(this, android.R.anim.fade_out));

        is.setFactory(() -> {
            ImageView imageView = new ImageView(MainActivity14.this);// 实例化一个ImageView类的对象
            imageView.setScaleType ( ImageView. ScaleType.FIT_CENTER);// 设置保持纵横比居中缩放图像
            imageView.setLayoutParams ( new ImageSwitcher . LayoutParams (LinearLayout.LayoutParams.WRAP_CONTENT ,
                    LinearLayout.LayoutParams. WRAP_CONTENT));
            return imageView;//返 回imageView对象
        });

        is.setImageResource(imgid[index]);

        // 设置按钮点击监听
        Button up = findViewById(R. id.button1);//获取"上一张”按钮
        Button down = findViewById(R. id. button2);//获取"下一张"按钮
        up.setOnClickListener(v -> {
            if (index > 0) {
                index--;//index的值减1
            } else {
                index = imgid.length - 1;
            }
            is.setImageResource(imgid[index]);//显示当前图片
        });

        down. setOnClickListener (v -> {
            if (index < imgid.length - 1) {
                index++;//index的值加1
            } else {
                index = 0;
            }
            is.setImageResource(imgid[index]);//显示当前图片
        });
    }
}
