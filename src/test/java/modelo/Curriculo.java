package modelo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import utilidades.ComparadorUtil;

@RunWith(MockitoJUnitRunner.class)
public class Curriculo {
	
	@Mock
	ComparadorUtil comparador;
	
	@InjectMocks
	modelos.Curriculo curriculo;
	
	@Test
	public void calcularQualisTest() {
		
		when(comparador.isEqual("JOURNAL OF THE BRAZILIAN COMPUTER SOCIETY (ONLINE)", "Journal of the Brazilian Computer Society")).thenReturn(true);
			
		
		
	}
	

}
