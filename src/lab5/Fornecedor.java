package lab5;

import java.util.HashMap;

public class Fornecedor {
	/**
	 * nome do fornecedor
	 */
	private String nome;
	/**
	 * email do fornecedor
	 */
	private String email;
	/**
	 * telefone do fornecedor
	 */
	private String telefone;
	/**
	 * colecao de produtos de um fornecedor
	 */
	private HashMap<IdProduto, Produto> produtos;

	/**
	 * constroi o fornecedor
	 * 
	 * @param nome     nome do fornecedor
	 * @param email    email do fornecedor
	 * @param telefone telefone do fornecedor
	 */
	public Fornecedor(String nome, String email, String telefone) {
		validaDados(nome, email, telefone);
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
	}

	/**
	 * verifica a validade das entradas
	 * 
	 * @param nome     nome a ser verificado
	 * @param email    email a ser verificado
	 * @param telefone telefone a ser verificado
	 */
	private void validaDados(String nome, String email, String telefone) {
		if (nome.equals("")) {
			throw new IllegalArgumentException("nome invalido");
		}
		if (nome == null) {
			throw new NullPointerException("nome não pode ser nulo");
		}
		if (email.equals("")) {
			throw new IllegalArgumentException("email invalido");
		}
		if (email == null) {
			throw new NullPointerException("email não pode ser nulo");
		}
		if (telefone.equals("")) {
			throw new IllegalArgumentException("telefone invalido");
		}
		if (telefone == null) {
			throw new NullPointerException("telefone não pode ser nulo");
		}
	}

	@Override
	/**
	 * representacao textual do fornecedor no formato: nome - email - telefone
	 */
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	/**
	 * edita o email e o telefone do fornecedor
	 * 
	 * @param novoEmail    novo email do fornecedor
	 * @param novoTelefone novo telefone do fornecedor
	 */
	public void editaFornecedor(String novoEmail, String novoTelefone) {
		this.email = novoEmail;
		this.telefone = novoTelefone;
	}

	// metodos de manipulacao dos produtos

	/**
	 * cadastra produto ainda nao cadastrado
	 * 
	 * @param nome      nome do produto
	 * @param descricao descricao do produto
	 * @param preco     preco do produto
	 */
	public void cadastraProduto(String nome, String descricao, double preco) {
		if (!produtos.containsKey(new IdProduto(nome, descricao))) {
			produtos.put(new IdProduto(nome, descricao), new Produto(nome, descricao, preco));
		}
	}

	/**
	 * retorna a representacao textual de um produto
	 * 
	 * @param nomeProduto nome do produto
	 * @param descricao   descricao do produto
	 * @return retorna a representacao textual do produto
	 */
	public String consultaProduto(String nomeProduto, String descricao) {
		return produtos.get(new IdProduto(nomeProduto, descricao)).toString();
	}

	/**
	 * lista todos os produtos cadastrados do fornecedor
	 * 
	 * @return listagem da representacao textual de todos os produtos
	 */
	public String listaProdutos() {
		String saida = "";
		for (Produto produto : produtos.values()) {
			saida += produto.toString() + " | ";
		}
		return saida.substring(0, saida.length() - 4);
	}

	/**
	 * lista todos os produtos cadastrados no formato: fornecedor - nome do produto
	 * - descricao do produto - preco do produto
	 * 
	 * @return
	 */
	public String listagemProdutos() {
		String saida = "";
		for (Produto produto : produtos.values()) {
			saida += this.nome + " - " + produto.toString() + " | ";
		}
		return saida;
	}

	/**
	 * altera o preco de um dado produto
	 * 
	 * @param nomeProduto nome do produto
	 * @param descricao   descricao do produto
	 * @param preco       novo preco do produto
	 */
	public void editaProduto(String nomeProduto, String descricao, double preco) {
		produtos.get(new IdProduto(nomeProduto, descricao)).alteraPreco(preco);
	}

	/**
	 * deleta um dado produto do sistema de um fornecedor
	 * 
	 * @param nomeProduto nome do produto a ser deletado
	 * @param descricao   descricao do produto a ser deletado
	 */
	public void deletaProduto(String nomeProduto, String descricao) {
		produtos.remove(new IdProduto(nomeProduto, descricao));
	}

}
