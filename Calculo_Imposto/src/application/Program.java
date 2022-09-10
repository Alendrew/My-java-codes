package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.*;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Person> list1 = new ArrayList<>();
		register_person(sc,list1);
		System.out.println("\nTAXES PAID:");
		Double totalTax = 0.0;
		for(Person p : list1) {
			System.out.println(p.taxesPaid());
			totalTax += p.calculateTax();
		}
		sc.close();
		System.out.println("\nTOTAL TAXES: $ "+totalTax);
	}
	static void register_person(Scanner sc, List<Person> list1) {
		System.out.println("Enter the number of tax payers: ");
		int numb1 = sc.nextInt();
		for(int i = 0; i < numb1; i++) {
			System.out.printf("Tax payer #%d data: ",i + 1);
			System.out.println("\nIndividual or company (i/c)? ");
			char op = sc.next().charAt(0);
			switch(op) {
				case 'i':{
					System.out.println("Name: ");
					String name = sc.next();
					System.out.println("Anual Income: ");
					Double anualIncome = sc.nextDouble();
					System.out.println("Health expenditures: ");
					Double health = sc.nextDouble();
					list1.add(new Individual(name,anualIncome,health));
					break;
				}
				case 'c':{
					System.out.println("Name: ");
					String name = sc.next();
					System.out.println("Anual Income: ");
					Double anualIncome = sc.nextDouble();
					System.out.println("Number of employees: ");
					Integer numbs = sc.nextInt();
					list1.add(new Company(name,anualIncome,numbs));
					break;
				}
				default:{
					System.out.println("Opção inválida");
					break;
				}
			}
		}
	}
}
