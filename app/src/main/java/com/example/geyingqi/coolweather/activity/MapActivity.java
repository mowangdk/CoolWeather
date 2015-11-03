package com.example.geyingqi.coolweather.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.example.geyingqi.coolweather.R;

/**
 * Created by geyingqi on 11/3/15.
 */
public class MapActivity extends Activity {
    MapView mapView;
    BaiduMap mBaiduMap;
    MapStatusUpdate update;
    BitmapDescriptor mCurrentMarker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.map_layout);
        Intent intent = getIntent();
        double latitude = intent.getDoubleExtra("latitude", 0.0);
        double longitude = intent.getDoubleExtra("longitude",0.0);
        float Radius = intent.getFloatExtra("radius",0);
        mapView = (MapView) findViewById(R.id.mapView);
        mBaiduMap = mapView.getMap();
        mBaiduMap.setMyLocationEnabled(true);
        MyLocationData locData = new MyLocationData.Builder().accuracy(Radius)
                .direction(100).latitude(latitude).longitude(longitude).build();
        mBaiduMap.setMyLocationData(locData);
        Log.d("MapActivity", "latitude = "+latitude+" longitude = "+longitude + "radius = "+Radius);
        update = MapStatusUpdateFactory.newLatLng(new LatLng(latitude, longitude));
        mCurrentMarker = BitmapDescriptorFactory.fromResource(R.drawable.notification_template_icon_bg);
        MyLocationConfiguration config = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL,true,mCurrentMarker);
        mBaiduMap.setMyLocationConfigeration(config);
        mBaiduMap.setMapStatus(update);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }
}
