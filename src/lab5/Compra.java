package lab5;

/**
 * @author Bruno Andrade Fernandes - 119110378
 */
public class Compra {
	/**
	 * data da compra
	 */
	private String data;
	/**
	 * nome do produto ou combo adquirido
	 */
	private String nomeProduto;
	/**
	 * descricao do produto ou combo adquirido
	 */
	private String descricaoProduto;
	/**
	 * preco pago na compra
	 */
	private double preco;

	/**
	 * cria a compra
	 * 
	 * @param data              data da compra
	 * @param nome_produto      nome do produto adquirido
	 * @param descricao_produto descricao do produto adquirido
	 * @param preco             preco da compra
	 */
	public Compra(String data, String nome_produto, String descricao_produto, double preco) {
		this.data = data;
		this.nomeProduto = nome_produto;
		this.descricaoProduto = descricao_produto;
		this.preco = preco;
	}

	/**
	 * retorna o preco da compra
	 * 
	 * @return preco da compra
	 */
	public double getPreco() {
		return this.preco;
	}

	/**
	 * retorna a data da compra
	 * 
	 * @return data da compra
	 */
	public String getData() {
		return this.data;
	}

	/**
	 * retorna o nome do produto adquirido
	 * 
	 * @return nome do produto adquirido
	 */
	public String getNome() {
		return this.nomeProduto;
	}

	/**
	 * retorna a descricao do produto adquirido
	 * 
	 * @return descricao do produto adquirido
	 */
	public String getDescricao() {
		return this.descricaoProduto;
	}

	@Override
	/**
	 * representacao textual padrao da compra no formato: nome do produto - data
	 */
	public String toString() {
		return (this.nomeProduto + " - " + this.data).replace("/", "-");
	}
}
