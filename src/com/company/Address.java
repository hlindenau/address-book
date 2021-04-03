package com.company;

import javax.lang.model.type.NullType;
import java.io.Serializable;

public class Address implements Serializable {
    private String street ="";
    private String houseNumber = "";
    private String flatNumber ="";
    private String postalCode ="";
    private String postOffice ="";

    public Address(){}

    public Address(String street, String houseNumber, String flatNumber, String postalCode, String postOffice) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.postalCode = postalCode;
        this.postOffice = postOffice;
    }

    public String getHouseNumber() {
        if (houseNumber.equals("")) return "brak numeru domu";
        else return houseNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public String getStreet() {
        if (street.equals("")) return "brak nazwy";
        else return street;
    }

    public String getPostalCode() {
        if (postalCode.equals("")) return "brak kodu pocztowego";
        else return postalCode;
    }

    public String getPostOffice() {
        if (postOffice.equals("")) return "brak urzędu pocztowego";
        else return postOffice;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String toString(){
        return ("ul. " + street + " " + houseNumber + "/" + flatNumber + ", " + postOffice + " " + postalCode + ".");
    }
}
