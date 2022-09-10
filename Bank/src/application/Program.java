package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.*;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try(sc) {
			Account ac1 = register(sc);
			System.out.println(ac1);
			System.out.println("withdraw: ");
			ac1.withdraw(sc.nextDouble());
		}catch(DomainException e) {
			System.out.println(e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
	}
	public static Account register(Scanner sc) {
		try{
			System.out.println("Enter account data: ");
			System.out.println("Number: ");
			int num = sc.nextInt();
			System.out.println("Holder: ");
			String name = sc.next();
			System.out.println("Initial balance: ");
			Double balance = sc.nextDouble();
			System.out.println("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			return new Account(num,name,balance,withdrawLimit);
		}catch(InputMismatchException e){
			throw new DomainException("Entrada inválida");
		}
	}
}
