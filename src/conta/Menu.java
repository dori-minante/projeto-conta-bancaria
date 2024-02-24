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

		System.out.println("\nCriar contas\n");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 452, 1, "Bianca Santos Ribeiro", 18000.0f,
				20000.0f);
		contas.cadastrar(cc1);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 432, 2, "João da Silva", 9000.0f, 15);
		contas.cadastrar(cp1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 362, 1, "Everton Duque", 63000.0f, 7500.0f);
		contas.cadastrar(cc2);

		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 152, 2, "Shakira Ribeiro", 3000.0f, 7);
		contas.cadastrar(cp2);

		contas.listarTodas();

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
				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();

				var buscaConta = contas.buscarNaCollection(numero);

				if (buscaConta != null) {

					System.out.println("Digite o Numero da Agência: ");
					agencia = sc.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					sc.skip("\\R?");
					titular = sc.nextLine();

					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = sc.nextFloat();

					tipo = buscaConta.getTipo();

					if (tipo == 1) {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = sc.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					} else if (tipo == 2) {
						System.out.println("Digite o dia do Aniversario da Conta: ");
						aniversario = sc.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					} else {
						System.out.println("Tipo de conta inválido!");
					}

									
				} else
					System.out.println("\nConta não encontrada!");

				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();
				contas.deletar(numero);
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
