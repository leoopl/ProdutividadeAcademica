import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int input;
		do {
			System.out.println("Escolha o n�mero da opera��o que deseja realizar: ");
			System.out.println("[1] - Criar Perfil de Colaborador");
			System.out.println("[2] - Gerenciar Projeto");
			System.out.println("[3] - Consulta");
			System.out.println("[4] - Relatorio de Produ��o");
			System.out.println("[5] - Publica��o/Orienta��o");
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
				printReport();//fa�o um contador pra cada 1????
				break;
			case 5:
				addPublication();
				break;
			case 6:
				System.out.println("Saindo do sistema...");
				break;
			default:
				System.out.println("Op��o invalida");
			}
		}while(input != 6);

	}

	private static void addPublication() {
		Scanner scan = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);
		System.out.println("Titulo da publica��o: ");
		String title = scan.nextLine();
		System.out.println("Nome da confer�ncia onde foi publicada: ");
		String confName = scan.nextLine();
		System.out.println("Ano de publica��o: ");
		int date = scanInt.nextInt();
		//como add mais de 1 autor
		System.out.println("Voc� deseja associar a algum projeto: [1] - SIM [2] - N�o");
		int aux = scanInt.nextInt();
		if (aux == 1) {
			System.out.println("Nome do projeto no qual deseja associar sua publica��o: ");
			String projName = scan.nextLine();
			//procurar se o projeto existe e se ele esta "em andamento"
		}else {
			System.out.println("Nenhum projeto associado.");
		}
		//criar uma nova prblica��o e setar tudo		
	}

	private static void consult() {
		Scanner scan = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);
		System.out.println("Voc� deseja consultar por [1] - Colaborador ou [2] - Projeto");
		int input = scanInt.nextInt();
		String name;
		if (input == 1) {
			System.out.println("Digite o nome do Colaborador: ");
			name = scan.nextLine();
			//pesquisar se esse colaborador existe
		}else if (input == 2) {
			System.out.println("Digite o nome do Projeto: ");
			name = scan.nextLine();
			//pesquisar se existe e fazer um toString
		}else {
			return;
		}
		
	}

	private static void projectMenu() {
		Scanner scan = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);
		
		System.out.println("[1] - Novo Projeto");
		System.out.println("[2] - Aloca��o de participantes");
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
			System.out.println("Descri��o: ");
			String desc = scan.nextLine();
			System.out.println("Agencia Financiadora: ");
			String agtName = scan.nextLine();
			System.out.println("Valor do financiamento: ");
			double value = scanInt.nextDouble();
			System.out.println("Data de inicio do projeto: ");//especificar como vai ser o input
			String inicialDate = scan.nextLine();
			System.out.println("Data para finaliza��o do projeto: ");
			String finalDate = scan.nextLine();
			System.out.println("Nome do professor responsaval: ");
			String profName = scan.nextLine();
			//procurar se esse professor existe e da o set	
			//setar o projeto como "em elabora��o"
			
			break;
		case 2:
			System.out.println("Qual Projeto voc� quer alocar?");
			projName = scan.nextLine();
			//procurar se o projeto existe e se ele esta "em elabora��o"
			System.out.println("Nome do colaborador a ser alocado: ");
			//ser for aluno de gradua��o, verificar se ele ja esta em um projeto, se n�o ele pode entrar.			
			
			break;
		case 3:
			System.out.println("Qual Projeto voc� quer alterar?");
			projName = scan.nextLine();
			//procurar se o projeto existe
			//se o status for 1 (verificar as informa��es basicas??????)
			//se o status for 2 verificar o tamanho da lista de publica��es se for > 1 pode alterar. se n�o error
			break;

		default:
			break;
		}

	}

	private static void addColaborador() {
		Scanner scan = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);
		
		System.out.println("Tipo de Colaborador:");
		System.out.println("[1] - Aluno");
		System.out.println("[2] - Professor");
		System.out.println("[3] - Pesquisador");
		System.out.println("[0] - Voltar ao menu principal");
		String newName, newEmail;
		int input = scan.nextInt();
		
		switch (input) {
		case 1:
			System.out.println("Nome do Aluno:");
			newName = scanString.nextLine();
			System.out.println("E-mail do Aluno: ");
			newEmail = scanString.nextLine();
			System.out.println("Tipo do aluno:\n [1] - Graduando\n [2] - Mestrando\n [3] - Doutorando");
			int newType = scan.nextInt();
			Estudante newAluno = new Estudante(newName, newEmail, newType);
			//add aluno na lista ou seria melhor hashmap de alunos
			break;
		case 2:
			System.out.println("Nome do Professor: ");
			newName = scanString.nextLine();
			System.out.println("E-mail do Professor: ");
			newEmail = scanString.nextLine();
			Professor newProf = new Professor(newName, newEmail);
			// add o professor na lista
			break;
		case 3:
			System.out.println("Nome do Pesquisador: ");
			newName = scanString.nextLine();
			System.out.println("E-mail do Pesquisador: ");
			newEmail = scanString.nextLine();
			Pesquisador newPesq = new Pesquisador(newName, newEmail);
			//add na lista
			break;
		case 0:
			return;
		default:
			break;
		}		
	}

}
