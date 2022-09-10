package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import model.entities.Contract;
import model.services.PaymentService;
import model.services.PaypalTaxService;

public class Program {
	public final static DateTimeFormatter BR_PATTERN = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static void main(String[] args) {
		Contract c1 = createContract();
		paymentService(c1);
		printInstallments(c1);
	}
	
	public static Contract createContract() {
		JOptionPane.showMessageDialog(null, "Enter contract data");
		int number = Integer.parseInt(JOptionPane.showInputDialog("Number: "));
		LocalDate date = LocalDate.parse(JOptionPane.showInputDialog("Date (dd/MM/yyyy):"), BR_PATTERN);
		double contractValue = Double.parseDouble(JOptionPane.showInputDialog("Contract value: "));
		return new Contract(number,date,contractValue);
	}
	
	public static void paymentService(Contract c1) {
		int months = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of installments: "));
		PaymentService p1 = new PaymentService(new PaypalTaxService());
		p1.processPayment(c1, months);
	}
	
	public static void printInstallments(Contract c1) {
		JOptionPane.showMessageDialog(null, "Installments:\n"+c1.getInstallments());
	}
	
}
