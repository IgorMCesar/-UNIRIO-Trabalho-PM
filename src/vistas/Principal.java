package vistas;

import utilidades.XML;
import org.w3c.dom.Document;

public class Principal {

	public static void main(String[] args) {
		try {
			Document curriculo = XML.lerXml("curriculo.xml");
			System.out.println(XML.pegarElementoDoCurriculo(curriculo, "NOME-COMPLETO", "DADOS-GERAIS"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
