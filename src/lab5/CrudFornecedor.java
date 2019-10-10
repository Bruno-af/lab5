package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CrudFornecedor {
	/**
	 * colecao de armazenamento dos fornecedores cadastrados
	 */
	private HashMap<String, Fornecedor> fornecedoresCadastrados;

	/**
	 * Constroi sistema de fornecedores
	 */
	public CrudFornecedor() {
		this.fornecedoresCadastrados = new HashMap<>();
	}

	// metodos para manipular fornecedores

	/**
	 * cadastra um fornecedor no sistema
	 * 
	 * @param nome     nome e identificador do fornecedor
	 * @param email    email do fornecedor
	 * @param telefone telefone do fornecedor
	 * @return o nome do fornecedor, caso bem sucedido, ou lanca um erro, caso nao
	 */
	public String cadastraFornecedor(String nome, String email, String telefone) {
		if (nome == null) {
			throw new NullPointerException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		} else if (nome.equals("")) {
			throw new NullPointerException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		} else if (email == null) {
			throw new NullPointerException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		} else if (email.equals("")) {
			throw new NullPointerException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		} else if (telefone == null) {
			throw new NullPointerException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		} else if (telefone.equals("")) {
			throw new NullPointerException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		} else if (haFornecedor(nome.toLowerCase())) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
		fornecedoresCadastrados.put(nome.toLowerCase(), new Fornecedor(nome, email, telefone));
		return nome;
	}

	/**
	 * retorna representacao textual de um dado fornecedor
	 * 
	 * @param nome nome e identificador do fornecedor
	 * @return representacao textual do fornecedor
	 */
	public String retornaFornecedor(String nome) {
		if (nome == null) {
			throw new NullPointerException("Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
		} else if (nome.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if (haFornecedor(nome)) {
			return getFornecedor(nome).toString();
		} else {
			throw new NullPointerException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
	}

	/**
	 * verifica a existencia previa de algum fornecedor
	 * 
	 * @param nome identificador do fornecedor
	 * @return true se houver um fornecedor cadastrado com o dado nome, falso caso
	 *         contrario
	 */
	private boolean haFornecedor(String nome) {
		if (fornecedoresCadastrados.containsKey(nome.toLowerCase())) {
			return true;
		}
		return false;
	}

	/**
	 * lista todos os fornecedores cadastrados
	 * 
	 * @return representacao textual da listagem dos fornecedores
	 */
	public String listaFornecedores() {
		String saida = "";
		List<Fornecedor> listaOrdenada = ordenaFornecedores();
		for (Fornecedor fornecedor : listaOrdenada) {
			saida += fornecedor.toString() + " | ";
		}
		if (!saida.equals("")) {
			return saida.substring(0, saida.length() - 3);
		} else {
			throw new NullPointerException("nao ha fornecedores cadastrados");
		}
	}

	/**
	 * ordena os fornecedores até entao cadastrados em uma lista
	 * 
	 * @return lista ordenada de fornecedores
	 */
	private List<Fornecedor> ordenaFornecedores() {
		List<Fornecedor> fornecedoresOrdenados = new ArrayList<>(this.fornecedoresCadastrados.values());
		Collections.sort(fornecedoresOrdenados);
		return fornecedoresOrdenados;
	}

	/**
	 * edita dados de um fornecedor
	 * 
	 * @param nome      identificador imutavel do fornecedor
	 * @param atributo  atributo que se deseja alterar
	 * @param novoValor equivalente ao novo atributo
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		if (nome == null) {
			throw new NullPointerException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		} else if (nome.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if (novoValor == null) {
			throw new NullPointerException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		} else if (novoValor.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}
		if (atributo == null) {
			throw new NullPointerException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		} else if (atributo.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		} else if (atributo.equals("email")) {
		} else if (atributo.equals("telefone")) {
		} else if (atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		} else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
		if (haFornecedor(nome)) {
			getFornecedor(nome).editaFornecedor(atributo, novoValor);
		} else {
			throw new NullPointerException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}
	}

	/**
	 * deleta um fornecedor do sistema
	 * 
	 * @param nome identificador do fornecedor
	 */
	public void deletaFornecedor(String nome) {
		if (nome == null) {
			throw new NullPointerException(
					"Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		} else if (nome.equals("")) {
			throw new IllegalArgumentException(
					"Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		}
		if (haFornecedor(nome)) {
			fornecedoresCadastrados.remove(nome.toLowerCase());
		} else {
			throw new NullPointerException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
	}

	/**
	 * retorna um fornecedor
	 * 
	 * @param nome nome e identificador do fornecedor
	 * @return o dado fornecedor
	 */
	public Fornecedor getFornecedor(String nome) {
		return fornecedoresCadastrados.get(nome.toLowerCase());
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
		if (nomeFornecedor == null) {
			throw new NullPointerException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (nomeFornecedor.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if (nomeProduto == null) {
			throw new NullPointerException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		} else if (nomeProduto.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
		if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		if (haFornecedor(nomeFornecedor)) {
			getFornecedor(nomeFornecedor).cadastraProduto(nomeProduto, descricao, preco);
		} else {
			throw new NullPointerException("Erro no cadastro de produto: fornecedor nao existe.");
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
		if (nomeFornecedor == null) {
			throw new NullPointerException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (nomeFornecedor.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if (haFornecedor(nomeFornecedor)) {
			return getFornecedor(nomeFornecedor).consultaProduto(nomeProduto, descricao);
		} else {
			throw new NullPointerException("Erro na exibicao de produto: fornecedor nao existe.");
		}
	}

	/**
	 * lista todos os produtos cadastrados de um certo fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor
	 * @return listagem da representacao textual de todos os produtos
	 */
	public String listaProdutos(String nomeFornecedor) {
		if (nomeFornecedor == null) {
			throw new NullPointerException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (nomeFornecedor.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if (haFornecedor(nomeFornecedor.toLowerCase())) {
			return getFornecedor(nomeFornecedor).listagemProdutos();
		} else {
			throw new NullPointerException("Erro na exibicao de produto: fornecedor nao existe.");
		}
	}

	/**
	 * lista todos os produtos de todos os fornecedores
	 * 
	 * @return representacao textual da listagem
	 */
	public String listaTodosProdutos() {
		String saida = "";
		List<Fornecedor> listaOrdenada = ordenaFornecedores();
		for (Fornecedor fornecedor : listaOrdenada) {
			saida += fornecedor.listagemProdutos() + " | ";
		}
		if (saida.equals("")) {
			throw new NullPointerException("nenhum produto cadastrado");
		}
		return saida.substring(0, saida.length() - 3);
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
		if (nomeFornecedor == null) {
			throw new NullPointerException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (nomeFornecedor.equals("")) {
			throw new NullPointerException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if (!haFornecedor(nomeFornecedor.toLowerCase())) {
			throw new NullPointerException("Erro na edicao de produto: fornecedor nao existe.");
		}
		getFornecedor(nomeFornecedor).editaProduto(nomeProduto, descricao, preco);
	}

	/**
	 * deleta um dado produto do sistema de um fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor do produto
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 */
	public void deletaProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		if (nomeFornecedor == null) {
			throw new NullPointerException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (nomeFornecedor.equals("")) {
			throw new NullPointerException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if (!haFornecedor(nomeFornecedor)) {
			throw new NullPointerException("Erro na remocao de produto: fornecedor nao existe.");
		}
		getFornecedor(nomeFornecedor).deletaProduto(nomeProduto, descricao);
	}

	// metodos para manipular vendas

	/**
	 * cadastra compra em um certo fornecedor
	 * 
	 * @param cpf               cpf do cliente consumidor
	 * @param fornecedor        fornecedor do produto
	 * @param data              data da compra
	 * @param nome_produto      nome do produto comprado
	 * @param descrição_produto descricao do produto comprado
	 */
	public void CadastraCompra(String cpf, String fornecedor, String data, String nome_produto,
			String descricao_produto) {
		if (fornecedor == null) {
			throw new NullPointerException("crud fornecedor  cadastraCOmpra 310");
		} else if (fornecedor.equals("")) {
			throw new IllegalArgumentException("crud fornecedor cadastra compra 312");
		}
		if (haFornecedor(fornecedor)) {
			getFornecedor(fornecedor).cadastraCompra(cpf, data, nome_produto, descricao_produto);
		} else {
			throw new IllegalArgumentException("crud fornecedor 317");
		}
	}

	public double getDebito(String cpf, String fornecedor) {
		if (fornecedor == null) {
			throw new NullPointerException("crud fornecedor get debito310");
		} else if (fornecedor.equals("")) {
			throw new IllegalArgumentException("crud fornecedor get debito 312");
		}
		return fornecedoresCadastrados.get(fornecedor).getDebito(cpf);
	}

	public String toStringConta(String cpf, String fornecedor) {
		return "";
	}

	public String listaContas(String cpf) {
		return "";
	}
}
