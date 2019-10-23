package lab5;

/**
 * @author Bruno Andrade Fernandes - 119110378
 */
public class Produto extends ProdutoGeral {
	/**
	 * cria um produto com os dados recebidos
	 * 
	 * @param nome      nome do produto
	 * @param descricao descricao do produto
	 * @param preco     preco do produto
	 */
	public Produto(String nome, String descricao, double preco) {
		super(nome, descricao, preco);
		validaDados(nome, descricao, preco);
	}

	/**
	 * valida dados passados para a criacao do produto
	 * 
	 * @param nome      nome do produto
	 * @param descricao descricao do produto
	 * @param preco     preco do produto
	 */
	private void validaDados(String nome, String descricao, Double preco) {
		if (nome == null) {
			throw new NullPointerException("nome nao pode ser nulo");
		} else if (nome.equals("")) {
			throw new IllegalArgumentException("nome invalido");
		}
		if (descricao == null) {
			throw new NullPointerException("descricao nao pode ser nulo");
		} else if (descricao.equals("")) {
			throw new IllegalArgumentException("descricao invalido");
		}
	}

	/**
	 * altera o preco do produto, caso valido
	 * 
	 * @param novoPreco novo preco a ser incoporado
	 */
	public void alteraPreco(double novoPreco) {
		if (novoPreco < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
		this.preco = novoPreco;
	}
}