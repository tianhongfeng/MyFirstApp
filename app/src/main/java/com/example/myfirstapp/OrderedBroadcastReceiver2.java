package com.example.myfirstapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class OrderedBroadcastReceiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText( context, "received in OrderedBroadcastReceiver 2 ",
                Toast. LENGTH_LONG) . show();
        abortBroadcast();
    }
}
