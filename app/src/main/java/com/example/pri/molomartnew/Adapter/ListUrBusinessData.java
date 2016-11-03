package com.example.pri.molomartnew.Adapter;

/**
 * Created by User on 28/09/2016.
 */
public class ListUrBusinessData {
    public String name,list,price,limit;
    public String rs;

    public ListUrBusinessData(String name, String list,String price,String limit, String rs) {
        this.name = name;
        this.list=list;
        this.price=price;
        this.limit=limit;
        this.rs = rs;
    }
    public String getName() {
        return name;
    }
    public String getList() {
        return list;
    }
    public String getPrice() {
        return price;
    }
    public String getLimit() {
        return limit;
    }
    public String getRs() {
        return rs;
    }

}
