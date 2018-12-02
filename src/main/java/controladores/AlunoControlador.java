package controladores;

import java.util.ArrayList;

import org.w3c.dom.Document;

import modelos.Aluno;
import utilidades.XML;

public class AlunoControlador {

	CurriculoControlador curriculoControlador;

	public Aluno instanciarAluno(String caminhoXML, Integer numeroSemestresSemReprovacao) {

		XML xml = new XML();

		Document documento = null;
		try {
			documento = (Document) curriculoControlador.instanciarCurriculo(caminhoXML, numeroSemestresSemReprovacao);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Aluno aluno = null;
		try {
			documento = XML.lerXml(caminhoXML);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aluno.getCurriculo().setEventos(xml.instanciarEventos(documento));
		aluno.getCurriculo().setArtigos(xml.instanciarArtigos(documento));
		aluno.getCurriculo().setPremios(xml.instanciarPremios(documento));
		aluno.getCurriculo().setVinculoUnirio(xml.instanciarVinculosUNIRIO(documento));
		// TODO instanciar semestres cursados

		aluno.getCurriculo().setNumeroSemestresSemReprovacao(numeroSemestresSemReprovacao);

		aluno.setCurriculo(aluno.getCurriculo());

		aluno.setNome(XML.pegarElementoDoCurriculo(documento, "NOME-COMPLETO", "DADOS-GERAIS"));

		return aluno;

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
	public void inserirAluno(String caminhoXML, Integer numeroSemestresSemReprovacao, ArrayList<Aluno> alunos)
			throws Exception {

		Aluno aluno = new Aluno(caminhoXML, numeroSemestresSemReprovacao);

		aluno.setCurriculo(curriculoControlador.instanciarCurriculo(caminhoXML, numeroSemestresSemReprovacao));

		alunos.add(aluno);

	}
	
}
