package lab5;

import java.util.HashMap;

public class CrudFornecedor {
	/**
	 * colecao de armazenamento dos fornecedores cadastrados
	 */
	private HashMap<String, Fornecedor> fornecedores;

	/**
	 * Constroi sistema de fornecedores
	 */
	public CrudFornecedor() {
		this.fornecedores = new HashMap<>();
	}

	/**
	 * cadastra um fornecedor no sistema de armazenamento
	 * 
	 * @param nome     nome e identificador do fornecedor
	 * @param email    email do fornecedor
	 * @param telefone telefone do fornecedor
	 * @return o nome do fornecedor, caso bem sucedido, ou lanca um erro
	 *         IllegalArgumentException caso ja tenha sido cadastrado
	 */
	public String cadastraFornecedor(String nome, String email, String telefone) {
		if (haFornecedor(nome)) {
			throw new IllegalArgumentException("Fornecedor ja cadastrado");
		}
		fornecedores.put(nome, new Fornecedor(nome, email, telefone));
		return nome;
	}

	/**
	 * retorna representacao textual de um dado fornecedor
	 * 
	 * @param nome nome e identificador do fornecedor
	 * @return representacao textual do fornecedor
	 */
	public String retornaFornecedor(String nome) {
		return fornecedores.get(nome).toString();
	}

	/**
	 * verifica a existencia previa de algum fornecedor
	 * 
	 * @param nome identificador do fornecedor
	 * @return true se ja houver um fornecedor com o dado nome, falso caso contrario
	 */
	private boolean haFornecedor(String nome) {
		if (fornecedores.containsKey(nome)) {
			return true;
		}
		return false;
	}

	/**
	 * lista a representacao textual de todos os fornecedores cadastrados
	 * 
	 * @return representacao textual da listagem dos fornecedores
	 */
	public String listaFornecedores() {
		String saida = "";
		for (Fornecedor fornecedor : fornecedores.values()) {
			saida += fornecedor.toString() + " | ";
		}
		return saida.substring(0, saida.length() - 4);
	}

	/**
	 * edita dados do fornecedor
	 * 
	 * @param nome     identificador imutavel do fornecedor
	 * @param email    novo email do fornecedor
	 * @param telefone novo telefone do fornecedor
	 */
	public void editaFornecedor(String nome, String email, String telefone) {
		fornecedores.get(nome).editaFornecedor(email, telefone);
	}

	/**
	 * deleta um fornecedor do sistema
	 * 
	 * @param nome identificador do fornecedor
	 */
	public void deletaFornecedor(String nome) {
		fornecedores.remove(nome);
	}

	// metodos para manipular produtos

	/**
	 * cadastra produto ainda nao cadastrado de certo fornecedor
	 * 
	 * @param nomeFornecedor nome e identificador do fornecedor
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 * @param preco          preco do produto
	 */
	public void cadastraProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		fornecedores.get(nomeFornecedor).cadastraProduto(nomeProduto, descricao, preco);
	}

	/**
	 * consulta um produto em forma de texto
	 * 
	 * @param nomeFornecedor nome do fornecedor do produto
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 * @return retorna uma representacao textual do produto
	 */
	public String consultaProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		return fornecedores.get(nomeFornecedor).consultaProduto(nomeProduto, descricao);
	}

	/**
	 * lista todos os produtos cadastrados de um certo fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor
	 * @return listagem da representacao textual de todos os produtos
	 */
	public String listaProdutos(String nomeFornecedor) {
		return fornecedores.get(nomeFornecedor).listaProdutos();
	}

	/**
	 * lista todos os produtos de todos os fornecedores
	 * 
	 * @return representacao textual da listagem
	 */
	public String listaTodosProdutos() {
		String saida = "";
		for (Fornecedor fornecedor : fornecedores.values()) {
			saida += fornecedor.listagemProdutos();
		}
		return saida.substring(0, saida.length() - 4);
	}

	/**
	 * altera o preco de um produto
	 * 
	 * @param nomeFornecedor nome do fornecedor
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 * @param preco          novo preco do produto
	 */
	public void editaProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		fornecedores.get(nomeFornecedor).editaProduto(nomeProduto, descricao, preco);
	}

	/**
	 * deleta um dado produto do sistema de um fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor do produto
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 */
	public void deletaProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		fornecedores.get(nomeFornecedor).deletaProduto(nomeProduto, descricao);
	}
}
