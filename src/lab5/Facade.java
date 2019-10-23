package lab5;

import easyaccept.EasyAccept;

/**
 * @author Bruno Andrade Fernandes - 119110378
 */
public class Facade {
	private ControllerGeral sistema;

	public Facade() {
		sistema = new ControllerGeral();
	}

	
	// comandos administrador/cliente

	
	/**
	 * cadastra cliente no sistema
	 * 
	 * @param cpf         nome e identificador do cliente
	 * @param nome        nome do cliente
	 * @param email       email do cliente
	 * @param localizacao local de trabalho do cliente
	 * @return cpf do cliente, caso o cadastro funcione, caso contrario, lanca-se o
	 *         devido erro
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		sistema.adicionaCliente(cpf, nome, email, localizacao);
		return cpf;
	}

	/**
	 * retorna a representacao textual de um dado cliente
	 * 
	 * @param cpf identificador do cliente
	 * @return representacao textual de um cliente de dado cpf
	 */
	public String exibeCliente(String cpf) {
		return sistema.exibeCliente(cpf);
	}

	/**
	 * retorna a representacao textual de um dado cliente
	 * 
	 * @return representacao textual de um cliente de dado cpf
	 */
	public String exibeClientes() {
		return sistema.exibeClientes();
	}

	/**
	 * edita certo atributo de dado cliente
	 * 
	 * @param cpf       identificador do cliente
	 * @param atributo  atributo que se deseja alterar
	 * @param novoValor equivalente ao novo atributo
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		sistema.editaCliente(cpf, atributo, novoValor);
	}

	/**
	 * deleta cliente que possui dado cpf
	 * 
	 * @param cpf identificador do cliente
	 */
	public void removeCliente(String cpf) {
		sistema.removeCliente(cpf);
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
		sistema.adicionaFornecedor(nome, email, telefone);
		return nome;
	}

	/**
	 * retorna a representacao textual de um dado fornecedor
	 * 
	 * @param nome nome do fornecedor
	 * @return representacao textual do fornecedor
	 */
	public String exibeFornecedor(String nome) {
		return sistema.exibeFornecedor(nome);
	}

	/**
	 * lista todos os fornecedores
	 * 
	 * @return retorna em forma de texto a lista de todos os fornecedores
	 */
	public String exibeFornecedores() {
		return sistema.exibeFornecedores();
	}

	/**
	 * edita certo atributo de um dado fornecedor
	 * 
	 * @param nome      identificador imutavel do fornecedor
	 * @param atributo  atributo que se deseja editar
	 * @param novoValor novo valor associado
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		sistema.editaFornecedor(nome, atributo, novoValor);
	}

	/**
	 * deleta um fornecedor do sistema
	 * 
	 * @param nome nome do fornecedor
	 */
	public void removeFornecedor(String nome) {
		sistema.removeFornecedor(nome);
	}

	/**
	 * remove um dado produto do sistema de um fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 */
	public void removeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		sistema.removeProduto(nomeProduto, descricao, nomeFornecedor);
	}

	
	// comandos unicos administrador/produtos(pelos fornecedores)

	
	/**
	 * cadastra produto ainda nao cadastrado de um dado fornecedor
	 * 
	 * @param nomeFornecedor nome e identificador do fornecedor
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 * @param preco          preco do produto
	 */
	public void adicionaProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		sistema.adicionaProduto(nomeFornecedor, nomeProduto, descricao, preco);
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
		sistema.editaProduto(nomeProduto, descricao, nomeFornecedor, preco);
	}

	// comandos repetidos entra produto/combo

	/**
	 * lista todos os produtos de todos os fornecedores
	 * 
	 * @return representacao textual de todos os produtos de todos os fornecedores
	 */
	public String exibeProdutos() {
		return sistema.exibeProdutos();
	}

	/**
	 * lista todos os produtos cadastrados de certo fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor do produto
	 * @return listagem da representacao textual de todos os produtos do fornecedor
	 */
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		return sistema.exibeProdutosFornecedor(nomeFornecedor);
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
		return sistema.exibeProduto(nomeProduto, descricao, nomeFornecedor);
	}

	// comandos unicos de administrador/ combos

	/**
	 * adiciona um combo no sistema de produtos
	 * 
	 * @param nome_fornecedor nome do fornecedor
	 * @param nome_combo      nome do combo
	 * @param descricao_combo descricao do combo
	 * @param fator           porcentagem de desconto do preco total
	 * @param produtos        produtos que fazem parte do combo
	 */
	public void adicionaCombo(String nome_fornecedor, String nome_combo, String descricao_combo, double fator,
			String produtos) {
		sistema.cadastraCombo(nome_fornecedor, nome_combo, descricao_combo, fator, produtos);
	}

	/**
	 * edita o fator de desconto de um combo
	 * 
	 * @param nome       nome do combo
	 * @param descricao  descricao do combo
	 * @param fornecedor fornecedor do combo
	 * @param novoFator  novo fator dde desconto do combo
	 */
	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		sistema.editaCombo(nome, descricao, fornecedor, novoFator);
	}

	// comandos administrador/Compras

	/**
	 * cadastra compra no sistema
	 * 
	 * @param cpf               cpf e identificador do cliente
	 * @param fornecedor        nome do fornecedor do produto
	 * @param data              data da compra
	 * @param nome_produto      nome do produto comprado
	 * @param descricao_produto descricao do produto comprado
	 */
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome_produto,
			String descricao_produto) {
		sistema.cadastraCompra(cpf, fornecedor, data, nome_produto, descricao_produto);
	}

	/**
	 * retorna o debito de uma conta
	 * 
	 * @param cpf        identificador e cpf do cliente
	 * @param fornecedor nome do fornecedor
	 * @return retorna o valor total gasto na conta
	 */
	public String getDebito(String cpf, String fornecedor) {
		return sistema.getDebito(cpf, fornecedor);
	}

	/**
	 * exibe a conta de um dado cliente com um fornecedor
	 * 
	 * @param cpf        identificador e cpf do cliente
	 * @param fornecedor nome do fornecedor da conta
	 * @return nome do cliente + representacao da conta
	 */
	public String exibeContas(String cpf, String fornecedor) {
		return sistema.exibeContas(cpf, fornecedor);
	}

	/**
	 * exibe todas as contas de um dado cliente
	 * 
	 * @param cpf identificador e cpf do cliente
	 * @return listagem em texto das contas do cliente
	 */
	public String exibeContasClientes(String cpf) {
		return sistema.exibeContasClientes(cpf);
	}

	
	// Comando para o pagamento

	
	/**
	 * quita as dividas de um cliente numa dada conta
	 * 
	 * @param cpf        identificador e cpf do cliente
	 * @param fornecedor nome do fornecedor
	 */
	public void realizaPagamento(String cpf, String fornecedor) {
		sistema.realizaPagamento(cpf, fornecedor);
	}

	
	// public main de testes de aceitacao

	
	public static void main(String[] args) {
		args = new String[] { "lab5.Facade", "Testes_aceitacao/use_case_1.txt", "Testes_aceitacao/use_case_2.txt",
				"Testes_aceitacao/use_case_3.txt", "Testes_aceitacao/use_case_4.txt", "Testes_aceitacao/use_case_6.txt",
				"Testes_aceitacao/use_case_5.txt", "Testes_aceitacao/use_case_7.txt",
				"Testes_aceitacao/use_case_8.txt" };
		EasyAccept.main(args);
	}
}
