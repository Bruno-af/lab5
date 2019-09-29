package lab5;

import java.util.HashMap;

public class CrudFornecedor {
	private HashMap<String, Fornecedor> fornecedores;

	// Como administrador do sistema, quero adicionar, recuperar, editar ou apagar
	// fornecedores.

	/**
	 * Constroi sistema de fornecedores
	 */
	public CrudFornecedor() {
		this.fornecedores = new HashMap<>();
	}

	/**
	 * cadastra um fornecedor no sistema de armazenamento
	 * 
	 * @param nome     nome e identificador do fornecedor
	 * @param email    email do fornecedor
	 * @param telefone telefone do fornecedor
	 * @return o nome do fornecedor, caso bem sucedido, ou lanca um erro
	 *         IllegalArgumentException caso ja tenha sido cadastrado
	 */
	public String cadastraFornecedor(String nome, String email, String telefone) {
		if (haFornecedor(nome)) {
			throw new IllegalArgumentException("Fornecedor ja cadastrado");
		}
		fornecedores.put(nome, new Fornecedor(nome, email, telefone));
		return nome;
	}

	/**
	 * retorna representacao textual de um dado fornecedor
	 * 
	 * @param nome nome e identificador do fornecedor
	 * @return representacao textual do fornecedor
	 */
	public String retornaFornecedor(String nome) {
		return fornecedores.get(nome).toString();
	}

	/**
	 * verifica a existencia previa de algum fornecedor
	 * 
	 * @param nome identificador do fornecedor
	 * @return true se ja houver um fornecedor com o dado nome, falso caso contrario
	 */
	private boolean haFornecedor(String nome) {
		if (fornecedores.containsKey(nome)) {
			return true;
		}
		return false;
	}

	/**
	 * lista a representacao textual de todos os fornecedores cadastrados
	 * 
	 * @return representacao textual da listagem dos fornecedores
	 */
	public String listarFornecedores() {
		String saida = "";
		for (Fornecedor fornecedor : fornecedores.values()) {
			saida += fornecedor.toString() + " | ";
		}
		return saida.substring(0, saida.length() - 4);
	}

	/**
	 * edita dados do fornecedor
	 * 
	 * @param nome     identificador imutavel do fornecedor
	 * @param email    novo email do fornecedor
	 * @param telefone novo telefone do fornecedor
	 */
	public void editaFornecedor(String nome, String email, String telefone) {
		fornecedores.get(nome).editaFornecedor(email, telefone);
	}

	/**
	 * deleta um fornecedor do sistema
	 * 
	 * @param nome identificador do fornecedor
	 */
	public void deletaFornecedor(String nome) {
		fornecedores.remove(nome);
	}
}
