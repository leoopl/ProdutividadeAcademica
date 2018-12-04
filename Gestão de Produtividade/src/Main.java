import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Colaborador> colaboradores;
	static List<Projeto> projetos;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		colaboradores = new ArrayList<>();
		projetos = new ArrayList<>();

		int input;
		do {
			System.out.println("Escolha o número da operação que deseja realizar: ");
			System.out.println("[1] - Criar Perfil de Colaborador");
			System.out.println("[2] - Gerenciar Projeto");
			System.out.println("[3] - Consulta");
			System.out.println("[4] - Relatorio de Produção");
			System.out.println("[5] - Publicação/Orientação");
			System.out.println("[6] - Sair");
			input = scan.nextInt();

			switch (input) {
			case 1:
				addColaborador();
				break;
			case 2:
				projectMenu();
				break;
			case 3:
				consult();
				break;
			case 4:
				//printReport();// faço um contador pra cada 1????
				break;
			case 5:
				addPublication();
				break;
			case 6:
				System.out.println("Saindo do sistema...");
				break;
			default:
				System.out.println("Opção invalida");
			}
		} while (input != 6);

	}

	private static void addPublication() {
		Scanner scan = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);
		System.out.println("Titulo da publicação: ");
		String title = scan.nextLine();
		System.out.println("Nome da conferência onde foi publicada: ");
		String confName = scan.nextLine();
		System.out.println("Ano de publicação: ");
		int date = scanInt.nextInt();
		// como add mais de 1 autor
		System.out.println("Você deseja associar a algum projeto: [1] - SIM [2] - Não");
		int aux = scanInt.nextInt();
		if (aux == 1) {
			System.out.println("Nome do projeto no qual deseja associar sua publicação: ");
			String projName = scan.nextLine();
			// procurar se o projeto existe e se ele esta "em andamento"
		} else {
			System.out.println("Nenhum projeto associado.");
		}
		// criar uma nova prblicação e setar tudo
	}

	private static void consult() {
		Scanner scan = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);
		System.out.println("Você deseja consultar por [1] - Colaborador ou [2] - Projeto");
		int input = scanInt.nextInt();
		String name;
		if (input == 1) {
			System.out.println("Digite o nome do Colaborador: ");
			name = scan.nextLine();
			// pesquisar se esse colaborador existe
		} else if (input == 2) {
			System.out.println("Digite o nome do Projeto: ");
			name = scan.nextLine();
			// pesquisar se existe e fazer um toString
		} else {
			return;
		}

	}

	private static void projectMenu() {
		Scanner scan = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);

		System.out.println("[1] - Novo Projeto");
		System.out.println("[2] - Alocação de participantes");
		System.out.println("[3] - Alterar Status");
		System.out.println("[0] - Voltar ao menu principal");
		String projName;
		int input = scanInt.nextInt();

		switch (input) {
		case 1:
			System.out.println("Titulo do projeto:");
			projName = scan.nextLine();
			System.out.println("Objetivo: ");
			String obj = scan.nextLine();
			System.out.println("Descrição: ");
			String desc = scan.nextLine();
			System.out.println("Agencia Financiadora: ");
			String agtName = scan.nextLine();
			System.out.println("Valor do financiamento: ");
			double value = scanInt.nextDouble();
			System.out.println("Data de inicio do projeto (Digite no formato - dd/mm/aa): ");
			String inicialDate = scan.nextLine();
			System.out.println("Data para finalização do projeto (Digite no formato - dd/mm/aa): ");
			String finalDate = scan.nextLine();
			System.out.println("Nome do professor responsaval: ");
			String profName = scan.nextLine();

			if (searchColab(profName, 4)) {
				Projeto newProj = new Projeto(projName, inicialDate, finalDate, obj, desc, value, agtName, profName);
				newProj.getParticipantes().add(profName);
				projetos.add(newProj);
			} else {
				System.out.println("Colaborador não existe ou não é professor");
			}
			break;
		case 2:
			System.out.println("Qual Projeto você quer alocar?");
			projName = scan.nextLine();

			Projeto projeto = searchProject(projName, 1);
			if (projeto != null) {
				System.out.println("Nome do colaborador a ser alocado: ");
				String newName = scan.nextLine();
				if (searchColab(newName, 0)) {
					if (searchColab(newName, 1)) {
						if (checkProject(newName)) {
							projeto.getParticipantes().add(newName);
						}
					} else {
						projeto.getParticipantes().add(newName);
					}
				} else {
					System.out.println("Colaborador não existente");
				}
			}
			break;
		case 3:
			System.out.println("Qual Projeto você quer alterar?");
			projName = scan.nextLine();
			Projeto prj = searchProject(projName, 0);
			if (prj.getType() == 1) {
				prj.setType(2);//ver isso aqui
			}else if (prj.getType() == 2) {
				if (prj.getPublicações().size() > 1) {
					prj.setType(3);
				}else {
					System.out.println("Projeto sem publicações");
				}
			} else if (prj.getType() == 3) {
				System.out.println("projeto concluido");
			}
			break;

		default:
			break;
		}

	}

	private static void addColaborador() {
		Scanner scan = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);

		System.out.println("Nome do Colaborador:");
		String newName = scanString.nextLine();
		System.out.println("E-mail do Colaborador: ");
		String newEmail = scanString.nextLine();
		System.out.println(
				"Tipo do Colaborador:\n [1] - Aluno Graduando\n [2] - Aluno Mestrando\n [3] - Aluno Doutorando\n [4] - Professor\n [5] - Pesquisador");
		int newType = scan.nextInt();
		Colaborador newColab;
		switch (newType) {
		case 1:
			newColab = new Colaborador(newName, newEmail, 1);
			colaboradores.add(newColab);
			break;
		case 2:
			newColab = new Colaborador(newName, newEmail, 2);
			colaboradores.add(newColab);
			break;
		case 3:
			newColab = new Colaborador(newName, newEmail, 3);
			colaboradores.add(newColab);
			break;
		case 4:
			newColab = new Colaborador(newName, newEmail, 4);
			colaboradores.add(newColab);
			break;
		case 5:
			newColab = new Colaborador(newName, newEmail, 5);
			colaboradores.add(newColab);
			break;
		default:
			break;
		}
	}

	private static Projeto searchProject(String name, int type) {

		for (Projeto projeto : projetos) {
			if (projeto.getTitulo().equals(name)) {
				if (type == 0) {
					return projeto;
				}

				if (type == projeto.getType()) {
					return projeto;
				}

			}
		}
		return null;
	}

	private static boolean searchColab(String name, int type) {
		for (Colaborador colaborador : colaboradores) {
			if (colaborador.getNome().equals(name)) {
				if (type == 0) {
					return true;
				}

				if (type == colaborador.getType()) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean checkProject(String name) {
		for (Projeto projeto : projetos) {
			for (String participante : projeto.getParticipantes()) {
				if (participante.equals(name)) {
					return true;
				}
			}
		}
		return false;

	}

}
