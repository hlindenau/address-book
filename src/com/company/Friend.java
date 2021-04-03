package com.company;

import java.io.Serializable;
import java.util.Date;

public class Friend extends Person implements Serializable {
        private int birthdayDay;
        private int birthdayMonth;


    public void Modify(){
        System.out.println("Wybierz numer atrybutu do zmiany:");
        System.out.println("1.Imie.");
        System.out.println("2.Nazwisko.");
        System.out.println("3.Nr telefonu.");
        System.out.println("4.Adres.");
        System.out.println("5.Data urodzenia");
        int choice2 = Integer.parseInt(scanner.nextLine());
        switch (choice2) {
            case 1:
                System.out.println("Podaj imię:");
                setName(scanner.nextLine());
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
            case 5:
                System.out.println("Podaj miesiąc urodzin:");
                setBirthdayMonth(Integer.parseInt(scanner.nextLine()));
                System.out.println("Podaj dzień urodzin:");
                setBirthdayDay(Integer.parseInt(scanner.nextLine()));

        }
    }

    public Friend(String name, String surname, String telephoneNumber, Address address, int birthdayDay, int birthdayMonth) {
        super(name, surname, telephoneNumber, address);
        this.birthdayDay = birthdayDay;
        this.birthdayMonth = birthdayMonth;
    }

    public void setBirthdayDay(int birthdayDay) {
        this.birthdayDay = birthdayDay;
    }

    public void setBirthdayMonth(int birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }

    public int getBirthdayDay() {
        return birthdayDay;
    }

    public int getBirthdayMonth() {
        return birthdayMonth;
    }

    public String getBirthday(){
        if(birthdayDay < 10 && birthdayMonth < 10) {
            return "Data urodzin: 0" + birthdayDay + ".0" + birthdayMonth;
        }
        else if(birthdayDay > 9 && birthdayMonth < 10){
           return "Data urodzin: " + birthdayDay + ".0" + birthdayMonth;
        }
        else if(birthdayDay < 10 && birthdayMonth > 9){
            return "Data urodzin: 0" + birthdayDay + "." + birthdayMonth;
        }
        else{
            return "Data urodzin: " + birthdayDay + "." + birthdayMonth;
        }
    }

    public void getInfo(){
        super.getInfo();
        System.out.println(getBirthday());
    }
    public String toString()
    {
        return super.toString() + "\n" + getBirthday();
    }
}
