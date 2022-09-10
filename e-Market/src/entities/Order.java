package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import enums.Status;

public class Order {
	private final static DateTimeFormatter TIME_PATTERN_BR = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	private LocalDateTime moment;
	private Status status;
	private Client client;
	
	private List<OrderItem> orderItems = new ArrayList<>();
	
	public Order() {
	}
	
	public Order(LocalDateTime moment,Status status,Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMoment() {
		return moment.format(TIME_PATTERN_BR);
	}
	
	public void addItem(OrderItem item) {
		orderItems.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orderItems.remove(item);
	}
	
	public Double getTotal() {
		double sum = 0.0;
		for(OrderItem it : orderItems) {
			sum += it.subTotal();
		}
		return sum;
	}
	public String orderSummary() {
		StringBuilder string = new StringBuilder();
		string.append("\nORDER SUMMARY: ");
		string.append("\nOrder moment: "+getMoment());
		string.append("\nOrder status: "+getStatus());
		string.append(getClient().toString());
		string.append("\nOrder items: ");
		for(OrderItem item : orderItems) {
			string.append(item + "\n");
		}
		string.append("\nTotal price: "+getTotal());
		return string.toString();
	}
}
