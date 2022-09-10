package application;

import entities.Employee;
import entities.OutsourceEmployee;

public class Program {

	public static void main(String[] args) {
		//Normal
		Employee emp1 = new Employee("Andr�", 40);
		OutsourceEmployee emp2 = new OutsourceEmployee("Andr�",30,10.00);
		//Upcasting (generalizando)
		Employee emp3 = new OutsourceEmployee("Andr�",30,10.00);
		//Downcasting (Devolvendo a especificidade)
		OutsourceEmployee emp4 = (OutsourceEmployee)emp2;	
	}
}
