package com.example.earthquake;

public class Earthquake {
    private String mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;
    private String mUrl;


    public String getmUrl() {
        return mUrl;
    }


    public Earthquake(String magnitude, String location, long timeInMilliseconds,String Url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl=Url;
    }

    public double getMagnitude() {
        return Double.parseDouble(mMagnitude);
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
