package lab5;

import java.util.HashMap;

/**
 * @author Bruno Andrade Fernandes - 119110378
 */
public class Cliente implements Comparable<Cliente> {
	/**
	 * validador de dados da classe
	 */
	private ValidaDados validador = new ValidaDados();
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
	 * 
	 * @param cpf         cpf a ser analisado
	 * @param nome        nome a ser analisado
	 * @param email       email a ser analisado
	 * @param localizacao localizacao a ser analisada
	 */
	private void validaDado(String cpf, String nome, String email, String localizacao) {
		validador.validaString("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.", cpf);
		validador.validaCpfTamanho("Erro no cadastro do cliente: cpf invalido.", cpf);
		validador.validaString("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", nome);
		validador.validaString("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", email);
		validador.validaString("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", localizacao);
	}

	/**
	 * Altera os dados do cliente, que nao o cpf
	 * 
	 * @param atributo  atributo que se deseja editar
	 * @param novoValor novo valor associado
	 */
	public void editaCliente(String atributo, String novoValor) {
		validador.validaString("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.", atributo);
		validador.validaString("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", novoValor);
		if (atributo.equals("nome")) {
			setNome(novoValor);
		} else if (atributo.equals("email")) {
			setEmail(novoValor);
		} else if (atributo.equals("localizacao")) {
			setLocalizacao(novoValor);
		} else if (atributo.equals("cpf")) {
			throw new IllegalAccessError("Erro na edicao do cliente: cpf nao pode ser editado.");
		} else {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
	}

	/**
	 * edita o local de trabalho do cliente
	 * 
	 * @param novoValor nova local agregado
	 */
	private void setLocalizacao(String novoValor) {
		this.localizacao = novoValor;
	}

	/**
	 * edita o email do cliente
	 * 
	 * @param novoValor novo email associado
	 */
	private void setEmail(String novoValor) {
		this.email = novoValor;
	}

	/**
	 * edita o nome do cliente
	 * 
	 * @param novoValor novo nome associado
	 */
	private void setNome(String novoValor) {
		this.nome = novoValor;
	}

	/**
	 * retorna nome do cliente
	 * 
	 * @return nome do cliente
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * retorna email do cliente
	 * 
	 * @return email do cliente
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * retorna o local de trabalho do cliente
	 * 
	 * @return o local de trabalho do cliente
	 */
	public String getLocalizacao() {
		return this.localizacao;
	}

	/**
	 * retorna cpf do cliente
	 * 
	 * @return cpf do cliente
	 */
	public String getCpf() {
		return this.cpf;
	}

	@Override
	/**
	 * representacao textual padrao de um cliente no formato: nome - local de
	 * trabalho - email
	 */
	public String toString() {
		return getNome() + " - " + getLocalizacao() + " - " + getEmail();
	}

	@Override
	/**
	 * cria codigo unico de um cliente
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	/**
	 * compara dois clientes, inclusive pelo seu cpf
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	/**
	 * compara dois clientes alfabeticamente
	 */
	public int compareTo(Cliente outro) {
		return this.getNome().compareTo(outro.getNome());
	}
}
