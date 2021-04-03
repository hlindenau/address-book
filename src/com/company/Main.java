package com.company;

import javafx.scene.effect.Light;

import java.awt.*;
import java.awt.print.Book;
import java.io.*;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.Scanner;
import java.util.Collections;

import static com.company.ObjectIO.filepath;



public class Main {

	public static void DisplayAllRecords(BookManager b1){
		for(int i = 0; i < b1.Records.size(); i++){
			b1.Records.elementAt(i).DisplayName(i);
		}
	}
	public static void SaveToFile(String pathname,BookManager b1) {
		try {
			FileOutputStream f = new FileOutputStream(new File("..KsiazkaAdresowa\\myObjects2.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			for (int i = 0; i < b1.Records.size(); i++) {
				o.writeObject(b1.Records.elementAt(i));
			}
			Collections.sort(b1.Records,b1.RecordSurnameComparator);
			o.close();
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	public static void ReadFromFile(String pathname, BookManager b1){
		try{
			FileInputStream fi = new FileInputStream(new File("..KsiazkaAdresowa\\myObjects2.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			boolean run = true;
			int i = 0;
			while(true)
			{
				try{
					Person pp = (Person)oi.readObject();
					b1.Records.add(pp);
					//pp.DisplayName(i++);
				} catch (EOFException e){run = false;
					oi.close();
					fi.close();};
			}

		} catch (FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku");
		} catch (IOException e) {
			//System.out.println(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(b1.Records,b1.RecordSurnameComparator);
	}

	static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
	BookManager b1 = new BookManager();
	boolean run = true;
	int choice = 0;
	String surname;
	// Menu
		ReadFromFile("C:\\PlikiProjektu\\myObjects2.txt",b1);
		while(run)
		{
			System.out.println("1.Wyświetl listę kontaktów.");
			System.out.println("2.Wyszukaj kontakt.");
			System.out.println("3.Dodaj kontakt.");
			System.out.println("4.Usuń kontakt.");
			System.out.println("5.Modyfikuj kontakt.");
			System.out.println("6.Wyjdź.");
			try {
				choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
					case 1:
						System.out.println("--- Kontakty ---");
						DisplayAllRecords(b1);
						System.out.println("----------------");
						break;
					case 2:
						System.out.println("Podaj wyszukiwane nazwisko:");
						b1.SearchBySurname();
						break;
					case 3:
						System.out.println("Dodawanie nowego kontaktu...");
						b1.AddRecord();
						SaveToFile("C:\\PlikiProjektu\\myObjects2.txt", b1);
						break;
					case 4:
						System.out.println("Usuwanie kontaktu...");
						System.out.println();
						b1.DeleteRecord();
						SaveToFile("C:\\PlikiProjektu\\myObjects2.txt", b1);
						break;
					case 5:
						boolean ModifyAgain = false;
						DisplayAllRecords(b1);
						b1.ModifyRecord();
						SaveToFile("C:\\PlikiProjektu\\myObjects2.txt", b1);
						break;
					case 6:
						run = false;
						break;
				}
			}
			catch(Exception e){
				System.out.println("Wprowadzono niepoprawny znak.");
			}
		}

	//Address sampleAddress = new Address("SampleStreet","1","2","33322","SampleTown");

/*	Person p1 = new Person("AHubert","abcsd", "999111222",sampleAddress);
	Person pa = new Person("A123t","abcsd", "999111222",sampleAddress);
	Person pv = new Person("AHasddasert","abcsd", "999111222",sampleAddress);
	Person pc = new Person("AHass","abcsd", "999111222",sampleAddress);
	Person p2 = new Person("Wojciecg","aytrutyu", "111221332",sampleAddress);
	Person p3 = new Person("AMaciej","dasadsads", "112244557",sampleAddress);
	Person p4 = new Person("AHubert","aasddasdasadsasd", "112353457",sampleAddress);
	Person p5 = new Person("ARob","daazcvbnb", "7890-90-2",sampleAddress);
	b1.Records.add(p1);
	b1.Records.add(p2);
	b1.Records.add(p3);
	b1.Records.add(p4);
	b1.Records.add(p5);
	b1.Records.add(pa);
	b1.Records.add(pc);
	b1.Records.add(pv);*/

//SaveToFile("C:\\PlikiProjektu\\myObjects2.txt", b1);
	//ReadFromFile("C:\\PlikiProjektu\\myObjects2.txt", b1);
		}
    }
