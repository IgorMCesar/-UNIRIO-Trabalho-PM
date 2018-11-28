package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import utilidades.NewCSV;

public class Curriculo {

	private int semestresCursados;
	private ArrayList<Premio> premios;
	private ArrayList<Artigo> artigos;
	private ArrayList<Evento> eventos;
	private ArrayList<String> vinculoUnirio;

	NewCSV csv = new NewCSV();

	public int calcularNota() {
		int nota = 0;
		//Calculo da pontuação por premios, verificando se está dentro da validade de 10 anos
		int notaPremio = calcularNotaPremio();
		int notaEvento = calcularNotaEvento();
		int notaArtigo = calcularNotaArtigo();

		return notaPremio + notaEvento + notaArtigo;
	}
	
	private int calcularNotaArtigo() {
		int nota = 0;
		List<List<String>> dados = csv.lerCSV("periodicos");
		for (int j = 0; j < artigos.size(); j++) {
			String periodico = artigos.get(j).getPeriodico();
			int ano = Integer.parseInt(artigos.get(j).getAno());
			if (ano >= 2008) {
				for (int i = 0; i < dados.size(); i++) {
					if (periodico.equals(dados.get(i).get(1))) {
						if (dados.get(i).get(2) == "A1" || dados.get(i).get(2) == "A2" || dados.get(i).get(2) == "B1") {
							nota += 3;
						} else {
							nota += 1;
						}
					}
				}
			}
		}
		return nota;
	}

	private int calcularNotaPremio() {
		int nota = 0;
		for (int i = 0; i < premios.size(); i++) {
	
		int ano = Integer.parseInt(premios.get(i).getAno());
		if (ano >= 2008) {
			nota++;
		}
		}
		return nota;
	}
	
	
	private int calcularNotaEvento() {
		int nota = 0;
		List<List<String>> dados = csv.lerCSV("conferencia");
		int notaEventos = 0;
		for (int j = 0; j < eventos.size(); j++) {
			String nome = eventos.get(j).getNome();
			for (int k = 0; k < dados.size(); k++) {
				if (nome.equals(dados.get(k).get(1))) {
					if (dados.get(k).get(2) == "A1" || dados.get(k).get(2) == "A2" || dados.get(k).get(2) == "B1"
							|| dados.get(k).get(2) == "B2" || dados.get(k).get(2) == "B3" || dados.get(k).get(2) == "B4"
							|| dados.get(k).get(2) == "B5") {
							notaEventos++;
					}
				}
			}
		}
		//Como a pontuação de evento está limitada a 5 pontos, verifica se a pontuação excedeu o limite
		if(notaEventos <= 5) {
			nota += notaEventos;
		}
		//Caso exceda se soma 5 a nota total
		else {
			nota += 5;
		}
		
		return nota;
	}

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
		// TODO Facilitar?
		return (ArrayList<Premio>) premios.stream()
				.filter(premio -> Integer.parseInt(premio.getAno()) >= (dataDeHoje.getYear() - 10))
				.collect(Collectors.toList());
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
		// TODO ForEach separado
		// this.artigos.forEach(artigo -> pontuacao += artigo.getValorPontuacao());
		return pontuacao;
	}

	public void setArtigos(ArrayList<Artigo> artigo) {
		this.artigos = artigo;
	}

}
