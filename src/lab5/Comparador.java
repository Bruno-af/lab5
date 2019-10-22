	package lab5;
	/**
	* Laboratório de Programação 2 - Lab 1
	* 
	* @author Bruno Andrade Fernandes - 119110378
	*/
public abstract class Comparador implements Comparable<Comparador> {
	/**
	 * fornecedor dos produtos e combos da conta
	 */
	private String fornecedor;
	
	/**
	 * constroi o comparador
	 */
	public Comparador(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public String getFornecedor() {
		return this.fornecedor;
	}
	
	@Override
	public int compareTo(Comparador o) {
		return this.getFornecedor().compareTo(o.getFornecedor());
	}
}
