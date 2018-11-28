package modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Aluno {
	
	@Test
	public void instanciarAlunoTest() {
		
		modelos.Aluno aluno = new modelos.Aluno("curriculo.xml",2);
		
		assertEquals(aluno.getNome(), "Gleison dos Santos Souza");
		assertTrue(aluno.getCurriculo().getNumeroSemestresSemReprovacao() == 2);
		assertEquals(aluno.getCurriculo().getPremios().get(0).getAno(),"2001");
		
	}
	
}
