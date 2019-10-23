package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author Bruno Andrade Fernandes - 119110378
 */
public class ControllerGeral {
	/**
	 * subsistema responsavel por manipular clientes
	 */
	private CrudCliente sistemaCliente;
	/**
	 * subsistema responsavel por manipular fornecedores
	 */
	private CrudFornecedor sistemaFornecedor;
	/**
	 * colecao de contas cadastradas
	 */
	private HashMap<String, List<Conta>> contasCadastradas;
	/**
	 * validador de dados da classe
	 */
	private ValidaDados validador;
	/**
	 * criterio de ordenacao do sistema
	 */
	private String criterioOrdenacao;

	/**
	 * constroi o sistema geral inicializando seus subsistemas e validador
	 */
	public ControllerGeral() {
		this.sistemaCliente = new CrudCliente();
		this.sistemaFornecedor = new CrudFornecedor();
		this.contasCadastradas = new HashMap<String, List<Conta>>();
		this.validador = new ValidaDados();
		criterioOrdenacao = "brunoD+oi&z3h";
	}

	// US1 comandos administrador/cliente

	/**
	 * cadastra cliente no subsistema de clientes e cria sua lista de contas
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
		contasCadastradas.put(cpf, new ArrayList<Conta>());
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
	 * edita certo atributo de dado cliente
	 * 
	 * @param cpf       identificador do cliente
	 * @param atributo  atributo que se deseja alterar
	 * @param novoValor equivalente ao novo atributo
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		sistemaCliente.editaCliente(cpf, atributo, novoValor);
	}

	/**
	 * deleta cliente que possui dado cpf
	 * 
	 * @param cpf identificador do cliente
	 */
	public void removeCliente(String cpf) {
		sistemaCliente.deletarCliente(cpf);
	}

	// US2 comando administrador/fornecedor

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
		sistemaFornecedor.cadastraFornecedor(nome, email, telefone);
		return nome;
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
	 * edita certo atributo de um dado fornecedor
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

