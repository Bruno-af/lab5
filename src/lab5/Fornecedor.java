package lab5;

public class Fornecedor {
	private String nome;
	private String email;
	private String telefone;
	
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
	public void setEmail(String novoEmail) {
		this.email = novoEmail;
	}
	
	public void setTelefone(String novoTelefone) {
		this.telefone = novoTelefone;
	}
	
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}
}
