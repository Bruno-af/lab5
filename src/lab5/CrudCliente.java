package lab5;

import java.util.HashMap;

public class CrudCliente {
	/**
	 * colecao de armazenamento dos clientes cadastrados
	 */
	private HashMap<String, Cliente> clientesCadastrados;

	/**
	 * Construtor do sistema de Clientes
	 */
	public CrudCliente() {
		this.clientesCadastrados = new HashMap<>();
	}

	/**
	 * Cadastra um cliente caso não cadastrado, caso contrario lanca um erro
	 * 
	 * @param cpf         identificador do cliente
	 * @param nome        nome do cliente
	 * @param email       email do cliente
	 * @param localizacao local de trabalho do cliente
	 * @return cpf do cliente caso o cadastro funcione, IllegalArgumentException
	 *         caso ja havia sido cadastrado
	 */
	public String cadastraCliente(String cpf, String nome, String email, String localizacao) {
		if (haCliente(cpf)) {
			throw new IllegalArgumentException("Cliente ja cadastrado");
		}
		clientesCadastrados.put(cpf, new Cliente(cpf, nome, email, localizacao));
		return cpf;
	}

	/**
	 * retorna a representacao textual padrao de um dado cliente especifico
	 * 
	 * @param cpf identificador do cliente
	 * @return representacao textual padrao de um cliente
	 */
	public String RepresentacaoCliente(String cpf) {
		if (!haCliente(cpf)) {
			throw new NullPointerException("Cliente nao cadastrado");
		}
		return clientesCadastrados.get(cpf).toString();
	}

	/**
	 * lista todos os clientes cadastrados na forma de sua representacao textual
	 * 
	 * @return texto da listagem
	 */
	public String listaClientes() {
		String saida = "";
		for (Cliente cliente : clientesCadastrados.values()) {
			saida += cliente.toString() + " | ";
		}
		if(saida.contentEquals("")) {
			throw new NullPointerException("Nao ha clientes cadastrados");
		}
		return saida.substring(0, saida.length() - 3);
	}

	/**
	 * Edita os dados do cliente, exeto o cpf(imutavel)
	 * 
	 * @param cpf         identificador do cliente
	 * @param nome        novo nome do cliente
	 * @param email       novo email do cliente
	 * @param localizacao novo local de trabalho do cliente
	 */
	public void editarCliente(String cpf, String nome, String email, String localizacao) {
		if(haCliente(cpf)) {
			clientesCadastrados.get(cpf).editaCliente(nome, email, localizacao);			
		} else {
			throw new NullPointerException("Cliente nao cadastrado");
		}
	}

	/**
	 * deleta o cliente que possui o cpf recebido
	 * @param cpf
	 */
	public void deletarCliente(String cpf) {
		if(haCliente(cpf)) {
			clientesCadastrados.remove(cpf);			
		} else {
			throw new NullPointerException("Cliente nao cadastrado");
		}
	}

	/**
	 * metodo que verifica a existencia de um cliente no sistema
	 * 
	 * @param cpf identificador do cliente
	 * @return se o cliente estiver cadastrado, true, senão, false
	 */
	private boolean haCliente(String cpf) {
		if (clientesCadastrados.containsKey(cpf)) {
			return true;
		} else {
			return false;
		}
	}

}
