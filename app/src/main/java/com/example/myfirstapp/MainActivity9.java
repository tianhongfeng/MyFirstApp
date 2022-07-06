package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity9 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private int year, month, hour, day, minute;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_linear_layout2);

        DatePicker datePicker = findViewById(R.id.datePicker);
        TimePicker timePicker = findViewById(R.id.timePicker);

        // 设置24小时格式
        timePicker.setIs24HourView(true);

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(calendar.YEAR);
        month = calendar.get(calendar.MONTH);
        day = calendar.get(calendar.DAY_OF_MONTH);
        hour = calendar.get(calendar.HOUR_OF_DAY);
        minute = calendar.get(calendar.MINUTE);

        datePicker.init(year, month, day, (view, year, monthOfYear, dayOfMonth) -> {
            this.year = year;
            this.month = monthOfYear;
            this.day = dayOfMonth;
            show(year, month, day, hour, minute);
        });

        timePicker.setOnTimeChangedListener((view, hourOfDay, minute) -> {
            this.hour = hourOfDay;
            this.minute = minute;
            show(year, month, day, hour, minute);
        });
    }

    private void show(int year, int month, int day, int hour, int minute) {
        StringBuilder sb = new StringBuilder();
        sb.append(year).append("年").append(month).append("月").append(day).append("日").
                append(hour).append(":").append(minute);
        Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
    }


}