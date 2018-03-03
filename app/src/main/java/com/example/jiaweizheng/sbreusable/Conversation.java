package com.example.jiaweizheng.sbreusable;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

class Conversation implements Serializable{
    Item item;
    String lastMessage;
    float x;
    float y;

    String itemName;
    Drawable itemPhoto;
    Drawable itemReducedPhoto;

    Conversation(Item item, String lastMessage, float x, float y) {
        this.item = item;
        this.lastMessage = lastMessage;
        this.x = x;
        this.y = y;

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
