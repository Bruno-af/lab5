package lab5;

/**
 * @author Bruno Andrade Fernandes - 119110378
 */
public abstract class Comparador implements Comparable<Comparador> {
	/**
	 * nome do fornecedor dos produtos e combos da conta
	 */
	private String fornecedor;

	/**
	 * constroi o comparador de fornecedores
	 * 
	 * @param fornecedor nome do fornecedor
	 */
	public Comparador(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	/**
	 * retorna o nome do fornecedor
	 * 
	 * @return nome do fornecedor
	 */
	public String getFornecedor() {
		return this.fornecedor;
	}

	@Override
	/**
	 * compara dois fornecedores por os seus nomes
	 */
	public int compareTo(Comparador o) {
		return this.getFornecedor().compareTo(o.getFornecedor());
	}
}
