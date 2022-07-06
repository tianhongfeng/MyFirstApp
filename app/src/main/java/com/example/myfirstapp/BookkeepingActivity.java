package com.example.myfirstapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookkeepingActivity extends AppCompatActivity {
    private final String[] columns = {"time", "billkeep", "money"};
    private Uri uri = Uri.parse("content://com.tian.billProvider");
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookkeeping);

        // 记账项
        EditText billkeep = findViewById(R.id.billkeep);

        // 记账金额
        EditText money = findViewById(R.id.money);

        // 添加按钮
        Button button = findViewById(R.id.submit);

        // listview
        ListView bill= findViewById(R.id.bill);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s2 = money.getText().toString();
                String s1 = billkeep.getText().toString();

                list.clear();

                // add
                if (!s1.equals("") && !s2.equals("")){
                    ContentResolver resolver = getContentResolver();
                    ContentValues contentValues = new ContentValues();

                    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date(System.currentTimeMillis());

                    contentValues.put("time",formatter.format(date));
                    contentValues.put("money",s2);
                    contentValues.put("billkeep",s1);

                    Log.i("bill","target------------->" + contentValues.get("time")
                            +"||"+ contentValues.get("money")
                            +"||"+ contentValues.get("billkeep") );
                    resolver.insert(uri,contentValues);


                    // query
                    Cursor cursor = resolver.query(uri, null, null, null, null);
                    while (cursor.moveToNext()){
                        int columnIndex = cursor.getColumnIndex(columns[0]);
                        int columnIndex1 = cursor.getColumnIndex(columns[1]);
                        int columnIndex2 = cursor.getColumnIndex(columns[2]);
                        String string = cursor.getString(columnIndex);
                        String string1 = cursor.getString(columnIndex1);
                        String string2 = cursor.getString(columnIndex1);
                        list.add(string + "  " +  string1 + "花费  " + string2);
                    }

                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                            BookkeepingActivity.this, android.R.layout.simple_list_item_1, list);
                    bill.setAdapter(arrayAdapter);
                    cursor.close();
                }
            }
        });
    }
}