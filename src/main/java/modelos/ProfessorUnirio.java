package modelos;

import java.util.List;

import utilidades.CSV;

public class ProfessorUnirio {
	
	/**
	 * Verifica se é um professor da UNIRIO
	 * @param nome nome do professor a ser analisado
	 * @return true em caso dele ser um professor da UNIRIO ou false caso contrário.
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
