package utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável por ler CSVs e retornar os dados deles.
 * @author Tomas
 *
 */
public class CSV {

	String caminhoArquivo;
	String separadorColunas;
	File file;

	/**
	 * Instancia a classe CSV, com o separador de linha ;
	 * @param caminho Local do arquivo.
	 */
	public CSV(String caminho) {

		this(caminho, ";");
	}


	/**
	 * Instancia a classe CSV, com o separador de linha especificado
	 * @param caminho Local do arquivo.
	 * @param separador Separador de colunas do csv.
	 */
	public CSV(String caminho, String separador) {

		caminhoArquivo = caminho;
		separadorColunas = separador;
		file = new File(caminhoArquivo);		

	}

	
	/**
	 * Funcao que le o arquivo CSV e retorna uma lista de dados contidos nele
	 * @return
	 */
	public ArrayList<String[]> lerCSV() {

		ArrayList<String[]> dados = new ArrayList<String[]>();

		Scanner leitor;
		try {
			leitor = new Scanner(file);
			while(leitor.hasNext()){
				String dadosLinha = leitor.next();
				String[] values = dadosLinha.split(separadorColunas);
				dados.add(values);
			} 
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return dados;
	}           




}
