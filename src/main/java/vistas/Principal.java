package vistas;

import org.w3c.dom.Document;

import controladores.ComissaoBolsasControlador;
import controladores.SaidaControlador;
import utilidades.Opcoes;
import utilidades.XML;

public class Principal {
	
	private Opcoes opcoes;

	private ComissaoBolsasControlador comissaoBolsasControlador;
	private SaidaControlador saidaControlador;


	public static void main(String[] args) {


		try {

			new Principal(args);

			Document curriculo = XML.lerXml("curriculo.xml");
			System.out.println(XML.pegarElementoDoCurriculo(curriculo, "NOME-COMPLETO", "DADOS-GERAIS"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	



	public Principal(String[] args) {
		
		opcoes = Opcoes.getInstancia(args);

		comissaoBolsasControlador = new ComissaoBolsasControlador();
		saidaControlador = new SaidaControlador();

		executarComandos();


	}


	private void executarComandos() {
		
		
		
	}




}
