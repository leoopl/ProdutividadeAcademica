package management;

import java.util.List;
import java.util.Scanner;

import dao.ColaboradorDAO;
import dao.ProjetoDAO;
import dao.PublicaçãoDAO;

public class Projectsetup {
	
	public void addPublication(List<ColaboradorDAO> colaboradores, List<ProjetoDAO> projetos) {
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
		ColaboradorDAO colab = searchColab(name, 0, colaboradores);
		PublicaçãoDAO pub = new PublicaçãoDAO(title, confName, date);
		pub.getAutores().add(name);
		colab.getPublicts().add(title);
		System.out.println("Você deseja associar a algum projeto: [1] - SIM [2] - Não");
		int aux = scanInt.nextInt();
		if (aux == 1) {
			System.out.println("Nome do projeto no qual deseja associar sua publicação: ");
			String projName = scan.nextLine();
			ProjetoDAO prj = searchProject(projName, 2, projetos);
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
	
	public void addColaborador(List<ColaboradorDAO> colaboradores) {
		Scanner scan = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);
		ColaboradorDAO newColab;
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
				newColab = new ColaboradorDAO(newName, newEmail, 1);
				colaboradores.add(newColab);
				break;
			case 2:
				newColab = new ColaboradorDAO(newName, newEmail, 2);
				colaboradores.add(newColab);
				break;
			case 3:
				newColab = new ColaboradorDAO(newName, newEmail, 3);
				colaboradores.add(newColab);
				break;
			case 4:
				newColab = new ColaboradorDAO(newName, newEmail, 4);
				colaboradores.add(newColab);
				break;
			case 5:
				newColab = new ColaboradorDAO(newName, newEmail, 5);
				colaboradores.add(newColab);
				break;
			default:
				System.out.println("Tipo de colaborador invalido");
				break;
			}
		} while (newType < 1 || newType > 5);
		System.out.println("Colaborador criado com sucesso.");
	}
	
	public void consult(List<ColaboradorDAO> colaboradores, List<ProjetoDAO> projetos) {
		Scanner scan = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);
		System.out.println("Você deseja consultar por [1] - Colaborador ou [2] - Projeto");
		int input = scanInt.nextInt();
		String name;
		if (input == 1) {
			System.out.println("Digite o nome do Colaborador: ");
			name = scan.nextLine();
			ColaboradorDAO colab = searchColab(name, 0, colaboradores);
			if (colab != null) {
				System.out.println(colab.toString());
			}else {
				System.out.println("Colaborador inexistente.");
			}
		} else if (input == 2) {
			System.out.println("Digite o nome do Projeto: ");
			name = scan.nextLine();
			ProjetoDAO project = searchProject(name, 0, projetos);
			if (project != null) {
				System.out.println(project.toString());
			} else {
				System.out.println("projeto inexistente");
			}
		} else {
			return;
		}
	}
	

	public void printReport(List<ColaboradorDAO> colaboradores, List<ProjetoDAO> projetos) {
		System.out.println("Numero de colaboradores: " + colaboradores.size());
		System.out.println("Número de projetos em elaboração: " + countType(1, projetos));
		System.out.println("Número de projetos em andamento: " + countType(2, projetos));
		System.out.println("Número de projetos concluídos: " + countType(3,projetos));
		System.out.println("Total de projetos: " + projetos.size());
	}
	
	public ProjetoDAO searchProject(String name, int type, List<ProjetoDAO> projetos) {

		for (ProjetoDAO projeto : projetos) {
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

	public ColaboradorDAO searchColab(String name, int type, List<ColaboradorDAO> colaboradores) {
		for (ColaboradorDAO colaborador : colaboradores) {
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

	public boolean checkProject(String name, List<ProjetoDAO> projetos) {
		for (ProjetoDAO projeto : projetos) {
			for (String participante : projeto.getParticipantes()) {
				if (participante.equals(name)) {
					return false;
				}
			}
		}
		return true;
	}

	public int countType(int type, List<ProjetoDAO> projetos) {
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		for (ProjetoDAO projeto : projetos) {
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
