package controladores;

import java.util.ArrayList;
import java.util.Collections;

import modelos.Aluno;

public class RankingControlador {
	
	/**
	 * Ordena os alunos em um vetor em ordem crescente, obedecendo os criterios de avaliacao definidos
	 * @param alunos ArrayList de alunos para rankear
	 * @return ArrayList de alunos rankeados pela pontuacao
	 */
	public ArrayList<Aluno> gerarRanking(ArrayList<Aluno> alunos) {
		Collections.sort(alunos);
		return alunos;
	}
}
