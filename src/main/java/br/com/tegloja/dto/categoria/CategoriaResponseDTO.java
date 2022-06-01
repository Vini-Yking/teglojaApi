package br.com.tegloja.dto.categoria;

import br.com.tegloja.model.Categoria;

public class CategoriaResponseDTO {

	private Long id;
	private String categoria;

	public CategoriaResponseDTO(Long id, String categoria) {
		super();
		this.id = id;
		this.categoria = categoria;
	}

	public CategoriaResponseDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.categoria = categoria.getCategoria();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
