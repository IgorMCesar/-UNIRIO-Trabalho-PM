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
	
	/**
	 * Insere um novo aluno para que o mesmo possa ser pontuado
	 * 
	 * @param caminhoXML
	 *            String com o caminho do xml fornecido
	 * @param numeroSemestresSemReprovacao
	 *            Integer com o numero de semestres sem reprovacao na pos graduacao
	 * @throws Exception
	 */
	public void inserirAluno(String caminhoXML, Integer numeroSemestresSemReprovacao)
			throws Exception {

		Aluno aluno = new Aluno(caminhoXML, numeroSemestresSemReprovacao);

		aluno.setCurriculo(curriculoControlador.instanciarCurriculo(caminhoXML, numeroSemestresSemReprovacao));

		alunos.add(aluno);

	}
	
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
}




