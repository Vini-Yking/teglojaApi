package br.com.tegloja.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NaoEncontradoException() {
		super("Não encontrado");

		// TODO Auto-generated constructor stub
	}

	public NaoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NaoEncontradoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NaoEncontradoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
