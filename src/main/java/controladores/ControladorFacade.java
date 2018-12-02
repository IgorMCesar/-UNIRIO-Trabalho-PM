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
//	private AlunoControlador aluno;

	public ControladorFacade() {

		comissao = new ComissaoBolsasControlador();
		curriculo = new CurriculoControlador();
		ranking = new RankingControlador();
		saida = new SaidaControlador();
//		aluno = new AlunoControlador();

	}
	
	/**
	 * Insere o aluno no controlador da comissão
	 * @param caminho
	 * @param numeroSemestresSemReprovacao
	 * @throws Exception
	 */
	public void inserirAluno(String caminho, Integer numeroSemestresSemReprovacao) throws Exception {

		comissao.inserirAluno(caminho, numeroSemestresSemReprovacao);

	}
	
	
	/**
	 * Define o arquivo de saída do programa
	 * @param caminho
	 */
	public void definirArquivoSaida(String caminho) {

		saida.setCaminhoSaida(caminho);

	}

	
	public void definirArquivoLog(String caminho) {

		saida.setCaminhoLogErro(caminho);

	}

	public void setVerboso() {

		saida.setVerboso(true);

	}

	/**
	 * Gera a saída dos prêmios dos alunos. 
	 */
	public void gerarSaidaPremios() {

		StringBuilder builder = new StringBuilder();

		builder.append("Prêmios obtidos:"  + "\r\n");
		
		System.out.println(comissao.getAlunos().size());
		
		for (Aluno aluno : comissao.getAlunos()) {

			builder.append(aluno.getNome() + ":\r\n");

			builder.append("Pontuação obtida: " + aluno.getCurriculo().calcularNotaPremio() + "\r\n");
			builder.append("Quantidade de prêmios considerados: " + aluno.getCurriculo().getPremiosMenoresDezAnos().size() + "\r\n");
			
			if(saida.isVerboso()) {
				builder.append("Prêmios: \r\n");
				for (Premio premio : aluno.getCurriculo().getPremios()) {
					builder.append("nome: " + premio.getNome() + ", ano: " + premio.getAno() + "\r\n");
				}
			}
		}
		
		saida.appendConteudoSaida("\n");
		saida.appendConteudoSaida(builder.toString());

		System.out.println(builder.toString());
	}
	
	

	/**
	 * Gera a saída dos Artigos com Qualis Restrito
	 */
	public void gerarSaidaArtigosQualisRestritos() {

		StringBuilder builder = new StringBuilder();
		
		saida.appendConteudoSaida("\n");
		saida.appendConteudoSaida("\r\n");

		builder.append("Artigos de Qualis Restrito obtidos:\r\n");

		for (Aluno aluno : comissao.getAlunos()) {

			builder.append(aluno.getNome() + ":\r\n");

			builder.append("Pontuação obtida: " + aluno.getCurriculo().calcularNotaArtigo() + "\r\n");
			builder.append("Quantidade de artigos considerados: " + aluno.getCurriculo().getArtigos().size() + "\r\n");

		}
		saida.appendConteudoSaida(builder.toString());

	}
	
	/**
	 * Gera a saída dos vínculos com a unirio considerados
	 */
	public void gerarSaidaVinculo() {
		StringBuilder builder = new StringBuilder();
		
		saida.appendConteudoSaida("\n");
		saida.appendConteudoSaida("\r\n");

		builder.append("Vínculo Unirio:\r\n");

		for (Aluno aluno : comissao.getAlunos()) {

			builder.append(aluno.getNome() + ":\r\n");

			builder.append("Nota conseguida por conta dos vínculos: " + aluno.getCurriculo().calcularNotaVinculo() + "\r\n");
			builder.append("Quantidade de artigos considerados: " + aluno.getCurriculo().getVinculoUnirio().size() + "\r\n");

		}
		saida.appendConteudoSaida(builder.toString());

	}

	public void escreverArquivoSaida() {
		
		saida.escreverArquivoSaida();
		
	}


}
