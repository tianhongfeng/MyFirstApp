package com.example.myfirstapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class PhoneBrightnessAdjustFragment extends Fragment {

    View view ;
    TextView tv ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        if(container == null) {
            view = inflater.inflate(R.layout.activity_rightfragment,null);
            tv = (TextView) view.findViewById(R.id.tv);
        }
        return view;
    }

    //提供给TextView设置数据的方法
    public void setTextViewText(String text) {
        tv.setText(text);
    }
}
