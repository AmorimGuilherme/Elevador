package br.com.brq.inicio.exercicios.elevador;

import java.util.Scanner;

public class ControleElevador {

	private Elevador[] elevador;

	public ControleElevador() {
		elevador = new Elevador[4];
	}

	public void inicializa(int escolheElevador) {
		if (escolheElevador >= 0 && escolheElevador < 5 && elevador[escolheElevador] == null) {
			elevador[escolheElevador] = new Elevador();
			elevador[escolheElevador].getAndar()[0] = 0;
			elevador[escolheElevador].getPessoa()[0] = 0;
			elevador[escolheElevador].setNumeroElevador(escolheElevador);
		}
	}

	public void sobe(int escolheElevador) {
		try {
			if (elevador[escolheElevador].getContadorAndar() <= 16) {
				elevador[escolheElevador].getAndar()[elevador[escolheElevador]
						.getContadorAndar()] = elevador[escolheElevador].getContadorAndar();
				elevador[escolheElevador].setContadorAndar(elevador[escolheElevador].getContadorAndar() + 1);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ELEVADOR NO ÚLTIMO ANDAR!\n");
		}
	}

	public void desce(int escolheElevador) {
		if (elevador[escolheElevador].getContadorAndar() > 1 && elevador[escolheElevador].getContadorAndar() < 16) {
			for (int i = 0; i < elevador[escolheElevador].getAndar().length; i++) {
				if (elevador[escolheElevador].getAndar()[i] != null
						&& elevador[escolheElevador].getAndar()[i + 1] == null) {
					elevador[escolheElevador].getAndar()[i] = null;
					elevador[escolheElevador].setContadorAndar(elevador[escolheElevador].getContadorAndar() - 1);
				}
			}
		}
	}

	public void entraPessoa(int escolheElevador) {
		try {

			if (elevador[escolheElevador].getContadorPessoa() <= 6) {
				elevador[escolheElevador].getPessoa()[elevador[escolheElevador]
						.getContadorPessoa()] = elevador[escolheElevador].getContadorPessoa();
				elevador[escolheElevador].setContadorPessoa(elevador[escolheElevador].getContadorPessoa() + 1);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.print("CARGA MÁXIMA DE PESSOAS!\n");
		}

	}

	public void saiPessoa(int escolheElevador) {
		if (elevador[escolheElevador].getContadorPessoa() > 1) {
			for (int i = 0; i < elevador[escolheElevador].getPessoa().length; i++) {
				if (elevador[escolheElevador].getPessoa()[i] != null
						&& elevador[escolheElevador].getPessoa()[i + 1] == null) {
					elevador[escolheElevador].getPessoa()[i] = null;
					elevador[escolheElevador].setContadorPessoa(elevador[escolheElevador].getContadorPessoa() - 1);
				}
			}
		}
	}

	public String interfaceElevador(int escolheElevador) {
		int var1 = 0;
		for (Integer andar : elevador[escolheElevador].getAndar()) {
			if (andar != null) {
				var1 = andar;
			}
		}
		int var2 = 0;
		for (Integer pessoa : elevador[escolheElevador].getPessoa()) {
			if (pessoa != null) {
				var2 = pessoa;
			}
		}
		return "\nELEVADOR " + elevador[escolheElevador].getNumeroElevador() + "\n" + "ANDAR: "
				+ elevador[escolheElevador].getAndar()[var1] + "\n" + "PESSOAS: "
				+ elevador[escolheElevador].getPessoa()[var2];
	}

	public void mostraMenu() {

		ControleElevador controle = new ControleElevador();

		Scanner scan = new Scanner(System.in);

		boolean sairMenuControlador;
		boolean sairMenu = false;

		do {

			System.out.println("1 - ELEVADOR");
			System.out.println("2 - ELEVADOR");
			System.out.println("3 - ELEVADOR");
			System.out.println("4 - ELEVADOR");
			System.out.println("5 - SAIR");
			System.out.print("ESCOLHA A OPÇÃO: ");
			int escolha = scan.nextInt();

			sairMenuControlador = false;

			if (escolha <= 0 && escolha > 5) {
				System.out.println("ESCOLHA INVÁLIDA, DIGITE NOVAMENTE!");
				System.out.print("ESCOLHA A OPÇÃO: ");
				escolha = scan.nextInt();
			}
			if (escolha == 5) {
				sairMenu = true;

			} else {
				controle.inicializa(escolha);
				do {

					System.out.println(controle.interfaceElevador(escolha));

					System.out.println("1 SUBIR | 2 DESCER | 3 ENTRAR PESSOA | 4 SAIR PESSOA | 5 MUDAR ELEVADOR");
					int escolhaMenuControlador = scan.nextInt();

					switch (escolhaMenuControlador) {
					case 1:
						controle.sobe(escolha);
						break;

					case 2:
						controle.desce(escolha);
						break;

					case 3:
						controle.entraPessoa(escolha);
						break;

					case 4:
						controle.saiPessoa(escolha);
						break;

					case 5:
						sairMenuControlador = true;
						break;
					default:
						System.out.println("CÓDIGO INVÁLIDO!!");

					}

				} while (sairMenuControlador == false);
			}
		} while (sairMenu == false);

	}
}