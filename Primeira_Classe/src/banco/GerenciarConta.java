package banco;

public class GerenciarConta {
	private int numeroConta;
	private String nomeTitular;
	private int saldoConta;
	
	
	public GerenciarConta(int numeroConta, String nomeTitular, int valorInicial) {
		this.numeroConta = numeroConta;
		this.nomeTitular = nomeTitular;
		this.saldoConta = valorInicial;
	}
	public GerenciarConta(int numeroConta, String nomeTitular) {
		this.numeroConta = numeroConta;
		this.nomeTitular = nomeTitular;
	}
	
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public void realizarSaque(int valor) {
		this.saldoConta -= valor;
	}
	public void fazerDeposito(int valor) {
		this.saldoConta += valor;
	}
	public int getSaldo() {
		return this.saldoConta;
	}
	
	

}
