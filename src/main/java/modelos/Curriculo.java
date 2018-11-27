package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
	
	public ArrayList<Premio> getPremiosMenoresDezAnos() {
		LocalDate dataDeHoje = LocalDate.now();
		//TODO Facilitar?
		return (ArrayList<Premio>) premios.stream().filter(premio -> Integer.parseInt(premio.getAno()) >= (dataDeHoje.getYear() - 10)).collect(Collectors.toList());
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
	
	public int getPontuacaoDeArtigos() {
		int pontuacao = 0;
		//TODO ForEach separado
//		this.artigos.forEach(artigo -> pontuacao += artigo.getValorPontuacao());
		return pontuacao;
	}

	public void setArtigos(ArrayList<Artigo> artigo) {
		this.artigos = artigo;
	}

}
