package vistas;

import java.util.Scanner;

import org.w3c.dom.Document;

import utilidades.XML;

public class Principal {

	public static void main(String[] args) {
		
		
		try {
			Document curriculo = XML.lerXml("curriculo.xml");
			System.out.println(XML.pegarElementoDoCurriculo(curriculo, "NOME-COMPLETO", "DADOS-GERAIS"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}





	public Principal() {

		while(true) {

			String resposta = lerReposta();

			decifrarResposta(resposta);


		}

	}
	
	private void decifrarResposta(String resposta) {
		String[] valores = resposta.split(" ");

		String opcao = valores[0];

		String argumento = valores[1];
		
		decifrarResposta(opcao, argumento);
	}


	private void decifrarResposta(String opcao, String argumento) {


		switch (opcao) {
		case "-o":
			
			
			break;//TODO chamar controller
			
		case "-l":
			
			break;//TODO chamar controller
			
		case "-a":
			break;//TODO chamar controller
			
		case "-c":
			
			break;//TODO chamar controller
			
		case "-v":
			
			break;//TODO chamar controller
			
		case "-pr":
			
			break;//TODO chamar controller
			
		case "-ar":  
			
			break;//TODO chamar controller
			
		case "-anr":  
			
			break;//TODO chamar controller
			
		case "-pe":   
			
			break;//TODO chamar controller
			
		case "-vi":
			
			break;//TODO chamar controller
			

		default:
			System.out.println("Opção não encontrada.");
		}

	}





	private String lerReposta() {

		Scanner scanner = new Scanner(System.in);

		String resposta = scanner.nextLine();
		
		decifrarResposta(resposta);

		scanner.close();

		return resposta;
	}

}
