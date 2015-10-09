package com.example.geyingqi.coolweather.model;
import android.os.Parcel;
import android.os.Parcelable;
/**
 * Created by geyingqi on 10/9/15.
 */
public class City implements Parcelable {
    private int id;
    private String cityName;
    private String cityCode;
    private int provinceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(cityCode);
        dest.writeString(cityName);
        dest.writeInt(provinceId);
    }
    //CREATOR名称不能改变
    public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>(){


        @Override
        public City createFromParcel(Parcel source) {
            return new City(source);
        }

        @Override
        public City[] newArray(int size) {
            return new City[0];
        }
    };

    public City(Parcel in){
        id = in.readInt();
        cityCode = in.readString();
        cityName = in.readString();
        provinceId = in.readInt();
    }

    public City(){}

}
