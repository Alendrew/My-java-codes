package model.services;

public class PaypalTaxService implements BankTaxService {

	private static final double MONTH_FEE = 0.01;
	private static final double PAYPAL_FEE = 0.02;
	public double tax(double amount,int installment) {
		double tax = amount * (MONTH_FEE * installment); 
		return (((tax + amount)*PAYPAL_FEE)+tax);
	}
}
