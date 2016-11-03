package com.example.pri.molomartnew.Adapter;

/**
 * Created by User on 16/09/2016.
 */public class Data_Image_Gallery {
    private int thumbnail;

    public Data_Image_Gallery() {
    }

    public Data_Image_Gallery(String name, int thumbnail) {

        this.thumbnail = thumbnail;
    }


    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}