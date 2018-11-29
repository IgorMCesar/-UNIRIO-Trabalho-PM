package controladores;

import utilidades.EscritorTxt;

public class SaidaControlador {
	
	private String caminhoSaida;
	private String caminhoLogErro;
	private boolean verboso;
	private StringBuilder conteudoSaida;
	
	public SaidaControlador() {
		conteudoSaida = new StringBuilder();
		this.setVerboso(false);
	}
	
	
	public void appendConteudoSaida(String conteudo) {
		this.conteudoSaida.append(conteudo);
	}
	
	public String getCaminhoSaida() {
		return caminhoSaida;
	}
	public void setCaminhoSaida(String caminhoSaida) {
		this.caminhoSaida = caminhoSaida;
	}
	public String getCaminhoLogErro() {
		return caminhoLogErro;
	}
	public void setCaminhoLogErro(String caminhoLogErro) {
		this.caminhoLogErro = caminhoLogErro;
	}
	public boolean isVerboso() {
		return verboso;
	}
	public void setVerboso(boolean verboso) {
		this.verboso = verboso;
	}


	public void escreverArquivoSaida() {
		
		EscritorTxt.EscreverTxt(caminhoSaida, conteudoSaida.toString());
		
	}
	
	
	
	
	

}
