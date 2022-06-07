package br.com.tegloja.model;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Foto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_foto")
	private Long id;

	// tipo de foto precisa ser notation lob e o typo cadeia de bytes = binario

	private String tipo;

	private String nome;

	@Lob
	@Column(name = "metadados_foto")
	private byte[] dados;

	// preicisa mapear a coluna com ID que ela será relacionada
	@OneToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;

	public Foto() {

	}

	public Foto(byte[] dados, String tipo, String nome, Produto produto) {
		this.dados = dados;
		this.tipo = tipo;
		this.nome = nome;
		this.produto = produto;
	}

	public Foto(Produto produto, MultipartFile file) throws IOException {
		this.dados = file.getBytes();
		this.nome = file.getName();
		this.produto = produto;
		this.tipo = file.getContentType();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getDados() {
		return dados;
	}

	public void setDados(byte[] dados) {
		this.dados = dados;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
