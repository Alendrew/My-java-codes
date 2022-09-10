package data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Date {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter time = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		LocalDateTime data_hoje = LocalDateTime.now();
		System.out.println(data_hoje.format(time));
		DateTimeFormatter padrao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Insira uma data dd/MM/yyyy ");
		String data_usr = sc.next();
		LocalDate data_usr_fr = LocalDate.parse(data_usr,padrao);
		System.out.println("Convertido para objeto -> "+data_usr_fr);
		System.out.println("Convertido para String -> "+data_usr_fr.format(padrao));
		sc.close();
	}
}
