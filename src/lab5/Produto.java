package lab5;

public class Produto {
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
		if (nome.equals("")) {
			throw new IllegalArgumentException("nome invalido");
		}
		if (nome == null) {
			throw new NullPointerException("nome n�o pode ser nulo");
		}
		if (descricao.equals("")) {
			throw new IllegalArgumentException("descricao invalido");
		}
		if (descricao == null) {
			throw new NullPointerException("descricao n�o pode ser nulo");
		}
		if (preco == null) {
			throw new NullPointerException("preco n�o pode ser nulo");
		}
	}

	@Override
	/**
	 * Representacao textual de um produto
	 */
	public String toString() {
		return this.nome + " - " + this.descricao + " - R$" + this.preco;
	}

	/**
	 * altera o preco do produto
	 * 
	 * @param novoPreco novo preco a ser incoporado
	 */
	public void alteraPreco(double novoPreco) {
		this.preco = novoPreco;

	}
}