package utilidades;

import info.debatty.java.stringsimilarity.*;

public class ComparadorUtil {
	
	private static double VALOR_DISTANCIA_MINIMA = 0.01;
	/**
	 * Compara distancia entre duas strings, a menor distancia indica a maior similidade
	 * @param periodico String vinda do curriculo
	 * @param dado String vinda do csv fornecido
	 * @return Boolean se é semelhante
	 */
	public boolean comparaSemelhante(String periodico, String dado) {
		JaroWinkler jaroWinkler = new JaroWinkler();
		double distanciaDeString = jaroWinkler.distance(periodico.toLowerCase(), dado.toLowerCase());
		if( distanciaDeString < VALOR_DISTANCIA_MINIMA) {
			return true;
		}	
		return false;
	}

}
