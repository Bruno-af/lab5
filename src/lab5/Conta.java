	package lab5;

import java.util.ArrayList;
import java.util.List;

/**
	* Laboratório de Programação 2 - Lab 1
	* 
	* @author Bruno Andrade Fernandes - 119110378
	*/
public class Conta {
	
	private List<Compra> comprasCadastradas;
	
		public Conta(String data, String nome_produto, String descricao_produto, double preco) {
			comprasCadastradas = new ArrayList<>();
		}

		public void cadastraCompra(String data, String nome_produto, String descricao_produto, double preco) {
			comprasCadastradas.add(new Compra(data, nome_produto, descricao_produto, preco));
		}

		public double getDebito() {
			double debito = 0;
			for (Compra compra : comprasCadastradas) {
				debito += compra.getPreco();
			}
			return debito;
		}

}
