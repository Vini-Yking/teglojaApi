package br.com.tegloja.handler;

public class DuplicateKeyException extends RuntimeException {

	public DuplicateKeyException(String message) {
		super(message);
	}

}
