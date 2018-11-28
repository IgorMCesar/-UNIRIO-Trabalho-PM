package controladores;

import modelos.Aluno;
import modelos.Premio;

/**
 * Classe responsável por receber chamadas da view e delegar aos controladores certos.
 * @author tomas.machado
 *
 */
public class ControladorFacade {

	private ComissaoBolsasControlador comissao;
	private CurriculoControlador curriculo;
	private RankingControlador ranking;
	private SaidaControlador saida;
	private AlunoControlador aluno;

	public ControladorFacade() {

		comissao = new ComissaoBolsasControlador();
		curriculo = new CurriculoControlador();
		ranking = new RankingControlador();
		saida = new SaidaControlador();
		aluno = new AlunoControlador();

	}

	public void inserirAluno(String caminho, Integer numeroSemestresSemReprovacao) throws Exception {

		comissao.inserirAluno(caminho, numeroSemestresSemReprovacao);

	}

	public void definirArquivoSaida(String caminho) {

		saida.setCaminhoSaida(caminho);

	}

	public void definirArquivoLog(String caminho) {

		saida.setCaminhoLogErro(caminho);

	}

	public void setVerboso() {

		saida.setVerboso(true);

	}

	//TODO implementar modo verboso
	public void gerarSaidaPremios() {

		StringBuilder builder = new StringBuilder();

		builder.append("Prêmios obtidos:"  + "\r\n");
		
		System.out.println(comissao.getAlunos().size());
		
		for (Aluno aluno : comissao.getAlunos()) {

			builder.append(aluno.getNome() + ":\r\n");

			builder.append("Pontuação obtida: " + aluno.getCurriculo().calcularNotaPremio() + "\r\n");
			builder.append("Quantidade de prêmios considerados: " + aluno.getCurriculo().getPremiosMenoresDezAnos().size() + "\r\n");

		}

		saida.appendConteudoSaida(builder.toString());

		System.out.println(builder.toString());
	}

	//TODO terminar
	public void gerarSaidaArtigosQualisRestritos() {

		StringBuilder builder = new StringBuilder();

		builder.append("Artigos de Qualis Restrito obtidos:");

		for (Aluno aluno : comissao.getAlunos()) {

			builder.append(aluno.getNome() + ":\r\n");

			builder.append("Pontuação obtida: " + aluno.getCurriculo() + "\r\n");
			builder.append("Quantidade de prêmios considerados: " + aluno.getCurriculo().getPremiosMenoresDezAnos().size() + "\r\n");

		}

	}


}
