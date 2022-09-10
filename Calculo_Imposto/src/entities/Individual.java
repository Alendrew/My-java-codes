package entities;

public class Individual extends Person {
	
	private Double health_expenditures;

	public Individual() {
		
	}
	
	public Individual(String name, Double anual_income, Double health_expenditures) {
		super(name, anual_income);
		this.health_expenditures = health_expenditures;
	}

	public Double getHealth_expenditures() {
		return health_expenditures;
	}

	public void setHealth_expenditures(Double health_expenditures) {
		this.health_expenditures = health_expenditures;
	}

	@Override
	public Double calculateTax() {
		Double tax = 0.0;
		if(getAnual_income() < 20000) {
			tax += (getAnual_income() * 0.15);
		}else {
			tax += (getAnual_income() * 0.25);
		}
		if(getHealth_expenditures() != 0) {
			tax -= (getHealth_expenditures() * 0.50);
		}
		return tax;
	}
}
