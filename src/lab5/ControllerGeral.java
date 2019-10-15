package lab5;

import java.util.ArrayList;
import java.util.HashMap;

public class ControllerGeral {
	private CrudCliente sistemaCliente;
	private CrudFornecedor sistemaFornecedor;
	private HashMap<String, ArrayList<Conta>> contasCadastradas;

	public ControllerGeral() {
		this.sistemaCliente = new CrudCliente();
		this.sistemaFornecedor = new CrudFornecedor();
		this.contasCadastradas = new HashMap<String, ArrayList<Conta>>();
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
		if (cpf == null) {
			throw new NullPointerException("fornecedor cadastracompra cpf nul");
		} else if (cpf.equals("")) {
			throw new IllegalArgumentException("fornecedor cadastracompra cpf vazi");
		} else if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
		}
		if (fornecedor == null) {
			throw new NullPointerException("fornecedor cadastracompra fornecedor nul");
		} else if (fornecedor.equals("")) {
			throw new IllegalArgumentException("fornecedor cadastracompra fornecedor vazio");
		}
		if (nome_produto == null) {
			throw new NullPointerException("fornecedor cadastracompra nome nul");
		} else if (nome_produto.equals("")) {
			throw new IllegalArgumentException("fornecedor cadastracompra nome vazi");
		}
		if (descricao_produto == null) {
			throw new NullPointerException("fornecedor cadastracompra descri nul");
		} else if (descricao_produto.equals("")) {
			throw new IllegalArgumentException("fornecedor cadastracompra descri vazi");
		}
		if (haContaCliente(cpf)) {
			if (haContaFornecedor(fornecedor, cpf)) {
				cadastraCompraLista(cpf, data, nome_produto, descricao_produto,
						sistemaFornecedor.getPreco(fornecedor, nome_produto, descricao_produto), fornecedor);
			} else {
				criaConta(cpf, data, nome_produto, descricao_produto);
				cadastraCompraLista(cpf, data, nome_produto, descricao_produto,
						sistemaFornecedor.getPreco(fornecedor, nome_produto, descricao_produto), fornecedor);
			}
		} else {
			throw new NullPointerException("Erro ao cadastrar compra: cliente nao existe.");
		}
	}

	private void cadastraCompraLista(String cpf, String data, String nome_produto, String descricao_produto,
			double preco, String fornecedor) {
		for (Conta conta : contasCadastradas.get(cpf)) {
			if (conta.getFornecedor().equals(fornecedor)) {
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
			if (conta.getFornecedor().equals(fornecedor)) {
				return true;
			}
		}
		return false;
	}
//
//	private void cadastraCompraLista(String cpf, String data, String nome_produto, String descricao_produto, double preco, String fornecedor) {
//		contasCadastradas.get(cpf).add();
//	}

	private void criaConta(String cpf, String data, String nome_produto, String descricao_produto) {
		contasCadastradas.get(cpf).add(new Conta(data, nome_produto, descricao_produto, cpf));
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
		if (contasCadastradas.containsKey(cpf)) {
			return true;
		}
		return false;
	}

	public double getDebito(String cpf, String fornecedor) {
		double debitoTotal = 0.0;
		if (cpf == null) {
			throw new NullPointerException("fornecedor getdebito cpf nul");
		} else if (cpf.equals("")) {
			throw new IllegalArgumentException("fornecedor getdebito cpf vazi");
		}
		if (fornecedor == null) {
			throw new NullPointerException("fornecedor getdebito fornecedor nul");
		} else if (fornecedor.equals("")) {
			throw new IllegalArgumentException("fornecedor getdebito fornecedor vazi");
		}
		if (haContaCliente(cpf)) {
			for (Conta conta : contasCadastradas.get(cpf)) {
				if (conta.getFornecedor().equals(fornecedor)) {
					debitoTotal = conta.getDebito();
				}
			}
			return debitoTotal;
		} else {
			throw new NullPointerException("getDebito n ha conta");
		}
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
