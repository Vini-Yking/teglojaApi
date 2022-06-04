package br.com.tegloja.dto;

import br.com.tegloja.model.Cliente;
import br.com.tegloja.model.Endereco;

public class ClienteResponseDTO {
	
	private Long id;
	private String cpf;
	private String nome;
	private String email;
	private String cep;
	private String bairro;
	private String logradouro;
	private Integer numeroEndereco;
	private String cidade;
	private String uf;
	
	
	public ClienteResponseDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.cpf = cliente.getCpf();
		this.cep = cliente.getCep();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.numeroEndereco = cliente.getNumeroEndereco();
	}
	
	public ClienteResponseDTO(Cliente cliente,Endereco endereco) {
		this.id = cliente.getId();
		this.cpf = cliente.getCpf();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.cep = cliente.getCep();
		this.numeroEndereco = cliente.getNumeroEndereco();
		this.bairro = endereco.getBairro();
		this.logradouro = endereco.getLogradouro();
		this.cidade = endereco.getLocalidade();
		this.uf = endereco.getUf();
		
	}
	
	
	
	public Integer getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(Integer numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String localidade) {
		this.cidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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
