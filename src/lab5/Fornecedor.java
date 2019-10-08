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
	private HashMap<String, Produto> produtos;

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
		if (nome == null) {
			throw new NullPointerException("nome n�o pode ser nulo");
		} else if (nome.equals("")) {
			throw new IllegalArgumentException("nome invalido");
		}
		if (email == null) {
			throw new NullPointerException("email n�o pode ser nulo");
		} else if (email.equals("")) {
			throw new IllegalArgumentException("email invalido");
		}
		if (telefone == null) {
			throw new NullPointerException("telefone n�o pode ser nulo");
		} else if (telefone.equals("")) {
			throw new IllegalArgumentException("telefone invalido");
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
	 * @param atributo  atributo que se deseja mudar
	 * @param novoValor novo valor associado
	 */
	public void editaFornecedor(String atributo, String novoValor) {
		if (atributo.equals("email")) {
			setEmail(novoValor);
		} else if (atributo.equals("telefone")) {
			setTelefone(novoValor);
		}
	}

	/**
	 * atualiza o telefone cadastrado
	 * 
	 * @param novoValor novo telefone associado
	 */
	private void setTelefone(String novoValor) {
		this.telefone = novoValor;
	}

	/**
	 * atualiza o email acadastrado
	 * 
	 * @param novoValor novo email associado
	 */
	private void setEmail(String novoValor) {
		this.email = novoValor;
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
		if (nome == null) { //////
			throw new NullPointerException("Erro no cadastro de produto: nome nao pode ser vazia ou nula.");
		} else if (nome.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazia ou nula.");
		}
		if (descricao == null) {
			throw new NullPointerException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		} else if (descricao.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
		IdProduto id = new IdProduto(nome, descricao);
		if (!produtos.containsKey(id.retornaId())) {
			produtos.put(id.retornaId(), new Produto(nome, descricao, preco));
		} else {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
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
		if(descricao == null) {
			throw new NullPointerException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		} else if(descricao.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}
		if(nomeProduto == null) {
			throw new NullPointerException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		} else if(nomeProduto.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}
		IdProduto id = new IdProduto(nomeProduto, descricao);
		if (produtos.containsKey(id.retornaId())) {
			return this.produtos.get(id.retornaId()).toString();
		} else {
			throw new NullPointerException("Erro na exibicao de produto: produto nao existe.");
		}
	}

	/**
	 * lista todos os produtos cadastrados do fornecedor
	 * 
	 * @return listagem da representacao textual de todos os produtos
	 */
	public String listaProdutos() {
		if (produtos.isEmpty()) {
			throw new NullPointerException("Nao ha produtos cadastrados");
		}
		String saida = "";
		for (Produto produto : produtos.values()) {
			saida += produto.toString() + " | ";
		}
		return saida.substring(0, saida.length() - 3);
	}

	/**
	 * lista todos os produtos cadastrados no formato: fornecedor - nome do produto
	 * - descricao do produto - preco do produto
	 * 
	 * @return listagem das representacoes textuais dos produtos com seu fornecedor
	 */
	public String listagemProdutos() {
		if (produtos.isEmpty()) {
			throw new NullPointerException("Nao ha produtos cadastrados");
		}
		String saida = "";
		for (Produto produto : produtos.values()) {
			saida += this.nome + " - " + produto.toString() + " | ";
		}
		return saida.substring(0, saida.length() - 3);
	}

	/**
	 * altera o preco de um dado produto
	 * 
	 * @param nomeProduto nome do produto
	 * @param descricao   descricao do produto
	 * @param preco       novo preco do produto
	 */
	public void editaProduto(String nomeProduto, String descricao, double preco) {
		if (nomeProduto == null) { //////
			throw new NullPointerException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		} else if (nomeProduto.equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null) {
			throw new NullPointerException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		} else if (descricao.equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}
		IdProduto key = new IdProduto(nomeProduto, descricao);
		if (produtos.containsKey(key.retornaId())) {
			produtos.get(key.retornaId()).alteraPreco(preco);
		} else {
			throw new NullPointerException("Erro na edicao de produto: produto nao existe.");
		}
	}

	/**
	 * deleta um dado produto do sistema de um fornecedor
	 * 
	 * @param nomeProduto nome do produto a ser deletado
	 * @param descricao   descricao do produto a ser deletado
	 */
	public void deletaProduto(String nomeProduto, String descricao) {
		if(nomeProduto == null) {
			throw new NullPointerException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		} else if (nomeProduto.equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}
		if(descricao == null) {
			throw new NullPointerException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		} else if (descricao.equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}
		String key = new IdProduto(nomeProduto, descricao).retornaId();
		if (produtos.containsKey(key)) {
			produtos.remove(key);
		} else {
			throw new NullPointerException("Erro na remocao de produto: produto nao existe.");
		}
	}

}
