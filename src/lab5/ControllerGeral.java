package lab5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ControllerGeral {
	private CrudCliente sistemaCliente;
	private CrudFornecedor sistemaFornecedor;
	private HashMap<String, List<Conta>> contasCadastradas;
	private ValidaDados validador;

	public ControllerGeral() {
		this.sistemaCliente = new CrudCliente();
		this.sistemaFornecedor = new CrudFornecedor();
		this.contasCadastradas = new HashMap<String, List<Conta>>();
		this.validador = new ValidaDados();
	}

	// US1 comandos administrador/cliente

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
	 * delublic class Facade {eta um dado produto do sistema de um fornecedor
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
	 * cadastra compra
	 * 
	 * @param cpf               cpf e identificador do cliente
	 * @param fornecedor        nome do fornecedor do produto
	 * @param data              data da compra
	 * @param nome_produto      nome do produto comprado
	 * @param descricao_produto descricao do produto comprado
	 */
	public void cadastraCompra(String cpf, String fornecedor, String data, String nome_produto,
			String descricao_produto) {
		ValidaDados validador = new ValidaDados();
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
	 * verifica se ha um fornecedor
	 * 
	 * @param fornecedor fornecedor da conta
	 * @param cpf        cpf e identificador do cliente
	 * @return se torna a veracidade da existencia do cliente no cadastro
	 */
	private boolean haContaFornecedor(String fornecedor, String cpf) {
		for (Conta conta : contasCadastradas.get(cpf)) {
			if ((conta.getFornecedor().toLowerCase()).equals(fornecedor.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
//
//	private void cadastraCompraLista(String cpf, String data, String nome_produto, String descricao_produto, double preco, String fornecedor) {
//		contasCadastradas.get(cpf).add();
//	}

	private void criaConta(String cpf, String fornecedor) {
		contasCadastradas.get(cpf).add(new Conta(cpf, fornecedor));
	}
//
//	private Cliente getCliente(String cpf, String nome_produto, String descricao_produto) {
//		return sistemaCliente.getCliente(cpf);
//	}

	/**
	 * verifica a existencia da conta de um cliente
	 * 
	 * @param cpf cpf e identificador do cliente
	 * @return true caso o cliente possua uma conta, false caso o contrario
	 */
	private boolean haContaCliente(String cpf) {
		return contasCadastradas.containsKey(cpf);
	}

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
			return String.format("%.2f", debitoTotal);
		} else {
			throw new NullPointerException("Erro ao recuperar debito: cliente nao existe.");
		}
	}

	private boolean haFornecedor(String fornecedor) {
		return sistemaFornecedor.haFornecedor(fornecedor);
	}

	// US6 metodos para combos

	/**
	 * adiciona um combo
	 * 
	 * @param nome_fornecedor nome do fornecedor
	 * @param nome_combo      nome do combo
	 * @param descricao_combo descricao do combo
	 * @param fator           porcentagem do preco original cobrado no combo
	 * @param produtos        produtos que fazem parte do combo
	 */
	public void cadastraCombo(String nome_fornecedor, String nome_combo, String descricao_combo, double fator,
			String produtos) {
		sistemaFornecedor.cadastraCombo(nome_fornecedor, nome_combo, descricao_combo, fator, produtos);
	}

	/**
	 * edita o desconto de um combo
	 * 
	 * @param nome       nome do combo
	 * @param descricao  descricao do combo
	 * @param fornecedor fornecedor do combo
	 * @param novoFator  novo fator do preco do combo
	 */
	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		sistemaFornecedor.editaCombo(nome, descricao, fornecedor, novoFator);
	}

}
