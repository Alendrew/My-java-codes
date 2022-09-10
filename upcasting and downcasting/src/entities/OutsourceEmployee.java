package entities;

public class OutsourceEmployee extends Employee {
	private Double payment;

	public OutsourceEmployee() {
	}
	
	public OutsourceEmployee(String name, Integer hours, Double payment) {
		super(name, hours);
		this.payment = payment;
	}

	public Double getPayment() {
		return payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}
	
	
	
}
