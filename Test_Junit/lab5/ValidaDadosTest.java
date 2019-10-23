	package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
	* Laboratório de Programação 2 - Lab 1
	* 
	* @author Bruno Andrade Fernandes - 119110378
	*/
class ValidaDadosTest {
private ValidaDados validador;

	@BeforeEach
	public void criaValidador() {
		validador = new ValidaDados();
	}

	@Test
	void testValidaStringNull() {
		try{
			validador.validaString("deu erro null", null);
			fail();
		} catch (NullPointerException npe) {
			assertTrue(npe.getMessage().equals("deu erro null"));
		}
	}

	@Test
	void testValidaStringVazio() {
		try{
				validador.validaString("deu erro vazio", "");
				fail();
			} catch (IllegalArgumentException iae) {
				assertTrue(iae.getMessage().equals("deu erro vazio"));
			}
		}

	@Test
	void testValidaCpfTamanhoCorreto() {
		validador.validaCpfTamanho("tamanho errado", "12345678901");
	}

	@Test
	void testValidaCpfTamanhoIncorretoMenor() {
		try{
			validador.validaCpfTamanho("tamanho errado", "12345");
			fail();
		} catch(IllegalArgumentException iae) {
			assertTrue(iae.getMessage().equals("tamanho errado"));
		}
	}

	@Test
	void testValidaCpfTamanhoIncorretoMaior() {
		try{
			validador.validaCpfTamanho("tamanho errado", "1234567890123");
			fail();
		} catch(IllegalArgumentException iae) {
			assertTrue(iae.getMessage().equals("tamanho errado"));
		}
	}

	@Test
	void testValidaDataCorreta() {
		validador.validaData("data errada", "23/04/2001");
	}

	@Test
	void testValidaDataDiaInvalido() {
		try {
			validador.validaData("data errada", "45/04/2001");
		} catch(IllegalArgumentException iae) {
			assertTrue(iae.getMessage().equals("data errada"));
		}
	}

	@Test
	void testValidaDataMesInvalido() {
		try {
			validador.validaData("data errada", "01/24/2001");
		} catch(IllegalArgumentException iae) {
			assertTrue(iae.getMessage().equals("data errada"));
		}
	}
}
