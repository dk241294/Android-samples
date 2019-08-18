package com.example.androidversion;

import android.media.Image;
import android.widget.ImageView;

public class AndroidFlavour {
    private String versionName;
    private int imageResourceId;
    private String versionNumber;

    public AndroidFlavour(String versionName, int imageResourceId, String versionNumber) {
        this.versionName = versionName;
        this.imageResourceId = imageResourceId;
        this.versionNumber = versionNumber;
    }

    public String getVersionName() {
        return versionName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getVersionNumber() {
        return versionNumber;
    }
}
