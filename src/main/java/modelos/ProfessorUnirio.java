package modelos;

import java.util.List;

import utilidades.CSV;

public class ProfessorUnirio {
	
	/**
	 * Verifica se o professor pertence a UNIRIO
	 * @param nome
	 * @return retorna TRUE caso o professor faça parte da UNIRIO
	 */
	public boolean isProfessorUnirio(String nome) {
		
		List<List<String>> professores = CSV.lerCSV("src/main/resources/CSVs/professores.csv");
		
		for(int i = 0; i < professores.size(); i ++) {
			if(professores.get(i).get(0).equalsIgnoreCase(nome)) {
				return true;
			}
		}
		return false;
	}

}
