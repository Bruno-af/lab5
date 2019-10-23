package lab5;

/**
 * @author Bruno Andrade Fernandes - 119110378
 */
public abstract class ProdutoGeral implements Comparable<ProdutoGeral> {
	/**
	 * preco do produto
	 */
	protected double preco;
	/**
	 * nome do produto
	 */
	private String nome;
	/**
	 * descricao do produto
	 */
	private String descricao;

	/**
	 * construtor do produto
	 * 
	 * @param nome      nome do produto
	 * @param descricao descricao do produto
	 * @param preco     preco do produto
	 */
	public ProdutoGeral(String nome, String descricao, double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	@Override
	/**
	 * retorna representacao textual de um produto
	 */
	public String toString() {
		return String.format("%s - %s - R$%.2f", this.nome, this.descricao, this.preco);
	}

	@Override
	/**
	 * compara outros produtos alfabeticamente
	 */
	public int compareTo(ProdutoGeral o) {
		if (getNome().equals(o.getNome())) {
			return (getDescricao().compareTo(o.getDescricao()));
		}
		return (getNome()).compareTo(o.getNome());
	}

	/**
	 * retorna o nome do produto
	 * 
	 * @return nome do produto
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * retorna a descricao do produto
	 * 
	 * @return descricao do produto
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * retorna o preco do produto
	 * 
	 * @return preco do produto
	 */
	public double getPreco() {
		return this.preco;
	}
}
