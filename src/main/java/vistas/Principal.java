package vistas;

import org.w3c.dom.Document;

import controladores.ComissaoBolsasControlador;
import controladores.ControladorFacade;
import controladores.SaidaControlador;
import utilidades.Opcoes;
import utilidades.XML;

public class Principal {
	
	private Opcoes opcoes;

	private ControladorFacade controladorFacade;


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

		controladorFacade = new ControladorFacade();

		executarComandos();


	}


	private void executarComandos() {
		
		try {
			
			if(opcoes.isVerboso())
				controladorFacade.setVerboso();
			
			controladorFacade.definirArquivoSaida(opcoes.getCaminhoSaida());
			
			controladorFacade.definirArquivoLog(opcoes.getCaminhoLogErros());
			
//			controladorFacade.
			
			//TODO testes, implementar lógica ao terminar
			controladorFacade.setVerboso();
			controladorFacade.definirArquivoSaida("saida.txt");
			controladorFacade.inserirAluno("curriculo.xml", 4);
			controladorFacade.gerarSaidaPremios();
			controladorFacade.gerarSaidaArtigosQualisRestritos();
			
//			controladorFacade.gerarSaidaVinculo();
			
			controladorFacade.escreverArquivoSaida();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}




}
