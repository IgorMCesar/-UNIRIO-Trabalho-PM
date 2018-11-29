package utilidades;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CSV {

	private final static String SEPARADOR_COLUNAS = ";";

	/**
	 * Funcao que le o arquivo CSV e retorna uma lista de dados contidos nele
	 * @param caminhoDoArquivo
	 * @return 
	 */
	public static List<List<String>> lerCSV(String caminhoDoArquivo) {
		
		List<List<String>> dados = null;
		try {
			Path caminho = Paths.get(caminhoDoArquivo);
	
		    if (Files.exists(caminho)) {
		        List<String> linhas = Files.readAllLines(caminho, Charset.forName("windows-1251"));
		        dados = linhas.stream()
	                                   .skip(1)
	                                   .map(linha -> Arrays.asList(linha.split(SEPARADOR_COLUNAS)))
	                                   .filter(Objects::nonNull)
	                                   .collect(Collectors.toList());
		    } else {
		    	System.err.println("Arquivo não encontrado");
		    }
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return dados;
	}
	
	

}