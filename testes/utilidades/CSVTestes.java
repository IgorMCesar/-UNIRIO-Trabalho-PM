package utilidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


/**
 * Classe de testes para CSVs
 * @author Tomas
 *
 */
public class CSVTestes {
	
	@Test
	public void testeLerCSV() {
		
		CSV csv1 = new CSV("testes/arquivosTeste/CSVs/CSV1.csv");
		ArrayList<String[]> dados1 = csv1.lerCSV();
		
		
		assertEquals("dado11", dados1.get(0)[0]);
		assertEquals("dado12", dados1.get(0)[1]);
		assertEquals("dado13", dados1.get(0)[2]);
		assertEquals("dado21", dados1.get(1)[0]);
		assertEquals("dado22", dados1.get(1)[1]);
		assertEquals("dado23", dados1.get(1)[2]);
		assertEquals("dado31", dados1.get(2)[0]);
		assertEquals("dado32", dados1.get(2)[1]);
		assertEquals("dado33", dados1.get(2)[2]);
		
	}

}
