package com.softbd.googleplaystoreclone.model;

public class ModelData {
    private int imageId;
    private String title;
    private String size;

    public ModelData() {

    }

    public ModelData(int imageId, String title, String size) {
        this.imageId = imageId;
        this.title = title;
        this.size = size;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
