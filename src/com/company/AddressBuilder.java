package com.company;

public class AddressBuilder {
    private String street;
    private String houseNumber;
    private String flatNumber;
    private String postalCode;
    private String postOffice;

    public AddressBuilder(){
        street = "";
        houseNumber = "";
        flatNumber = "";
        postalCode = "";
        postOffice = "";
    };

    public Address BuildAddress(){
        return new Address(street,houseNumber,flatNumber,postalCode,postOffice);
    }



}
