package com.example.geyingqi.coolweather.util;

/**
 * Created by geyingqi on 10/9/15.
 */
public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
