package br.com.tegloja.dto;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ErroResponseDTO {

	private Integer status;
	private String titulo;
	private LocalDateTime timestamp;
	private List<String> erros;

	public ErroResponseDTO() {
	}

	public ErroResponseDTO(Integer status, String titulo, LocalDateTime timestamp, List<String> erros) {
		super();
		this.status = status;
		this.titulo = titulo;
		this.timestamp = timestamp;
		this.erros = erros;
	}

	public ErroResponseDTO(Integer status, String titulo, LocalDateTime timestamp, String erro) {
		super();
		this.status = status;
		this.titulo = titulo;
		this.timestamp = timestamp;
		this.erros = Arrays.asList(erro);
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

	@Override
	public String toString() {
		return "ErroResponseDTO [status=" + status + ", titulo=" + titulo + ", timestamp=" + timestamp + ", erros="
				+ erros + "]";
	}

}
