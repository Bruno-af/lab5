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
	public String listaClientes() {
		return sistemaCliente.listaClientes();
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
	/**
	 * Cadastra um fornecedor
	 * 
	 * @param nome     nome e identificador do fornecedor
	 * @param email    email do fornecedor
	 * @param telefone telefone do fornecedor
	 * @return nome do fornecedor caso o cadastro seja bem sucedido, senao, lanca-se
	 *         um erro IllegalArgumentException
	 */
	public String cadastraFornecedor(String nome, String email, String telefone) {
		try {
			sistemaFornecedor.cadastraFornecedor(nome, email, telefone);
			return nome;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * retorna a representacao textual de um dado fornecedor
	 * 
	 * @param nome nome e identificador do fornecedor
	 * @return representacao textual do fornecedor
	 */
	public String recuperaFornecedor(String nome) {
		return sistemaFornecedor.retornaFornecedor(nome);
	}

	/**
	 * lista todos os fornecedores
	 * 
	 * @return retorna em forma de texto a lista de todos os fornecedores
	 */
	public String listaFornecedores() {
		return sistemaFornecedor.listaFornecedores();
	}

	/**
	 * edita fornecedor
	 * 
	 * @param nome     identificador imutavel do fornecedor
	 * @param email    novo email do fornecedor
	 * @param telefone novo telefone do fornecedor
	 */
	public void editaFornecedor(String nome, String email, String telefone) {
		sistemaFornecedor.editaFornecedor(nome, email, telefone);
	}

	/**
	 * deleta um fornecedor do sistema
	 * 
	 * @param nome identificador do fornecedor
	 */
	public void deletaFornecedor(String nome) {
		sistemaFornecedor.deletaFornecedor(nome);
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
