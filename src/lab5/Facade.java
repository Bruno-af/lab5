package lab5;

public class Facade {

	// comandos administrador/cliente
	public String cadastraCliente() {
		/**
		 * Em uma adição bem sucedida, o CPF deve ser retornado. Quando não é bem
		 * sucedida, uma exceção deve ser lançada e a mensagem de erro mostrada para o
		 * usuário. Após isso, o programa não deverá continuar.
		 * 
		 */
		return "cpf";
	}

	public String recuperarCliente() {
		return "toString de cliente";
	}

	public void editarCliente(String cpf) {
		//so n pode cpf
	}

	public void removerCliente() {

	}

	public String listarClientes() {
		return "toString1 | toString2 | (...) | toStringn";
	}
	
	// comando administrador/fornecedor
	public String cadastrarFornecedor() {
		/**
		 * Em uma adição bem sucedida, o nome do fornecedor deve ser retornado. Quando
		 * não é bem sucedida, uma exceção deve ser lançada e a mensagem de erro
		 * mostrada para o usuário. Após isso, o programa não deverá continuar.
		 * 
		 */
		return "";
	}	
	
	public String recuperarFornecedor() {
		return "toString do fornecedor";
	}

	public void editarFornecedor(String nome) {
		//so n pode o nome
	}
	
	public void deletarFornecedor() {
		
	}
	
	public String listarFornecedores() {
		return "toString1 | toString2 | (...) | toStringn";
	}
	
	//comandos administrador/produtos(dos fornecedores)
	public String cadastrarProduto() {
		return"";
	}
	
	public String recuperarProduto() {
		return"";
	}
	public String editarProduto() {
		return"";
	}
	
	public String deletarProduto() {
		return"";
	}
}
