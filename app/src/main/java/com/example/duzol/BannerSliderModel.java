package com.example.duzol;

public class BannerSliderModel {
    private int bannerImage;
    private String backgroundColor;


    public BannerSliderModel(int bannerImage, String backgroundColor) {
        this.bannerImage = bannerImage;
        this.backgroundColor = backgroundColor;
    }

    public int getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(int bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
