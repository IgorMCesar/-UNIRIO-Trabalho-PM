package utilidades;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Classe responsável por escrever arquivos de texto.
 * @author Tomas
 *
 */
public class TxtWriter {
	
	
	private String caminho;
	private String conteudo;
	
	/**
	 * Instancia um escritor de texto.
	 */
	public TxtWriter() {
	}
	
	
	/**
	 * Instância um escritor de texto com o caminho do arquivo especificado.
	 * @param caminho Local e nome do arquivo
	 */
	public TxtWriter(String caminho) {
		this.caminho = caminho;
		
	}
	
	/**
	 * 
	 * Instância um escritor de texto com o caminho e conteudo do arquivo especificado.
	 * @param caminho Local e nome do arquivo
	 * @param conteudo Conteudo do arquivo
	 */
	public TxtWriter(String caminho, String conteudo) {
		
		this.caminho = caminho;
		this.conteudo = conteudo;
		
	}
	
	/**
	 * Escreve um arquivo de texto com o conteudo no local especificado
	 */
	public void escreverTxt() {
		
		FileWriter fw = null;
	    try {
	        fw = new FileWriter(caminho,true);
	        BufferedWriter bw = new BufferedWriter(fw);
	        PrintWriter out = new PrintWriter(bw);

	        out.write(this.conteudo);
	        out.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	

}
