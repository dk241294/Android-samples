package com.example.retrofitexample;

import com.google.gson.annotations.SerializedName;

public class Hero {
    private String name;
    @SerializedName("realname")
    private String realName;
    private String team;
    @SerializedName("firstappearance")
    private String firstAppearance;
    @SerializedName("createdby")
    private String CreatedBy;
    private String publisher;
    private String imageurl;
    private String bio;

    public Hero(String name, String realName, String team, String firstAppearance, String createdBy, String publisher, String imageurl, String bio) {
        this.name = name;
        this.realName = realName;
        this.team = team;
        this.firstAppearance = firstAppearance;
        CreatedBy = createdBy;
        this.publisher = publisher;
        this.imageurl = imageurl;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public String getTeam() {
        return team;
    }

    public String getFirstAppearance() {
        return firstAppearance;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getBio() {
        return bio;
    }
}
