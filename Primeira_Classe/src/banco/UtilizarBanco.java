package banco;

import java.util.Scanner;

public class UtilizarBanco {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GerenciarConta conta1 = gerarConta(sc);
		gerenciar(sc,conta1);
		sc.close();

	}
	public static GerenciarConta gerarConta(Scanner sc) {
		int op;
		System.out.println("Insira o numero da conta: ");
		int numero = sc.nextInt();
		System.out.println("Insira o nome do titular: ");
		String nome = sc.next();
		System.out.println("Deseja fazer um deposito inicial?\n"
				+ "1 - Sim\n"
				+ "2 - Não\n");
		op = sc.nextInt();
		
		GerenciarConta conta1 = null;
		if(op == 1) {
			System.out.println("Insira o valor do deposito Inicial: ");
			int depositoInicial = sc.nextInt();
			conta1 = new GerenciarConta(numero,nome,depositoInicial);
		}else if(op == 2) {
			conta1 = new GerenciarConta(numero,nome);
		}
		return conta1;
	}
	
	
	public static void gerenciar(Scanner sc, GerenciarConta conta1) {
		int op;
		boolean sair = false;
		int valor;
		String nome;
		while(sair != true) {
			System.out.println("Banco Neon\n"
					+ "1 - Fazer deposito\n"
					+ "2 - Realizar saque\n"
					+ "3 - Verificar Saldo\n"
					+ "4 - Listagem completa\n"
					+ "5 - Mudar nome Titular\n"
					+ "6 - Sair\n"
					+ "O que você deseja fazer? ");
			op = sc.nextInt();
			switch(op) {
				case 1: {
					System.out.println("Insira o valor que voce deseja depositar");
					valor = sc.nextInt();
					conta1.fazerDeposito(valor);
					break;
				}
				case 2:{
					System.out.println("Insira o valor que voce deseja sacar");
					valor = sc.nextInt();
					conta1.realizarSaque(valor);
					break;
				}
				case 3:{
					System.out.println("Seu Saldo é igual a: "+conta1.getSaldo());
					break;
				}
				case 4: {
					System.out.println("Numero da conta: "+ conta1.getNumeroConta() + "\n"
							+ "Nome titular: "+ conta1.getNomeTitular() + "\n"
							+ "Saldo: "+ conta1.getSaldo());
					break;
				}
				case 5:{
					System.out.println("Qual o nome que voce deseja inserir? ");
					nome = sc.next();
					conta1.setNomeTitular(nome);
					break;
				}
				case 6: {
					sair = true;
					break;
				}
			}
			
		}
	}
	

}
