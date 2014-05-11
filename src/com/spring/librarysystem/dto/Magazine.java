package com.spring.librarysystem.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * Created by LahiruI on 5/7/2014.
 */
public class Magazine extends Material{

    //@Digits(integer = 1, fraction = 3, message = "Enter valid magazine id")
    private int meterialId;

    private String title;

    private String name;

    private int magazineType;

    private String reviewerName;


    public int getMeterialId() {
        return meterialId;
    }


    public void setMeterialId(int meterialId) {
        this.meterialId = meterialId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getMagazineType() {
        return magazineType;
    }

    public void setMagazineType(int magazineType) {
        this.magazineType = magazineType;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }
}
