package modelos;



import java.util.ArrayList;

public class Curriculo {
	
	private int semestresCursados;
	private ArrayList<String> premios;
	private ArrayList<String> artigosTres;
	private ArrayList<String> artigosUm;
	private ArrayList<String> eventos;
	private ArrayList<String> vinculoUnirio;
	
	
	public int getSemestresCursados() {
		return semestresCursados;
	}
	public void setSemestresCursados(int semestresCursados) {
		this.semestresCursados = semestresCursados;
	}
	public ArrayList<String> getPremios() {
		return premios;
	}
	public void setPremios(ArrayList<String> premios) {
		this.premios = premios;
	}
	public ArrayList<String> getArtigosTres() {
		return artigosTres;
	}
	public void setArtigosTres(ArrayList<String> artigosTres) {
		this.artigosTres = artigosTres;
	}
	public ArrayList<String> getArtigosUm() {
		return artigosUm;
	}
	public void setArtigosUm(ArrayList<String> artigosUm) {
		this.artigosUm = artigosUm;
	}
	public ArrayList<String> getEventos() {
		return eventos;
	}
	public void setEventos(ArrayList<String> eventos) {
		this.eventos = eventos;
	}
	public ArrayList<String> getVinculoUnirio() {
		return vinculoUnirio;
	}
	public void setVinculoUnirio(ArrayList<String> vinculoUnirio) {
		this.vinculoUnirio = vinculoUnirio;
	}
	
	

}
