package lab5;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Fornecedor;

/**
 * Laborat�rio de Programa��o 2 - Lab 1
 * 
 * @author Bruno Andrade Fernandes - 119110378
 */
class FornecedorTest {
	private Fornecedor bencola, fornecedorSemProdutos;

	@BeforeEach
	public void criaFornecedores() {
		bencola = new Fornecedor("pastelaria do bencola", "bencola@outloock.com", "40028922");
		bencola.cadastraProduto("xburguer", "carne relativamente boa", 4);
		fornecedorSemProdutos = new Fornecedor("nome", "email", "telefone");
	}

	@Test
	void testFornecedorvalido() {
		Fornecedor DonaInes = new Fornecedor("dona ines", "inesLinda02@gmail.com", "49055923");
	}

	@Test
	void testFornecedorNomeVazio() {
		try {
			Fornecedor DonaInes = new Fornecedor("", "inesLinda02@gmail.com", "49055923");
			fail(); // nao se deve construir um fornecedor de nome vazio
		} catch (IllegalArgumentException iae) {

		}
	}

	@Test
	void testFornecedorNomeNull() {
		try {
			Fornecedor donaInes = new Fornecedor(null, "inesLinda02@gmail.com", "49055923");
			fail(); // nao se deve construir um fornecedor com null no nome
		} catch (NullPointerException npe) {
		}
	}

	@Test
	void testFornecedorEmailVazio() {
		try {
			Fornecedor DonaInes = new Fornecedor("dona ines", "", "49055923");
			fail(); // nao se deve construir um fornecedor de email vazio
		} catch (IllegalArgumentException iae) {

		}
	}

	@Test
	void testFornecedorEmailNull() {
		try {
			Fornecedor donaInes = new Fornecedor("dona ines", null, "49055923");
			fail(); // nao se deve construir um fornecedor com null no email
		} catch (NullPointerException npe) {
		}
	}

	@Test
	void testFornecedorTelefoneVazio() {
		try {
			Fornecedor DonaInes = new Fornecedor("dona ines", "inesLinda02@gmail.com", "");
			fail(); // nao se deve construir um fornecedor de telefone vazio
		} catch (IllegalArgumentException iae) {

		}
	}

	@Test
	void testFornecedorTelefoneNull() {
		try {
			Fornecedor donaInes = new Fornecedor("dona ines", "inesLinda02@gmail.com", null);
			fail(); // nao se deve construir um fornecedor com null no telefone
		} catch (NullPointerException npe) {
		}
	}

	@Test
	void testToString() {
		assertEquals(bencola.toString(), "pastelaria do bencola - bencola@outloock.com - 40028922");
	}

	@Test
	void testEditaFornecedorValido() {
		bencola.editaFornecedor("email", "Bencola2.0@hotmail.com");
		assertEquals(bencola.toString(), "pastelaria do bencola - Bencola2.0@hotmail.com - 40028922");
	}
	
	@Test
	void testEditaFornecedorEmailVazio() {
		try {
			bencola.editaFornecedor("", "4002-8922");
		} catch(IllegalArgumentException iae) {
		}
	}
	
	@Test
	void testEditaFornecedorEmailNull() {
		try {
			bencola.editaFornecedor(null, "4002-8922");
		} catch(NullPointerException npe) {
		}
	}
	
	@Test
	void testEditaFornecedorTelefoneVazio() {
		try {
			bencola.editaFornecedor("email@.com","");
		} catch(IllegalArgumentException iae) {
		}
	}
	
	@Test
	void testEditaFornecedorTelefoneNull() {
		try {
			bencola.editaFornecedor("email@.com", null);
		} catch(NullPointerException npe) {
		}
	}

	@Test
	void testCadastraNovoProduto() {
		bencola.cadastraProduto("pastel de flango", "pastel de feira bom demais", 2);
	}

	@Test
	void testCadastraProdutoExistente() {
		try {
			bencola.cadastraProduto("xburguer", "carne relativamente boa", 4);
			fail();// nao se cadastra o mesmo prooduto novamente
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	void testConsultaProdutoInexistente() {
		try {
			assertEquals(bencola.consultaProduto("hot dog", "carne quase boa").toString(),
					"hot dog - carne quase boa - R$4,00");
			fail();
		} catch (NullPointerException npe) {
		}
	}

	@Test
	void testConsultaProdutoExistente() {
		assertEquals(bencola.consultaProduto("xburguer", "carne relativamente boa"),
				"xburguer - carne relativamente boa - R$4,00");
	}

	@Test
	void testListaProdutosValido() {
		assertEquals(bencola.listaProdutos(), "xburguer - carne relativamente boa - R$4,00");
	}

	@Test
	void testListaProdutosExistentes() {
		assertEquals(bencola.listaProdutos(), "xburguer - carne relativamente boa - R$4,00");
	}

	@Test
	void testListaProdutosInexistentes() {
		try {
			fornecedorSemProdutos.listaProdutos();
			fail(); // nao e possivel listar produtos inexistentes
		} catch (NullPointerException npe) {
			assertEquals("Nao ha produtos cadastrados", npe.getMessage());
		}
	}

	@Test
	void testListagemProdutos() {
		assertEquals(bencola.listagemProdutos(),"pastelaria do bencola - xburguer - carne relativamente boa - R$4,00");
	}
	
	@Test
	void testListagemProdutosInexistentes() {
		assertTrue(fornecedorSemProdutos.listagemProdutos().equals("nome -"));
	}

	 @Test
	 void testEditaProdutoExistente() {
		 bencola.editaProduto("xburguer", "carne relativamente boa", 7);
		 assertEquals(bencola.consultaProduto("xburguer", "carne relativamente boa"), "xburguer - carne relativamente boa - R$7,00");
	 }
	 
	 @Test
	 void testEditaProdutoInexistente() {
		 try {
			 fornecedorSemProdutos.editaProduto("pastel especial", "provavelmente tem acucar nele", 1.5);
			 fail(); // nao se edita produto inexistente
		 } catch (NullPointerException npe) {
			 
		 }
	 }
	
	 @Test
	 void testDeletaProduto() {
		 bencola.deletaProduto("xburguer", "carne relativamente boa");
		 try {
			 assertEquals(bencola.consultaProduto("xburguer", "carne relativamente boa"), "xburguer - carne relativamente boa - R$4,00");
		 } catch (NullPointerException npe) {
		 }
	 }
	 
	 @Test
	 void testDeletaProdutoExistente() {
		 bencola.deletaProduto("xburguer", "carne relativamente boa");
		 try {
			 assertEquals(bencola.consultaProduto("xburguer", "carne relativamente boa"), "xburguer - carne relativamente boa - R$4,00");
		 } catch (NullPointerException npe) {
		 }
	 }

	 @Test
	 void testDeletaProdutoInexistente() {
		 try {
			 fornecedorSemProdutos.deletaProduto("xburguer", "carne relativamente boa");
			 fail(); //nao se deleta produto inexistente
			 } catch (NullPointerException npe) {
		 }
	 }
}
