package com.example.pri.molomartnew.Adapter;

/**
 * Created by Pri on 9/17/2016.
 */
public class Data {
    public String title;
    public String category;
    public String location;
    public String  phno;
    public String description;
    public int imageId;

    public Data(String title, String category, String location, String phno, String description, int imageId) {
        this.title = title;
        this.category=category;
        this.location=location;
        this.phno=phno;
        this.description = description;
        this.imageId = imageId;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getLocation() {
        return location;
    }

    public String getPhno() {
        return phno;
    }
    public String getDescription() {
        return description;
    }
    public int getImageId() {
        return imageId;
    }
}