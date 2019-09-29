package lab5;

import java.util.ArrayList;

public class Fornecedor {
	/**
	 * nome do fornecedor
	 */
	private String nome;
	/**
	 * email do fornecedor
	 */
	private String email;
	/**
	 * telefone do fornecedor
	 */
	private String telefone;
	/**
	 * lista de produtos de um fornecedor
	 */
	private ArrayList<Produto> produtos;

	/**
	 * constroi o fornecedor
	 * 
	 * @param nome     nome do fornecedor
	 * @param email    email do fornecedor
	 * @param telefone telefone do fornecedor
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	/**
	 * representacao textual do fornecedor
	 */
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	/**
	 * edita o email e o telefone do fornecedor
	 * 
	 * @param novoEmail    novo email do fornecedor
	 * @param novoTelefone novo telefone do fornecedor
	 */
	public void editaFornecedor(String novoEmail, String novoTelefone) {
		this.email = novoEmail;
		this.telefone = novoTelefone;
	}
}
