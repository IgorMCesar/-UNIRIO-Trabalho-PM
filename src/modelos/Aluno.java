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
	public int compareTo(Aluno o) {
		if (o.getPontuacao() < this.getPontuacao()) {
			return 1;
		} else if (o.getPontuacao() > this.getPontuacao()) {
			return -1;
		} else {
			//CRITERIOS DE DESEMPATE
			
			//semestres cursados
			if(o.getCurriculo().getSemestresCursados() < this.getCurriculo().getSemestresCursados()) {
				return 1;
			} else if(o.getCurriculo().getSemestresCursados() > this.getCurriculo().getSemestresCursados()) {
				return -1;
			} 
			//artigos publicados
			else if(o.getCurriculo().getArtigos().size() < this.getCurriculo().getArtigos().size()) {
				return 1;
			} else if(o.getCurriculo().getArtigos().size() > this.getCurriculo().getArtigos().size()) {
				return -1;
			} 
			//premiacoes
			else if(o.getCurriculo().getPremios().size() < this.getCurriculo().getPremios().size()) {
				return 1;
			} else if(o.getCurriculo().getPremios().size() > this.getCurriculo().getPremios().size()) {
				return -1;
			} 
			//participacao em eventos
			else if (o.getCurriculo().getEventos().size() < this.getCurriculo().getEventos().size()) {
				return 1;
			} else if (o.getCurriculo().getEventos().size() > this.getCurriculo().getEventos().size()) {
				return -1;
			} else {
				return 0;
			}
		}
	}

}
