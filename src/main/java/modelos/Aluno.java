package modelos;

public class Aluno implements Comparable<Aluno> {

	private String nome;
	private Curriculo curriculo;
	private int pontuacao;

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
			else if(aluno.getCurriculo().getArtigos().size() < this.getCurriculo().getArtigos().size()) {
				return 1;
			} else if(aluno.getCurriculo().getArtigos().size() > this.getCurriculo().getArtigos().size()) {
				return -1;
			} 
			//premiacoes
			else if(aluno.getCurriculo().getPremiosMenoresDezAnos().size() < this.getCurriculo().getPremiosMenoresDezAnos().size()) {
				return 1;
			} else if(aluno.getCurriculo().getPremiosMenoresDezAnos().size() > this.getCurriculo().getPremiosMenoresDezAnos().size()) {
				return -1;
			} 
			//participacao em eventos
			else if (aluno.getCurriculo().getEventos().size() < this.getCurriculo().getEventos().size()) {
				return 1;
			} else if (aluno.getCurriculo().getEventos().size() > this.getCurriculo().getEventos().size()) {
				return -1;
			} else {
				return 0;
			}
		}
	}

}
