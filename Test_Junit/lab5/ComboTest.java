package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Bruno Andrade Fernandes - 119110378
 */
class ComboTest {
	private Fornecedor mac;

	@BeforeEach
	public void criaDadosBase() {
		mac = new Fornecedor("Sebosao", "ronald@macDolnaulds.com.br", "1666-6661");
		mac.cadastraProduto("hot-dog", "com salsichao de 15 cm", 12.90);
		mac.cadastraProduto("suco", "tem agua pra render", 4.90);
		mac.cadastraProduto("chiclete", "tava preso no banco", 0.30);
		mac.cadastraProduto("pimenta", "tempero do vizinho", 5.00);
		mac.cadastraProduto("caneta", "roubada", .3);
		mac.cadastraCombo("combo 1", "hot-dog com suco", 0.15, "hot-dog - com salsichao de 15 cm, suco - tem agua pra render", "Sebosao");
	}
	//X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)
	
	
	@Test
	void testComboValido() {
		mac.cadastraCombo("chucrute", "gororoba", .5, "chiclete - tava preso no banco, pimenta - tempero do vizinho", "Sebosao");
	}
	
	@Test
	void testComboExistente() {
		try{
			mac.cadastraCombo("combo 1", "hot-dog com suco", 0.15, "hot-dog - com salsicha de 15 cm, suco - tem agua pra render", "Sebosao");
			fail();
		} catch (IllegalArgumentException iae) {
			assertTrue(iae.getMessage().equals("Erro no cadastro de combo: combo ja existe."));
		}
	}
	
	@Test
	void testComboProdutosNull() {
		try{
			mac.cadastraCombo("sanduiche de ar", "ar em sacola plastica", .3, null, "Sebosao");
			fail();
		} catch (NullPointerException npe) {
			assertTrue(npe.getMessage().equals("Erro no cadastro de combo: combo deve ter produtos."));
		}
	}
	
	@Test
	void testComboProdutosVazio() {
		try{
			mac.cadastraCombo("sanduiche de ar", "ar em sacola plastica", .3, "", "Sebosao");
			fail();
		} catch (IllegalArgumentException iae) {
			assertTrue(iae.getMessage().equals("Erro no cadastro de combo: combo deve ter produtos."));
		}
	}
	
	@Test
	void testComboFatorNegativo() {
		try {
			mac.cadastraCombo("caneta roubada", "a caneta era sua", -1, "caneta - roubada", "sebosao");
			fail();
		} catch (IllegalArgumentException iae) {
			assertTrue(iae.getMessage().equals("Erro no cadastro de combo: fator invalido."));
		}
	}
	
	@Test
	void testComboFatorNulo() {
		try {
			mac.cadastraCombo("caneta roubada", "a caneta era sua", 0, "caneta - roubada", "sebosao");
			fail();
		} catch (IllegalArgumentException iae) {
			assertTrue(iae.getMessage().equals("Erro no cadastro de combo: fator invalido."));
		}
	}
	
	@Test
	void testComboFatorGrande() {
		try {
			mac.cadastraCombo("caneta roubada", "a caneta era sua", 1, "caneta - roubada", "sebosao");
			fail();
		} catch (IllegalArgumentException iae) {
			assertTrue(iae.getMessage().equals("Erro no cadastro de combo: fator invalido."));
		}
	}
	
	@Test
	void testToString() {
		assertTrue(mac.consultaProduto("combo 1", "hot-dog com suco").equals("combo 1 - hot-dog com suco - R$15,13"));
	}

	@Test
	void testGetPreco() {
		assertEquals(mac.getPreco("combo 1", "hot-dog com suco"), 15.13);
	}

	@Test
	void testEditaComboValido() {
		mac.editaCombo("combo 1", "hot-dog com suco", .2);
	}

	@Test
	void testEditaComboFatorNeg() {
		try{
			mac.editaCombo("combo 1", "hot-dog com suco", -.1);
			fail();
		} catch (IllegalArgumentException iae) {
			assertTrue(iae.getMessage().equals("Erro na edicao de combo: fator invalido."));
		}
	}

	@Test
	void testEditaComboFatorSuperior() {
		try{
			mac.editaCombo("combo 1", "hot-dog com suco", 1.2);
			fail();
		} catch (IllegalArgumentException iae) {
			assertTrue(iae.getMessage().equals("Erro na edicao de combo: fator invalido."));
		}
	}

}
