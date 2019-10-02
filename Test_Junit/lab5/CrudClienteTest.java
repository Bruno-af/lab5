	package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
	* Laboratório de Programação 2 - Lab 1
	* 
	* @author Bruno Andrade Fernandes - 119110378
	*/
class CrudClienteTest {
	private CrudCliente sistemaClientes, sistemaVazio;
	
	@BeforeEach
	public void ControntroiControlador() {
		sistemaClientes = new CrudCliente();
		sistemaClientes.cadastraCliente("119110378", "brunao", "email de bruno", "Lcc3");
		sistemaVazio = new CrudCliente();
	}
	
	@Test
	void testConstrutor() {
		CrudCliente cadastrados = new CrudCliente();
	}

	@Test
	void testCadastraCliente() {
		sistemaClientes.cadastraCliente("cpf", "nome", "email", "localizacao");
	}
	
	@Test
	void testCadastraClienteCadastrado() {
		try {
			sistemaClientes.cadastraCliente("119110378", "brunao", "email de bruno", "Lcc3");
			fail(); //nao deve construir
		} catch (IllegalArgumentException iae) {
			iae.getMessage().equals("Cliente ja cadastrado");
		}
	}

	@Test
	void testRepresentacaoClienteCadastrado() {
		assertEquals(sistemaClientes.RepresentacaoCliente("119110378"),"brunao - Lcc3 - email de bruno");
	}
	
	@Test
	void testRepresentacaoClienteInexistente() {
		try {
			sistemaClientes.RepresentacaoCliente("40028922");
			fail(); //nao deve ser capaz de acessar um cliente inexistente
		} catch (NullPointerException npe) {
		}
	}

	@Test
	void testListaClientes() {
		assertEquals(sistemaClientes.listaClientes(), "brunao - Lcc3 - email de bruno");
	}
	
	@Test
	void testListaClientesInexistentes() {
		try {
			sistemaVazio.listaClientes();
			fail(); // nao se lista listas vazias
		} catch (NullPointerException npe) {
			
		}
	}

	@Test
	void testEditarClienteExistente() {
		sistemaClientes.editarCliente("119110378", "nome", "email", "localizacao");
	}
	
	@Test
	void testEditarClienteInexistente() {
		try {
			sistemaClientes.editarCliente("cpf inexistente", "nome", "email", "localizacao");
			fail(); // nao deve ser possivel editar algo inexistente
		} catch(NullPointerException npe) {
			
		}
	}

	@Test
	void testDeletarClienteExistente() {
		sistemaClientes.deletarCliente("119110378");
	}
	
	@Test
	void testDeletarClienteInexistente() {
		try {
			sistemaClientes.deletarCliente("cpf inexistente");
			fail(); // nao se deleta algo inexistente
		} catch(NullPointerException npe) {
			
		}
	}

}
