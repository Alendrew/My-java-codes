package application;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(sc){
			Reservation r1 = register(sc);
			System.out.println(r1.toString());
			System.out.println("Atualização de datas: ");
			System.out.println("Check-in date (dd/MM/yyyy): ");
			LocalDate checkin = LocalDate.parse(sc.next(), Reservation.DATE_PATTERN_BR);
			System.out.println("Check-out date (dd/MM/yyyy): ");
			LocalDate checkout = LocalDate.parse(sc.next(), Reservation.DATE_PATTERN_BR);
			r1.updateDates(checkin, checkout);
		}catch(DomainException e) {
			System.out.println(e.getMessage());
		}
	}
	public static Reservation register(Scanner sc) {
		try {
			Reservation r1 = new Reservation();
			System.out.println("Room number: ");
			r1.setRoomNumber(sc.nextInt());
			System.out.println("Check-in date (dd/MM/yyyy): ");
			r1.setCheckin(LocalDate.parse(sc.next(), Reservation.DATE_PATTERN_BR));
			System.out.println("Check-out date (dd/MM/yyyy): ");
			r1.setCheckout(LocalDate.parse(sc.next(), Reservation.DATE_PATTERN_BR));
			return r1;
		}catch(DateTimeParseException e) {
			throw new DomainException("Data inválida");
		}catch(InputMismatchException e) {
			throw new DomainException("Entrada inválida");
		}catch(DomainException e) {
			throw new DomainException(e.getMessage());
		}
	}
}
