package com.stackbits.dragndrop.Model;

public class DragData {

    public final ItemModel item;
    public final int width;
    public final int height;

    public DragData(ItemModel item, int width, int height) {
        this.item= item;
        this.width = width;
        this.height = height;
    }

}
