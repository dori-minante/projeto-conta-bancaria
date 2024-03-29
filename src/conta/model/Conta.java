package conta.model;

public class Conta {

	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public void visualizar() {

		String tipoConta = "";

		switch (this.tipo) {
		case 1:
			tipoConta = "Conta Corrente";
			break;
		case 2:
			tipoConta = "Conta Poupança";
			break;
		}
		
		System.out.println("--------------------------------------------------");
		System.out.println("\nDados da Conta\n");
		System.out.println("--------------------------------------------------");
		System.out.println("Número da conta: " + getNumero());
		System.out.println("Agência da conta: " + getAgencia());
		System.out.println("Tipo da conta: " + tipoConta);
		System.out.println("Titular da conta: " + getTitular());
		System.out.printf("Saldo da conta: R$ %.2f%n", getSaldo());

	}
}
