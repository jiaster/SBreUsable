package com.example.jiaweizheng.sbreusable;

class Item {
    String name;
    String description;
    int photoId;
    String user;
    String contact;
    float x;
    float y;

    Item(String name, String description, int photoId, String user, String contact, float x, float y) {
        this.name = name;
        this.description = description;
        this.photoId = photoId;
        this.user = user;
        this.contact = contact;
        this.x = x;
        this.y = y;
    }
}
