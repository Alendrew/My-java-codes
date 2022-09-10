package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.*;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list1 = new ArrayList<>();
		register_products(sc,list1);
		print_tags(list1);
		sc.close();
	}
	static void print_tags(List<Product> list1) {
		System.out.println("PRICE TAGS:");
		for(Product p : list1) {
			System.out.println(p.priceTag());
		}
	}
	static void register_products(Scanner sc,List<Product> list1) {
		System.out.println("Enter the number of products: ");
		int numb1 = sc.nextInt();
		for(int i = 0; i < numb1; i++) {
			System.out.printf("Product #%d data: ",i + 1);
			System.out.println("\nCommon, used or imported (c/u/i) ? ");
			char op = sc.next().charAt(0);
			switch(op) {
				case 'c':{
					System.out.println("Name: ");
					String name = sc.next();
					System.out.println("Price: ");
					Double price = sc.nextDouble();
					list1.add(new Product(name,price));
					break;
				}
				case 'u':{
					System.out.println("Name: ");
					String name = sc.next();
					System.out.println("Price: ");
					Double price = sc.nextDouble();
					System.out.println("Manufacture date (dd/MM/yyyy): ");
					LocalDate manufactureDate = LocalDate.parse(sc.next(),Used.DATE_PATTERN_BR);
					list1.add(new Used(name,price,manufactureDate));
					break;
				}
				case 'i':{
					System.out.println("Name: ");
					String name = sc.next();
					System.out.println("Price: ");
					Double price = sc.nextDouble();
					System.out.println("Custom fee: ");
					Double customFee = sc.nextDouble();
					list1.add(new Imported(name,price,customFee));
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
