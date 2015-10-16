package com.example.geyingqi.coolweather.model;

import android.os.Parcel;
import android.os.Parcelable;
/**
 * Created by geyingqi on 10/13/15.
 */
public class Weather  {

    public WeatherInfo weatherinfo;

    public WeatherInfo getWeatherinfo() {
        return weatherinfo;
    }

    public void setWeatherinfo(WeatherInfo weatherinfo) {
        this.weatherinfo = weatherinfo;
    }

    public static class WeatherInfo{

        public String city;

        public String cityid;


        public String temp1;

        public String temp2;

        public String weather;

        public String ptime;


        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityid() {
            return cityid;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public String getTemp1() {
            return temp1;
        }

        public void setTemp1(String temp1) {
            this.temp1 = temp1;
        }

        public String getTemp2() {
            return temp2;
        }

        public void setTemp2(String temp2) {
            this.temp2 = temp2;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        @Override
        public String toString() {
            return "WeatherInfo{" +
                    "city='" + city + '\'' +
                    ", cityid='" + cityid + '\'' +
                    ", temp1='" + temp1 + '\'' +
                    ", temp2='" + temp2 + '\'' +
                    ", weather='" + weather + '\'' +
                    ", ptime='" + ptime + '\'' +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "Weather{" +
                "weatherinfo=" + weatherinfo +
                '}';
    }
}
