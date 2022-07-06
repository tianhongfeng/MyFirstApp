package com.example.myfirstapp;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.FragmentManager;

public class PhoneListFragment extends android.app.ListFragment {

    int curCheckPosition = 0;//当前选择的索引位置

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_checked, PhoneData.TITLES));//为列表设置适配器

        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);// 设置列表为单选模式
        showDetails(curCheckPosition);//显示详细内容
    }

    //重写onListItemClick()方法
    @Override
    public void onListItemClick (ListView l, View v,int position, long id) {
        showDetails(position);//调用showDetails()方法显示详细内容
    }

    void showDetails (int index){
        //通过FragmentManager找到需要操作的fragment
        PhoneBrightnessAdjustFragment rightFragment = (PhoneBrightnessAdjustFragment)
                getFragmentManager().findFragmentById(R.id.rightFragment);
        rightFragment.setTextViewText(PhoneData.TITLES[index]);
    }
}
