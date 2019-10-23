package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Fornecedor implements Comparable<Fornecedor> {

	/**
	 * nome do fornecedor
	 */
	private String nomeFornecedor;
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
	 * colecao de combos de um fornecedor
	 */
	private HashMap<String, Combo> combos;
	/**
	 * validador de dados da classe
	 */
	private ValidaDados validador = new ValidaDados();

	// metodos que manipulam o fornecedor

	/**
	 * constroi o fornecedor
	 * 
	 * @param nome     nome do fornecedor
	 * @param email    email do fornecedor
	 * @param telefone telefone do fornecedor
	 */
	public Fornecedor(String nome, String email, String telefone) {
		validaDados(nome, email, telefone);
		this.nomeFornecedor = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
		this.combos = new HashMap<String, Combo>();
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
			throw new NullPointerException("nome nao pode ser nulo");
		} else if (nome.equals("")) {
			throw new IllegalArgumentException("nome invalido");
		}
		if (email == null) {
			throw new NullPointerException("email nao pode ser nulo");
		} else if (email.equals("")) {
			throw new IllegalArgumentException("email invalido");
		}
		if (telefone == null) {
			throw new NullPointerException("telefone nao pode ser nulo");
		} else if (telefone.equals("")) {
			throw new IllegalArgumentException("telefone invalido");
		}
	}

	@Override
	/**
	 * representacao textual padrao do fornecedor no formato: nome - email -
	 * telefone
	 */
	public String toString() {
		return this.getNomeFornecedor() + " - " + this.email + " - " + this.telefone;
	}

	/**
	 * retorna o nome do fornecedor
	 * 
	 * @return nome do fornecedor
	 */
	private String getNomeFornecedor() {
		return this.nomeFornecedor;
	}

	/**
	 * edita um atributo do fornecedor
	 * 
	 * @param atributo  atributo que se deseja editar
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
	public void setTelefone(String novoValor) {
		validaDados(this.nomeFornecedor, this.email, novoValor);
		this.telefone = novoValor;
	}

	/**
	 * atualiza o email acadastrado
	 * 
	 * @param novoValor novo email associado
	 */
	public void setEmail(String novoValor) {
		validaDados(this.nomeFornecedor, novoValor, this.telefone);
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
		validador.validaString("Erro no cadastro de produto: nome nao pode ser vazia ou nula.", nome);
		validador.validaString("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", descricao);
		IdProduto id = new IdProduto(nome, descricao);
		if (!this.produtos.containsKey(id.retornaId())) {
			this.produtos.put(id.retornaId(), new Produto(nome, descricao, preco));
		} else {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
	}

	/**
	 * retorna a representacao textual padrao de um produto(combo ou simples)
	 * cadastrado
	 * 
	 * @param nomeProduto nome do produto
	 * @param descricao   descricao do produto
	 * @return retorna a representacao textual do produto
	 */
	public String consultaProduto(String nomeProduto, String descricao) {
		validador.validaString("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.", descricao);
		validador.validaString("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		IdProduto id = new IdProduto(nomeProduto, descricao);
		if (haCombo(id.retornaId())) {
			return this.combos.get(id.retornaId()).toString();
		} else if (produtos.containsKey(id.retornaId())) {
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
		if (!produtos.isEmpty()) {
			List<ProdutoGeral> listaOrdenadaProdutos = ordenaProdutos();
			String saida = "";
			for (ProdutoGeral produto : listaOrdenadaProdutos) {
				saida += this.nomeFornecedor + " - " + produto.toString() + " | ";
			}
			return saida.substring(0, saida.length() - 3);
		} else {
			return this.nomeFornecedor + " -";
		}
	}

	/**
	 * Ordena produtos(produtos e combos)
	 * 
	 * @return lista ordenada alfabeticamente de produtos
	 */
	private List<ProdutoGeral> ordenaProdutos() {
		List<ProdutoGeral> produtosOrdenados = new ArrayList<>(produtos.values());
		produtosOrdenados.addAll(combos.values());
		Collections.sort(produtosOrdenados);
		return produtosOrdenados;
	}

	/**
	 * altera o preco de um dado produto cadastrado
	 * 
	 * @param nomeProduto nome do produto
	 * @param descricao   descricao do produto
	 * @param preco       novo preco do produto
	 */
	public void editaProduto(String nomeProduto, String descricao, double preco) {
		validador.validaString("Erro na edicao de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		validador.validaString("Erro na edicao de produto: descricao nao pode ser vazia ou nula.", descricao);
		IdProduto key = new IdProduto(nomeProduto, descricao);
		if (produtos.containsKey(key.retornaId())) {
			produtos.get(key.retornaId()).alteraPreco(preco);
		} else {
			throw new NullPointerException("Erro na edicao de produto: produto nao existe.");
		}
	}

	/**
	 * deleta um dado produto cadastrado no fornecedor
	 * 
	 * @param nomeProduto nome do produto a ser deletado
	 * @param descricao   descricao do produto a ser deletado
	 */
	public void deletaProduto(String nomeProduto, String descricao) {
		validador.validaString("Erro na remocao de produto: nome nao pode ser vazio ou nulo.", nomeProduto);
		validador.validaString("Erro na remocao de produto: descricao nao pode ser vazia ou nula.", descricao);
		String key = new IdProduto(nomeProduto, descricao).retornaId();
		if (haCombo(key)) {
			combos.remove(key);
		} else if (produtos.containsKey(key)) {
			produtos.remove(key);
		} else {
			throw new NullPointerException("Erro na remocao de produto: produto nao existe.");
		}
	}

	/**
	 * retorna o preco de um produto cadastrado
	 * 
	 * @param nomeProduto       nome do produto
	 * @param descricao_produto descricao do produto
	 * @return preco do produto
	 */
	public double getPreco(String nomeProduto, String descricao_produto) {
		String key = new IdProduto(nomeProduto, descricao_produto).retornaId();
		if (haCombo(key)) {
			return combos.get(key).getPreco();
		} else if (produtos.containsKey(key)) {
			return produtos.get(key).getPreco();
		} else {
			throw new NullPointerException("Erro ao cadastrar compra: produto nao existe.");
		}
	}

	@Override
	/**
	 * compara dois fornecedores alfabeticamente
	 */
	public int compareTo(Fornecedor o) {
		return this.getNomeFornecedor().compareTo(o.getNomeFornecedor());
	}

	// metodo de combos

	public void cadastraCombo(String nome_combo, String descricao_combo, double fator, String produtos2,
			String fornecedor) {
		validador.validaString("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.", nome_combo);
		validador.validaString("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.", descricao_combo);
		validador.validaString("Erro no cadastro de combo: combo deve ter produtos.", produtos2);
		IdProduto key = new IdProduto(nome_combo, descricao_combo);
		if (haCombo(key.retornaId())) {
			throw new IllegalAccessError("Erro no cadastro de combo: combo ja existe.");
		}
		if (fator <= 0 | fator >= 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}
		if (verificaProdutos(produtos2)) {
			combos.put(key.retornaId(),
					new Combo(nome_combo, descricao_combo, fator, pegaPreco(produtos2), fornecedor));
		}
	}

	/**
	 * verifica se ha combo cadastrado
	 * 
	 * @param nome_combo nome do combo
	 * @return veracidade da existencia do combo
	 */
	private boolean haCombo(String id_combo) {
		return this.combos.containsKey(id_combo);
	}

	/**
	 * acessa o preco do combo sem desconto
	 * 
	 * @param produtos string com os produtos do combo
	 * @return preco total do combo sem desconto
	 */
	private double pegaPreco(String produtos) {
		double preco = 0.0;
		String[] listaProdutosLocal = produtos.split(",");
		for (String produto : listaProdutosLocal) {
			IdProduto id = new IdProduto(produto.split(" - ")[0].trim(), produto.split(" - ")[1]);
			if (this.produtos.containsKey(id.retornaId())) {
				preco += this.produtos.get(id.retornaId()).getPreco();
			} else if (haCombo(id.retornaId())) {
				throw new NullPointerException(
						"Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
			}
		}
		return preco;
	}

	/**
	 * verifica a existencia dos produtos(simples ou combo)
	 * 
	 * @param produtosEntrada produtos que se deseja verificar
	 * @return true se todos produtos existirem, falso caso algum n existe
	 */
	private boolean verificaProdutos(String produtosEntrada) {
		String[] listaProdutosLocal = produtosEntrada.split(", "); // separa os produtos diferentes
		for (String produto : listaProdutosLocal) {
			IdProduto id = new IdProduto(produto.split(" - ")[0], produto.split(" - ")[1]); // separa nome/descricao de
																							// cada produto
			if (haCombo(id.retornaId())) {
				throw new IllegalArgumentException(
						"Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
			}
			if (!this.produtos.containsKey(id.retornaId())) {
				throw new NullPointerException("Erro no cadastro de combo: produto nao existe.");
			}
		}
		return true;
	}

	/**
	 * edita o fator de desconto de um combo
	 * 
	 * @param nome      nome do combo
	 * @param descricao descricao do combo
	 * @param novoFator novo fator de desconto
	 */
	public void editaCombo(String nome, String descricao, double novoFator) {
		validador.validaString("Erro na edicao de combo: nome nao pode ser vazio ou nulo.", nome);
		validador.validaString("Erro na edicao de combo: descricao nao pode ser vazia ou nula.", descricao);
		IdProduto key = new IdProduto(nome, descricao);
		if (haCombo(key.retornaId())) {
			combos.get(key.retornaId()).editaCombo(novoFator);
		} else {
			throw new NullPointerException("Erro na edicao de combo: produto nao existe.");
		}
	}

	/**
	 * verifica a existencia de um produto simples
	 * 
	 * @param nome_produto nome do produto
	 * @param descricao    descricao do produto
	 * @return a veracidade da existencia do produto
	 */
	public boolean haProduto(String nome_produto, String descricao) {
		String key = new IdProduto(nome_produto, descricao).retornaId();
		return produtos.containsKey(key);
	}

	/**
	 * verifica a existencia de um combo
	 * 
	 * @param nome_produto      nome do combo
	 * @param descricao_produto descricao do combo
	 * @return a veracidade da existencia do produto
	 */
	public boolean haCombo(String nome_produto, String descricao_produto) {
		String key = new IdProduto(nome_produto, descricao_produto).retornaId();
		return combos.containsKey(key);
	}
}
