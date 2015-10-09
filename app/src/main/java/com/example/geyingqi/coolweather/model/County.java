package com.example.geyingqi.coolweather.model;
import android.os.Parcel;
import android.os.Parcelable;
/**
 * Created by geyingqi on 10/9/15.
 */
public class County implements Parcelable {
    private int id;
    private String countyName;
    private String countyCode;
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(cityId);
        dest.writeString(countyCode);
        dest.writeString(countyName);
    }

    public static final Parcelable.Creator<County> CREATOR = new Parcelable.Creator<County>(){


        @Override
        public County createFromParcel(Parcel source) {
            return new County(source);
        }

        @Override
        public County[] newArray(int size) {
            return new County[0];
        }
    };

    public County(Parcel in){
        id = in.readInt();
        cityId = in.readInt();
        countyCode = in.readString();
        countyName = in.readString();
    }

    public County(){}
}
