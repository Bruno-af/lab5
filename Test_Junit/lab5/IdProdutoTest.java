	package lab5;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab5.IdProduto;

/**
	* Laborat�rio de Programa��o 2 - Lab 5
	* 
	* @author Bruno Andrade Fernandes - 119110378
	*/
class IdProdutoTest {

	@Test
	void testIdProdutoValido() {
		IdProduto identificador = new IdProduto("vida", "e o que tem pra hoje");
	}
	
	@Test
	void testIdProdutoNomeNull() {
		try {
			IdProduto identificador = new IdProduto(null, "e o que tem pra hoje");
			fail();
		} catch(NullPointerException npe) {
		}
	}
	
	@Test
	void testIdProdutoNomeVazio() {
		try {
			IdProduto identificador = new IdProduto("","parece engulivel");
			fail();
		} catch(IllegalArgumentException iae) {
		}
	}
	
	@Test
	void testIdProdutodescricaoNull() {
		try {
			IdProduto identificador = new IdProduto("suco",null);
			fail();
		} catch(NullPointerException npe) {
		}
	}
	
	@Test
	void testIdProdutoDescricaoVazia() {
		try {
			IdProduto identificador = new IdProduto("suco","");
			fail();
		} catch(IllegalArgumentException iae) {
		}
	}

	@Test
	void testRetornaId() {
		IdProduto suco = new IdProduto("suCo de maracuja", "QUEM nao tomou, vai tomar");
		assertEquals(suco.retornaId(),"suco de maracujaquem nao tomou, vai tomar");
	}

}
