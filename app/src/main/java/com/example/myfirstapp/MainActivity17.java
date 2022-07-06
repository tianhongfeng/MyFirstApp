package com.example.myfirstapp;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageSwitcher;

import androidx.annotation.RequiresApi;

public class MainActivity17 extends Activity {

    //定义并初始化一个保存要显示图片id的数组
    final private int imageId[] = new int[]{R.drawable.pic1, R.drawable.pic2,
            R.drawable.pic3, R.drawable.pic4,
            R.drawable.pic6};

    private ImageSwitcher is;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_linear_layout11);

        //通知栏管理器(得到系统服务)
        final NotificationManager manager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String id = "channel_1"; //自定义设置通道ID属性
        String description = "123";//自定义 设置通道描述属性

        int importance = NotificationManager.IMPORTANCE_HIGH;//通知栏管理重要提示消息声音设定
        int NOTIFYID_1 = 0x1;
        int NOTIFYID_2 = 0x2;


        // 为关闭通知按钮添加监听事件
        Button button02 = findViewById(R.id.button2);
        button02.setOnClickListener(v1 -> {
            manager.cancel(NOTIFYID_1); //清除ID号为常量NOTIFYID_ 1的通知
            manager.cancelAll();//清除全部通知
        });

        Button button1 = findViewById(R.id.button1);//获取"显示通知”按钮

        //为"显示通知"按钮添加单击事件监昕器
        button1.setOnClickListener(v -> {
            //建立通知栏通道类(需要有ID,重要属性)
            NotificationChannel mChannel = new NotificationChannel(id, "123", importance);
            mChannel.setDescription(description); //配置通知渠道的属性
            mChannel.enableLights(true);//设置通知出现时的闪灯(如果android设备支持的话)
            mChannel.enableVibration(true); // 设置通知出现时的震动(如果android设备支持的话)
            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200,
                    400});

            //最后在notificationmanager中创建该通知渠道
            manager.createNotificationChannel(mChannel);
            Notification notification = new
                    Notification.Builder(MainActivity17.this, id)// 创建Notification对象。
                    .setContentTitle("这是通知的标题") //设置通知标题
                    .setSmallIcon(R.drawable.pic1)//设置通知小图标
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                            R.drawable.pic1))//设置通知大图标
                    .setContentText("这是通知的内容")//设置通知内容
                    .setAutoCancel(true)//设置自动删除通知
                    .build();//运行
            manager.notify(NOTIFYID_1, notification); /* 通知栏保留多条通知 */



            Intent intent = new Intent(MainActivity17.this, ContentActivity.class);
            PendingIntent pendingIntent =
                    PendingIntent.getActivity(MainActivity17.this, 0, intent, 0);

            Notification notification2 = new
                    Notification.Builder(MainActivity17.this, id)// 创建Notification对象。
                    .setContentTitle("我是通知标题") // 设置通知标题
                    .setSmallIcon(R.drawable.pic2)//设置通知小图标
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                            R.drawable.pic2))//设置通知大图标
                    .setContentText("Welcome to Android")//设置通知内容
                    .setAutoCancel(true)//设置自动删除通知
                    .setContentIntent(pendingIntent)
                    .build();//运行
            manager.notify(NOTIFYID_2, notification2); //通知栏保留多条通知
        });

        //        Gallery gallery =  findViewById(R.id.gallery1);
//        is = findViewById(R.id.imageSwitcher1);
//
//        //设置动画效果
//        //设置淡入动画
//        is.setInAnimation (AnimationUtils. loadAnimation(this , android.R.anim.fade_in));
//        //设置淡出动画
//        is.setOutAnimation (AnimationUtils. loadAnimation(this, android.R.anim.fade_out));
//
//        is.setFactory(() -> {
//            ImageView imageView = new ImageView(MainActivity.this);// 实例化一个ImageView类的对象
//            imageView.setScaleType ( ImageView. ScaleType.FIT_CENTER);// 设置保持纵横比居中缩放图像
//            imageView.setLayoutParams (new ImageSwitcher.LayoutParams(300 , 500));
//            return imageView;//返 回imageView对象
//        });
//
//        // 创建BaseAdapter
//        BaseAdapter adapter = new BaseAdapter() {
//
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                ImageView imageview;//声明ImageView的对象
//                if (convertView == null) {
//                    imageview = new ImageView(MainActivity.this);//实例化ImageView的对象
//                    imageview.setScaleType(ImageView.ScaleType.FIT_XY);// 设置缩放方式
//                    imageview.setLayoutParams(new Gallery.LayoutParams(300, 300));
//                    TypedArray typedArray = obtainStyledAttributes(R.styleable.Gallery);
//                    imageview.setPadding(5, 0, 5, 0);// 设置ImageView的内边距
//                    imageview.setBackgroundResource(typedArray.getResourceId(
//                            R.styleable.Gallery_android_galleryItemBackground, 0));
//                } else {
//                    imageview = (ImageView)convertView;
//                }
//                imageview.setImageResource(imageId[position]);//为ImageView设置要显示的图片
//                return imageview;// 返回ImageView
//            }
//
//            @Override
//            public int getCount() {
//                return imageId.length;
//            }
//
//            @Override
//            public Object getItem(int position) {
//                return position;
//            }
//
//            @Override
//            public long getItemId(int position) {
//                return position;
//            }
//        };
//
//        gallery.setAdapter(adapter);
//        gallery.setSelection(imageId.length / 2);
//        gallery.setOnItemClickListener(
//                (parent, vieW, position, id) -> is.setImageResource(imageId[position])//显示当前图片
//        );
//        Toast toast=new Toast(this);
//        toast.setDuration(Toast.LENGTH_SHORT);// 设置持续时间
//        toast.setGravity(Gravity.CENTER, 0, 0);// 设置对齐方式
//        LinearLayout ll = new LinearLayout(this); // 补创建 -一个线性布局管理器
//        ll.setOrientation(LinearLayout.VERTICAL);
//        ImageView iv=new ImageView(this);// 创建- - 个ImageView
//        iv.setLayoutParams(new LinearLayout.LayoutParams(300, 600));
//        iv.setImageResource(R.drawable.pic1);//设置要显示的图片
//        iv.setPadding(0, 0, 5, 0);// 设置ImageView的内边距
//        ll.addView(iv);//将ImageView添加到线性布局管理器中
//        TextView tv=new TextView(this);// 创建-一个TextView
//        tv.setText("我是通过构造方法创建的消息提示框");//为TextView设置文本内容
//        ll.addView(tv);//将TextView添加到线性布局管理器中
//        toast.setView(ll);//设置消息提示框中要显示的视图
//        toast .show();//显示消息提示框

        }
    }



