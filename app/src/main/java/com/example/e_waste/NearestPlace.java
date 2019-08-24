package com.example.e_waste;

import android.os.Parcel;
import android.os.Parcelable;

public class NearestPlace implements Parcelable {
    String latitude, longtitude, range;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.latitude);
        parcel.writeString(this.longtitude);
        parcel.writeString(this.range);
    }

    public NearestPlace() {}

    protected NearestPlace(Parcel in) {
        latitude = in.readString();
        longtitude = in.readString();
        range = in.readString();
    }

    public static final Creator<NearestPlace> CREATOR = new Creator<NearestPlace>() {
        @Override
        public NearestPlace createFromParcel(Parcel in) {
            return new NearestPlace(in);
        }

        @Override
        public NearestPlace[] newArray(int size) {
            return new NearestPlace[size];
        }
    };


}
