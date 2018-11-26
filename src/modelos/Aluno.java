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
			return -1;
		} else if (o.getPontuacao() > this.getPontuacao()) {
			return 1;
		} 
		//Retorna 2 caso o nome do aluno seja igual.
		else if (this.getNome().equals(o.getNome())) {
			return 2;
		} else {
		return 0;
		}
	}

}
