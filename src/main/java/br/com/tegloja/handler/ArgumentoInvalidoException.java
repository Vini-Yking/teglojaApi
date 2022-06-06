package br.com.tegloja.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ArgumentoInvalidoException extends RuntimeException {

	public ArgumentoInvalidoException() {
		super("Argumento inválido.");
	}

	public ArgumentoInvalidoException(String message) {
		super(message);
	}

}
