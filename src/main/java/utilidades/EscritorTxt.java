package utilidades;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Classe responsável por escrever arquivos de texto.
 * @author Igor
 *
 */
public class EscritorTxt {
	
	/**
	 * 
	 * Cria um arquivo de texto no caminho e com o conteudo do arquivo especificado.
	 * @param caminho Local e nome do arquivo
	 * @param conteudo Conteudo do arquivo
	 */
	public static void EscreverTxt(String caminhoDoArquivo, String conteudo) {
		
		FileWriter fw = null;
	    try {
	        fw = new FileWriter(caminhoDoArquivo,true);
	        BufferedWriter bw = new BufferedWriter(fw);
	        PrintWriter out = new PrintWriter(bw);

	        out.write(conteudo);
	        out.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
