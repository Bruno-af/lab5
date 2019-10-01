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
		validaDado(cpf, nome, email, localizacao);
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}

	/**
	 * verifica a validade dos dados passados
	 * @param cpf cpf a ser analisado
	 * @param nome nome a ser analisado
	 * @param email email a ser analisado
	 * @param localizacao localizacao a ser analisada
	 */
	private void validaDado(String cpf, String nome, String email, String localizacao) {
		if (cpf.equals("")) {
			throw new IllegalArgumentException("cpf invalido");
		}
		if (cpf == null) {
			throw new NullPointerException("cpf n�o pode ser nulo");
		}
		if (nome.equals("")) {
			throw new IllegalArgumentException("nome invalido");
		}
		if (nome == null) {
			throw new NullPointerException("nome n�o pode ser nulo");
		}
		if (email.equals("")) {
			throw new IllegalArgumentException("email invalido");
		}
		if (email == null) {
			throw new NullPointerException("email n�o pode ser nulo");
		}
		if (localizacao.equals("")) {
			throw new IllegalArgumentException("localizacao invalida");
		}
		if (localizacao == null) {
			throw new NullPointerException("localizacao n�o pode ser nula");
		}
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
