package com.example.jiaweizheng.sbreusable;

class Item {
    String name;
    String description;
    int photoId;
    int bigPhotoId;
    String category;
    String user;
    String contact;
    float x;
    float y;

    Item(String name, String description, int photoId, int bigPhotoId, String category, String user, String contact, float x, float y) {
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
}
