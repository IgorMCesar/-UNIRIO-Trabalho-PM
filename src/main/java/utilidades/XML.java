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

import modelos.Artigo;
import modelos.Evento;
import modelos.Premio;
import modelos.ProfessorUnirio;
import modelos.Vinculo;



/**
 * Classe com o prop�sito de ler e escrever em arquivos xml.
 *
 */
public class XML {
	
	/**
	 * Instancia os premios do curriculo
	 * @param curriculo
	 * @return ArrayList com premios do xml
	 */
	
	public ArrayList<Premio> instanciarPremios(Document curriculo){
		ArrayList<Premio> premios = new ArrayList<Premio>();
		NodeList nomes = XML.pegarElementosDoCurriculo(curriculo, "PREMIO-TITULO");
		NodeList anos = XML.pegarElementosDoCurriculo(curriculo, "PREMIO-TITULO");
		NodeList entidades = XML.pegarElementosDoCurriculo(curriculo, "PREMIO-TITULO");
		for (int i = 0; i < nomes.getLength(); i++) {
			Premio premio = new Premio();
			premio.setNome(nomes.item(i).getAttributes().getNamedItem("NOME-DO-PREMIO-OU-TITULO").getNodeValue());
			premio.setAno(anos.item(i).getAttributes().getNamedItem("ANO-DA-PREMIACAO").getNodeValue());
			premio.setEntidade(entidades.item(i).getAttributes().getNamedItem("NOME-DA-ENTIDADE-PROMOTORA").getNodeValue());
			premios.add(premio);
		}
		
		return premios;
		
	}
	/**
	 * Instancia os eventos do curriculo
	 * @param curriculo
	 * @return ArrayList com eventos do xml
	 */
	public ArrayList<Evento> instanciarEventos(Document curriculo){
		ArrayList<Evento> eventos = new ArrayList<Evento>();
		NodeList nomes = XML.pegarElementosDoCurriculo(curriculo, "DETALHAMENTO-DA-PARTICIPACAO-EM-CONGRESSO");
		NodeList anos = XML.pegarElementosDoCurriculo(curriculo, "DADOS-BASICOS-DA-PARTICIPACAO-EM-CONGRESSO");
		for (int i = 0; i < nomes.getLength(); i++) {
			Evento evento = new Evento();
			
			evento.setNome(nomes.item(i).getAttributes().getNamedItem("NOME-DO-EVENTO").getNodeValue());
			evento.setAno(anos.item(i).getAttributes().getNamedItem("ANO").getNodeValue());
			eventos.add(evento);
		}
		
		return eventos;
		
	} 
	
	/**
	 * Instancia os artigos do curriculo
	 * @param curriculo
	 * @return ArrayList com artigos do xml
	 */
	public ArrayList<Artigo> instanciarArtigos(Document curriculo){
		ArrayList<Artigo> artigos = new ArrayList<Artigo>();
		NodeList titulos = XML.pegarElementosDoCurriculo(curriculo, "DADOS-BASICOS-DO-ARTIGO");
		NodeList periodicos = XML.pegarElementosDoCurriculo(curriculo, "DETALHAMENTO-DO-ARTIGO");
		for (int i = 0; i < titulos.getLength(); i++) {
			Artigo artigo = new Artigo();
			artigo.setAno(titulos.item(i).getAttributes().getNamedItem("ANO-DO-ARTIGO").getNodeValue());
			artigo.setTitulo(titulos.item(i).getAttributes().getNamedItem("TITULO-DO-ARTIGO").getNodeValue());
			artigo.setPeriodico(periodicos.item(i).getAttributes().getNamedItem("TITULO-DO-PERIODICO-OU-REVISTA").getNodeValue());
			artigos.add(artigo);
		}
		
		return artigos;
		
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
	
	public static NodeList pegarElementosDoCurriculo(Document documento, String tag) {
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

	public String pegarElementoDoCurriculo(Node no, String elementoDoCurriculo) {
		return no.getAttributes().getNamedItem(elementoDoCurriculo).getNodeValue();
	}

	public static NodeList NodeListpegartNos(Document documento, String tag) {
		return documento.getElementsByTagName(tag);
	}

	public static int pegarQunatidadeDeNos(Document documento, String tag) {
		return documento.getElementsByTagName(tag).getLength();
	}
	
	
	public ArrayList<Vinculo> instanciarVinculosUNIRIO(Document documento){
		
		ArrayList<Vinculo> vinculos = new ArrayList<Vinculo>();
		
		//projeto de pesquisa
		NodeList projetos = XML.pegarElementosDoCurriculo(documento, "PROJETO-DE-PESQUISA");
		NodeList periodicos = XML.pegarElementosDoCurriculo(documento, "DETALHAMENTO-DO-ARTIGO");
		NodeList formacao = XML.pegarElementosDoCurriculo(documento, "MESTRADO");
		for (int i = 0; i < projetos.getLength(); i++) {
			Vinculo vinculo = new Vinculo();
			NodeList integrantes = XML.pegarElementosDoCurriculo(documento, "INTEGRANTES-DO-PROJETO");
			for(int j = 0; j < integrantes.getLength(); j++) {
				if(new ProfessorUnirio().isProfessorUnirio(integrantes.item(i).getAttributes().getNamedItem("NOME-COMPLETO").getNodeValue())) {
					vinculo.setAno(projetos.item(i).getAttributes().getNamedItem("ANO-INICIO").getNodeValue());
					vinculo.setTitulo(projetos.item(i).getAttributes().getNamedItem("NOME-DO-PROJETO").getNodeValue());
				}
			}
			vinculo.setAno(projetos.item(i).getAttributes().getNamedItem("ANO-INICIO").getNodeValue());
			vinculo.setTitulo(projetos.item(i).getAttributes().getNamedItem("NOME-DO-PROJETO").getNodeValue());
			vinculos.add(vinculo);
		}
		for (int i = 0; i < periodicos.getLength(); i++) {
			Vinculo vinculo = new Vinculo();
			vinculo.setPeriodico(periodicos.item(i).getAttributes().getNamedItem("TITULO-DO-PERIODICO-OU-REVISTA").getNodeValue());
			vinculos.add(vinculo);
		}
		
		//formação acadêmica(procura pelo mestrado)
		if(formacao.getLength() > 0) {
			Vinculo vinculo = new Vinculo();
				if(formacao.item(0).getAttributes().getNamedItem("NOME-INSTITUICAO").equals("Universidade Federal do Estado do Rio de Janeiro")) {	
					vinculo.setAno(projetos.item(0).getAttributes().getNamedItem("ANO-DE-CONCLUSAO").getNodeValue());
					vinculo.setTitulo(projetos.item(0).getAttributes().getNamedItem("TITULO-DA-DISSERTACAO-TESE").getNodeValue());
					vinculos.add(vinculo);
				}
		
	}
		return vinculos;
	
}
}
