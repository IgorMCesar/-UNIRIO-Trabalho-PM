package controladores;

public class SaidaControlador {
	
	private String caminhoSaida;
	private String caminhoLogErro;
	private boolean verboso;
	
	public SaidaControlador() {
		this.setVerboso(false);
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
	
	
	

}
