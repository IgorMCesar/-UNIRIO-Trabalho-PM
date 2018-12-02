package controladores;

import org.w3c.dom.Document;

import modelos.Aluno;
import utilidades.XML;

public class AlunoControlador {

	CurriculoControlador curriculoControlador;

	public Aluno instanciarAluno(String caminhoXML, Integer numeroSemestresSemReprovacao) {

		Document documento = null;
		try {
			documento = (Document) curriculoControlador.instanciarCurriculo(caminhoXML, numeroSemestresSemReprovacao);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Aluno aluno = new Aluno(caminhoXML, numeroSemestresSemReprovacao);
		
		aluno.setNome(XML.pegarElementoDoCurriculo(documento, "NOME-COMPLETO", "DADOS-GERAIS"));
		
		aluno.setPontuacao(aluno.getCurriculo().calcularNota());

		return aluno;

	}
	
	
}
