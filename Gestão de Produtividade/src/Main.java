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
			System.out.println();
			System.out.println("Escolha o número da operação que deseja realizar: ");
			System.out.println("[1] - Criar Perfil de Colaborador");
			System.out.println("[2] - Gerenciar Projeto");
			System.out.println("[3] - Consulta");
			System.out.println("[4] - Relatorio de Produção");
			System.out.println("[5] - Publicação");
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
				printReport();
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

	private static void printReport() {
		System.out.println("Numero de colaboradores: " + colaboradores.size());
		System.out.println("Número de projetos em elaboração: " + countType(1));
		System.out.println("Número de projetos em andamento: " + countType(2));
		System.out.println("Número de projetos concluídos: " + countType(3));
		System.out.println("Total de projetos: " + projetos.size());
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
		System.out.println("Nome do autor: ");
		String name = scan.nextLine();
		Colaborador colab = searchColab(name, 0);
		Publicação pub = new Publicação(title, confName, date);
		pub.getAutores().add(name);
		colab.getPublicts().add(title);
		System.out.println("Você deseja associar a algum projeto: [1] - SIM [2] - Não");
		int aux = scanInt.nextInt();
		if (aux == 1) {
			System.out.println("Nome do projeto no qual deseja associar sua publicação: ");
			String projName = scan.nextLine();
			Projeto prj = searchProject(projName, 2);
			if (prj != null) {
				pub.getProjetos().add(projName);
				prj.getPublicações().add(title);
			} else {
				System.out.println("Projeto inexistente ou encontrasse em um status diferente de em andamento");
			}
		} else {
			System.out.println("Nenhum projeto associado a essa publicação.");
		}
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
			Colaborador colab = searchColab(name, 0);
			if (colab != null) {
				System.out.println(colab.toString());
			}else {
				System.out.println("Colaborador inexistente.");
			}
		} else if (input == 2) {
			System.out.println("Digite o nome do Projeto: ");
			name = scan.nextLine();
			Projeto project = searchProject(name, 0);
			if (project != null) {
				System.out.println(project.toString());
			} else {
				System.out.println("projeto inexistente");
			}
		} else {
			return;
		}

	}

	private static void projectMenu() {
		Scanner scan = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);
		int input;

		do {
			System.out.println("[1] - Novo Projeto");
			System.out.println("[2] - Alocação de participantes");
			System.out.println("[3] - Alterar Status");
			System.out.println("[0] - Voltar ao menu principal");
			String projName;
			input = scanInt.nextInt();

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
				Colaborador collab = searchColab(profName, 4);

				if (collab != null) {
					Projeto newProj = new Projeto(projName, inicialDate, finalDate, obj, desc, value, agtName,
							profName);
					newProj.getParticipantes().add(profName);
					collab.getProjects().add(projName);
					projetos.add(newProj);
				} else {
					System.out.println("Colaborador não existe ou não é professor\n O projeto não foi criado.");
				}
				System.out.println("Projeto criado com sucesso!");
				break;
			case 2:
				System.out.println("Qual Projeto você quer alocar?");
				projName = scan.nextLine();

				Projeto projeto = searchProject(projName, 1);
				if (projeto != null) {//algo errado aqui
					System.out.println("Nome do colaborador a ser alocado: ");
					String newName = scan.nextLine();
					Colaborador colab = searchColab(newName, 0);
					if (colab != null) {
						if (colab.getType() == 1) {
							if (checkProject(newName)) {
								projeto.getParticipantes().add(newName);
								colab.getProjects().add(projName);
							}else {
								System.out.println("O aluno em graduação já está em algum projeto.");
							}
						}else {
							projeto.getParticipantes().add(newName);
							colab.getProjects().add(projName);
						}
					}else {
						System.out.println("Colaborador não existente");
					}
				}else {
					System.out.println("projeto inexistente.");
				}
				break;
			case 3:
				System.out.println("Qual Projeto você quer alterar?");
				projName = scan.nextLine();
				Projeto prj = searchProject(projName, 0);
				if (prj.getType() == 1) {
					prj.setType(2);
				} else if (prj.getType() == 2) {
					if (prj.getPublicações().size() > 1) {
						prj.setType(3);
					} else {
						System.out.println("Projeto sem publicações");
					}
				} else if (prj.getType() == 3) {
					System.out.println("projeto concluido");
				}else {
					System.out.println("projeto não existente");
				}
				break;
			case 0:
				break;
			default:
				System.out.println("Tente outra vez.");
			}
		} while (input != 0);

	}

	private static void addColaborador() {
		Scanner scan = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);
		Colaborador newColab;
		int newType;

		System.out.println("Nome do Colaborador:");
		String newName = scanString.nextLine();
		System.out.println("E-mail do Colaborador: ");
		String newEmail = scanString.nextLine();
		do {
			System.out.println(
					"Tipo do Colaborador:\n [1] - Aluno Graduando\n [2] - Aluno Mestrando\n [3] - Aluno Doutorando\n [4] - Professor\n [5] - Pesquisador");
			newType = scan.nextInt();
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
				System.out.println("Tipo de colaborador invalido");
				break;
			}
		} while (newType < 1 || newType > 5);
		System.out.println("Colaborador criado com sucesso.");
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

	private static Colaborador searchColab(String name, int type) {
		for (Colaborador colaborador : colaboradores) {
			if (colaborador.getNome().equals(name)) {
				if (type == 0) {
					return colaborador;
				}

				if (type == colaborador.getType()) {
					return colaborador;
				}
			}
		}
		return null;
	}

	private static boolean checkProject(String name) {
		for (Projeto projeto : projetos) {
			for (String participante : projeto.getParticipantes()) {
				if (participante.equals(name)) {
					return false;
				}
			}
		}
		return true;
	}

	private static int countType(int type) {
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		for (Projeto projeto : projetos) {
			if (projeto.getType() == 1) {
				count1 += 1;
			} else if (projeto.getType() == 2) {
				count2 += 1;
			} else {
				count3 += 1;
			}
		}
		if (type == 1) {
			return count1;
		} else if (type == 2) {
			return count2;
		} else {
			return count3;
		}
	}

}
