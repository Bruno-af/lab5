package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Bruno Andrade Fernandes - 119110378
 */
class CrudFornecedorTest {
	private CrudFornecedor sistemaFornecedores, sistemaVazio;

	@BeforeEach
	public void criaSistema() {
		sistemaFornecedores = new CrudFornecedor();
		sistemaVazio = new CrudFornecedor();
		sistemaFornecedores.cadastraFornecedor("cafe com monitor", "gatoDmais@gamil.com", "4002-8922");
		sistemaFornecedores.cadastraProduto("cafe com monitor", "misto", "quente", 4);
	}

	@Test
	void testCrudFornecedor() {
		CrudFornecedor sistemaFornecedoresTeste = new CrudFornecedor();
	}

	@Test
	void testCadastraFornecedorNovo() {
		sistemaFornecedores.cadastraFornecedor("bruno", "bruno.fernandes@ccc.ufcg.edu.br", "119110378");
	}

	@Test
	void testCadastraFornecedorExistente() {
		try {
			sistemaFornecedores.cadastraFornecedor("cafe com monitor", "gatoDmais@gamil.com", "4002-8922");
			fail();
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	void testRetornaFornecedorExistente() {
		assertEquals(sistemaFornecedores.retornaFornecedor("CAFE com MonITor"),
				"cafe com monitor - gatoDmais@gamil.com - 4002-8922");
	}

	@Test
	void testRetornaFornecedorInexistente() {
		try {
			assertEquals(sistemaFornecedores.retornaFornecedor("CAFE com O MonITor"),
					"cafe com monitor - gatoDmais@gamil.com - 4002-8922");
			fail();
		} catch (NullPointerException npe) {
		}
	}

	@Test
	void testListaFornecedores() {
		assertEquals(sistemaFornecedores.listaFornecedores(), "cafe com monitor - gatoDmais@gamil.com - 4002-8922");
	}

	@Test
	void testListaFornecedoresInexistentes() {
		try {
			assertEquals(sistemaVazio.listaFornecedores(), "cafe com monitor - gatoDmais@gamil.com - 4002-8922");
			fail();
		} catch (NullPointerException npe) {
		}
	}

	@Test
	void testEditaFornecedorExistente() {
		sistemaFornecedores.editaFornecedor("cafe com monitor", "GatissimosDMAIS@gamil.com", "0000-1234");
		assertEquals(sistemaFornecedores.listaFornecedores(),
				"cafe com monitor - GatissimosDMAIS@gamil.com - 0000-1234");
	}

	@Test
	void testEditaFornecedorInexistente() {
		try {
			sistemaVazio.editaFornecedor("cafe com monitor", "GatissimosDMAIS@gamil.com", "0000-1234");
			fail();
		}catch(NullPointerException npe) {
		}
	}

		@Test
		void testDeletaFornecedorExistente() {
			sistemaFornecedores.deletaFornecedor("cafe com monitor");
		}
		
		@Test
		void testDeletaFornecedorInexistente() {
			try {
				sistemaVazio.deletaFornecedor("cafe com monitor");
				fail();
			} catch(NullPointerException npe) {	
			}
		}
	
		@Test
		void testCadastraProduto() {
			sistemaFornecedores.cadastraProduto("cafe com monitor", "cafe", "quente e levemente velho", 3.7);
		}
		
		@Test
		void testCadastraProdutoFornecedorInexistente() {
			try {
				sistemaVazio.cadastraProduto("cafe com monitor", "cafe", "quente e levemente velho", 3.7);
				fail();
			} catch(NullPointerException npe) {
			}
		}
	
		@Test
		void testConsultaProduto() {
			assertEquals(sistemaFornecedores.consultaProduto("cafe com monitor", "misto", "quente"),"misto - quente - R$4,00");
		}
		
		@Test
		void testConsultaProdutoFornecedorInexistente() {
			try{
				assertEquals(sistemaVazio.consultaProduto("cafe com monitor", "misto", "quente"),"misto - quente - R$4,00");
				fail();
			} catch(NullPointerException npe) {
			}
		}
	
		@Test
		void testListaProdutos() {
			assertEquals(sistemaFornecedores.listaProdutos("cafe com monitor"),"misto - quente - R$4,00");
		}
		
		@Test
		void testListaProdutosInexistentes() {
			try {
				assertEquals(sistemaVazio.listaProdutos("cafe com monitor"),"misto - quente - R$4,00");		
				fail();
			} catch(NullPointerException npe) {
			}
		}
	
		@Test
		void testListaTodosProdutos() {
			assertEquals(sistemaFornecedores.listaTodosProdutos(),"cafe com monitor - misto - quente - R$4,00");
		}
		
		@Test
		void testListaTodosProdutosInexistentes() {
			try{
				assertEquals(sistemaVazio.listaTodosProdutos(),"cafe com monitor - misto - quente - R$4,00");
				fail();
			} catch(NullPointerException npe) {
				
			}
		}
	
		@Test
		void testEditaProduto() {
			sistemaFornecedores.editaProduto("cafe com monitor", "misto", "quente", 13);
			assertEquals(sistemaFornecedores.consultaProduto("cafe com monitor", "misto", "quente"), "misto - quente - R$13,00");
		}
		
		@Test
		void testEditaProdutoFornecedorInexistente() {
			try {
				sistemaVazio.editaProduto("cafe com monitor", "misto", "quente", 13);
				fail();
			} catch (NullPointerException npe) {
			}
		}
	
		@Test
		void testDeletaProduto() {
			sistemaFornecedores.deletaProduto("cafe com monitor", "misto", "quente");
		}
		
		@Test
		void testDeletaProdutoFornecedorInexistente() {
			try {
				sistemaVazio.deletaProduto("cafe com monitor", "misto", "quente");
				fail();
			} catch(NullPointerException npe) {
			}
		}

}
