package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author Bruno Andrade Fernandes - 119110378
 */
public class CrudCliente {
	/**
	 * colecao de armazenamento dos clientes cadastrados
	 */
	private HashMap<String, Cliente> clientesCadastrados;
	/**
	 * validador de dados da classe
	 */
	private ValidaDados validador = new ValidaDados();

	/**
	 * Construtor do sistema de Clientes
	 */
	public CrudCliente() {
		this.clientesCadastrados = new HashMap<>();
	}

	/**
	 * Cadastra um cliente caso nao cadastrado, caso contrario lanca um erro
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
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
		clientesCadastrados.put(cpf, new Cliente(cpf, nome, email, localizacao));
		return cpf;
	}

	/**
	 * retorna a representacao textual padrao de um dado cliente
	 * 
	 * @param cpf identificador e cpf do cliente
	 * @return representacao textual padrao de um cliente
	 */
	public String RepresentacaoCliente(String cpf) {
		validador.validaString("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.", cpf);
		if (!haCliente(cpf)) {
			throw new NullPointerException("Erro na exibicao do cliente: cliente nao existe.");
		}
		return clientesCadastrados.get(cpf).toString();
	}

	/**
	 * lista todos os clientes cadastrados na forma de sua representacao textual
	 * 
	 * @return listagem em forma de texto
	 */
	public String listaClientes() {
		String saida = "";
		List<Cliente> clientesOrdenados = new ArrayList<>(this.clientesCadastrados.values());
		Collections.sort(clientesOrdenados);
		for (Cliente atual : clientesOrdenados) {
			saida += atual.toString() + " | ";
		}
		validador.validaString("Nao ha clientes cadastrados", saida);
		return saida.substring(0, saida.length() - 3);
	}

	/**
	 * Edita os dados do cliente, exeto o cpf(imutavel)
	 * 
	 * @param cpf         identificador e cpf do cliente
	 * @param nome        novo nome do cliente
	 * @param email       novo email do cliente
	 * @param localizacao novo local de trabalho do cliente
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		validador.validaString("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.", cpf);
		if (haCliente(cpf)) {
			clientesCadastrados.get(cpf).editaCliente(atributo, novoValor);
		} else {
			throw new NullPointerException("Erro na edicao do cliente: cliente nao existe.");
		}
	}

	/**
	 * deleta um dado cliente
	 * 
	 * @param cpf identificador e cpf do cliente
	 */
	public void deletarCliente(String cpf) {
		validador.validaString("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo", cpf);
		if (haCliente(cpf)) {
			clientesCadastrados.remove(cpf);
		} else {
			throw new NullPointerException("Erro na remocao do cliente: cliente nao existe.");
		}
	}

	/**
	 * metodo que verifica a existencia de um cliente no sistema
	 * 
	 * @param cpf identificador do cliente
	 * @return se o cliente estiver cadastrado, true, sen�o, false
	 */
	private boolean haCliente(String cpf) {
		if (clientesCadastrados.containsKey(cpf)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * retorna um cliente cadastrado
	 * 
	 * @param cpf identificador e cpf do cliente
	 * @return cliente que possui o cpf
	 */
	public Cliente getCliente(String cpf) {
		if (clientesCadastrados.containsKey(cpf)) {
			return clientesCadastrados.get(cpf);
		} else {
			throw new NullPointerException("CrudCliente get cliente");
		}

	}

}
