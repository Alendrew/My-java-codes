package entities;

public abstract class Person {
	
	private String name;
	private Double anual_income;
	
	public Person() {
	}

	public Person(String name, Double anual_income) {
		this.name = name;
		this.anual_income = anual_income;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAnual_income() {
		return anual_income;
	}

	public void setAnual_income(Double anual_income) {
		this.anual_income = anual_income;
	}
	
	public abstract Double calculateTax();
	
	public String taxesPaid() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName()+": ");
		sb.append("$ " + calculateTax());
		return sb.toString();
	}
	
}
