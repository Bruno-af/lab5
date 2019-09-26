package lab5;

public class Facade {
	private CrudCliente sistemaCliente = new CrudCliente();
	private CrudFornecedor sistemaFornecedor = new CrudFornecedor();

	// comandos administrador/cliente
	/**
	 * cadastra cliente
	 * 
	 * @param cpf         identificador do cliente
	 * @param nome        nome do cliente
	 * @param email       email do cliente
	 * @param localizacao localizacao do cliente
	 * @return cpf do cliente, caso o cadastro funcione, caso contrario, lanca-se um
	 *         IllegalArgumentException
	 */
	public String cadastraCliente(String cpf, String nome, String email, String localizacao) {
		try {
			sistemaCliente.cadastraCliente(cpf, nome, email, localizacao);
			return cpf;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * retorna a representacao textual de um dado cliente
	 * 
	 * @param cpf identificador do cliente
	 * @return representacao textual de um cliente de dado cpf
	 */
	public String recuperaCliente(String cpf) {
		return sistemaCliente.RepresentacaoCliente(cpf);
	}

	/**
	 * retorna a listagem da representacao textual de todos os clientes cadastrados
	 * 
	 * @return listagem de todos os clientes cadastrados
	 */
	public String listarClientes() {
		return sistemaCliente.listarClientes();
	}

	/**
	 * edita dados de certo cliente
	 * 
	 * @param cpf         identificador do cliente
	 * @param nome        novo nome do cliente
	 * @param email       novo email do cliente
	 * @param localizacao novo local de trabalho do cliente
	 */
	public void editaCliente(String cpf, String nome, String email, String localizacao) {
		sistemaCliente.editarCliente(cpf, nome, email, localizacao);
	}

	/**
	 * deleta cliente que possui cpf cedido
	 * 
	 * @param cpf identificador do cliente
	 */
	public void deletaCliente(String cpf) {
		sistemaCliente.deletarCliente(cpf);
	}

	// comando administrador/fornecedor
	public String cadastraFornecedor() {
		/**
		 * Em uma adição bem sucedida, o nome do fornecedor deve ser retornado. Quando
		 * não é bem sucedida, uma exceção deve ser lançada e a mensagem de erro
		 * mostrada para o usuário. Após isso, o programa não deverá continuar.
		 * 
		 */
		return "";
	}

	public String recuperaFornecedor() {
		return "toString do fornecedor";
	}

	public void editaFornecedor(String nome) {
		// so n pode o nome
	}

	public void deletaFornecedor() {

	}

	public String listaFornecedores() {
		return "toString1 | toString2 | (...) | toStringn";
	}

	// comandos administrador/produtos(dos fornecedores)
	public String cadastrarProduto(String nomeFornecedor, String nomeProduto, String descricao, String preco) {
		return "";
	}

	public String consultarProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		return "toString do produto";
	}

	public String listarProdutosFornecedor(String nomeFornecedor) {
		return "toString de todos os produtos ' | ' " + "fornecedor - toString do produto ' | '";
	}

	public String listarProdutos() {
		return "todos os produtos ' | ' \\ de todos os fornecedores" + " fornecedor - toString do produto ' | ' ";
	}

	public String editarProduto(String nome, String descricao) {
		return "";
	}

	public String deletarProduto(String nome, String descricao) {
		return "";
	}
}
