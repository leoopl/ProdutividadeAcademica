package dao;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorDAO {
	private String nome;
	private String email;
	private int type; //1 - graduação; 2 - mestrado; 3 - doutorado 4 - professor 5- pesquisador
	private List<String> projects;
	private List<String> publicts;
	
	
	public ColaboradorDAO(String name, String email, int type) {
		this.setNome(name);
		this.setEmail(email);
		this.setType(type);
		this.setProjects(new ArrayList<>());
		this.setPublicts(new ArrayList<>());
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}

	public String getType(int type) {
		if (type == 1) {
			return "Aluno de Graduação";			
		}else if (type == 2) {
			return "Aludo de Mestrado";
		}else if (type == 3) {
			return "Aluno de Doutorado";
		}else if (type == 4) {
			return "Professor";
		}else {
			return "Pesquisador";
		}
	}

	@Override
	public String toString() {
		return "Colaborador [Nome = " + nome + ", e-mail = " + email + ", Tipo de Colaborador =" + getType(type) + ", Projetos = " + projects + ", Publicações = " + publicts + "]";
	}


	public List<String> getPublicts() {
		return publicts;
	}


	public void setPublicts(List<String> publicts) {
		this.publicts = publicts;
	}


	public List<String> getProjects() {
		return projects;
	}


	public void setProjects(List<String> projects) {
		this.projects = projects;
	}
	
}
