package start;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.ColaboradorDAO;
import dao.ProjetoDAO;
import dao.PublicaçãoDAO;
import management.*;

public class Main {
	static List<ColaboradorDAO> colaboradores;
	static List<ProjetoDAO> projetos;
	
	static Projectsetup projectsetup = new Projectsetup();

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
				projectsetup.addColaborador(colaboradores);
				break;
			case 2:
				projectMenu();
				break;
			case 3:
				projectsetup.consult(colaboradores, projetos);
				break;
			case 4:
				projectsetup.printReport(colaboradores, projetos);
				break;
			case 5:
				projectsetup.addPublication(colaboradores, projetos);
				break;
			case 6:
				System.out.println("Saindo do sistema...");
				break;
			default:
				System.out.println("Opção invalida");
			}
		} while (input != 6);

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
				ColaboradorDAO collab = projectsetup.searchColab(profName, 4, colaboradores);

				if (collab != null) {
					ProjetoDAO newProj = new ProjetoDAO(projName, inicialDate, finalDate, obj, desc, value, agtName,
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

				ProjetoDAO projeto = projectsetup.searchProject(projName, 1, projetos);
				if (projeto != null) {//algo errado aqui
					System.out.println("Nome do colaborador a ser alocado: ");
					String newName = scan.nextLine();
					ColaboradorDAO colab = projectsetup.searchColab(newName, 0, colaboradores);
					if (colab != null) {
						if (colab.getType() == 1) {
							if (projectsetup.checkProject(newName, projetos)) {
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
				ProjetoDAO prj = projectsetup.searchProject(projName, 0, projetos);
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

}
