package modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ProfessorUnirio {
	
	@Test
	public void isProfessorTeste() {
		
		String professoro = "Gleison dos Santos Souza";
		
		assertTrue(new modelos.ProfessorUnirio().isProfessorUnirio(professoro));
		
	}

}
