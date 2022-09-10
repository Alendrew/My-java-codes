package application;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.Scanner;


import entities.*;
import enums.Status;



public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Client c1 = sign_up(sc);
		Order order1 = createOrder(c1,sc);
		sc.close();
		System.out.println(order1.orderSummary());
	}

	static Client sign_up(Scanner sc) {
		System.out.println("Enter the client data:");
		System.out.println("Name: ");
		String nome = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.next();
		System.out.println("Birth Date (dd/MM/yyyy): ");
		LocalDate birthDate = LocalDate.parse(sc.next(), Client.DATE_PATTERN_BR);
		Client cliente = new Client(nome,email,birthDate);
		return cliente;
	}
	static Order createOrder(Client client,Scanner sc) {
		System.out.println("Enter order data:");
		System.out.println("Status: ");
		Status status = Status.valueOf(sc.next());
		Order order = new Order(LocalDateTime.now(),status,client);
		System.out.println("How many items to this order? ");
		int items = sc.nextInt();
		for(int i = 0; i < items; i++) {
			System.out.printf("Enter #%d item data:",i+1);
			System.out.println("\nProduct name: ");
			String name = sc.next();
			System.out.println("Product price: ");
			Double price = sc.nextDouble();
			System.out.println("Quantity: ");
			int quantity = sc.nextInt();
			Product product = new Product(name,price);
			OrderItem orderItem = new OrderItem(quantity,product.getPrice(),product);
			order.addItem(orderItem);
		}
		return order;
	}
}
