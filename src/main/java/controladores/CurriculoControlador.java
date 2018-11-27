package controladores;

import org.w3c.dom.Document;

import modelos.Curriculo;
import utilidades.XML;

public class CurriculoControlador {
	XML xml = new XML();

	public Curriculo instanciarCurriculo(Document documento){
		Curriculo curriculo = new Curriculo();
		curriculo.setEventos(xml.instanciarEventos(documento));
		curriculo.setArtigos(xml.instanciarArtigos(documento));
		curriculo.setPremios(xml.instanciarPremios(documento));
		//TODO instanciar semestres cursados
		
		
	return curriculo;
		
	}
}
