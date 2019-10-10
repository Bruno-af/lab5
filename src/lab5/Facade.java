package lab5;

import easyaccept.EasyAccept;

public class Facade {
	private CrudCliente sistemaCliente;
	private CrudFornecedor sistemaFornecedor;
	private ControllerCompras sistemaCompras;

	public Facade() {
		sistemaCliente = new CrudCliente();
		sistemaFornecedor = new CrudFornecedor();
		sistemaCompras = new ControllerCompras();
	}

	// comandos administrador/cliente
	/**
	 * cadastra cliente
	 * 
	 * @param cpf         identificador do cliente
	 * @param nome        nome do cliente
	 * @param email       email do cliente
	 * @param localizacao local de trabalho do cliente
	 * @return cpf do cliente, caso o cadastro funcione, caso contrario, lanca-se o
	 *         devido erro
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		sistemaCliente.cadastraCliente(cpf, nome, email, localizacao);
		return cpf;
	}

	/**
	 * retorna a representacao textual de um dado cliente
	 * 
	 * @param cpf identificador do cliente
	 * @return representacao textual de um cliente de dado cpf
	 */
	public String exibeCliente(String cpf) {
		return sistemaCliente.RepresentacaoCliente(cpf);
	}

	/**
	 * retorna a listagem da representacao textual de todos os clientes cadastrados
	 * 
	 * @return listagem de todos os clientes cadastrados
	 */
	public String exibeClientes() {
		return sistemaCliente.listaClientes();
	}

	/**
	 * edita certo atributo de certo cliente
	 * 
	 * @param cpf       identificador do cliente
	 * @param atributo  atributo que se deseja alterar
	 * @param novoValor equivalente ao novo atributo
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		sistemaCliente.editaCliente(cpf, atributo, novoValor);
	}

	/**
	 * deleta cliente que possui cpf cedido
	 * 
	 * @param cpf identificador do cliente
	 */
	public void removeCliente(String cpf) {
		sistemaCliente.deletarCliente(cpf);
	}

	// comando administrador/fornecedor
	/**
	 * Cadastra um fornecedor
	 * 
	 * @param nome     nome do fornecedor
	 * @param email    email do fornecedor
	 * @param telefone telefone do fornecedor
	 * @return nome do fornecedor caso o cadastro seja bem sucedido, senao, lanca-se
	 *         um erro IllegalArgumentException
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
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
	 * @param nome nome do fornecedor
	 * @return representacao textual do fornecedor
	 */
	public String exibeFornecedor(String nome) {
		return sistemaFornecedor.retornaFornecedor(nome);
	}

	/**
	 * lista todos os fornecedores
	 * 
	 * @return retorna em forma de texto a lista de todos os fornecedores
	 */
	public String exibeFornecedores() {
		return sistemaFornecedor.listaFornecedores();
	}

	/**
	 * edita fornecedor
	 * 
	 * @param nome      identificador imutavel do fornecedor
	 * @param atributo  atributo que se deseja editar
	 * @param novoValor novo valor associado
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		sistemaFornecedor.editaFornecedor(nome, atributo, novoValor);
	}

	/**
	 * deleta um fornecedor do sistema
	 * 
	 * @param nome nome do fornecedor
	 */
	public void removeFornecedor(String nome) {
		sistemaFornecedor.deletaFornecedor(nome);
	}

	// comandos administrador/produtos(pelos fornecedores)
	/**
	 * cadastra produto ainda nao cadastrado de um dado fornecedor
	 * 
	 * @param nomeFornecedor nome e identificador do fornecedor
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 * @param preco          preco do produto
	 */
	public void adicionaProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		sistemaFornecedor.cadastraProduto(nomeFornecedor, nomeProduto, descricao, preco);
	}

	/**
	 * consulta um produto cadastrado
	 * 
	 * @param nomeFornecedor nome do fornecedor do produto
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 * @return representacao textual do produto
	 */
	public String exibeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		return sistemaFornecedor.consultaProduto(nomeFornecedor, nomeProduto, descricao);
	}

	/**
	 * lista todos os produtos cadastrados de certo fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor do produto
	 * @return listagem da representacao textual de todos os produtos do fornecedor
	 */
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		return sistemaFornecedor.listaProdutos(nomeFornecedor);
	}

	/**
	 * lista todos os produtos de todos os fornecedores
	 * 
	 * @return representacao textual de todos os produtos de todos os fornecedores
	 */
	public String exibeProdutos() {
		return sistemaFornecedor.listaTodosProdutos();
	}

	/**
	 * Altera o preco de um produto de um fornecedor
	 * 
	 * @param nomeFornecedor nome e identificador do fornecedor
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 * @param preco          novo preco do produto
	 */
	public void editaProduto(String nomeProduto, String descricao, String nomeFornecedor, double preco) {
		sistemaFornecedor.editaProduto(nomeFornecedor, nomeProduto, descricao, preco);
	}

	/**
	 * deleta um dado produto do sistema de um fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 */
	public void removeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		sistemaFornecedor.deletaProduto(nomeFornecedor, nomeProduto, descricao);
	}

	// comandos administrador/Compras
	
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome_produto, String descricao_produto) {
		sistemaFornecedor.CadastraCompra(cpf, fornecedor, data, nome_produto, descricao_produto);
	}
	
	public double getDebito(String cpf, String fornecedor) {
		return sistemaFornecedor.getDebito(cpf, fornecedor);
	}
	
	public String toStringConta(String cpf, String fornecedor) {
		return "";
	}
	
	public String listaContas(String cpf) {
		return "";
	}
	
 	public static void main(String[] args) {
		args = new String[] { "lab5.Facade", "Testes_aceitacao/use_case_1.txt", "Testes_aceitacao/use_case_2.txt",
				"Testes_aceitacao/use_case_3.txt", "Testes_aceitacao/use_case_4.txt", "Testes_aceitacao/use_case_5.txt",
				"Testes_aceitacao/use_case_6.txt" };
		EasyAccept.main(args);
	}
}
