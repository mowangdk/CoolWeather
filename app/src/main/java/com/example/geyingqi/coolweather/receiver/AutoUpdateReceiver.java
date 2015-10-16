package com.example.geyingqi.coolweather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.geyingqi.coolweather.service.AutoUpdateService;

/**
 * Created by geyingqi on 10/12/15.
 */
public class AutoUpdateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("BroadcastReceivcer","intent = " + intent.getAction());
        Intent i = new Intent (context, AutoUpdateService.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startService(i);

    }

}
