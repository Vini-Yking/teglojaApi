package br.com.tegloja.handler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.tegloja.dto.ErroResponseDTO;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Exceção que trata quando o usuario entra um parametro e ele não é encontrado
	 (ex: id não encontrado)
	 */
	@ExceptionHandler(value = { NaoEncontradoException.class })
	public ResponseEntity<Object> handle(NaoEncontradoException ex, WebRequest request) {
		ErroResponseDTO erroResponse = new ErroResponseDTO(HttpStatus.NOT_FOUND.value(), "Não encontrado",
				LocalDateTime.now(), ex.getMessage());
		return super.handleExceptionInternal(ex, erroResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}


	 /**
	  * 	Exceção que trata quando o usuario entra um parâmetro que contraria a regra
	 de negócio (ex: passar quantidade de produto maior que estoque)
	  */
	@ExceptionHandler(value = { ArgumentoInvalidoException.class })
	public ResponseEntity<Object> handle(ArgumentoInvalidoException ex, WebRequest request) {
		ErroResponseDTO erroResponse = new ErroResponseDTO(HttpStatus.BAD_REQUEST.value(), "Argumento inválido.",
				LocalDateTime.now(), ex.getMessage());
		return super.handleExceptionInternal(ex, erroResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { DuplicateKeyException.class })
	public ResponseEntity<Object> handle(DuplicateKeyException ex, WebRequest request) {
		ErroResponseDTO erroResponse = new ErroResponseDTO(HttpStatus.BAD_REQUEST.value(),
				"Erro de constraint no banco de dados.", LocalDateTime.now(), ex.getMessage());
		return super.handleExceptionInternal(ex, erroResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	/**
	 * Exceção que trata os erros de validação do Request Body (@Valid ...)
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getDefaultMessage());
		}

		ErroResponseDTO errorResponse = new ErroResponseDTO(status.value(), "Há campos inválidos.", LocalDateTime.now(),
				errors);
		return super.handleExceptionInternal(ex, errorResponse, headers, status, request);
	}

}
