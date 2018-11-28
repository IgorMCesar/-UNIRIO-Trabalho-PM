package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import utilidades.CSV;

public class Curriculo {

	private int semestresCursados;
	private ArrayList<Premio> premios;
	private ArrayList<Artigo> artigos;
	private ArrayList<Evento> eventos;
	private ArrayList<Vinculo> vinculoUnirio;
	private Integer numeroSemestresSemReprovacao;

	public static final int PONTUACAO_ARTIGOS_3_PONTOS = 3;
	public static final int PONTUACAO_ARTIGOS_1_PONTOS = 1;
	public static final int PONTUACAO_EVENTO = 1;
	public static final int PONTUACAO_MAXIMA_EVENTO = 5;
	
	public int calcularNota() {
		
		//Calculo da pontuação por premios, verificando se está dentro da validade de 10 anos
		int notaPremio = calcularNotaPremio();
		int notaEvento = calcularNotaEvento();
		int notaArtigo = calcularNotaArtigo();

		return notaPremio + notaEvento + notaArtigo;
	}
	
	public int calcularNotaArtigo() {
		int nota = 0;
		List<List<String>> dados = CSV.lerCSV("src/main/resources/CSVs/periodicos.csv");
		for (int j = 0; j < artigos.size(); j++) {
			String periodico = artigos.get(j).getPeriodico();
			System.out.println(artigos.get(j).getAno());
			System.out.println(periodico);
			int ano = Integer.parseInt(artigos.get(j).getAno());
			if (ano >= 2008) {
				for (int i = 0; i < dados.size(); i++) {				
					if (periodico.equalsIgnoreCase(dados.get(i).get(1))) {
						if (dados.get(i).get(2).equalsIgnoreCase("A1") || dados.get(i).get(2).equalsIgnoreCase("A2") || dados.get(i).get(2).equalsIgnoreCase("B1")) {
							nota += PONTUACAO_ARTIGOS_3_PONTOS;
						} else {
							nota += PONTUACAO_ARTIGOS_1_PONTOS;
						}
					}
				}
			}
		}
		return nota;
	}

	public int calcularNotaPremio() {
		int nota = 0;
		for (int i = 0; i < premios.size(); i++) {
	
		int ano = Integer.parseInt(premios.get(i).getAno());
		if (ano >= 2008) {
			nota++;
		}
		}
		return nota;
	}
	
	
	public int calcularNotaEvento() {
		int nota = 0;
		List<List<String>> dados = CSV.lerCSV("src/main/resources/CSVs/conferencia.csv");
		int notaEventos = 0;
		for (int j = 0; j < eventos.size(); j++) {
			String nome = eventos.get(j).getNome();
			for (int k = 0; k < dados.size(); k++) {
				if (nome.equals(dados.get(k).get(1))) {
					if (dados.get(k).get(3).equalsIgnoreCase("A1") || dados.get(k).get(3).equalsIgnoreCase("A2") || dados.get(k).get(3).equalsIgnoreCase("B1")
							|| dados.get(k).get(3).equalsIgnoreCase("B2") || dados.get(k).get(3).equalsIgnoreCase("B3") || dados.get(k).get(3).equalsIgnoreCase("B4")
							|| dados.get(k).get(3).equalsIgnoreCase("B5")) {
							notaEventos += PONTUACAO_EVENTO;
					}
				}
			}
		}
		//Como a pontuação de evento está limitada a 5 pontos, verifica se a pontuação excedeu o limite
		if(notaEventos <= PONTUACAO_MAXIMA_EVENTO) {
			nota += notaEventos;
		}
		//Caso exceda se soma 5 a nota total
		else {
			nota += PONTUACAO_MAXIMA_EVENTO;
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

	public ArrayList<Vinculo> getVinculoUnirio() {
		return vinculoUnirio;
	}

	public void setVinculoUnirio(ArrayList<Vinculo> vinculoUnirio) {
		this.vinculoUnirio = vinculoUnirio;
	}

	public ArrayList<Artigo> getArtigos() {
		return artigos;
	}

	public int getPontuacaoArtigos() {
		return this.calcularNotaArtigo();
	}
	
	public int getPontuacaoEventos() {
		return this.calcularNotaEvento();
	}

	public void setArtigos(ArrayList<Artigo> artigo) {
		this.artigos = artigo;
	}

	public Integer getNumeroSemestresSemReprovacao() {
		return numeroSemestresSemReprovacao;
	}

	public void setNumeroSemestresSemReprovacao(Integer numeroSemestresSemReprovacao) {
		this.numeroSemestresSemReprovacao = numeroSemestresSemReprovacao;
	}

}
