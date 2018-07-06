package com.example.angel.myapplication.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Person implements Parcelable {

    private String Name;
    private String Age;
    private String FavoriteColor;

    public Person(String name, String age, String favoriteColor) {
        Name = name;
        Age = age;
        FavoriteColor = favoriteColor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Name);
        parcel.writeString(this.Age);
        parcel.writeString(this.FavoriteColor);
    }
}