	// US3 comandos administrador/produtos(pelos fornecedores)

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
	 * remove um dado produto do sistema de um fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 */
	public void removeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		sistemaFornecedor.deletaProduto(nomeFornecedor, nomeProduto, descricao);
	}

	// US5 metodos para manipular vendas

	/**
	 * cadastra compra no sistema
	 * 
	 * @param cpf               cpf e identificador do cliente
	 * @param fornecedor        nome do fornecedor do produto
	 * @param data              data da compra
	 * @param nome_produto      nome do produto comprado
	 * @param descricao_produto descricao do produto comprado
	 */
	public void cadastraCompra(String cpf, String fornecedor, String data, String nome_produto,
			String descricao_produto) {
		validador.validaString("Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.", cpf);
		validador.validaCpfTamanho("Erro ao cadastrar compra: cpf invalido.", cpf);
		validador.validaString("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.", fornecedor);
		validador.validaString("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.", nome_produto);
		validador.validaString("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.",
				descricao_produto);
		validador.validaString("Erro ao cadastrar compra: data nao pode ser vazia ou nula.", data);
		validador.validaData("Erro ao cadastrar compra: data invalida.", data);
		if (haContaCliente(cpf)) {
			double preco = sistemaFornecedor.getPreco(fornecedor, nome_produto, descricao_produto);
			if (haContaFornecedor(fornecedor, cpf)) {
				cadastraCompraLista(cpf, data, nome_produto, descricao_produto, preco, fornecedor);
			} else {
				criaConta(cpf, fornecedor);
				cadastraCompraLista(cpf, data, nome_produto, descricao_produto, preco, fornecedor);
			}
		} else {
			throw new NullPointerException("Erro ao cadastrar compra: cliente nao existe.");
		}
	}

	/**
	 * cadastra compra na lista de compras do cliente
	 * 
	 * @param cpf               identificador e cpf do cliente
	 * @param data              data da compra
	 * @param nome_produto      nome do produto adquirido
	 * @param descricao_produto descricao do produto adquirido
	 * @param preco             custo da compra
	 * @param fornecedor        nome do fornecedor dos produtos
	 */
	private void cadastraCompraLista(String cpf, String data, String nome_produto, String descricao_produto,
			double preco, String fornecedor) {
		if ((!sistemaFornecedor.haProduto(nome_produto, descricao_produto, fornecedor))
				&& !sistemaFornecedor.haCombo(nome_produto, descricao_produto, fornecedor)) {
			throw new NullPointerException("Erro ao cadastrar compra: produto nao existe.");
		}
		for (Conta conta : contasCadastradas.get(cpf)) {
			if (conta.getFornecedor().toLowerCase().equals(fornecedor.toLowerCase())) {
				conta.cadastraCompra(data, nome_produto, descricao_produto, preco);
			}
		}
	}

	/**
	 * verifica se ha uma conta de um dado cliente com um fornecedor
	 * 
	 * @param fornecedor nome do fornecedor da conta
	 * @param cpf        cpf e identificador do cliente
	 * @return retorna a veracidade da existencia da conta do fornecedor com o
	 *         cliente
	 */
	private boolean haContaFornecedor(String fornecedor, String cpf) {
		for (Conta conta : contasCadastradas.get(cpf)) {
			if ((conta.getFornecedor().toLowerCase()).equals(fornecedor.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * exibe a conta de um dado cliente com um fornecedor
	 * 
	 * @param cpf        identificador e cpf do cliente
	 * @param fornecedor nome do fornecedor da conta
	 * @return nome do cliente + representacao da conta
	 */
	public String exibeContas(String cpf, String fornecedor) {
		validador.validaString("Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.", cpf);
		validador.validaCpfTamanho("Erro ao exibir conta do cliente: cpf invalido.", cpf);
		validador.validaString("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.", fornecedor);
		if (!contasCadastradas.containsKey(cpf)) {
			throw new NullPointerException("Erro ao exibir conta do cliente: cliente nao existe.");
		}
		if (!haFornecedor(fornecedor)) {
			throw new NullPointerException("Erro ao exibir conta do cliente: fornecedor nao existe.");
		}
		for (Conta conta : contasCadastradas.get(cpf)) {
			if ((conta.getFornecedor().toLowerCase()).equals(fornecedor.toLowerCase())) {
				return "Cliente: " + sistemaCliente.getCliente(cpf).getNome() + " | "
						+ conta.toString().substring(0, conta.toString().length() - 3);
			}
		}
		throw new NullPointerException(
				"Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
	}

	private void criaConta(String cpf, String fornecedor) {
		contasCadastradas.get(cpf).add(new Conta(cpf, fornecedor, sistemaCliente.getCliente(cpf).getNome()));
	}

	/**
	 * verifica a existencia de um cliente no sistema de contas
	 * 
	 * @param cpf cpf e identificador do cliente
	 * @return true caso o cliente esteja no sistema, false caso o contrario
	 */
	private boolean haContaCliente(String cpf) {
		return contasCadastradas.containsKey(cpf);
	}

	/**
	 * retorna o debito de uma conta
	 * 
	 * @param cpf        identificador e cpf do cliente
	 * @param fornecedor nome do fornecedor
	 * @return retorna o valor total gasto na conta
	 */
	public String getDebito(String cpf, String fornecedor) {
		double debitoTotal = 0.0;
		validador.validaString("Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.", cpf);
		validador.validaCpfTamanho("Erro ao recuperar debito: cpf invalido.", cpf);
		validador.validaString("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.", fornecedor);
		if (haContaCliente(cpf)) {
			for (Conta conta : contasCadastradas.get(cpf)) {
				if (conta.getFornecedor().equals(fornecedor)) {
					debitoTotal = conta.getDebito();
				}
			}
			if (!haFornecedor(fornecedor)) {
				throw new NullPointerException("Erro ao recuperar debito: fornecedor nao existe.");
			}
			if (debitoTotal == 0) {
				throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
			}
			return String.format("%.2f", debitoTotal).replace(",", ".");
		} else {
			throw new NullPointerException("Erro ao recuperar debito: cliente nao existe.");
		}
	}

	/**
	 * verifica se ha um certo fornecedor no sistema de fornecedores
	 * 
	 * @param fornecedor nome do fornecedor
	 * @return a veracidade da existencia da conta
	 */
	private boolean haFornecedor(String fornecedor) {
		return sistemaFornecedor.haFornecedor(fornecedor);
	}

	// US6 metodos para combos

	/**
	 * adiciona um combo no sistema de produtos
	 * 
	 * @param nome_fornecedor nome do fornecedor
	 * @param nome_combo      nome do combo
	 * @param descricao_combo descricao do combo
	 * @param fator           porcentagem de desconto do preco total
	 * @param produtos        produtos que fazem parte do combo
	 */
	public void cadastraCombo(String nome_fornecedor, String nome_combo, String descricao_combo, double fator,
			String produtos) {
		sistemaFornecedor.cadastraCombo(nome_fornecedor, nome_combo, descricao_combo, fator, produtos);
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
		sistemaFornecedor.editaCombo(nome, descricao, fornecedor, novoFator);
	}

	/**
	 * exibe todas as contas de um dado cliente
	 * 
	 * @param cpf identificador e cpf do cliente
	 * @return listagem em texto das contas do cliente
	 */
	public String exibeContasClientes(String cpf) {
		validador.validaString("Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.", cpf);
		validador.validaCpfTamanho("Erro ao exibir contas do cliente: cpf invalido.", cpf);
		if (!contasCadastradas.containsKey(cpf)) {
			throw new NullPointerException("Erro ao exibir contas do cliente: cliente nao existe.");
		}
		if (contasCadastradas.get(cpf).isEmpty()) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		}
		return listaOrdenado(cpf).substring(0, listaOrdenado(cpf).length() - 3);
	}

	/**
	 * concatena as representacoes das contas em ordem alfabetica dos fornecedores
	 * 
	 * @param cpf identificador e cpf do cliente
	 * @return listagem de todas as contas de um cliente em ordem alfabetica dos
	 *         fornecedores
	 */
	private String listaOrdenado(String cpf) {
		String saida = "Cliente: " + sistemaCliente.getCliente(cpf).getNome() + " | ";
		List<Conta> fornecedoresOrdenados = ordenaFornecedores(cpf);
		for (Conta conta : fornecedoresOrdenados) {
			saida += conta.toString();
		}
		return saida;
	}

	/**
	 * ordena a lista de fornecedores
	 * 
	 * @param cpf identificador e cpf do cliente
	 * @return lista ordenada de clientes
	 */
	public List<Conta> ordenaFornecedores(String cpf) {
		List<Conta> contas = new ArrayList<>();
		contas.addAll(contasCadastradas.get(cpf));
		Collections.sort(contas);
		return contas;
	}

	/**
	 * quita as dividas de um cliente numa dada conta
	 * 
	 * @param cpf        identificador e cpf do cliente
	 * @param fornecedor nome do fornecedor
	 */
	public void realizaPagamento(String cpf, String fornecedor) {
		validador.validaString("Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.", cpf);
		validador.validaCpfTamanho("Erro no pagamento de conta: cpf invalido.", cpf);
		validador.validaString("Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.", fornecedor);
		if (!contasCadastradas.containsKey(cpf)) {
			throw new NullPointerException("Erro no pagamento de conta: cliente nao existe.");
		}
		if (!sistemaFornecedor.haFornecedor(fornecedor)) {
			throw new NullPointerException("Erro no pagamento de conta: fornecedor nao existe.");
		}
		Conta removivel = null;
		for (Conta conta : contasCadastradas.get(cpf)) {
			if (conta.getFornecedor().toLowerCase().equals(fornecedor.toLowerCase())) {
				removivel = conta;
			}
		}
		if (removivel == null) {
			throw new NullPointerException(
					"Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.");
		}
		contasCadastradas.get(cpf).remove(removivel);
	}

	/**
	 * lista Compras com o criterio definido
	 * 
	 * @return lista ordenada pelo criterio
	 */
	public String listarCompras() {
		if(criterioOrdenacao.equals("brunoD+oi&z3h")) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio ainda nao definido pelo sistema.");
		} else if(criterioOrdenacao.equals("Cliente")) {
			
//			(<fornecedor>, <desc_prod>, <data_compra>)
		} else if(criterioOrdenacao.equals("Fornecedor")) {
			
//		<cliente>, <desc_prod>, <data_compra>
		} else if(criterioOrdenacao.equals("Data")) {
			
//			(<cliente>, <fornecedor>, <desc_prod>);
		}
		return null;
	}
	
	private String OrdenaPeloCriterio() {
		String saida = "";
		for(Cliente cliente : ordenaClientes()) {
			
		}
		return saida;
	}
	
	/**
	 * ordena clientes cadastrados, alfabeticamente
	 * 
	 * @return lista ordenada de clientes
	 */
	private List<Cliente> ordenaClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		for(String clienteCpf : contasCadastradas.keySet()) {
			clientes.add(sistemaCliente.getCliente(clienteCpf));
		}
		Collections.sort(clientes);
		return clientes;
	}

	/**
	 * Define um novo criterio de ordenacao
	 * 
	 * @param criterio novo criterio associado
	 */
	public void ordenaPor(String criterio) {
		validador.validaString("Erro na listagem de compras: criterio nao pode ser vazio ou nulo.", criterio);
		if(criterio.equals("Cliente")) {
			this.criterioOrdenacao = "Cliente";
		} else if(criterio.equals("Fornecedor")) {
			this.criterioOrdenacao = "Fornecedor";
		} else if (criterio.equals("Data")) {
			this.criterioOrdenacao = "Data";
		} else {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio nao oferecido pelo sistema.");
		}
	}

}
