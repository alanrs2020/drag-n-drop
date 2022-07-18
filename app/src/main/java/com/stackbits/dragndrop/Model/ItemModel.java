package com.stackbits.dragndrop.Model;

import java.io.Serializable;

public class ItemModel implements Serializable {
    String name;
    int bitmap;


    public ItemModel(String name, int bitmap) {
        this.name = name;
        this.bitmap = bitmap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBitmap() {
        return bitmap;
    }

    public void setBitmap(int bitmap) {
        this.bitmap = bitmap;
    }
}
