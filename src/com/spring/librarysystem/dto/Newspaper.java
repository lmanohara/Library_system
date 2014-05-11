package com.spring.librarysystem.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by LahiruI on 5/7/2014.
 */
public class Newspaper extends Material {

    private int meterialId;
    @NotNull(message = "Newspaper title can not be null")
    private String title;
    @NotNull(message = "Newspaper name can not be null")
    private String name;
    private String auditorName;


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

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }
}
