import java.util.ArrayList;

public class Projeto {
	private String titulo;
	private String dataInicial;
	private String dataFinal;
	private String objetivo;
	private String descri�ao;
	private Double valor;
	private String financiadora;
	private ArrayList<String> participantes;

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

	public ArrayList<String> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<String> participantes) {
		this.participantes = participantes;
	}

}
