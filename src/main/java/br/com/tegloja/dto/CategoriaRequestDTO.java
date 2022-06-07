package br.com.tegloja.dto;

import javax.validation.constraints.NotNull;

public class CategoriaRequestDTO {

	@NotNull(message = "Informe categoria")
	private String categoria;

	public CategoriaRequestDTO() {

	}

	public CategoriaRequestDTO(String categoria) {
		super();
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
