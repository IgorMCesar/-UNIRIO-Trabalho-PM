package controladores;

import java.util.ArrayList;
import java.util.Collections;

import modelos.Aluno;

public class RankingControlador {
	
	/**
	 * Ordena os alunos em um vetor em ordem crescente, obedecendo os
	 * critérios de avaliação definidos
	 * @author Lucas Lopes
	 * @param ArrayList de alunos
	 * @return retorna arrayList ordenado de alunos
	 */
	public ArrayList<Aluno> gerarRanking(ArrayList<Aluno> alunos) {
		Collections.sort(alunos);
		return alunos;
	}
}
