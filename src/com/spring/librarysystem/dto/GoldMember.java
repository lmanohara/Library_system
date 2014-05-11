package com.spring.librarysystem.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * Created by LahiruI on 5/7/2014.
 */
public class GoldMember extends Member{

    @Digits(integer = 1, fraction = 3, message = "Enter valid GoldMember id")
    private int memberId;
    @NotNull(message = "Member name can not be null")
    private String name;
    @NotNull(message = "Member address can not be null")
    private String address;
    @NotNull(message = "Member name can not be null")
    private String creditCardNo;
    @NotNull(message = "Member vehicle no can not be null")
    private String vehicleNo;
    private Material material;
    private String borrowDate;


    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }
}
