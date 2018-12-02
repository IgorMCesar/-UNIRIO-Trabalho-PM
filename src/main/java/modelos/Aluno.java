package modelos;

import org.w3c.dom.Document;

import utilidades.XML;

public class Aluno implements Comparable<Aluno> {

	private String nome;
	private Curriculo curriculo;
	private int pontuacao;
	
	public Aluno() {
		// TODO Auto-generated constructor stub
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
	
	/**Funcao responsavel por estabelecer os m�todos de compara��o entre alunos
	 * @author Lucas Lopes
	 * @param Aluno aluno que ser� comparado com o corrente
	 * @return numero inteiro que representa >, < ou = (1,-1 e 0, respectivamente)
	 */
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
