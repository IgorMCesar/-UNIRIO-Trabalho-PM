package controladores;

import org.w3c.dom.Document;

import modelos.Curriculo;
import utilidades.XML;

public class CurriculoControlador {
	XML xml = new XML();

	
	/**
	 * @param caminho String com o caminho do xml fornecido
	 * @param numeroRemestresSemReprovacao Integer com o numero de semestres sem reprovacao na pos graduacao
	 * @return Curriculo do aluno
	 * @throws Exception
	 */
	public Curriculo instanciarCurriculo(String caminho, Integer numeroSemestresSemReprovacao) throws Exception{
		
		Document documento = XML.lerXml(caminho);
		
		Curriculo curriculo = new Curriculo();
		curriculo.setEventos(xml.instanciarEventos(documento));
		curriculo.setArtigos(xml.instanciarArtigos(documento));
		curriculo.setPremios(xml.instanciarPremios(documento));
		curriculo.setVinculoUnirio(xml.instanciarVinculosUNIRIO(documento));
		//TODO instanciar semestres cursados
		
		curriculo.setNumeroSemestresSemReprovacao(numeroSemestresSemReprovacao);
		
	return curriculo;
		
	}
}
