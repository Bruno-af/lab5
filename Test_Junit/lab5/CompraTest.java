	package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
	* Laboratório de Programação 2 - Lab 1
	* 
	* @author Bruno Andrade Fernandes - 119110378
	*/
class CompraTest {
private Compra amoeba;

	@BeforeEach
	public void CriaPreDados() {
		amoeba = new Compra("23/04/2001", "Amoeba", "eh de brincar, nao de comer", 10.0);
	}
	
	@Test
	void testCompra() {
		Compra compra = new Compra("01/04/1996", "livro de H.P.", "que deus nos salve", 45.50);
	}

	@Test
	void testGetPreco() {
		assertEquals(amoeba.getPreco(), 10);
	}

	@Test
	void testGetData() {
		assertEquals(amoeba.getData(), "23/04/2001");
	}

	@Test
	void testGetNome() {
		assertEquals(amoeba.getNome(), "Amoeba");
	}

	@Test
	void testGetDescricao() {
		assertEquals(amoeba.getDescricao(), "eh de brincar, nao de comer");
	}

	@Test
	void testToString() {
		assertEquals(amoeba.toString(), "Amoeba - 23-04-2001");
	}

}
