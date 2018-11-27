package modelos;

public class Artigo {
	
	private String titulo;
	private String periodico;
	private String ano;
	private int valorPontuacao;
	
	
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPeriodico() {
		return periodico;
	}

	public void setPeriodico(String periodico) {
		this.periodico = periodico;
	}
	
	public void setValorPontuacao(int pontuacao) {
		this.valorPontuacao = pontuacao;
	}
	
	public int getValorPontuacao() {
		return valorPontuacao;
	}

}
