package controladores;

import java.util.ArrayList;
import java.util.Collections;

import modelos.Aluno;

public class RankingControlador {
	
	public ArrayList<Aluno> gerarRanking(ArrayList<Aluno> alunos) {
		Collections.sort(alunos);
		return alunos;
	}
}
