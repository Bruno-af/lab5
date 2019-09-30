package lab5;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Bruno Andrade Fernandes - 119110378
 */
public class IdProduto {
	/**
	 * nome do produto
	 */
	private String nome;
	/**
	 * descricao do produto
	 */
	private String descricao;

	/**
	 * cria identificador de um produto
	 * 
	 * @param nome      nome do produto
	 * @param descricao descricao do porduto
	 */
	public IdProduto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
}
