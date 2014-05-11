package com.spring.librarysystem.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * Created by LahiruI on 5/7/2014.
 */
public class Book extends Material {


    @Digits(integer = 1, fraction = 3, message = "Enter valid book id")
    private int meterialId;
    @NotNull(message = "Book title can not be null")
    private String title;
    @NotNull(message = "Book name can not be null")
    private String name;
    @NotNull(message = "Book ISBN can not be null")
    private String ISBN;
    @Digits(integer = 1, fraction = 3, message = "NO of pages can not be null")
    private int noOfPages;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

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
