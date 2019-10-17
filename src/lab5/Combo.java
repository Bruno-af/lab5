	package lab5;
	/**
	* Laborat�rio de Programa��o 2 - Lab 1
	* 
	* @author Bruno Andrade Fernandes - 119110378
	*/
public class Combo extends ProdutoGeral{
	private double fator;
	private String fornecedor;
	
		public Combo(String nome_combo, String descricao_combo, double fator, double precoOriginal, String fornecedor) {
			super(nome_combo, descricao_combo, precoOriginal);
			if(1 <= fator || fator <= 0) {
				throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
			}
			if(nome_combo == null) {
				throw new NullPointerException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
			} else if(nome_combo.equals("")) {
				throw new IllegalArgumentException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
			}
			this.fator = fator;
			this.fornecedor = fornecedor;
		}
		
		@Override
		/**
		 * retorna o preco do produto
		 */
		public double getPreco(){
			//System.out.println(precoOriginal + "  " + fator);
			return preco - (preco * fator); 
		}

		public void editaCombo(double novoFator) {
			if(novoFator > 0 && novoFator < 1) {
				this.fator = novoFator;
			} else {
				throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
			}
		}
		
		@Override
		public String toString() {
			return String.format("%s - %s - R$%.2f", getNome(), getDescricao(), getPreco());
			// precisa formatar o preco para duas casas decimais
		}
}
