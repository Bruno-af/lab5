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
		fornecedores.put(nome.toLowerCase(), new Fornecedor(nome, email, telefone));
		return nome;
	}

	/**
	 * retorna representacao textual de um dado fornecedor
	 * 
	 * @param nome nome e identificador do fornecedor
	 * @return representacao textual do fornecedor
	 */
	public String retornaFornecedor(String nome) {
		if (haFornecedor(nome)) {
			return fornecedores.get(nome.toLowerCase()).toString();
		} else {
			throw new NullPointerException("fornecedor nao cadastrado");
		}
	}

	/**
	 * verifica a existencia previa de algum fornecedor
	 * 
	 * @param nome identificador do fornecedor
	 * @return true se ja houver um fornecedor com o dado nome, falso caso contrario
	 */
	private boolean haFornecedor(String nome) {
		if (fornecedores.containsKey(nome.toLowerCase())) {
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
		if (!saida.equals("")) {
			return saida.substring(0, saida.length() - 3);
		} else {
			throw new NullPointerException("nao ha fornecedores cadastrados");
		}
	}

	/**
	 * edita dados do fornecedor
	 * 
	 * @param nome     identificador imutavel do fornecedor
	 * @param email    novo email do fornecedor
	 * @param telefone novo telefone do fornecedor
	 */
	public void editaFornecedor(String nome, String email, String telefone) {
		if (haFornecedor(nome)) {
			fornecedores.get(nome.toLowerCase()).editaFornecedor(email, telefone);
		} else {
			throw new NullPointerException("fornecedor nao cadastrado");
		}
	}

	/**
	 * deleta um fornecedor do sistema
	 * 
	 * @param nome identificador do fornecedor
	 */
	public void deletaFornecedor(String nome) {
		if (haFornecedor(nome)) {
			fornecedores.remove(nome.toLowerCase());
		} else {
			throw new NullPointerException("fornecedor nao cadastrado");
		}
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
		if (haFornecedor(nomeFornecedor)) {
			fornecedores.get(nomeFornecedor.toLowerCase()).cadastraProduto(nomeProduto, descricao, preco);
		} else {
			throw new NullPointerException("fornecedor nao cadastrado");
		}
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
		if (haFornecedor(nomeFornecedor)) {
			return fornecedores.get(nomeFornecedor.toLowerCase()).consultaProduto(nomeProduto, descricao);
		} else {
			throw new NullPointerException("fornecedor nao cadastrado");
		}
	}

	/**
	 * lista todos os produtos cadastrados de um certo fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor
	 * @return listagem da representacao textual de todos os produtos
	 */
	public String listaProdutos(String nomeFornecedor) {
		if (haFornecedor(nomeFornecedor)) {
			return fornecedores.get(nomeFornecedor.toLowerCase()).listaProdutos();
		} else {
			throw new NullPointerException("fornecedor nao cadastrado");
		}
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
		if (saida.equals("")) {
			throw new NullPointerException("nenhum produto cadastrado");
		}
		return saida;
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
		if (!haFornecedor(nomeFornecedor)) {
			throw new NullPointerException("fornecedor nao cadastrado");
		}
		fornecedores.get(nomeFornecedor.toLowerCase()).editaProduto(nomeProduto, descricao, preco);
	}

	/**
	 * deleta um dado produto do sistema de um fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor do produto
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 */
	public void deletaProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		if(!haFornecedor(nomeFornecedor)) {
			throw new NullPointerException("fornecedor nao cadastrado");
		}
		fornecedores.get(nomeFornecedor.toLowerCase()).deletaProduto(nomeProduto, descricao);
	}
}
