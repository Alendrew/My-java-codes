package model.entities;

import java.time.LocalDate;

import application.Program;

public class Installment {
	
	private LocalDate dueDate;
	private Double amount;
	
	public Installment() {
		
	}

	public Installment(LocalDate dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public Double getAmount() {
		return amount;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(dueDate.format(Program.BR_PATTERN)).append(" - ").append(String.format("%.2f", amount));
		return sb.toString();
	}
}
