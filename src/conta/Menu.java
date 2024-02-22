package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Conta cc1 = new ContaCorrente(361345, 452, 1, "Bianca Santos Ribeiro", 18000.0f, 20000.0f);
		cc1.visualizar();
		cc1.sacar(8000.0f);
		cc1.visualizar();

		Conta cp1 = new ContaPoupanca(181309, 432, 2, "João da Silva", 9000.0f, 15);
		cp1.visualizar();
		cp1.sacar(450.0f);
		cp1.visualizar();
		cp1.depositar(1200.0f);

		Conta cp2 = new ContaPoupanca(381302, 152, 2, "Shakira Ribeiro", 3000.0f, 7);
		cp2.visualizar();
		cp2.sacar(57.0f);
		cp2.visualizar();

		Conta cc2 = new ContaCorrente(211869, 362, 1, "Everton Duque", 63000.0f, 7500.0f);
		cc2.visualizar();
		cc2.depositar(300.0f);
		cc2.visualizar();

		Scanner sc = new Scanner(System.in);
			
		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_BLUE + Cores.ANSI_BLACK_BACKGROUND
					+ "-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("                      RIBANK                         ");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = sc.nextInt();

			if (opcao == 9) {
				System.out.println(
						Cores.TEXT_WHITE_BOLD + "\nRIBank: Transformando Sonhos em Conquistas, Seu Banco, Seu Futuro!");
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta\n\n");

				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
				break;
			}
		}

	}

}
