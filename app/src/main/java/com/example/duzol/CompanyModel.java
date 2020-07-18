package com.example.duzol;

public class CompanyModel {
    int companyImage;
    String companyName;

    public CompanyModel(int companyImage, String companyName) {
        this.companyImage = companyImage;
        this.companyName = companyName;
    }

    public int getCompanyImage() {
        return companyImage;
    }

    public void setCompanyImage(int companyImage) {
        this.companyImage = companyImage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
