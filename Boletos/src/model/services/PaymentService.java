package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class PaymentService {
	
	private BankTaxService bankTaxService;

	public PaymentService() {
		
	}

	public PaymentService(BankTaxService bankTaxService) {
		this.bankTaxService = bankTaxService;
	}

	public void processPayment(Contract contract, int months) {
		Double totalValue = contract.getTotalValue()/months;
		LocalDate dueDate = contract.getDate();
		for(int i = 1; i <= months; i++) {
			contract.addInstallment(new Installment(dueDate.plusMonths(i),(totalValue+(bankTaxService.tax(totalValue, i)))));
		}
	}
}
