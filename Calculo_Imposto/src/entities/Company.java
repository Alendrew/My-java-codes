package entities;

public class Company extends Person {

	private Integer numberOfEmployees;

	public Company() {
		
	}

	public Company(String name, Double anual_income, Integer numberOfEmployees) {
		super(name, anual_income);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double calculateTax() {
		Double tax = 0.0;
		if(getNumberOfEmployees() < 10) {
			tax += (getAnual_income() * 0.16);
		}else {
			tax += (getAnual_income() * 0.14);
		}
		return tax;
	}
}
