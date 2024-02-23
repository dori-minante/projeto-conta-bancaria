package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner sc = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;

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

			try {
				opcao = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Você precisa digitar valores inteiros!");
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(
						Cores.TEXT_WHITE_BOLD + "\nRIBank: Transformando Sonhos em Conquistas, Seu Banco, Seu Futuro!");
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar nova conta\n\n");
				System.out.println("Digite o número da agência: ");
				agencia = sc.nextInt();
				sc.nextLine();

				System.out.println("Digite o nome do titular: ");
				// sc.skip("\\R:");
				titular = sc.nextLine();

				do {
					System.out.println("Digite o tipo da conta (1 - Conta Corrente ou 2 - Conta Poupança): ");
					tipo = sc.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o saldo da Conta: R$ ");
				saldo = sc.nextFloat();

				// Tentando com o if-else

				if (tipo == 1) {
					System.out.println("Digite o limite de crédito R$ ");
					limite = sc.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				} else if (tipo == 2) {
					System.out.println("Digite o dia do aniversário da conta: ");
					aniversario = sc.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				} else {
					System.out.println("Tipo de conta inválido! Tente novamente.");
				}

				keyPress();

			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta por número\n\n");
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n\n");
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida! Tente novamente.\n");
				keyPress();
				break;
			}
		}
	}

	public static void keyPress() {
		try {

			System.out.println(Cores.TEXT_RESET + "\nPressione Enter para continuar!");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter! Tente novamente.");

		}
	}
}
