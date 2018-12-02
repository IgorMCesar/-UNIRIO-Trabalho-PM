package controladores;

import java.util.ArrayList;

import modelos.Aluno;

public class ComissaoBolsasControlador {
	
	private ArrayList<Aluno> alunos;
	
	private CurriculoControlador curriculoControlador;
	
	private SaidaControlador saidaControlador;
	
	public ComissaoBolsasControlador() {
		
		alunos = new ArrayList<Aluno>();
		
		curriculoControlador = new CurriculoControlador();
		
		saidaControlador = new SaidaControlador();
		
	}
	
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
}




