	package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
	* Laboratório de Programação 2 - Lab 1
	* 
	* @author Bruno Andrade Fernandes - 119110378
	*/
class ProdutoTest {
	private Produto pastel;
	
	@BeforeEach
	public void criaProduto() {
		pastel = new Produto("pastel de flango", "verdadeiro pastel chines", 2);
	}
	
	@Test
	void testProdutoValido() {
		Produto hamburguer = new Produto("xburguer", "pao com carne e queijo", 5.6);
	}

	@Test
	void testProdutoNomeVazio() {
		try {
			Produto hamburguer = new Produto("", "pao com carne e queijo", 5.6);
			fail();
		} catch(IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testProdutoNomeNull() {
		try {
			Produto hamburguer = new Produto(null, "pao com carne e queijo", 5.6);
			fail();
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testProdutoDescricaoVazia() {
		try {
			Produto hamburguer = new Produto("x-burguer", "", 5.6);
			fail();
		} catch(IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testProdutoDescricaoNull() {
		try {
			Produto hamburguer = new Produto("x-burguer", null, 5.6);
			fail();
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testToString() {
		assertEquals(pastel.toString(),"pastel de flango - verdadeiro pastel chines - R$2,00");
	}

	@Test
	void testAlteraPreco() {
		pastel.alteraPreco(2.5);
		assertEquals(pastel.toString(),"pastel de flango - verdadeiro pastel chines - R$2,50");
	}

}
