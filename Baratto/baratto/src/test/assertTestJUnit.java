package test;

import org.junit.Test;
import Models.*;
import java.sql.SQLException;
import java.time.LocalTime;

import org.junit.Assert;

//test blackbox + assert
public class assertTestJUnit {
	@Test
	public void nomeGerarchiaTest() throws SQLException {
		boolean assertionbool = false;
		String nome = "Gerarchia";
		int id = 0;
		Model model = new Model();
		var result = model.getCategoria(id);
		if (result.getNome().equals(nome))
			assertionbool = true;
		Assert.assertTrue(assertionbool);
	}
	@Test
	public void articoloTest() throws SQLException {
		boolean assertionbool = false;
		int idArticolo = 22;
		Model model = new Model();
		var result = model.getArticolo(idArticolo);
		if (result instanceof Articolo)
			assertionbool = true;
		Assert.assertTrue(assertionbool);
		Assert.assertNotNull(result);
	}
	//Analisi valori limite
	@Test
	public void controlloCompatibilitaIntervalloOraTest() {
		Model model=new Model();
		LocalTime inizio=LocalTime.of(02, 00);
		LocalTime fine=LocalTime.of(03, 00);
		IntervalloOra intervallo = new IntervalloOra(inizio, fine);
		
		LocalTime prima=LocalTime.of(01, 59);
		LocalTime dopo=LocalTime.of(03, 01);
		LocalTime durante1=LocalTime.of(02, 01);
		LocalTime durante2=LocalTime.of(02, 59);
		
		Assert.assertFalse(model.controlloCompatibilitaIntervalloOra(intervallo, inizio));
		Assert.assertFalse(model.controlloCompatibilitaIntervalloOra(intervallo, fine));
		Assert.assertFalse(model.controlloCompatibilitaIntervalloOra(intervallo, prima));
		Assert.assertFalse(model.controlloCompatibilitaIntervalloOra(intervallo, dopo));
		Assert.assertTrue(model.controlloCompatibilitaIntervalloOra(intervallo, durante1));
		Assert.assertTrue(model.controlloCompatibilitaIntervalloOra(intervallo, durante2));
		
	}
}
