package com.example.myfirstapp;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.CursorAdapter;
import android.widget.FilterQueryProvider;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity28 extends AppCompatActivity {


    private String[] columns = {
            ContactsContract.Contacts._ID,//希望获得ID值
            ContactsContract.Contacts.DISPLAY_NAME, //希望获得姓名
            ContactsContract.CommonDataKinds.Phone.NUMBER, //希望获得电话号
            ContactsContract.CommonDataKinds.Phone.CONTACT_ID};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_linear_layout20);

        TextView tv = findViewById(R.id.result); //获得布局文件中的标签
        tv.setText(getQueryData());//为标签设置数据


//        ContentResolver resolver = getContentResolver();
//        Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI,
//                columns, null, null, null);
//        ContactListAdapter adapter = new ContactListAdapter(this, cursor);
//        AutoCompleteTextView textView = findViewById(R.id.edit);
//        textView.setAdapter(adapter);
    }

    private String getQueryData() {
        StringBuilder sb = new StringBuilder();//用于保存字符串
        ContentResolver resolver = getContentResolver(); //获得ContentResolver对象
        Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI, null,
                null, null, null); //查询记录


        while (cursor.moveToNext()) {
            int idIndex = cursor.getColumnIndex(columns[0]); //获得ID记录的索引值
            int displayNameIndex = cursor.getColumnIndex(columns[1]);//获得姓名记录的索引值

            int id = cursor.getInt(idIndex);
            String displayName = cursor.getString(displayNameIndex);

            Cursor phone = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null, columns[3] + "=" + id,
                    null, null);
            while (phone.moveToNext()) {
                int phoneNumbeindex = phone.getColumnIndex(columns[2]);
                String phoneNumber = phone.getString(phoneNumbeindex);
                sb.append(displayName + ":  " + phoneNumber + "\n");
            }
        }
        cursor.close();//关闭Cursor
        return sb.toString();//返回查询结果
    }
}

//class ContactListAdapter extends CursorAdapter {
//    private ContentResolver resolver;
//    private String[] columns = new String[]{ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME};
//
//    public ContactListAdapter(Context context, Cursor c) {
//        super(context, c);// 调用父类构造方法
//        resolver = context.getContentResolver();//初始化ContentResolver
//    }
//
//    @Override
//    public void bindView(View arg0, Context arg1, Cursor arg2) {
//        ((TextView) arg0).setText(arg2.getString(1));
//    }
//
//    @Override
//    public View newView(Context context, Cursor cursor, ViewGroup parent) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        TextView view = (TextView)
//                inflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false);
//        view.setText(cursor.getString(1));
//        return view;
//    }
//
//    @Override
//    public CharSequence convertToString(Cursor cursor) {
//        return cursor.getString(1);
//    }
//
//    @Override
//    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
//        FilterQueryProvider filter = getFilterQueryProvider();
//        if (filter != null) {
//            return filter.runQuery(constraint);
//        }
//        Uri uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI,
//                Uri.encode(constraint.toString()));
//        return resolver.query(uri, columns, null, null, null);
//    }
//}




