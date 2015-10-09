package com.example.geyingqi.coolweather.model;
import android.os.Parcel;
import android.os.Parcelable;
/**
 * Created by geyingqi on 10/9/15.
 */
public class Province implements Parcelable {
    private int id;
    private String provinceName;
    private String provinceCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(provinceCode);
        dest.writeString(provinceName);
        dest.writeInt(id);
    }

    public static final Parcelable.Creator<Province> CREATOR = new Parcelable.Creator<Province>(){
        @Override
        public Province createFromParcel(Parcel source) {
            return new Province(source);
        }

        @Override
        public Province[] newArray(int size) {
            return new Province[0];
        }
    };

    public Province(Parcel source){
        id = source.readInt();
        provinceCode = source.readString();
        provinceName = source.readString();
    }
    public Province(){

    }

}
