package utilidades;

import picocli.CommandLine;
import picocli.CommandLine.Option;

public class Opcoes {
	
	private static Opcoes instancia;
	
	private Opcoes() {
		
	}
	
	public static Opcoes getInstancia(String[] args) {
		if (instancia == null)
			return CommandLine.populateCommand(new Opcoes(), args);
		return instancia;
	}
	
	public static Opcoes getIntancia() {
		if (instancia == null)
			throw new IllegalStateException("Instancia não inicializada. Use o construtor getInstancia(String[] args) para inicializá-la.");
		return instancia;
	}
	
	@Option(names = {"-o"}, description = "indica o caminho do arquivo texto que deve conter a saída do programa.")
	private String caminhoSaida;
	
	@Option(names = {"-l"}, description = "indica o caminho do arquivo texto que deve conter um log/relatório de erros do programa.")
	private String caminhoLogErros;
	
	//Se a entrada for -a saida1 8 -a saida2 4, o array ficara ["saida1", "8", "saida2", "4"]
	@Option(names = {"-a"}, arity = "2", description = "indica os dados do candidato a ser considerado: o caminho do arquivo com o currículo Lattes, no formato XML, e o número de semestres que o aluno já completou sem reprovações. Podem ser passados vários parâmetros \"-a\" para o programa.")
	private String[] caminhoESemestresSemReprovar;
	
	@Option(names = {"-v"}, description = "modificador que indica que a saída deve ser completa (modo verboso, ou verbose mode).")
    private boolean verboso = false;
	
	@Option(names = {"-c"}, description = "gera a saida completa do programa.")
    private boolean saidaCompleta = false;
	
	@Option(names = {"-pr"}, description = "gera a saída referente aos prêmios recebidos.")
    private boolean saidaPremios = false;
	
	@Option(names = {"-ar"}, description = "gera a saída referente aos artigos completos no Qualis Restrito (ou seja, publicados em conferências ou periódicos classificados como A1, A2 e B1).")
    private boolean saidaQualisRestrito = false;
	
	@Option(names = {"-anr"}, description = " gera a saída referente aos artigos completos fora do Qualis Restrito (ou seja, publicados em conferências ou periódicos classificados como B2, B3, B4 e B5).")
    private boolean saidaForaQualisRestrito = false;
	
	@Option(names = {"-pe"}, description = "gera a saída referente à participação em eventos classificados (ou seja, referentes a conferências classificadas como A1, A2, B1, B2, B3, B4 e B5).")
    private boolean saidaParticipacaoEventos = false;
	
	@Option(names = {"-vi"}, description = "gera a saída referente à existência de vínculo com a UNIRIO.")
    private boolean saidaVinculo = false;


	public String getCaminhoSaida() {
		return caminhoSaida;
	}

	public String getCaminhoLogErros() {
		return caminhoLogErros;
	}

	public String[] getCaminhoESemestresSemReprovar() {
		return caminhoESemestresSemReprovar;
	}

	public boolean isVerboso() {
		return verboso;
	}

	public boolean isSaidaCompleta() {
		return saidaCompleta;
	}

	public boolean isSaidaPremios() {
		return saidaPremios;
	}

	public boolean isSaidaQualisRestrito() {
		return saidaQualisRestrito;
	}

	public boolean isSaidaForaQualisRestrito() {
		return saidaForaQualisRestrito;
	}

	public boolean isSaidaParticipacaoEventos() {
		return saidaParticipacaoEventos;
	}

	public boolean isSaidaVinculo() {
		return saidaVinculo;
	}

   
    

}
