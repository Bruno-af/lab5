package lab5;

public class Produto implements Comparable<Produto> {
	private double preco;
	private String nome;
	private String descricao;

	/**
	 * cria um produto com os dados recebidos
	 * 
	 * @param nome      nome do produto
	 * @param descricao descricao do produto
	 * @param preco     preco do produto
	 */
	public Produto(String nome, String descricao, double preco) {
		validaDados(nome, descricao, preco);
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	private void validaDados(String nome, String descricao, Double preco) {
		if (nome == null) {
			throw new NullPointerException("nome não pode ser nulo");
		} else if (nome.equals("")) {
			throw new IllegalArgumentException("nome invalido");
		}
		if (descricao == null) {
			throw new NullPointerException("descricao nï¿½o pode ser nulo");
		}else if (descricao.equals("")) {
			throw new IllegalArgumentException("descricao invalido");
		}
	}

	@Override
	/**
	 * Representacao textual de um produto
	 */
	public String toString() {
		return String.format("%s - %s - R$%.2f",this.nome, this.descricao, this.preco);
	}

	/**
	 * altera o preco do produto
	 * 
	 * @param novoPreco novo preco a ser incoporado
	 */
	public void alteraPreco(double novoPreco) {
		if(novoPreco<0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
		this.preco = novoPreco;
	}

	@Override
	public int compareTo(Produto o) {
		return (this.nome + this.descricao).compareTo(o.nome + o.descricao);
	}

	public double getPreco() {
		return this.preco;
	}
}