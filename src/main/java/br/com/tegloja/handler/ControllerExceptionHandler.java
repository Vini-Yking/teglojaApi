package br.com.tegloja.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.tegloja.dto.ErroResponseDTO;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { IdNotFoundException.class })
	public ResponseEntity<Object> handleIdNotFoundException(IdNotFoundException ex, WebRequest request) {
		ErroResponseDTO erroResponse = new ErroResponseDTO(HttpStatus.NOT_FOUND.value(), "ID não encontrado",
				LocalDateTime.now(), ex.getMessage());
		return super.handleExceptionInternal(ex, erroResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

}
