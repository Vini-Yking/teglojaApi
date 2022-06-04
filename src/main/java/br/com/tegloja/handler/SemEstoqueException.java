package br.com.tegloja.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class SemEstoqueException extends RuntimeException {

	public SemEstoqueException() {
		super("Sem estoque.");
	}

	public SemEstoqueException(String message) {
		super(message);
	}

}
