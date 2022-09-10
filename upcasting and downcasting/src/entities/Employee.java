package entities;

public class Employee {
	private String name;
	private Integer hours;
	
	public Employee() {
	}

	public Employee(String name, Integer hours) {
		this.name = name;
		this.hours = hours;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
}
