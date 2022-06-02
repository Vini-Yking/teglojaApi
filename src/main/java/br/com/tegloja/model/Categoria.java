package br.com.tegloja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import br.com.tegloja.dto.CategoriaRequestDTO;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long id;

	@Column(name = "nm_categoria", nullable = false, unique = true)
	@Size(max = 100)
	private String categoria;

	public Categoria() {

	}

	public Categoria(CategoriaRequestDTO request) {
		this.categoria = request.getCategoria();
	}

	public Categoria(Long id, @Size(max = 100) String categoria) {
		super();
		this.id = id;
		this.categoria = categoria;
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
