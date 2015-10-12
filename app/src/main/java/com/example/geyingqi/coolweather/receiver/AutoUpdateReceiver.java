package com.example.geyingqi.coolweather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.geyingqi.coolweather.service.AutoUpdateService;

/**
 * Created by geyingqi on 10/12/15.
 */
public class AutoUpdateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent (context, AutoUpdateService.class);
        context.startActivity(i);
    }
}
