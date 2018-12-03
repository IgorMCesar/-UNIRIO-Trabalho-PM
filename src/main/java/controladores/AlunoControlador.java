package controladores;

import org.w3c.dom.Document;

import modelos.Curriculo;
import modelos.Aluno;
import utilidades.XML;

public class AlunoControlador {

	CurriculoControlador curriculoControlador;
	XML xml = new XML();

	
	/**
	 * Função para instanciar o aluno atráves do curriculo do mesmo
	 * @param caminhoXML
	 * @param numeroSemestresSemReprovacao
	 * @return
	 */
	public Aluno instanciarAluno(String caminhoXML, Integer numeroSemestresSemReprovacao) {

		Curriculo curriculo = null;
		Document documento = null;
		try {
			documento = XML.lerXml(caminhoXML);
			curriculo = curriculoControlador.instanciarCurriculo(caminhoXML, numeroSemestresSemReprovacao);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Aluno aluno = new Aluno();
		
		aluno.setNome(XML.pegarElementoDoCurriculo(documento, "NOME-COMPLETO", "DADOS-GERAIS"));
		
		aluno.setCurriculo(curriculo);
		
		aluno.setPontuacao(aluno.getCurriculo().calcularNota());

		return aluno;

	}
	
	
}
