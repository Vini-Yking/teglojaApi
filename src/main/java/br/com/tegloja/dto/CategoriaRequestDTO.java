package br.com.tegloja.dto;

public class CategoriaRequestDTO {

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
