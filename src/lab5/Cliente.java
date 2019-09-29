package lab5;

public class Cliente {
	/**
	 * cpf e identificador unico de um cliente
	 */
	private String cpf;
	/**
	 * nome do cliente
	 */
	private String nome;
	/**
	 * email do cliente
	 */
	private String email;
	/**
	 * local de trabalho do cliente
	 */
	private String localizacao;

	/**
	 * Cria o cliente com os dados parametros
	 * 
	 * @param cpf         cpf do cliente
	 * @param nome        nome do cliente
	 * @param email       email do cliente
	 * @param localizacao local de trabalho do cliente
	 */
	public Cliente(String cpf, String nome, String email, String localizacao) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}

	/**
	 * Altera os dados do cliente, que nao o cpf
	 * 
	 * @param nome        novo nome do cliente
	 * @param email       novo email do cliente
	 * @param localizacao novo localizacao do cliente
	 */
	public void editaCliente(String nome, String email, String localizacao) {
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}

	@Override
	/**
	 * representacao textual padrao de um cliente no formato: nome - local de
	 * trabalho - email
	 */
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}
}
