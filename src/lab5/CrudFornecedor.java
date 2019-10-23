package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author Bruno Andrade Fernandes - 119110378
 */
public class CrudFornecedor {
	/**
	 * colecao de armazenamento dos fornecedores cadastrados
	 */
	private HashMap<String, Fornecedor> fornecedoresCadastrados;
	/**
	 * validador da classe
	 */
	private ValidaDados validador = new ValidaDados();

	/**
	 * Constroi sistema de fornecedores
	 */
	public CrudFornecedor() {
		this.fornecedoresCadastrados = new HashMap<>();
	}

	// metodos para manipular fornecedores

	/**
	 * cadastra um fornecedor ainda nao cadastrado no sistema
	 * 
	 * @param nome     nome e identificador do fornecedor
	 * @param email    email do fornecedor
	 * @param telefone telefone do fornecedor
	 * @return o nome do fornecedor, caso bem sucedido, lanca um erro, caso nao
	 */
	public String cadastraFornecedor(String nome, String email, String telefone) {
		validador.validaString("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", nome);
		validador.validaString("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", email);
		validador.validaString("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", telefone);
		if (haFornecedor(nome)) {
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
		validador.validaString("Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.", nome);
		if (haFornecedor(nome)) {
			return getFornecedor(nome).toString();
		} else {
			throw new NullPointerException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
	}

	/**
	 * verifica a existencia previa de algum fornecedor
	 * 
	 * @param nome nome e identificador do fornecedor
	 * @return veracidade da existencia do fornecedor no sistema
	 */
	boolean haFornecedor(String nome) {
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
	 * ordena os fornecedores cadastrados em uma lista
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
		validador.validaString("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.", nome);
		validador.validaString("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.", novoValor);
		validador.validaString("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.", atributo);
		if (atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		} else if (!atributo.equals("telefone") && !atributo.equals("email")) {
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
	 * @param nome nome e identificador do fornecedor
	 */
	public void deletaFornecedor(String nome) {
		validador.validaString("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.", nome);
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
		validador.validaString("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		validador.validaString("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
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
	 * @param nomeFornecedor nome e identificador do fornecedor do produto
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 * @return retorna uma representacao textual do produto
	 */
	public String consultaProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		validador.validaString("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		if (haFornecedor(nomeFornecedor)) {
			return getFornecedor(nomeFornecedor).consultaProduto(nomeProduto, descricao);
		} else {
			throw new NullPointerException("Erro na exibicao de produto: fornecedor nao existe.");
		}
	}

	/**
	 * lista todos os produtos cadastrados de um certo fornecedor
	 * 
	 * @param nomeFornecedor nome e identificador do fornecedor
	 * @return listagem da representacao textual de todos os produtos
	 */
	public String listaProdutos(String nomeFornecedor) {
		validador.validaString("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		if (haFornecedor(nomeFornecedor)) {
			return getFornecedor(nomeFornecedor.toLowerCase()).listagemProdutos();
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
		validador.validaString("nenhum produto cadastrado", saida);
		return saida.substring(0, saida.length() - 3);
	}

	/**
	 * altera o preco de um produto
	 * 
	 * @param nomeFornecedor nome e identificador do fornecedor
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 * @param preco          novo preco do produto
	 */
	public void editaProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		validador.validaString("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
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
		validador.validaString("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.", nomeFornecedor);
		if (!haFornecedor(nomeFornecedor)) {
			throw new NullPointerException("Erro na remocao de produto: fornecedor nao existe.");
		}
		getFornecedor(nomeFornecedor).deletaProduto(nomeProduto, descricao);
	}

	/**
	 * verifica se ja um produto em um fornecedor cadastrado
	 * 
	 * @param nome_produto nome do produto
	 * @param descricao    decricao do produto
	 * @param fornecedor   nome e identificador do fornecedor
	 * @return a vericidade da existencia do produto no fornecedor
	 */
	public boolean haProduto(String nome_produto, String descricao, String fornecedor) {
		return fornecedoresCadastrados.get(fornecedor.toLowerCase()).haProduto(nome_produto, descricao);
	}

	/**
	 * retorna o preco de um dado produto de um dado fornecedor
	 * 
	 * @param fornecedor        nome e identificador do fornecedor
	 * @param nome_produto      nome do produto
	 * @param descricao_produto descricao do produto
	 * @return preco do produto
	 */
	public double getPreco(String fornecedor, String nome_produto, String descricao_produto) {
		if (haFornecedor(fornecedor)) {
			return fornecedoresCadastrados.get(fornecedor.toLowerCase()).getPreco(nome_produto, descricao_produto);
		} else {
			throw new NullPointerException("Erro ao cadastrar compra: fornecedor nao existe.");
		}
	}

	// comando para manipulacao dos Combos

	/**
	 * cadastra um combo na colecao de combos
	 * 
	 * @param nome_fornecedor nome do fornecedor do combo
	 * @param nome_combo      nome do combo
	 * @param descricao_combo descricao do combo
	 * @param fator           porcentagem do desconto do preco do combo
	 * @param produtos        produtos que fazem parte do combo
	 */
	public void cadastraCombo(String nome_fornecedor, String nome_combo, String descricao_combo, double fator,
			String produtos) {
		validador.validaString("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.", nome_fornecedor);
		if (haFornecedor(nome_fornecedor)) {
			fornecedoresCadastrados.get(nome_fornecedor.toLowerCase()).cadastraCombo(nome_combo, descricao_combo, fator,
					produtos, nome_fornecedor);
		} else {
			throw new NullPointerException("Erro no cadastro de combo: fornecedor nao existe.");
		}
	}

	/**
	 * edita o fator de desconto do combo
	 * 
	 * @param nome       nome do combo
	 * @param descricao  descricao do cmbo
	 * @param fornecedor nome do fornecedor do combo
	 * @param novoFator  novo fator de desconto do combo
	 */
	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		validador.validaString("Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.", fornecedor);
		if (fornecedoresCadastrados.containsKey(fornecedor.toLowerCase())) {
			fornecedoresCadastrados.get(fornecedor.toLowerCase()).editaCombo(nome, descricao, novoFator);
		} else {
			throw new NullPointerException("Erro na edicao de combo: fornecedor nao existe.");
		}
	}

	/**
	 * verifica a existencia de um combo no sistema
	 * 
	 * @param nome_produto      nome do combo
	 * @param descricao_produto descricao do combo
	 * @param fornecedor        nome do fornecedor do combo
	 * @return a veracidade da existencia do combo no sistema
	 */
	public boolean haCombo(String nome_produto, String descricao_produto, String fornecedor) {
		return fornecedoresCadastrados.get(fornecedor.toLowerCase()).haCombo(nome_produto, descricao_produto);
	}
}
