package Projeto.Testes;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import Projeto.acoes.Ordena;

public class TestaOrdena {
	
	
	private static Ordena ordena;
	
	
	
	
	
	@Test
	@SuppressWarnings("static-access")
	public void testaBubbleSort(){ //Recebendo String[]
		String[] rests1 = {"100:Giraffas", "200:Divino Fogão", "50:Bar do George", "150:Bar do Santos", "350:Fazenda"};
		String[] rests2 = {"100;Giraffas", "200:Divino Fogão"};
		String[] rests3 = {};
		String[] rests4 = {"^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$"};
		
		
		try {
			Assert.assertEquals("Erro", "[100:Giraffas, 200:Divino Fogão, 50:Bar do George, 150:Bar do Santos, 350:Fazenda]", Arrays.toString(rests1));
			ordena.bubbleSort(rests1);
			Assert.assertEquals("Erro", "[50:Bar do George, 100:Giraffas, 150:Bar do Santos, 200:Divino Fogão, 350:Fazenda]", Arrays.toString(rests1));
		} catch (Exception ex1) {
			ex1.getMessage();
		}
		
		try{
			ordena.bubbleSort(rests2);
			fail("Deveria ter lançado uma exceção.");
		} catch(Exception ex2){
			assertTrue(true);
		}
		
		try{
			ordena.bubbleSort(rests3);
			fail("Deveria ter lançado uma exceção.");
		} catch(Exception ex3){
			assertTrue(true);
		}
		
		try{
			ordena.bubbleSort(rests4);
			fail("Deveria ter lançado uma exceção.");
		} catch(Exception ex4){
			assertTrue(true);
		}
		

		
		
		
		
		
		
		
		
		
	}
	
	@Test
	@SuppressWarnings("static-access")
	public void testaBubbleSortDec(){
		String[] rests1 = {"100:Giraffas", "200:Divino Fogão", "50:Bar do George", "150:Bar do Santos", "350:Fazenda"};
		String[] rests2 = {"100;Giraffas", "200:Divino Fogão"};
		String[] rests3 = {};
		String[] rests4 = {"^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$"};
		
		try {
			Assert.assertEquals("Erro", "[100:Giraffas, 200:Divino Fogão, 50:Bar do George, 150:Bar do Santos, 350:Fazenda]", Arrays.toString(rests1));
			ordena.bubbleSortDec(rests1);
			Assert.assertEquals("Erro", "[350:Fazenda, 200:Divino Fogão, 150:Bar do Santos, 100:Giraffas, 50:Bar do George]", Arrays.toString(rests1));
		} catch (Exception ex1) {
			ex1.getMessage();
		}
		
		
		try{
			ordena.bubbleSortDec(rests2);
			fail("Deveria ter lançado uma exceção.");
		} catch(Exception ex2){
			assertTrue(true);
		}
		
		try{
			ordena.bubbleSortDec(rests3);
			fail("Deveria ter lançado uma exceção.");
		} catch(Exception ex3){
			assertTrue(true);
		}
		
		try{
			ordena.bubbleSortDec(rests4);
			fail("Deveria ter lançado uma exceção.");
		} catch(Exception ex4){
			assertTrue(true);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

