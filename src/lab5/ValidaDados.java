package lab5;

public class ValidaDados {

	public ValidaDados() {
	}

	/**
	 * valida entradas qunato a nulidade e o estado vazio
	 * 
	 * @param msg mensagem de erro possivel
	 * @param str texto a ser verificado
	 */
	public void validaString(String msg, String str) {
		if (str == null) {
			throw new NullPointerException(msg);
		} else if (str.equals("")) {
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * valida o cpf passado
	 * 
	 * @param msg mensagem de erro possivel
	 * @param cpf cpf a ser verificado
	 */
	public void validaCpfTamanho(String msg, String cpf) {
		if (cpf.length() != 11) {
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * valida formatacao da data
	 * 
	 * @param msg  mensagem de possivel erro de formatacao
	 * @param data data a ser validada
	 */
	public void validaData(String msg, String data) {
		String[] partes = data.split("/");
		if (Integer.parseInt(partes[0]) <= 0 || Integer.parseInt(partes[0]) > 31) {
			throw new IllegalArgumentException(msg);
		} else if (Integer.parseInt(partes[1]) <= 0 || Integer.parseInt(partes[1]) > 12) {
			throw new IllegalArgumentException(msg);
		}
	}
}
