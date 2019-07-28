package com.example.earthquake;

import android.app.Activity;
import android.support.v7.widget.AppCompatAutoCompleteTextView;

public class Earthquake  {
    private String mMagnitude;
    private String mLocation;
    private String mDate;

    public Earthquake(String magnitude,String location,String date){
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;

    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getdate() {
        return mDate;
    }
}
