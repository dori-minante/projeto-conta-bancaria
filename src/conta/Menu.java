package conta;

import conta.model.Conta;

public class Menu {

	public static void main(String[] args) {

		Conta conta1 = new Conta(361345, 452, 1, "Bianca Santos Ribeiro", 18000.0f);

		conta1.visualizar();

		Conta conta2 = new Conta(181309, 432, 2, "João da Silva", 9000.0f);

		conta2.visualizar();

		Conta conta3 = new Conta(381302, 152, 2, "Shakira Ribeiro", 3000.0f);

		conta3.visualizar();

		Conta conta4 = new Conta(211869, 362, 1, "Everton Duque", 63000.0f);

		conta4.visualizar();

	}

}
