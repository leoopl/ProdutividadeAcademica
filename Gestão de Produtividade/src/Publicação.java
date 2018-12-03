import java.util.ArrayList;

public class Publicação {
	private String titulo;
	private String confName;
	private int ano;
	private ArrayList<String> autores;
	private ArrayList<String> projetos;
	
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getConfName() {
		return confName;
	}
	public void setConfName(String confName) {
		this.confName = confName;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public ArrayList<String> getAutores() {
		return autores;
	}
	public void setAutores(ArrayList<String> autores) {
		this.autores = autores;
	}
	public ArrayList<String> getProjetos() {
		return projetos;
	}
	public void setProjetos(ArrayList<String> projetos) {
		this.projetos = projetos;
	}
}
