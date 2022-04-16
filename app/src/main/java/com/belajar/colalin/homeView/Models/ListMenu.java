package com.belajar.colalin.homeView.Models;

public class ListMenu {
    private String title;
    private String desc;
    private int image;
    private int color;

    public ListMenu(String title, String desc, int image, int color) {
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
