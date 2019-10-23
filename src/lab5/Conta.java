package lab5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Andrade Fernandes - 119110378
 */
public class Conta extends Comparador {
	/**
	 * lista de compras feitas na conta
	 */
	private List<Compra> comprasCadastradas;
	/**
	 * cpf do cliente dono da conta
	 */
	private String cpfCliente;
	/**
	 * nome do cliente dono da conta
	 */
	private String nomeCliente;

	/**
	 * Constroi a conta
	 * 
	 * @param cpfCliente  cpf do cliente dono da conta
	 * @param fornecedor  nome do fornecedor da conta
	 * @param nomeCliente nome do cliente dono da conta
	 */
	public Conta(String cpfCliente, String fornecedor, String nomeCliente) {
		super(fornecedor);
		this.cpfCliente = cpfCliente;
		this.nomeCliente = nomeCliente;
		comprasCadastradas = new ArrayList<>();
	}

	/**
	 * cadastra uma compra na conta
	 * 
	 * @param data              data da compra
	 * @param nome_produto      nome do produto adquirido
	 * @param descricao_produto descricao do produto adquirido
	 * @param preco             preco da compra
	 */
	public void cadastraCompra(String data, String nome_produto, String descricao_produto, double preco) {
		comprasCadastradas.add(new Compra(data, nome_produto, descricao_produto, preco));
	}

	/**
	 * calcula o gasto total na conta, somando todas as compras
	 * 
	 * @return gasto total da conta
	 */
	public double getDebito() {
		double debito = 0;
		for (Compra compra : comprasCadastradas) {
			debito += compra.getPreco();
		}
		return debito;
	}

	/**
	 * retorna o cpf do cliente dono da conta
	 * 
	 * @return cpf do cliente
	 */
	public String getCpfCliente() {
		return this.cpfCliente;
	}

	@Override
	/**
	 * representacao textual padrao da conta no formato: nome do fornecedor |
	 * representacao textual de cada compra na conta
	 */
	public String toString() {
		// Cliente: Amigao Fernandes | Marcos | Coxao com batata - 03-12-2013 |
		// Refrigerante - 03-06-2017
		return super.getFornecedor() + " | " + listaCompras();
	}

	/**
	 * representacao textual da lista de compras cadastradas
	 * 
	 * @return listagem das representacoes textuais das compras cadastradas
	 */
	public String listaCompras() {
		String compras = "";
		for (Compra compra : comprasCadastradas) {
			compras += compra.toString() + " | ";
		}
		return compras;
	}

	/**
	 * compara duas contas quanto ao seu nome
	 * 
	 * @param other a conta a ser comparada
	 * @return compareTo das strings correspondentes ao nome do fornecedor
	 */
	public int compareTo(Conta other) {
		return this.getFornecedor().compareTo(other.getFornecedor());
	}
}