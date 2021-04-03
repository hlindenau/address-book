package com.company;

import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String name;
    protected String surname;
    protected String telephoneNumber;
    protected Address address;
    transient static Scanner scanner = new Scanner(System.in);

    public Person(String name, String surname, String telephoneNumber, Address address) {
        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }

    public void DisplayName(int num) {
        System.out.println((num + 1) + ". " + name + " " + surname);
    }

    public void DisplayName() {
        System.out.println(name + " " + surname);
    }


    public void Modify() {
        System.out.println("Wybierz numer atrybutu do zmiany:");
        System.out.println("1.Imie.");
        System.out.println("2.Nazwisko.");
        System.out.println("3.Nr telefonu.");
        System.out.println("4.Adres.");
        int choice2 = Integer.parseInt(scanner.nextLine());
        //scanner.nextLine();
        switch (choice2) {
            case 1:
                System.out.println("Podaj imię:");
                String name2 = scanner.nextLine();
                setName(name2);
                break;
            case 2:
                System.out.println("Podaj nazwisko:");
                setSurname(scanner.nextLine());
                break;
            case 3:
                System.out.println("Podaj numer telefonu:");
                setTelephoneNumber(scanner.nextLine());
                break;
            case 4:
                Address tempAddress = new Address();
                System.out.println("Podaj nazwę ulicy:");
                tempAddress.setStreet(scanner.nextLine());
                System.out.println("Podaj numer domu:");
                tempAddress.setHouseNumber(scanner.nextLine());
                System.out.println("Podaj numer mieszkania (opcjonalnie):");
                tempAddress.setFlatNumber(scanner.nextLine());
                System.out.println("Podaj kod pocztowy:");
                tempAddress.setPostalCode(scanner.nextLine());
                System.out.println("Podaj urząd pocztowy:");
                tempAddress.setPostOffice(scanner.nextLine());
                setAddress(tempAddress);
                break;
        }
    }

    public void getInfo() {
        System.out.println("Imie: " + getName());
        System.out.println("Nazwisko: " + getSurname());
        System.out.println("Numer telefonu: " + getTelephoneNumber());
        if (address.getFlatNumber().equals("")) {
            System.out.println("Adress: ul." + address.getStreet() + " " + address.getHouseNumber()
                    + ", " + address.getPostalCode() + ", " + address.getPostOffice());
        } else {
            System.out.println("Adress: ul." + address.getStreet() + " " + address.getHouseNumber()
                    + "/" + address.getFlatNumber() + ", " + address.getPostalCode() + ", " + address.getPostOffice());
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTelephoneNumber() {
        if (telephoneNumber == null) return "brak";
        else return telephoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String toString() {
        return "Imie: " + name + "\nNazwisko: " + surname + "\nNumer telefonu: " + telephoneNumber + "\nAdres: " + address.toString();
    }
}
