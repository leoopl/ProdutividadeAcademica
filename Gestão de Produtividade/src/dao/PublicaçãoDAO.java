package dao;
import java.util.ArrayList;
import java.util.List;

public class PublicaçãoDAO {
	private String titulo;
	private String confName;
	private int ano;
	private List<String> autores;
	private List<String> projetos;
	
	
	public PublicaçãoDAO(String titulo, String confName, int ano) {
		super();
		this.titulo = titulo;
		this.confName = confName;
		this.ano = ano;
		this.autores = new ArrayList<>();
		this.projetos = new ArrayList<>();
	}
	
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
	public List<String> getAutores() {
		return autores;
	}
	public void setAutores(ArrayList<String> autores) {
		this.autores = autores;
	}
	public List<String> getProjetos() {
		return projetos;
	}
	public void setProjetos(ArrayList<String> projetos) {
		this.projetos = projetos;
	}
}
