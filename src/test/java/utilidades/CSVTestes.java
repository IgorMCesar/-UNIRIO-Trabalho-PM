package utilidades;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * Classe de testes para CSVs
 * @author Tomas
 *
 */
public class CSVTestes {
	
	@Test
	public void testeLerCSV() {
		

		List<List<String>> dados1 = CSV.lerCSV("src/test/resources/CSVs/CSV1.csv");
		
		assertEquals("dado11", dados1.get(0).get(0));
		assertEquals("dado11", dados1.get(0).get(0));
		assertEquals("dado12", dados1.get(0).get(1));
		assertEquals("dado13", dados1.get(0).get(2));
		assertEquals("dado21", dados1.get(1).get(0));
		assertEquals("dado22", dados1.get(1).get(1));
		assertEquals("dado23", dados1.get(1).get(2));
		assertEquals("dado31", dados1.get(2).get(0));
		assertEquals("dado32", dados1.get(2).get(1));
		assertEquals("dado33", dados1.get(2).get(2));
		
	}

}
