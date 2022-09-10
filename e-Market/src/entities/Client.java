package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
	public final static DateTimeFormatter DATE_PATTERN_BR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private String name;
	private String email;
	private LocalDate birthDate;
	
	public Client() {
	}
	
	public Client(String name, String email, LocalDate birthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String toString() {
		StringBuilder cliente = new StringBuilder();
		cliente.append("\nCliente: ");
		cliente.append(name + " ");
		cliente.append("("+birthDate.format(DATE_PATTERN_BR)+") - "+email);
		return cliente.toString();
	}
}
