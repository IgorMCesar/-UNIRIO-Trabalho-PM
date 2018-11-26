package utilidades;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



/**
 * Classe com o propósito de ler e escrever em arquivos xml.
 *
 */
public class XML {
	
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