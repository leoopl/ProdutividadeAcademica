package dao;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {
	private String titulo;
	private String dataInicial;
	private String dataFinal;
	private String objetivo;
	private String descri�ao;
	private Double valor;
	private String financiadora;
	private String profResponsavel;
	private List<String> participantes;
	private List<String> publica��es;
	private int type; //1 - "em elabora��o" 2 - "em andamento" 3 - "concluido"	
	
	public ProjetoDAO(String titulo, String dataInicial, String dataFinal, String objetivo, String descri�ao, Double valor,
			String financiadora, String profResponsavel) {

		this.titulo = titulo;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.objetivo = objetivo;
		this.descri�ao = descri�ao;
		this.valor = valor;
		this.financiadora = financiadora;
		this.profResponsavel = profResponsavel;
		this.participantes = new ArrayList<>();
		this.setPublica��es(new ArrayList<>());
		this.type = 1;
	}

	@Override
	public String toString() {
		return "Projeto [Titulo = " + titulo + ", DataInicial = " + dataInicial + ", DataFinal = " + dataFinal + ", Objetivo = "
				+ objetivo + ", Descri�ao = " + descri�ao + ", Valor do financiamento =" + valor + ", Financiadora = " + financiadora
				+ ", Professor Responsavel = " + profResponsavel + ", Participantes = " + participantes + ", Publica��es = "
				+ publica��es + ", Status = " + getType(type) + "]";
	}
	
	public String getType(int type) {
		if (type == 1) {
			return "Em elabora��o";
		}else if (type == 2) {
			return "Em andamento";
		}else {
			return "Concluido";
		}
	}


	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getProfResponsavel() {
		return profResponsavel;
	}

	public void setProfResponsavel(String profResponsavel) {
		this.profResponsavel = profResponsavel;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getDescri�ao() {
		return descri�ao;
	}

	public void setDescri�ao(String descri�ao) {
		this.descri�ao = descri�ao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getFinanciadora() {
		return financiadora;
	}

	public void setFinanciadora(String financiadora) {
		this.financiadora = financiadora;
	}

	public List<String> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<String> participantes) {
		this.participantes = participantes;
	}

	public List<String> getPublica��es() {
		return publica��es;
	}

	public void setPublica��es(List<String> publica��es) {
		this.publica��es = publica��es;
	}

}
