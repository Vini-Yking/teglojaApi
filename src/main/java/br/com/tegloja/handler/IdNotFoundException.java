package br.com.tegloja.handler;

public class ExceptionById extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionById() {
		super("Não encontrado");
		
		// TODO Auto-generated constructor stub
	}

	public ExceptionById(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ExceptionById(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExceptionById(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ExceptionById(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
