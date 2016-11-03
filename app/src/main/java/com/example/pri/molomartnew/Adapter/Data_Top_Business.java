package com.example.pri.molomartnew.Adapter;

/**
 * Created by User on 20/09/2016.
 */
public class Data_Top_Business {
    public String title;
    public String city;
    public int imageId;

    public Data_Top_Business(String title, String city, int imageId) {
        this.title = title;
        this.city=city;
        this.imageId = imageId;
    }
    public String getTitle() {
        return title;
    }
    public String getCity() {
        return city;
    }
    public int getImageId() {
        return imageId;
    }

}
