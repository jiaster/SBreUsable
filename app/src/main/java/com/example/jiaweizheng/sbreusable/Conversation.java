package com.example.jiaweizheng.sbreusable;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

class Conversation implements Serializable{
    private Item item;
    private String lastMessage;

    private String itemName;
    private Drawable itemPhoto;
    private Drawable itemReducedPhoto;
    private float x;
    private float y;

    Conversation(Item item, String lastMessage) {
        this.item = item;
        this.lastMessage = lastMessage;

        x = item.getX();
        y = item.getY();

        itemName = item.getName();
        itemPhoto = item.getPhoto();
        itemReducedPhoto = item.getReducedPhoto();

    }

    public String getName(){
        return itemName;
    }

    public String getUser(){
        return item.getUser();
    }

    public Drawable getReducedPhoto(){
        return itemReducedPhoto;
    }

}
