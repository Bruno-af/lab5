package lab5;

/**
 * @author Bruno Andrade Fernandes - 119110378
 */
public class Combo extends ProdutoGeral {
	/**
	 * validador de dados da classe
	 */
	ValidaDados validador = new ValidaDados();
	/**
	 * desconto em porcentagem do valor original do combo
	 */
	private double fator;
	/**
	 * nome do fornecedor do combo
	 */
	private String fornecedor;

	/**
	 * Construtor do combo
	 * 
	 * @param nome_combo      nome do produto combo
	 * @param descricao_combo descricao do produto combo
	 * @param fator           porcentagem de desconto em relacao ao preco original
	 *                        dos produtos que o forma
	 * @param precoOriginal   soma dos precos dos produtos que compoe o combo
	 * @param fornecedor      nome do fornecedor do combo
	 */
	public Combo(String nome_combo, String descricao_combo, double fator, double precoOriginal, String fornecedor) {
		super(nome_combo, descricao_combo, precoOriginal);
		if (1 <= fator || fator <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}
		validador.validaString("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.", nome_combo);
		this.fator = fator;
		this.fornecedor = fornecedor;
	}

	@Override
	/**
	 * retorna o preco do produto
	 */
	public double getPreco() {
		return preco - (preco * fator);
	}

	/**
	 * edita o fator de desconto do combo
	 * 
	 * @param novoFator novo fator de desconto
	 */
	public void editaCombo(double novoFator) {
		if (novoFator > 0 && novoFator < 1) {
			this.fator = novoFator;
		} else {
			throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
		}
	}

	@Override
	/**
	 * representacao textual padrao do combo no formato: nome - descricao - preco
	 */
	public String toString() {
		return String.format("%s - %s - R$%.2f", getNome(), getDescricao(), getPreco());
	}
}
