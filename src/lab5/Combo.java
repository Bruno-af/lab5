	package lab5;
	/**
	* Laboratório de Programação 2 - Lab 1
	* 
	* @author Bruno Andrade Fernandes - 119110378
	*/
public class Combo {
	private String nome;
	private String descricao;
	private double fator;
	private double precoOriginal;
	
		public Combo(String nome_combo, String descricao_combo, double fator, double precoOriginal) {
			if(1 < fator | fator < 0) {
				throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
			}
			if(nome_combo == null) {
				throw new NullPointerException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
			} else if(nome_combo.equals("")) {
				throw new IllegalArgumentException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
			}
			this.nome = nome_combo;
			this.descricao = descricao_combo;
			this.fator = fator;
			this.precoOriginal = precoOriginal;
		}

		public double getPreco(){
			return fator * precoOriginal;
		}
}
