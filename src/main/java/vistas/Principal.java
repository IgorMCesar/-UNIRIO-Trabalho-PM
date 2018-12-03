package vistas;

import org.w3c.dom.Document;

import controladores.ComissaoBolsasControlador;
import controladores.ControladorFacade;
import controladores.CurriculoControlador;
import controladores.SaidaControlador;
import modelo.Curriculo;
import utilidades.Opcoes;
import utilidades.XML;

public class Principal {

	private Opcoes opcoes;

	private ControladorFacade controladorFacade;


	public static void main(String[] args) {


		try {

			new Principal(args);
			CurriculoControlador controlador = new CurriculoControlador();
			modelos.Curriculo curriculo = controlador.instanciarCurriculo("curriculo.xml",2);
			System.out.println(curriculo.calcularNotaEvento());
			
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
			
			for(int i = 0; i < opcoes.getCaminhoESemestresSemReprovar().length; i++) {
				String caminhoArquivo = opcoes.getCaminhoESemestresSemReprovar()[i];
				Integer numeroSemestresSemReprovar = Integer.parseInt( opcoes.getCaminhoESemestresSemReprovar()[i+1]);
				controladorFacade.inserirAluno(caminhoArquivo, numeroSemestresSemReprovar);
				i++;
			}
			
			if(opcoes.isSaidaCompleta()) {
				controladorFacade.gerarSaidaPremios();
				controladorFacade.gerarSaidaArtigosQualisRestritos();

				controladorFacade.gerarSaidaVinculo();
			}
			else {
				if(opcoes.isSaidaPremios()) {
					controladorFacade.gerarSaidaPremios();
				}
				if(opcoes.isSaidaQualisRestrito()) {
					controladorFacade.gerarSaidaArtigosQualisRestritos();
				}
			}//TODO implementar próximas

			
			controladorFacade.escreverArquivoSaida();

		} catch (Exception e) {
			e.printStackTrace();
		}



	}




}
