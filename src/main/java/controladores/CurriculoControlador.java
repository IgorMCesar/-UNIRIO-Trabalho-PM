package controladores;

import org.w3c.dom.Document;

import modelos.Curriculo;
import utilidades.XML;

public class CurriculoControlador {
	XML xml = new XML();

	/**
	 * @author Lucas Lopes
	 * @param
	 * @return
	 */
	public Curriculo instanciarCurriculo(String caminho, Integer numeroRemestresSemReprovacao) throws Exception{
		
		Document documento = XML.lerXml(caminho);
		
		Curriculo curriculo = new Curriculo();
		curriculo.setEventos(xml.instanciarEventos(documento));
		curriculo.setArtigos(xml.instanciarArtigos(documento));
		curriculo.setPremios(xml.instanciarPremios(documento));
		//TODO instanciar semestres cursados
		
		curriculo.setNumeroSemestresSemReprovacao(numeroRemestresSemReprovacao);
		
	return curriculo;
		
	}
}
