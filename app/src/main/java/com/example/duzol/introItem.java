package com.example.duzol;

public class introItem {

    String Title,Description;
    int introImg;

    public introItem(String title, String description, int introImg) {
        Title = title;
        Description = description;
        this.introImg = introImg;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getIntroImg() {
        return introImg;
    }

    public void setIntroImg(int introImg) {
        this.introImg = introImg;
    }
}
