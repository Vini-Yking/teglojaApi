package br.com.tegloja.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EnumValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnumValidationException() {
		super("Pagamento invalido");
		// TODO Auto-generated constructor stub
	}

	public EnumValidationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EnumValidationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
