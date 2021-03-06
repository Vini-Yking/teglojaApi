package br.com.tegloja.handler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.tegloja.dto.ErroResponseDTO;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Exceção que trata quando o usuario entra um parametro e ele não é encontrado
	 * (ex: id não encontrado)
	 */
	@ExceptionHandler(value = { NaoEncontradoException.class })
	public ResponseEntity<Object> handle(NaoEncontradoException ex, WebRequest request) {
		ErroResponseDTO erroResponse = new ErroResponseDTO(HttpStatus.NOT_FOUND.value(), "Não encontrado",
				LocalDateTime.now(), ex.getMessage());
		return super.handleExceptionInternal(ex, erroResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	/**
	 * exceção que trata os pagamentos do Enum caso na finalização da compra seja
	 * informado o pagamento em aberto ou diferente dos enums ele retorna mensagem
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = { EnumValidationException.class })
	public ResponseEntity<Object> handle(EnumValidationException ex, WebRequest request) {
		ErroResponseDTO erroResponse = new ErroResponseDTO(HttpStatus.NOT_FOUND.value(), "Forma de pagamento invalida",
				LocalDateTime.now(), ex.getMessage());
		return super.handleExceptionInternal(ex, erroResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	/**
	 * Exceção que trata quando o usuario entra um parâmetro que contraria a regra
	 * de negócio (ex: passar quantidade de produto maior que estoque)
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

	/**
	 * Essa exception é acionada quando um parâmetro esta faltando na request
	 */
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = ex.getParameterName() + ": parâmetro está faltando";

		ErroResponseDTO apiError = new ErroResponseDTO(HttpStatus.BAD_REQUEST.value(), ex.getLocalizedMessage(),
				LocalDateTime.now(), error);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	/**
	 * Exceção que é acionada quando o usuário insere um tipo inválido para um
	 * campo.
	 */
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
			WebRequest request) {
		String error = ex.getName() + " deveria ser do tipo " + ex.getRequiredType().getName();

		ErroResponseDTO apiError = new ErroResponseDTO(HttpStatus.BAD_REQUEST.value(), ex.getLocalizedMessage(),
				LocalDateTime.now(), error);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	/**
	 * Exceção que ocorre quando o usuário manda um método HTTP não suportado na
	 * requisição.
	 */
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		StringBuilder builder = new StringBuilder();
		builder.append(ex.getMethod());
		builder.append(" não é um método suportado para essa requisição. Métodos suportados são: ");
		ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

		ErroResponseDTO apiError = new ErroResponseDTO(HttpStatus.METHOD_NOT_ALLOWED.value(), ex.getLocalizedMessage(),
				LocalDateTime.now(), builder.toString());
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	/**
	 * Exceção que ocorre quando o usuário manda um tipo de mídia não suportado.
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		StringBuilder builder = new StringBuilder();
		builder.append(ex.getContentType());
		builder.append(" é um tipo de mídia não suportado. Tipos suportados são ");
		ex.getSupportedMediaTypes().forEach(t -> builder.append(t + ", "));

		ErroResponseDTO apiError = new ErroResponseDTO(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(),
				ex.getLocalizedMessage(), LocalDateTime.now(), builder.substring(0, builder.length() - 2));
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	/**
	 * Exception Default: pega outras exceções não tratadas nos outros handlers.
	 */
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		ErroResponseDTO apiError = new ErroResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				ex.getLocalizedMessage(), LocalDateTime.now(), "Um erro ocorreu");
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

}
