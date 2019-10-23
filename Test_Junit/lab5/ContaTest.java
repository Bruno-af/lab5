package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Bruno Andrade Fernandes - 119110378
 */
class ContaTest {
	private Conta deadPoll;

	@BeforeEach
	public void CriaPreRequisitos() {
		deadPoll = new Conta("11111111111", "Barzin do filme", "Dad Pow");
		deadPoll.cadastraCompra("23/06/1996", "chokitos", "tchokolati", 20);
	}

	@Test
	void testConta() {
		Conta conta = new Conta("11911038911", "restaurante do pai do Souma", "Alquimista de aco");
	}

	@Test
	void testCadastraCompra() {
		deadPoll.cadastraCompra("24/05/2016", "Breja", "ja tava na mesa", 10.0);
	}

	@Test
	void testGetDebito() {
		assertEquals(deadPoll.getDebito(), 20.0);
	}

	@Test
	void testGetCpfCliente() {
		assertEquals(deadPoll.getCpfCliente(), "11111111111");
	}

	@Test
	void testToString() {
		assertEquals(deadPoll.toString(), "Barzin do filme | chokitos - 23-06-1996 | ");
	}

	@Test
	void testListaCompras() {
		assertEquals(deadPoll.listaCompras(), "chokitos - 23-06-1996 | ");
	}
}
