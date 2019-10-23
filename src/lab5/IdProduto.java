package lab5;

/**
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
	 * validador de dados da classe
	 */
	private ValidaDados validador = new ValidaDados();

	/**
	 * cria identificador de um produto
	 * 
	 * @param nome      nome do produto
	 * @param descricao descricao do porduto
	 */
	public IdProduto(String nome, String descricao) {
		validaDado(nome, descricao);
		this.nome = nome;
		this.descricao = descricao;
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
		validador.validaString("Erro no cadastro de produto: nome nao pode ser vazia ou nula.", nome);
		validador.validaString("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", descricao);
		return true;
	}

	/**
	 * cria um id para um dado produto. Lestras maiusculas e minusculas sao
	 * consideradas iguais
	 * 
	 * @return id em forma de texto
	 */
	public String retornaId() {
		return ((this.nome + this.descricao).toLowerCase());
	}
}
