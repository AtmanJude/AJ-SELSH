package com.example.myapplication;

public class ReciclerViewItem {

    private int imageView;
    private String zag;
    private String lid;

    public ReciclerViewItem(int imageResource, String zag, String lid) {
        this.imageView = imageView;
        this.zag = zag;
        this.lid=lid;
    }

    public int getImageView() {
        return imageView;
    }

    public String getLid() {
        return lid;
    }

    public String getZag() {
        return zag;
    }
}
