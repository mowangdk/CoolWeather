package com.example.geyingqi.coolweather.service;


import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;

import android.preference.PreferenceManager;
import android.util.Log;

import com.example.geyingqi.coolweather.util.HttpCallbackListener;
import com.example.geyingqi.coolweather.util.HttpUtil;
import com.example.geyingqi.coolweather.util.Utility;

/**
 * Created by geyingqi on 10/12/15.
 */
public class AutoUpdateService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                updateWeather();
            }
        }).start();
        return super.onStartCommand(intent,flags,startId);
    }


    //更新天气信息
    private final void updateWeather(){

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherCode = prefs.getString("weather_code", "");
        Log.d("AutoUpdateService", "updateWeather updateWeather = " + weatherCode );
        String address = "http://www.weather.com.cn/data/cityinfo/" + weatherCode + ".html";
        HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                if(response.contains("weatherinfo")) {
                    Utility.handleWeatherResponse(AutoUpdateService.this, response);

                } else {
                    onError(new Exception("该区天气无法访问"));
                }
            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
            }
        });


    }


}
