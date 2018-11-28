package modelos;

import org.w3c.dom.Document;

import utilidades.XML;

public class Aluno implements Comparable<Aluno> {

	private String nome;
	private Curriculo curriculo;
	private int pontuacao;
	
	public Aluno(String caminhoXML, Integer numeroSemestresSemReprovacao) {
		
		XML xml = new XML();
		
		Document documento;
		try {
			curriculo = new Curriculo();
			documento = XML.lerXml(caminhoXML);
			curriculo.setEventos(xml.instanciarEventos(documento));
			curriculo.setArtigos(xml.instanciarArtigos(documento));
			curriculo.setPremios(xml.instanciarPremios(documento));
			//TODO instanciar semestres cursados
			
			
			
			curriculo.setNumeroSemestresSemReprovacao(numeroSemestresSemReprovacao);
			
			this.setCurriculo(curriculo);
			
			this.setNome(xml.pegarElementoDoCurriculo(documento, "NOME-COMPLETO", "DADOS-GERAIS"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	@Override
	
	public int compareTo(Aluno aluno) {
		if (aluno.getPontuacao() < this.getPontuacao()) {
			return 1;
		} else if (aluno.getPontuacao() > this.getPontuacao()) {
			return -1;
		} else {
			//CRITERIOS DE DESEMPATE
			
			//semestres cursados
			if(aluno.getCurriculo().getSemestresCursados() < this.getCurriculo().getSemestresCursados()) {
				return 1;
			} else if(aluno.getCurriculo().getSemestresCursados() > this.getCurriculo().getSemestresCursados()) {
				return -1;
			} 
			//artigos publicados
			else if(aluno.getCurriculo().getPontuacaoArtigos() < this.getCurriculo().getPontuacaoArtigos()) {
				return 1;
			} else if(aluno.getCurriculo().getPontuacaoArtigos() > this.getCurriculo().getPontuacaoArtigos()) {
				return -1;
			} 
			//premiacoes
			else if(aluno.getCurriculo().getPremiosMenoresDezAnos().size() < this.getCurriculo().getPremiosMenoresDezAnos().size()) {
				return 1;
			} else if(aluno.getCurriculo().getPremiosMenoresDezAnos().size() > this.getCurriculo().getPremiosMenoresDezAnos().size()) {
				return -1;
			} 
			//participacao em eventos
			else if (aluno.getCurriculo().getPontuacaoEventos() < this.getCurriculo().getPontuacaoEventos()) {
				return 1;
			} else if (aluno.getCurriculo().getPontuacaoEventos() > this.getCurriculo().getPontuacaoEventos()) {
				return -1;
			} else {
				return 0;
			}
		}
	}

}
