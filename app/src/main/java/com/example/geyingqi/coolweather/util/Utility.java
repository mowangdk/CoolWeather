package com.example.geyingqi.coolweather.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

import com.example.geyingqi.coolweather.db.CoolWeatherDB;
import com.example.geyingqi.coolweather.model.City;
import com.example.geyingqi.coolweather.model.County;
import com.example.geyingqi.coolweather.model.Province;
import com.example.geyingqi.coolweather.model.Weather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by geyingqi on 10/9/15.
 */
public class Utility {
    //处理和解析服务器返回的省级数据
    public final synchronized static boolean handleProvinceResponse(CoolWeatherDB coolWeatherDB,String response){
        if (!TextUtils.isEmpty(response)){
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0){
                for (String p : allProvinces){
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    //将解析出来的数据存储到Province表
                    coolWeatherDB.saveProvince(province);
                }
                return true;
            }

        }
        return false;
    }


    //处理和解析服务器返回的市级数据
    public final static boolean handleCitiesResponse(CoolWeatherDB coolWeatherDB,String response,int provinceId){
        if (! TextUtils.isEmpty(response)){
            String[] allCities = response.split(",");
            if (allCities != null && allCities.length > 0){
                for(String c : allCities){
                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    coolWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }




    //处理县级数据
    public final static boolean handleCountiesResponse (CoolWeatherDB coolWeatherDB, String response,int cityId){
        if (!TextUtils.isEmpty(response)){
            String[] allCounties = response.split(",");
            if (allCounties != null && allCounties.length > 0){
                for(String c : allCounties){
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    // 将解析出来的数据存储到County表
                    coolWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }


    //解析服务器返回的JSON数据,并将解析出的数据存储到本地

    public final static void handleWeatherResponse(Context context,String response)  {
        Log.d("Utility", "show the response = " + response);
        Gson gson = new Gson();
        Type type = new TypeToken<Weather>(){}.getType();
        Weather weather = gson.fromJson(response, type);
        Log.d("Utility", "show the List<weather> = " + weather);
        saveWeatherInfo(context, weather.getWeatherinfo());

//        JSONObject jsonObject = null;
//        try {
//            jsonObject = new JSONObject(response);
//            JSONObject weatherInfo = jsonObject.getJSONObject("weatherinfo");
//            String cityName = weatherInfo.getString("city");
//            String weatherCode = weatherInfo.getString("cityid");
//            String temp1 = weatherInfo.getString("temp1");
//            String temp2 = weatherInfo.getString("temp2");
//            String weatherDesp = weatherInfo.getString("weather");
//            String publishTime = weatherInfo.getString("ptime");
//            saveWeatherInfo(context,cityName,weatherCode,temp1,temp2,weatherDesp,publishTime);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }



    }


//
//
//    private static void saveWeatherInfo(Context context, String cityName, String weatherCode, String temp1, String temp2, String weatherDesp, String publishTime) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日", Locale.CHINA);
//        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
//        editor.putBoolean("city_selected", true);
//        editor.putString("city_name",cityName);
//        editor.putString("weather_code", weatherCode);
//        editor.putString("temp1", temp1);
//        editor.putString("temp2", temp2);
//        editor.putString("weather_desp", weatherDesp);
//        editor.putString("publish_time", publishTime);
//        editor.putString("current_date", sdf.format(new Date()));
//        editor.commit();
//
//    }



    //将服务器返回的所有天气信息存储到SharedPreferences文件中

    private final static void saveWeatherInfo(Context context, Weather.WeatherInfo weather) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日", Locale.CHINA);
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean("city_selected", true);
        editor.putString("city_name",weather.getCity());
        editor.putString("weather_code", weather.getCityid());
        editor.putString("temp1", weather.getTemp1());
        editor.putString("temp2", weather.getTemp2());
        editor.putString("weather_desp", weather.getWeather());
        editor.putString("publish_time", weather.getPtime());
        editor.putString("current_date", sdf.format(new Date()));
        editor.commit();

    }
}
