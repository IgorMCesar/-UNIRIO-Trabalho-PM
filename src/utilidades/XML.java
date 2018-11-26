package utilidades;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import modelos.Premio;

import modelos.Premio;



/**
 * Classe com o propósito de ler e escrever em arquivos xml.
 *
 */
public class XML {
	
	/**
	 * Instancia os premios do curriculo
	 * @param curriculo
	 * @return
	 */
	
	public ArrayList<Premio> instanciarPremios(Document curriculo){
		ArrayList<Premio> premios = new ArrayList<Premio>();
		NodeList nomes = XML.pegarElementosDoCurriculo(curriculo, "NOME-DO-PREMIO-OU-TITULO", "PREMIOS-TITULOS");
		NodeList anos = XML.pegarElementosDoCurriculo(curriculo, "ANO-DA-PREMIACAO", "PREMIOS-TITULOS");
		NodeList entidades = XML.pegarElementosDoCurriculo(curriculo, "NOME-DA-ENTIDADE-PROMOTORA", "PREMIOS-TITULOS");
		for (int i = 0; i < nomes.getLength(); i++) {
			Premio premio = new Premio();
			premio.setNome(nomes.item(i).getAttributes().getNamedItem("NOME-DO-PREMIO-OU-TITULO").getNodeValue());
			premio.setAno(anos.item(i).getAttributes().getNamedItem("ANO-DA-PREMIACAO").getNodeValue());
			premio.setNome(entidades.item(i).getAttributes().getNamedItem("NOME-DA-ENTIDADE-PROMOTORA").getNodeValue());
			premios.add(premio);
		}
		
		return premios;
		
	}
	
	/**
	 * Faz a Leitura do documento XML fornecido.
	 * @param caminho - String, caminho do arquivo XML fornecido.
	 * @return 
	 * @throws Exception Caso ocorra algum problema na leitura do arquivo.
	 */
	public static Document lerXml(String caminho) throws Exception {
		Document documento = null;
		try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            documento = builder.parse(caminho);
            
        } catch (ParserConfigurationException ex) {
           
        } catch (SAXException ex) {
         
        } catch (IOException ex) {
            
        }
		return documento;
		
	}
	
	public static NodeList pegarElementosDoCurriculo(Document documento, String elementoDoCurriculo, String tag) {
		NodeList listaDeElementos = documento.getElementsByTagName(tag);
		if (listaDeElementos.getLength() > 0) {
			return listaDeElementos;
		} else {
			return null;
		}
	}


	public static String pegarElementoDoCurriculo(Document documento, String elementoDoCurriculo, String tag) {
		NodeList listaDeElementos = documento.getElementsByTagName(tag);
		if (listaDeElementos.getLength() > 0) {
			return listaDeElementos.item(0).getAttributes().getNamedItem(elementoDoCurriculo).getNodeValue();
		} else {
			return "";
		}
	}

	public static String pegarElementoDoCurriculoo(Node no, String elementoDoCurriculo) {
		return no.getAttributes().getNamedItem(elementoDoCurriculo).getNodeValue();
	}

	public static NodeList NodeListpegartNos(Document documento, String tag) {
		return documento.getElementsByTagName(tag);
	}

	public static int pegarQunatidadeDeNos(Document documento, String tag) {
		return documento.getElementsByTagName(tag).getLength();
	}
	
	
	
	
}

//NodeList listaDePremios = doc.getElementsByTagName("PREMIO-TITULO");
//for (int i = 0; i < listaDePremios.getLength(); i++) {
//  
//  Node noDoPremio = listaDePremios.item(i);
//  if(noDoPremio.getNodeType() == Node.ELEMENT_NODE){
//      Element premio = (Element) noDoPremio;
//      
//      String anoDaPremiacao = premio.getAttribute("ANO-DA-PREMIACAO");
//      String anoDaPremiacao = premio.getAttribute("NOME-DO-PREMIO-OU-TITULO");
//      System.out.println("Ano = " + anoDaPremiacao);
//      
//      NodeList listaDeFilhosDaPessoa = premio.getChildNodes();
//      int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
//  }
//}