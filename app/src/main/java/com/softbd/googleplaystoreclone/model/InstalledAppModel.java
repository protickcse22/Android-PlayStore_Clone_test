package com.softbd.googleplaystoreclone.model;

import android.graphics.drawable.Drawable;

public class InstalledAppModel {
    Drawable icon;
    private String name;
    private String packages;

    public InstalledAppModel(String name, Drawable icon, String packages) {
        this.name = name;
        this.icon = icon;
        this.packages = packages;
    }

    public String getName() {
        return name;
    }

    public Drawable getIcon() {
        return icon;
    }

    public String getPackages() {
        return packages;
    }

}

