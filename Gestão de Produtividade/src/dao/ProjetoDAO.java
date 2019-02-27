package dao;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {
	private String titulo;
	private String dataInicial;
	private String dataFinal;
	private String objetivo;
	private String descriçao;
	private Double valor;
	private String financiadora;
	private String profResponsavel;
	private List<String> participantes;
	private List<String> publicações;
	private int type; //1 - "em elaboração" 2 - "em andamento" 3 - "concluido"	
	
	public ProjetoDAO(String titulo, String dataInicial, String dataFinal, String objetivo, String descriçao, Double valor,
			String financiadora, String profResponsavel) {

		this.titulo = titulo;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.objetivo = objetivo;
		this.descriçao = descriçao;
		this.valor = valor;
		this.financiadora = financiadora;
		this.profResponsavel = profResponsavel;
		this.participantes = new ArrayList<>();
		this.setPublicações(new ArrayList<>());
		this.type = 1;
	}

	@Override
	public String toString() {
		return "Projeto [Titulo = " + titulo + ", DataInicial = " + dataInicial + ", DataFinal = " + dataFinal + ", Objetivo = "
				+ objetivo + ", Descriçao = " + descriçao + ", Valor do financiamento =" + valor + ", Financiadora = " + financiadora
				+ ", Professor Responsavel = " + profResponsavel + ", Participantes = " + participantes + ", Publicações = "
				+ publicações + ", Status = " + getType(type) + "]";
	}
	
	public String getType(int type) {
		if (type == 1) {
			return "Em elaboração";
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

	public String getDescriçao() {
		return descriçao;
	}

	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
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

	public List<String> getPublicações() {
		return publicações;
	}

	public void setPublicações(List<String> publicações) {
		this.publicações = publicações;
	}

}
