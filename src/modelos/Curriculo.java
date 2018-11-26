package modelos;

import java.util.ArrayList;

public class Curriculo {

	private int semestresCursados;
	private ArrayList<Premio> premios;
	private ArrayList<Artigo> artigos;
	private ArrayList<Evento> eventos;
	private ArrayList<String> vinculoUnirio;

	public int getSemestresCursados() {
		return semestresCursados;
	}

	public void setSemestresCursados(int semestresCursados) {
		this.semestresCursados = semestresCursados;
	}

	public ArrayList<Premio> getPremios() {
		return premios;
	}

	public void setPremios(ArrayList<Premio> premios) {
		this.premios = premios;
	}

	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}

	public ArrayList<String> getVinculoUnirio() {
		return vinculoUnirio;
	}

	public void setVinculoUnirio(ArrayList<String> vinculoUnirio) {
		this.vinculoUnirio = vinculoUnirio;
	}

	public ArrayList<Artigo> getArtigos() {
		return artigos;
	}

	public void setArtigos(ArrayList<Artigo> artigo) {
		this.artigos = artigo;
	}

}
