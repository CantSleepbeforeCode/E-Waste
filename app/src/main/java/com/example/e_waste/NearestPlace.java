package com.example.e_waste;

import android.os.Parcel;
import android.os.Parcelable;

public class NearestPlace implements Parcelable {
    String name, description, latitude, longtitude, range, percentage, imageBin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getImageBin() {
        return imageBin;
    }

    public void setImageBin(String imageBin) {
        this.imageBin = imageBin;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.latitude);
        parcel.writeString(this.longtitude);
        parcel.writeString(this.range);
        parcel.writeString(this.percentage);
        parcel.writeString(this.imageBin);
    }

    public NearestPlace() {}

    protected NearestPlace(Parcel in) {
        name = in.readString();
        description = in.readString();
        latitude = in.readString();
        longtitude = in.readString();
        range = in.readString();
        percentage = in.readString();
        imageBin = in.readString();
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
