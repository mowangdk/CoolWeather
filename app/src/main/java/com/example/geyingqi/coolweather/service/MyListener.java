package com.example.geyingqi.coolweather.service;

import android.util.Log;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;

/**
 * Created by geyingqi on 11/3/15.
 */
public class MyListener implements BDLocationListener {
    StringBuilder sb = new StringBuilder();
    TextView location;
    private double latitude;
    private double longitude;
    private float radius;
    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
        if (BDLocation.TypeNetWorkLocation == bdLocation.getLocType()){
            //网络定位结果

            sb.append("当前所在城市:");
            sb.append(bdLocation.getCity());
            location.setText(sb.toString());
            Log.d("CityCode", "show the CityCode = " + bdLocation.getCityCode());
            sb.delete(0, sb.length());
            Log.d("CityStringBuiler", "show the City StringBuilder = " + sb);
            latitude = bdLocation.getLatitude();
            longitude = bdLocation.getLongitude();
            radius = bdLocation.getRadius();
        }
    }
    public MyListener(TextView location){
        this.location = location;
    }

    public double getLatitude() {
        return latitude;
    }



    public double getLongitude() {
        return longitude;
    }


    public float getRadius() {
        return radius;
    }


}
