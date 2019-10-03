package lab5;

/**
 * Laborat�rio de Programa��o 2 - Lab 1
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
		if (validaDado(nome, descricao)) {
			this.nome = nome;
			this.descricao = descricao;
		}
	}

	/**
	 * valida os parametros passados
	 * 
	 * @param nome      nome do produto
	 * @param descricao descricao do produto
	 * @return lanca o devido erro caso algum for nulo ou vazio, caso contrario,
	 *         true
	 */
	private boolean validaDado(String nome, String descricao) {
		if (nome == null) {
			throw new NullPointerException("nome nao pode ser nulo");
		} else if (nome.equals("")) {
			throw new IllegalArgumentException("nome nao pode ser vazio");
		}
		if (descricao == null) {
			throw new NullPointerException("descricao nao pode ser nula");
		} else if (descricao.equals("")) {
			throw new IllegalArgumentException("descricao nao pode ser vazia");
		}
		return true;
	}

	/**
	 * cria um id para um dado produto. Lestras maiusculas e minusculas sao
	 * consideradas iguais
	 * 
	 * @return id em forma de texto.
	 */
	public String retornaId() {
		return (this.nome + this.descricao).toLowerCase();
	}
}
