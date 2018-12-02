package modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import controladores.AlunoControlador;

public class Aluno {
	
	AlunoControlador controlador = new AlunoControlador();
	
	@Test
	public void instanciarAlunoTest() {
		
		modelos.Aluno aluno =  controlador.instanciarAluno("curriculo.xml",2);
		
		assertEquals(aluno.getNome(), "Gleison dos Santos Souza");
		assertTrue(aluno.getCurriculo().getNumeroSemestresSemReprovacao() == 2);
		assertEquals(aluno.getCurriculo().getPremios().get(0).getAno(),"2001");
		
	}
	
	
	@Test
	public void calcularNotaPremiosTest() {
		
		
		modelos.Aluno aluno =  controlador.instanciarAluno("curriculo.xml",2);
		assertEquals(aluno.getCurriculo().calcularNotaPremio(),21);
	}
	

	@Test
	public void calcularNotaEventosTest() {
		modelos.Aluno aluno =  controlador.instanciarAluno("curriculo.xml",2);
	//	assertEquals(aluno.getCurriculo().calcularNotaEvento(),)
		
	}
	
	
	@Test
	public void calcularNotaArtigosTest() {
		modelos.Aluno aluno =  controlador.instanciarAluno("curriculo.xml",2);
		assertEquals(aluno.getCurriculo().calcularNotaArtigo(), 6);
	}
	
	@Test
	public void calcularNotaVinculoTest() {
		modelos.Aluno aluno =  controlador.instanciarAluno("curriculo.xml",2);
		assertEquals(aluno.getCurriculo().calcularNotaVinculo(),1);
		
	}
	
	@Test
	public void calcularNotaTotalTest() {
		modelos.Aluno aluno =  controlador.instanciarAluno("curriculo.xml",2);
		assertEquals(aluno.getCurriculo().calcularNota(),27);
	}
	
}
