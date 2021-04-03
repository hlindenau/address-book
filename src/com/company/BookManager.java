package com.company;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class BookManager {

    public Scanner scanner = new Scanner(System.in);


    public Vector<Person> Records = new Vector<Person>();

    public void DisplayRecords() {
        for (int i = 0; i < Records.size(); i++) {
            Records.elementAt(i).DisplayName(i);
        }
    }

    public void AddRecord() {
        String _name, _surname, _telephone, _street, _houseNumber, _flatNumber, _postalCode, _postOffice;
        int _birthdayDay, _birthdayMonth;
        String _isFriend;
        System.out.print("Podaj imie: ");
        _name = scanner.nextLine();
        System.out.print("Nazwisko: ");
        _surname = scanner.nextLine();
        System.out.print("Numer telefonu:");
        _telephone = scanner.nextLine();
        System.out.println("--- Podaj adres --- ");
        System.out.print("Ulica:");
        _street = scanner.nextLine();
        System.out.print("Numer domu:");
        _houseNumber = scanner.nextLine();
        System.out.print("Numer mieszkania (opcjonalnie):");
        _flatNumber = scanner.nextLine();
        System.out.print("Kod pocztowy:");
        _postalCode = scanner.nextLine();
        System.out.print("Urzad pocztowy:");
        _postOffice = scanner.nextLine();
        Address _address = new Address(_street, _houseNumber, _flatNumber, _postalCode, _postOffice);
        do {
            System.out.print("Przyjaciel (T/N):");
            _isFriend = scanner.nextLine();
        } while (!_isFriend.toUpperCase().equals("T") &&
                !_isFriend.toUpperCase().equals("N"));
        if (_isFriend.toUpperCase().equals("T")) {
            System.out.print("Miesiac urodzin (numerycznie):");
            _birthdayDay = Integer.parseInt(scanner.nextLine());
            System.out.print("Dzien urodzin:");
            _birthdayMonth = Integer.parseInt(scanner.nextLine());
            Records.add(new Friend(_name, _surname, _telephone, _address, _birthdayDay, _birthdayMonth));
        } else if (_isFriend.toUpperCase().equals("N")) {
            Records.add(new Person(_name, _surname, _telephone, _address));
        }
    }

    public void DeleteRecord() {
        System.out.println("Podaj nazwisko kontaktu do usunięcia:");
        String search = scanner.nextLine();
        Vector<Person> temp = new Vector<Person>();
        int j = 0;
        Vector indexes = new Vector();
        for (int i = 0; i < Records.size(); i++) {
            if (Records.elementAt(i).getSurname().toUpperCase().equals(search.toUpperCase())) {
                temp.add(Records.elementAt(i));
                indexes.add(i);
                Records.elementAt(i).DisplayName(j++);
            }
        }
        System.out.println("Wybierz numer pozycji do usunięcia:");
        int choice = Integer.parseInt(scanner.nextLine());
        Records.remove((int) (indexes.elementAt(choice - 1)));
    }

    public void ModifyRecord() {
        System.out.println("Wybierz numer pozycji do edycji:");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                Records.elementAt((choice - 1)).Modify();
            } catch (Exception e) {
                System.out.println("Nieodpowiednia komenda, proszę wprowadź numer:");
            }
    }

    public void SearchBySurname() {
        String search;
        int j = 0;
        //scanner.nextLine();
        search = scanner.nextLine();
        for (int i = 0; i < Records.size(); i++) {
            if (Records.elementAt(i).getSurname().toUpperCase().equals(search.toUpperCase())) {
                Records.elementAt(i).getInfo();
                j++;
            }
        }
        if(j == 0) { System.out.println("Nie znaleziono kontaktu.");}
    }

    public static Comparator<Person> RecordSurnameComparator = new Comparator<Person>() {
        public int compare(Person person1, Person person2) {
            String Surname1 = person1.getSurname().toUpperCase();
            String Surname2 = person2.getSurname().toUpperCase();

            return Surname1.compareTo(Surname2);
    }
    };
}


