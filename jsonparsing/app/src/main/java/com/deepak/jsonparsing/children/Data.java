package com.deepak.jsonparsing.children;

import com.google.gson.annotations.SerializedName;

import java.net.URL;

import retrofit2.http.Url;

public class Data {
    @SerializedName("contest_mode")
    private  String contest_mode;
    @SerializedName(" subreddit")
    private  String subreddit;
    @SerializedName("author")
    private String author;
    @SerializedName("url")
    private URL url;

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getContest_mode() {
        return contest_mode;
    }

    public void setContest_mode(String contest_mode) {
        this.contest_mode = contest_mode;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Data{" +
                "contest_mode='" + contest_mode + '\'' +
                ", subreddit='" + subreddit + '\'' +
                ", author='" + author + '\'' +
                ", preview=" + url+
                '}';
    }
}
