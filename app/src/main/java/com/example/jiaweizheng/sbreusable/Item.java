package com.example.jiaweizheng.sbreusable;

import java.io.Serializable;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

class Item implements Serializable{
    String name;
    String description;
//    int photoId;
//    int bigPhotoId;
    String category;
    String user;
    String contact;
    float x;
    float y;
    Drawable photo;
    Drawable reducedPhoto;

   /* Item(String name, String description, int photoId, int bigPhotoId, String category, String user, String contact, float x, float y) {
        this.name = name;
        this.description = description;
        this.photoId = photoId;
        this.bigPhotoId = bigPhotoId;
        this.category = category;
        this.user = user;
        this.contact = contact;
        this.x = x;
        this.y = y;
    }
    */
    Item(String name, String description, Drawable photo, Drawable reducedPhoto, String category, String user, String contact, float x, float y) {
        this.name = name;
        this.description = description;
        this.reducedPhoto = reducedPhoto;
        this.photo = photo;
        this.category = category;
        this.user = user;
        this.contact = contact;
        this.x = x;
        this.y = y;
    }

    public String getName(){
        return name;
    }

    public Drawable getPhoto(){
        return photo;
    }

    public Drawable getReducedPhoto(){
        return reducedPhoto;
    }

    public String getUser(){
        return user;
    }


}
