package utilidades;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
	 * @throws Exception Caso ocorra algum problema na leitura do arquivo.
	 */
	public static void lerXml(String caminho) throws Exception {
		try {
            //objetos para construir e fazer a leitura do documento
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            //abre e faz o parser de um documento xml de acordo com o nome passado no parametro
            Document doc = builder.parse(caminho);
            
            //cria uma lista de pessoas. Busca no documento todas as tag pessoa
            NodeList listaDePremios = doc.getElementsByTagName("PREMIO-TITULO");
            
            //pego o tamanho da lista de pessoas
            int tamanhoLista = listaDePremios.getLength();
            
            //varredura na lista de pessoas
            for (int i = 0; i < tamanhoLista; i++) {
                
                //pego cada item (pessoa) como um nó (node)
                Node noPremio = listaDePremios.item(i);
                
                //verifica se o noPessoa é do tipo element (e não do tipo texto etc)
                if(noPremio.getNodeType() == Node.ELEMENT_NODE){
                    
                    //caso seja um element, converto o no Pessoa em Element pessoa
                    Element elementoPessoa = (Element) noPremio;
                    
                    //já posso pegar o atributo do element
                    String id = elementoPessoa.getAttribute("ANO-DA-PREMIACAO");
                    
                    //imprimindo o id
                    System.out.println("ID = " + id);      
                    
                    //recupero os nos filhos do elemento pessoa (nome, idade e peso)
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    
                    //pego o tamanho da lista de filhos do elemento pessoa
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                            
                    //varredura na lista de filhos do elemento pessoa
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        
                        //crio um no com o cada tag filho dentro do no pessoa (tag nome, idade e peso)
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        
                        //verifico se são tipo element
                        if(noFilho.getNodeType() == Node.ELEMENT_NODE){
                            
                            //converto o no filho em element filho
                            Element elementoFilho = (Element) noFilho;
                            
                            //verifico em qual filho estamos pela tag
                            switch(elementoFilho.getTagName()){
                                case "nome":
                                    //imprimo o nome
                                    System.out.println("NOME=" + elementoFilho.getTextContent());
                                    break;
                                    
                                case "idade":
                                    //imprimo a idade
                                    System.out.println("IDADE=" + elementoFilho.getTextContent());
                                    break;
                                    
                                case "peso":
                                    //imprimo o peso
                                    System.out.println("PESO=" + elementoFilho.getTextContent());
                                    break;
                            }
                        }
                    }
                }
            }
            
        } catch (ParserConfigurationException ex) {
           
        } catch (SAXException ex) {
         
        } catch (IOException ex) {
            
        }
	}
	
}