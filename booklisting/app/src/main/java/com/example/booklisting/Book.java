package com.example.booklisting;

public class Book {
    private String mAuthors;
    private String mDatePublis;
    private String mTitle;
    private String mRate;

    public Book(String mAuthors, String mDatePublis, String mTitle, String mRate) {
        this.mAuthors = mAuthors;
        this.mDatePublis = mDatePublis;
        this.mTitle = mTitle;
        this.mRate = mRate;
    }

    public String getmAuthors() {
        return mAuthors;
    }

    public void setmAuthors(String mAuthors) {
        this.mAuthors = mAuthors;
    }

    public String getmDatePublis() {
        return mDatePublis;
    }

    public void setmDatePublis(String mDatePublis) {
        this.mDatePublis = mDatePublis;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmRate() {
        return mRate;
    }

    public void setmRate(String mRate) {
        this.mRate = mRate;
    }
}
