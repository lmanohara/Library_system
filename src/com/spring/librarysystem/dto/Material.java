package com.spring.librarysystem.dto;


import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * Created by Lahiru on 5/4/2014.
 */
public class Material {




     private int meterialId;
    @NotNull(message = "Material title can not be null")
     private String title;
    @NotNull(message = "Material name can not be null")
     private String name;


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




}
