	package lab5;

/**
	* Laboratório de Programação 2 - Lab 1
	* 
	* @author Bruno Andrade Fernandes - 119110378
	*/
public class Main {
	public void main(String[] args) {
		Facade a = new Facade();
		a.adicionaCliente("11111111111", "nome", "email", "localizacao");
		a.exibeCliente("11111111111");
		a.listaClientes();
	}
}
