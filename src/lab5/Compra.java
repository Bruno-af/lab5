	package lab5;
	/**
	* Laboratório de Programação 2 - Lab 1
	* 
	* @author Bruno Andrade Fernandes - 119110378
	*/
public class Compra {
	private String data;
	private String nomeProduto;
	private String descricaoProduto;
	private double preco;
	
		public Compra(String data, String nome_produto, String descricao_produto, double preco) {
			this.data = data;
			this.nomeProduto = nome_produto;
			this.descricaoProduto = descricao_produto;
			this.preco = preco;
		}

		public double getPreco() {
			return this.preco;
		}

}
