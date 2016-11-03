package com.example.pri.molomartnew.Adapter;

/**
 * Created by User on 16/09/2016.
 */public class Data_dashboard {
    private String name;
    private int thumbnail;

    public Data_dashboard() {
    }

    public Data_dashboard(String name, int thumbnail) {
        this.name = name;

        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}