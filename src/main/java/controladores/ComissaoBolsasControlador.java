package controladores;

import java.util.ArrayList;

import modelos.Aluno;

public class ComissaoBolsasControlador {
	
	private ArrayList<Aluno> alunos;
	
	private CurriculoControlador curriculoControlador;
	
	public ComissaoBolsasControlador() {
		
		alunos = new ArrayList<Aluno>();
		
		curriculoControlador = new CurriculoControlador();
		
	}
	
	public void inserirAluno(String caminhoXML, Integer numeroRemestresSemReprovacao) throws Exception {
		
		Aluno aluno = new Aluno();
		
		aluno.setCurriculo(curriculoControlador.instanciarCurriculo(caminhoXML,numeroRemestresSemReprovacao));
		
		alunos.add(aluno);
		
	}
}




