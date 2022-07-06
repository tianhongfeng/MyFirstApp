package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity11 extends ListActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 为listView创建适配器
        String[] ctype = new String[5];
        for (int i = 0; i < 5; i++) {
            ctype[i] = "田洪锋" + i;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_single_choice, ctype);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String result = l.getItemAtPosition(position).toString();
        Toast.makeText(this, "您选择了第"+ result.substring(result.length() - 1)+ "项", Toast.LENGTH_SHORT).show();
    }

}