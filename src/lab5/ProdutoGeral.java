package lab5;

public abstract class ProdutoGeral implements Comparable<ProdutoGeral> {
	protected double preco;
	private String nome;
	private String descricao;

	public ProdutoGeral(String nome, String descricao, double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	@Override
	/**
	 * Representacao textual de um produto
	 */
	public String toString() {
		return String.format("%s - %s - R$%.2f", this.nome, this.descricao, this.preco);
	}

	@Override
	/**
	 * compara outros produtos
	 */
	public int compareTo(ProdutoGeral o) {
		if(getNome().equals(o.getNome())) {
			return (getDescricao().compareTo(o.getDescricao()));
		}
		return (getNome()).compareTo(o.getNome());
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * retorna o preco do produto
	 */
	public double getPreco() {
		return this.preco;
	}
}
