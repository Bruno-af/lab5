package lab5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Laborat�rio de Programa��o 2 - Lab 1
 * 
 * @author Bruno Andrade Fernandes - 119110378
 */
class ClienteTest {
	private Cliente cliente1, cliente2;

	@BeforeEach
	public void criaClientes() {
		cliente1 = new Cliente("11911037811", "bruno", "bruno.fernandes@ccc.ufcg.edu.br", "Lcc3");
		cliente2 = new Cliente("12311457811", "breno", "bruno.fernandes@ccc.ufcg.edu.br", "Lcc3");
	}

	@Test
	void testClienteValido() {
		Cliente voce = new Cliente("11911337211", "voce", "voce.monitor@ccc.ufcg.edu.br", "Lcc2");
	}

	@Test
	void testClienteCpfVazio() {
		try {
			Cliente cpfVazio = new Cliente("", "Nome Criativo", "nome.criativo@ccc.ufcg.edu.br", "Minha mente");
			fail(); // nao deve ser construido na pratica
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	void testClienteCpfNulo() {
		try {
			Cliente cpfNulo = new Cliente(null, "voce", "voce.monitor@ccc.ufcg.edu.br", "Lcc2");
			fail(); // nao deve ser construido na pratica
		} catch (NullPointerException npe) {
		}
	}

	@Test
	void testClienteNomeVazio() {
		try {
			Cliente nomeVazio = new Cliente("4002892211", "", "emailDeNinguem@ccc.ufcg.edu.br", "Lugar Nenhum");
			fail(); // nao deve ser construido na pratica
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	void testClienteNomeNulo() {
		try {
			Cliente nomeNulo = new Cliente("3247288211", null, "Gaudencio.Lenda@ccc.ufcg.edu.br", "Lcc3");
			fail(); // nao deve ser construido na pratica
		} catch (NullPointerException npe) {
		}
	}

	@Test
	void testClienteEmailVazio() {
		try {
			Cliente nomeVazio = new Cliente("4002892211", "jaba", "", "Em um lugar bem distante");
			fail(); // nao deve ser construido na pratica
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	void testClienteEmailNulo() {
		try {
			Cliente emailNulo = new Cliente("3247288211", "nome incrivel", null, "Lcc3");
			fail(); // nao deve ser construido na pratica
		} catch (NullPointerException npe) {
			
		}
	}

	@Test
	void testClienteLocVazia() {
		try {
			Cliente localizacaoVazia = new Cliente("4002892211", "luke", "agmcc@hotmail.com", "");
			fail(); // nao deve ser construido na pratica
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	void testClienteLocNulo() {
		try {
			Cliente locNulo = new Cliente("3247288211", "nome do cara", "email do cara", null);
			fail(); // nao deve ser construido na pratica
		} catch (NullPointerException npe) {
		}
	}

	@Test
	void testToString() {
		assertEquals(cliente1.toString(), "bruno - Lcc3 - bruno.fernandes@ccc.ufcg.edu.br");
	}

	@Test
	void testEditaCliente() {
		cliente1.editaCliente("nome","beto");
		assertEquals(cliente1.toString(), "beto - Lcc3 - bruno.fernandes@ccc.ufcg.edu.br");
	}

	@Test
	void testGetNome() {
		assertEquals(cliente1.getNome(), "bruno");
	}

	@Test
	void testGetEmail() {
		assertEquals(cliente1.getEmail(), "bruno.fernandes@ccc.ufcg.edu.br");
	}

	@Test
	void testGetLocalizacao() {
		assertEquals(cliente1.getLocalizacao(), "Lcc3");
	}

	@Test
	void testGetCpf() {
		assertEquals(cliente1.getCpf(), "11911037811");
	}

	@Test
	void testEqualsMesmoCliente() {
		assertTrue(cliente1.equals(cliente1));
	}
	
	@Test
	void testEqualsMesmoCpf() {
		Cliente cliente2 = cliente1;
		cliente2.editaCliente("nome", "nome");
		assertTrue(cliente2.equals(cliente1));
	}
	
	@Test
	void testEqualsComUmNull() {
		assertFalse(cliente1.equals(null));
	}
	
	@Test
	void testEqualsDiferentesClasse() {
		assertFalse(cliente1.equals("bruno - Lcc3 - bruno.fernandes@ccc.ufcg.edu.br"));
	}
	
	@Test
	void testEqualsDiferentesClientes() {
		assertFalse(cliente1.equals(cliente2));
	}
	
	@Test
	void testEqualsCpfsIguais() {
		assertTrue(cliente1.equals(new Cliente("11911037811", "nome", "email", "localizacao")));
	}
	
	@Test
	void testHashCodeIguais() {
		Cliente mesmoCpf = new Cliente("11911037811", "nome", "email", "localizacao");
		assertTrue(cliente1.hashCode() == mesmoCpf.hashCode());
	}
	
	@Test
	void testHashCodeDiferentes() {
		Cliente cpfDiferente = new Cliente("11210007810", "nome", "email", "localizacao");
		assertFalse(cliente1.hashCode() == cpfDiferente.hashCode());
	}
	
	@Test
	void testHashCodeDiferentesTipos() {
		assertFalse(cliente1.hashCode() == "oi".hashCode());
	}

}
