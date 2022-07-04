package br.com.tegloja.dto;

import br.com.tegloja.model.Cliente;
import br.com.tegloja.model.Endereco;

public class ClienteResponseDTO {
	
	private Long id;
	private String cpf;
	private String nome;
	private String email;
	private String cep;
	private Integer numeroEndereco;
	private Endereco endereco;
	private String urlFoto;
	
	
	public ClienteResponseDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.cpf = cliente.getCpf();
		this.cep = cliente.getCep();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.numeroEndereco = cliente.getNumeroEndereco();
		this.endereco = cliente.getEndereco();
		this.urlFoto = cliente.getUrlFoto();
	}
	
	public ClienteResponseDTO() {
		super();
	}
	
	
	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Integer getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(Integer numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
