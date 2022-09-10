package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Used extends Product {
	
	public static final DateTimeFormatter DATE_PATTERN_BR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate manufactureDate;

	public Used() {
	}
	
	public Used(String name, Double price, LocalDate manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + " ");
		sb.append("(used) ");
		sb.append("$ " + getPrice() + " ");
		sb.append("(Manufacture date: " + getManufactureDate().format(DATE_PATTERN_BR));
		return sb.toString();
	}
}
